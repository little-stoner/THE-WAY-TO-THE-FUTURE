package gosql

import (
	"context"
	"database/sql"
	"fmt"
	"github.com/go-sql-driver/mysql"
	"log"
	"time"
)

var db *sql.DB

func main() {

	cfg := mysql.Config{
		User:                 "root",
		Passwd:               "root",
		Net:                  "tcp",
		Addr:                 "127.0.0.1:3306",
		DBName:               "viber",
		AllowNativePasswords: true,
	}

	var err error

	db, err = sql.Open("mysql", cfg.FormatDSN())
	if err != nil {
		fmt.Println("==================")
		log.Fatal(err)
	}

	pingErr := db.Ping()
	if pingErr != nil {
		log.Fatal(pingErr)
	}
	fmt.Println(" Connected ")

}

func QueryWithTimeout(ctx context.Context) {

	queryCtx, cancel := context.WithTimeout(ctx, 5*time.Second)
	defer cancel()

	rows, err := db.QueryContext(queryCtx, "Select * from user")
	if err != nil {
		log.Fatal(err)
	}
	defer rows.Close()

	//

}

func CreateOrder(ctx context.Context, userId, quantity int) (oid int64, err error) {

	fail := func(err error) (int64, error) {
		return fmt.Errorf("CreateOrder: %v", err)
	}

	tx, err := db.BeginTx(ctx, nil)
	if err != nil {
		return fail(err)
	}

	defer tx.Rollback()

	var enough bool
	if err = tx.QueryRowContext(ctx, "SELECT (quantity > ?) from user where id = ?",
		quantity, userId).Scan(&enough); err != nil {
		if err == sql.ErrNoRows {
			return fail(fmt.Errorf(" no such user"))
		}
		return fail(err)
	}

	if !enough {
		return fail(fmt.Errorf(" not enough order permission "))
	}

	_, err = tx.ExecContext(ctx, "UPDATE user set quantity = quantity - ? where id = ?",
		quantity, userId)
	if err != nil {
		return fail(err)
	}

	result, err := tx.ExecContext(ctx, "insert into order (uid, quantity, date) values(?, ?, ?)",
		userId, quantity, time.Now())

	if err != nil {
		return fail(err)
	}

	orderId, err := result.LastInsertId()
	if err != nil {
		return fail(err)
	}

	if err = tx.Commit(); err != nil {
		return fail(err)
	}

	return orderId, nil

}

type User struct {
	Id       int64
	Username string
	Salt     string
	Valid    int8
}

func crud() {

	users, err := users()

	fmt.Println(" ==> users: ", users)

	user, err := userById(1)
	if err != nil {
		log.Fatal(err)
	}
	fmt.Println(" ==> user: ", user)

	id, err := addUser(User{
		Username: "KKK",
	})
	if err != nil {
		log.Fatal(err)
	}
	fmt.Println(">>>>>>>> id: ", id)

}

func users() ([]User, error) {
	var users []User

	rows, err := db.Query("SELECT id, username, salt, valid FROM user")
	if err != nil {
		return nil, fmt.Errorf(" users: %v", err)
	}
	defer rows.Close()

	for rows.Next() {
		var user User
		if err := rows.Scan(&user.Id, &user.Username, &user.Salt, &user.Valid); err != nil {
			fmt.Println("   #######   ", err)
			return nil, fmt.Errorf(" user: %v", err)
		}
		users = append(users, user)
	}

	if err := rows.Err(); err != nil {
		return nil, fmt.Errorf(" users: %v", err)
	}

	return users, nil

}

func userById(id int64) (User, error) {
	var user User
	row := db.QueryRow(" select id, username, salt, valid from user where id = ?", id)
	if err := row.Scan(&user.Id, &user.Username, &user.Salt, &user.Valid); err != nil {
		if err == sql.ErrNoRows {
			return user, fmt.Errorf("userById %d: no such user", id)
		}
		return user, fmt.Errorf("userById %d: %v", id, err)
	}

	return user, nil
}

func addUser(user User) (int64, error) {
	result, err := db.Exec("insert into user(username) values (?)", user.Username)
	if err != nil {
		return 0, fmt.Errorf("add user: %v", err)
	}
	id, err := result.LastInsertId()
	if err != nil {
		return 0, fmt.Errorf("add user: %v", err)
	}
	return id, nil
}
