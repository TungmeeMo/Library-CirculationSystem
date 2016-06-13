package org.storm.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.stereotype.Service;
import org.storm.dao.UserMapper;
import org.storm.pojo.User;
import org.storm.service.IUserService;

@Service("userService")
public class UserServiceImpl implements IUserService {
	@Resource
	private UserMapper userDao;

	public User getUserById(int userId) {
		// TODO Auto-generated method stub
		return this.userDao.selectByPrimaryKey(userId);
	}

	public int newUser(User user) {
		// TODO Auto-generated method stub
		// 用户的密码使用MD5加盐加密处理后存储
		Md5PasswordEncoder md5 = new Md5PasswordEncoder();
		// false 表示：生成32位的Hex版, 这也是encodeHashAsBase64的, Acegi 默认配置; true
		// 表示：生成24位的Base64版
		md5.setEncodeHashAsBase64(false);
		return this.userDao.insert(user);
	}

	public int updateUser(User user) {
		// TODO Auto-generated method stub
		// 用户的密码使用MD5加盐加密处理后存储
		Md5PasswordEncoder md5 = new Md5PasswordEncoder();
		// false 表示：生成32位的Hex版, 这也是encodeHashAsBase64的, Acegi 默认配置; true
		// 表示：生成24位的Base64版
		md5.setEncodeHashAsBase64(false);
		user.setPassword(md5.encodePassword(user.getPassword(), user.getUserName()));

		return this.userDao.updateByPrimaryKey(user);
	}

	public int deleteUserById(int userId) {
		// TODO Auto-generated method stub
		return this.userDao.deleteByPrimaryKey(userId);
	}

	public List<User> getAll() {
		// TODO Auto-generated method stub
		return this.userDao.selectAll();
	}

	@Override
	public List<User> login(String userName, String password) {
		// TODO Auto-generated method stub
		return this.userDao.login(userName, password);
	}

	@Override
	public int getIdByUsername(String userName) {
		// TODO Auto-generated method stub
		return this.userDao.getIdByUsername(userName);
	}
}
