package _onjava8._annotations.database;


public @interface Uniqueness {
    Constraints constraints()
            default @Constraints(unique = true);
}
