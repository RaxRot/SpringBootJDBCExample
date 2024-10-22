package com.raxrot.springbootjdbcexample.repo;

import com.raxrot.springbootjdbcexample.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class UserRepo {
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public void adduser(User user) {
        String sqlQuery="insert into user (userId,name,age) values(?,?,?)";
       int rows = jdbcTemplate.update(sqlQuery,user.getUserId(),user.getName(),user.getAge());
        System.out.println(rows + " rows inserted");
    }

    public List<User> getAllUsers() {
        String sqlQuery="select * from user";
        List<User> users = jdbcTemplate.query(sqlQuery, new RowMapper<User>() {
            public User mapRow(ResultSet rs, int rowNum) throws SQLException {
                User user = new User();
                user.setUserId(rs.getInt("userId"));
                user.setName(rs.getString("name"));
                user.setAge(rs.getInt("age"));
                return user;
            }
        });
        return users;
    }

    public User getUserById(int userId) {
        String sqlQuery = "select * from user where userId = ?";
        User user = jdbcTemplate.queryForObject(sqlQuery, new Object[]{userId}, new RowMapper<User>() {
            @Override
            public User mapRow(ResultSet rs, int rowNum) throws SQLException {
                User user = new User();
                user.setUserId(rs.getInt("userId"));
                user.setName(rs.getString("name"));
                user.setAge(rs.getInt("age"));
                return user;
            }
        });
        return user;
    }

    public void updateUser(User user) {
        String sqlQuery="update user set name=?,age=? where userId=?";
        int rows = jdbcTemplate.update(sqlQuery,user.getName(),user.getAge(),user.getUserId());
        System.out.println(rows + " rows updated");
    }

    public void deleteUser(int userId) {
        String sqlQuery="delete from user where userId=?";
        int rows = jdbcTemplate.update(sqlQuery,userId);
        System.out.println(rows + " rows deleted");
    }
}
