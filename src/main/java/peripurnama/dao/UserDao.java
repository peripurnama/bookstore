package peripurnama.dao;

import java.util.List;

import peripurnama.model.User;

public interface UserDao {
   User save(User user);
   User update(User user);
   User delete(User user);
   List<User> list();
   User findUserByUsername(String username);
}
