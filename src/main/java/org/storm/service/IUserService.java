package org.storm.service;

import java.util.List;

import org.storm.pojo.User;

public interface IUserService {
	public User getUserById(int userId);
	public int newUser(User user);
	public int updateUser(User user);
	public int deleteUserById(int userId);
    public List<User> getAll();
    public List<User> login(String userName,String password);
    public int getIdByUsername(String userName);
}
