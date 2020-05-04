package web.dao;


import web.model.User;

import java.util.List;

public interface UserDao {
   void add(User user);
   List<User> listUsers();
   User getUserByNameAndSeries(String name, int series);
   User getUserById(Long id);
   void  updateUser(User user);
}
