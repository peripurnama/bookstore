package peripurnama.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import peripurnama.dao.UserDao;
import peripurnama.model.User;

@Service
public class UserServiceImp implements UserService {

	@Autowired
	private UserDao userDao;

	@Transactional
	public User save(User user) {
		return userDao.save(user);
	}

	@Transactional(readOnly = true)
	public List<User> list() {
		return userDao.list();
	}

	@Transactional
	public User update(User user) {
		return userDao.update(user);
	}

	@Transactional
	public User delete(User user) {
		return userDao.delete(user);
	}

	@Transactional
	public User findUserByUsername(String username) {
		return userDao.findUserByUsername(username);
	}

}