package org.cisco.blog.data;


import java.util.List;


public class UserService {
	private static UserDao userDao;

	public UserService() {
		userDao = new UserDao();
	}

	public void persist(User entity) {
		userDao.openCurrentSessionwithTransaction();
		userDao.persist(entity);
		userDao.closeCurrentSessionwithTransaction();
	}

	public void update(User entity) {
		userDao.openCurrentSessionwithTransaction();
		userDao.update(entity);
		userDao.closeCurrentSessionwithTransaction();
	}

	public User findByUsername(String username) {
		userDao.openCurrentSession();
		User user = userDao.findByUsername(username);
		userDao.closeCurrentSession();
		return user;
	}
	
	public boolean  isValidPassword(String username, String password) {
		userDao.openCurrentSession();
		boolean result =  userDao.isValidPassword (username, password);
		userDao.closeCurrentSession();
		return result;
	}

	public User findById(String id) {
		userDao.openCurrentSession();
		User user = userDao.findById(id);
		userDao.closeCurrentSession();
		return user;
	}

	public void delete(String id) {
		userDao.openCurrentSessionwithTransaction();
		User user = userDao.findById(id);
		userDao.delete(user);
		userDao.closeCurrentSessionwithTransaction();
	}

	public List<User> findAll() {
		userDao.openCurrentSession();
		List<User> users = userDao.findAll();
		userDao.closeCurrentSession();
		return users;
	}
	
	public void deleteAll() {
		userDao.openCurrentSessionwithTransaction();
		userDao.deleteAll();
		userDao.closeCurrentSessionwithTransaction();
	}

	public UserDao userDao() {
		return userDao;
	}

}