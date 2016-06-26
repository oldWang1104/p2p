package com.julend.p2p.service;

import java.sql.SQLException;
import java.util.List;

import com.julend.p2p.model.User;


public interface IUserService {
	
	public List<User> queryAllUsers() throws SQLException;
	
	public User checkUser(User user) throws SQLException;
	
	public void insertUser(User user) throws SQLException;
	
	public void updateUser(User user) throws SQLException;
}
