package com.hedgo.dbtests.dao.impl;

import com.hedgo.dbtests.dao.UserDAO;
import com.hedgo.dbtests.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Repository("JDBCTemplate")
public class UserDAOJDBCTemplateImpl implements UserDAO {

    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplateNamed;
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void save(User user) {
        String INSERT_SQL = "INSERT INTO USER(name, country, age) VALUES (:name, :country, :age)";

        Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("name", user.getName());
        paramMap.put("country", user.getCountry());
        paramMap.put("age", user.getAge());

        jdbcTemplateNamed.update(INSERT_SQL, paramMap);
        //public static final String INSERT_SQL = "INSERT INTO USER(name, country, age) VALUES(?, ?, ?)";
        //jdbcTemplate.update(INSERT_SQL, user.getName(), user.getCountry(), user.getAge());
    }

    @Override
    public User read(int id) {
        String FIND_BY_SQL = "SELECT * FROM USER WHERE id = ?; ";

        User user = jdbcTemplate.queryForObject(FIND_BY_SQL, (rs, rowNum) -> {
            return new User(rs.getInt("ID"), rs.getString("NAME"), rs.getString("COUNTRY"), rs.getInt("AGE"));
        }, id);

/* Old way, before Java8
        User user = jdbcTemplateNamed.queryForObject(FIND_BY_SQL, new RowMapper<User>() {
            @Override
            public User mapRow(ResultSet resultSet, int i) throws SQLException {
                User user=new User(resultSet.getString("NAME"), resultSet.getString("COUNTRY"), resultSet.getInt("AGE"));
                user.setId(resultSet.getInt("ID"));
                return user;
            }
        }, id);
*/
        return user;
    }

    @Override
    public void update(int id, User user) {

    }

    @Override
    public void delete(int id) {

    }

    @Override
    public void deleteAll() {
        String DELETE_ALL_SQL = "DELETE FROM USER";
        jdbcTemplateNamed.update(DELETE_ALL_SQL,new HashMap());
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
        String SELECT_ALL_SQL = "SELECT * FROM USER";
        List<Map<String, Object>> allUsers = jdbcTemplate.queryForList(SELECT_ALL_SQL);

/* Old way, before Java8
        List<User> userList = new ArrayList<User>();
        for (Map row : rows) {
            User user = new User((String) row.get("NAME"), (String) row.get("COUNTRY"), (Integer) row.get("AGE"));
            user.setId((Integer) row.get("ID"));
            userList.add(user);
        }
*/

        return allUsers.stream().map(oneUser -> {
            return new User((Integer) oneUser.get("ID"), (String) oneUser.get("NAME"), (String) oneUser.get("COUNTRY"), (Integer) oneUser.get("AGE"));
        }).collect(Collectors.toList());
    }

    @Override
    public void initSession() {

    }

    @Override
    public void closeSession() {

    }
}
