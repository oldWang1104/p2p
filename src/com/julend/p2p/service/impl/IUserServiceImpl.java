package com.julend.p2p.service.impl;

import java.sql.SQLException;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.julend.p2p.model.User;
import com.julend.p2p.service.IUserService;

@Service("userService")
public class IUserServiceImpl implements IUserService {
	
	@Resource(name="sqlMapClient")
	private SqlMapClient sqlMapClient;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<User> queryAllUsers() throws SQLException{
		// TODO Auto-generated method stub
		return sqlMapClient.queryForList("QueryUserList");
	}

	@Override
	public User checkUser(User user) throws SQLException {
		// TODO Auto-generated method stub
		return (User) sqlMapClient.queryForObject("QueryUserByUsernameAndPass",user);
	}

	@Override
	public void insertUser(User user) throws SQLException {
		// TODO Auto-generated method stub
		sqlMapClient.insert("AddUser", user);
	}

	@Override
	public void updateUser(User user) throws SQLException {
		// TODO Auto-generated method stub
		sqlMapClient.insert("UpdateUser", user);
	}

}
