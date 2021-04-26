package com.stone.db.sqlinjection.service;

import com.stone.db.sqlinjection.core.Result;
import com.stone.db.sqlinjection.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.jdbc.core.StatementCallback;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

@Service
public class UserServiceImpl implements UserService {

    private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    private final JdbcTemplate jdbcTemplate;
    @Autowired
    public UserServiceImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Result psQuery(String username) {
        try {
            User user = psSelect(username);
            return Result.success(user);
        } catch (Exception e) {
            logger.error(e.getMessage());
            return Result.fail();
        }
    }

    @Override
    public Result sQuery(String username) {
        try {
            sExecute(username);
            //User user = sSelect(username);
            return Result.success();
        } catch (Exception e) {
            logger.error(e.getMessage());
            return Result.fail();
        }
    }

    private User psSelect(String username) {
        String sql = " select * from user where username = ?";
        return jdbcTemplate.execute(sql, new PreparedStatementCallback<User>() {
            @Override
            public User doInPreparedStatement(PreparedStatement preparedStatement) throws SQLException, DataAccessException {
                preparedStatement.setString(1, username);
                ResultSet rs = preparedStatement.executeQuery();
                System.out.println(">>>>>>>>>" + rs.getStatement().toString());
                User user = new User();
                while (rs.next()) {
                    user.setId(BigInteger.valueOf(rs.getLong("id")));
                    user.setUsername(rs.getString("username"));
                }
                return user;
            }
        });
    }

    private User sSelect(String username) {
        String sql = " select * from user where username = '" + username + "'";
        System.out.println(">>>>>>>>>>>>>> " + sql);
        return jdbcTemplate.execute(new StatementCallback<User>() {
            @Override
            public User doInStatement(Statement statement) throws SQLException, DataAccessException {
                ResultSet rs = statement.executeQuery(sql);
                User user = new User();
                while (rs.next()) {
                    user.setId(BigInteger.valueOf(rs.getLong("id")));
                    user.setUsername(rs.getString("username"));
                }
                return user;
            }
        });
    }

    private Boolean sExecute(String username) {
        String sql = " select * from user where username = '" + username + "'";
        System.out.println(">>>>>>>>>>>>>> " + sql);
        return jdbcTemplate.execute(new StatementCallback<Boolean>() {
            @Override
            public Boolean doInStatement(Statement statement) throws SQLException, DataAccessException {
                return statement.execute(sql);
            }
        });
    }

}
