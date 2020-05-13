package web.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import web.model.Role;
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
        sessionFactory.getCurrentSession().save(user.getRoles().get(0));
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<User> listUsers() {
        TypedQuery<User> query = sessionFactory.getCurrentSession().createQuery("From User");
        return query.getResultList();
    }

    @Override
    public User getUserById(Long id) {
        TypedQuery<User> query = sessionFactory.getCurrentSession().createQuery("FROM User WHERE id = :id");
        query.setParameter("id", id);
        return query.getSingleResult();
    }

    @Override
    public void updateUser(User user) {
      sessionFactory.getCurrentSession().update(user);
    }

    @Override
    public void deleteUser(User user) {
        sessionFactory.getCurrentSession().delete(user);
    }

    @Override
    public User findByUsername(String email) {
        TypedQuery<User> query = sessionFactory.getCurrentSession().createQuery("FROM User WHERE email=:email");
        query.setParameter("email", email);
        return query.getSingleResult();
    }

    @Override
    public void updateUserRole(String role, Long id) {
        User user = getUserById(id);
        List<Role> list = user.getRoles();
        Role userRole = list.get(0);
        TypedQuery<Role> query = sessionFactory.getCurrentSession().createQuery("UPDATE Role Set role =:role WHERE id =:id ");
        query.setParameter("role", role);
        query.setParameter("id", userRole.getId());
        query.executeUpdate();
    }
}
