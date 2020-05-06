package web.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import web.model.User;

import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class UserDaoImp implements UserDao {

   @Autowired
   private SessionFactory sessionFactory;

   @Override
   public void add(User user) {
      sessionFactory.getCurrentSession().save(user);
   }

   @Override
   @SuppressWarnings("unchecked")
   public List<User> listUsers() {
      TypedQuery<User> query=sessionFactory.getCurrentSession().createQuery("From User");
      return query.getResultList();
   }

   @Override
   public User getUserById(Long id){
      TypedQuery<User> query = sessionFactory.getCurrentSession().createQuery("FROM User WHERE id = :id");
      query.setParameter("id", id);
      return query.getSingleResult();
   }

   @Override
   public void updateUser(User user){
      TypedQuery<User> query = sessionFactory.getCurrentSession().createQuery("UPDATE User SET firstName = :firstName, lastName = :lastName, email = :email WHERE id = :id");
      query.setParameter("firstName", user.getFirstName());
      query.setParameter("lastName", user.getLastName());
      query.setParameter("email", user.getEmail());
      query.setParameter("id", user.getId());
      query.executeUpdate();
   }

   @Override
   public void deleteUser(User user) {
      sessionFactory.getCurrentSession().delete(user);
   }
}
