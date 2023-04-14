package com.example.sprintasynccontroller.repository;


import com.example.sprintasynccontroller.entity.User;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;


@Repository
public class UserRepository {

    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public UserRepository(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    public User findOneById(String id) {
        Map<String, String> map = new HashMap<>();
        map.put("id", id);
        return namedParameterJdbcTemplate.queryForObject("select id, username from user where id = :id", new MapSqlParameterSource(map), new UserMapper());
    }

    public User findOneByUsername(String name) {
        Map<String, String> map = new HashMap<>();
        map.put("name", name);
        return namedParameterJdbcTemplate.queryForObject("select id, username from user where username = :name", new MapSqlParameterSource(map), new UserMapper());
    }
    public CompletableFuture<Optional<User>> findOneByUsernameAsync(String name) {
        Map<String, String> map = new HashMap<>();
        map.put("name", name);
        return CompletableFuture.supplyAsync(() ->
                Optional.of(namedParameterJdbcTemplate.queryForObject("select id, username from user where username = :name", new MapSqlParameterSource(map), new UserMapper()))
        );
    }

    static class UserMapper implements RowMapper<User> {

        @Override
        public User mapRow(ResultSet rs, int rowNum) throws SQLException {
            User user = new User();
            user.setId(rs.getObject("id", BigInteger.class));
            user.setUsername(rs.getString("username"));
            return user;
        }

    }

}
