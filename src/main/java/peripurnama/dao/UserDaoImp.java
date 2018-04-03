package peripurnama.dao;

import java.util.List;



import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import peripurnama.model.User;

@Repository
public class UserDaoImp  implements UserDao {

  @Autowired
  private SessionFactory sessionFactory;

  public User findUserByUsername(String username) {
    return sessionFactory.getCurrentSession().get(User.class, username);
  }

  public User save(User user) {
    sessionFactory.getCurrentSession().save(user);
    return user;
  }

  public User update(User user) {
    sessionFactory.getCurrentSession().update(user);
    return user;
  }

  public User delete(User user) {
    sessionFactory.getCurrentSession().delete(user);
    return user;
  }

  @SuppressWarnings("unchecked")
public List<User> list() {
	  return sessionFactory.getCurrentSession().createQuery("from User").getResultList();
  }

}