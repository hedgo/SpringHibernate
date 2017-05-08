package com.hedgo.dbtests.dao.impl;

import com.hedgo.dbtests.dao.UserDAO;
import com.hedgo.dbtests.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

    @Repository("JDBCTemplate")
    public class UserDAOJDBCTemplateImpl implements UserDAO {

        public static final String SELECT_ALL_SQL = "SELECT * FROM USER";
        public static final String INSERT_SQL = "INSERT INTO USER(name, country, age) VALUES(?, ?, ?)";
        public static final String FIND_BY_SQL = "SELECT * FROM USER WHERE id = ?; ";
        @Autowired
        private JdbcTemplate jdbcTemplate;

        @Override
        public void save(User user) {
            jdbcTemplate.update(INSERT_SQL, user.getName(), user.getCountry(), user.getAge());
        }

    @Override
    public User read(int id) {
        User user = jdbcTemplate.queryForObject(FIND_BY_SQL, new RowMapper<User>() {
            @Override
            public User mapRow(ResultSet resultSet, int i) throws SQLException {
                User user=new User(resultSet.getString("NAME"), resultSet.getString("COUNTRY"), resultSet.getInt("AGE"));
                user.setId(resultSet.getInt("ID"));
                return user;
            }
        }, id);

        return user;
    }

    @Override
    public void update(int id, User user) {

    }

    @Override
    public void delete(int id) {

    }

    @Override
    public List<User> listAll() {
        return listAllNative();
    }

    @Override
    public Long countAll() {
        return null;
    }

    @Override
    public List<User> listAllNative() {
        List<User> userList = new ArrayList<User>();
        List<Map<String, Object>> rows = jdbcTemplate.queryForList(SELECT_ALL_SQL);

        for (Map row : rows) {
            User user=new User((String) row.get("NAME"), (String) row.get("COUNTRY"), (Integer) row.get("AGE"));
            user.setId((Integer) row.get("ID"));
            userList.add(user);
        }

        return userList;
    }

    @Override
    public void initSession() {

    }

    @Override
    public void closeSession() {

    }
}
