package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.dao.UserDao;
import web.model.User;

import java.util.List;

@Service
public class UserServiceImp implements UserService {

   @Autowired
   private UserDao userDao;

   @Transactional
   @Override
   public void add(User user) {
      userDao.add(user);
   }

   @Transactional(readOnly = true)
   @Override
   public List<User> listUsers() {
      return userDao.listUsers();
   }

   @Transactional
   @Override
   public User getUserByNameAndSeries(String name, int series){
      return userDao.getUserByNameAndSeries(name,series);
   }

   @Transactional
   @Override
   public User getUserById(Long id){
      return userDao.getUserById(id);
   }

   @Transactional
   @Override
   public void updateUser(User user){
      userDao.updateUser(user);
   }
}
