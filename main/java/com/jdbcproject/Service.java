package com.jdbcproject;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
@org.springframework.stereotype.Service
public class Service {
	@Autowired
	Dao dao;
	//getAll
	public  List<IplTeam> getIplTeams() throws ClassNotFoundException, SQLException
		{
		
	   List<IplTeam>list= dao.getiplTeam();
	   return list;
	}
	
	//insert
	public String AddIplteam(IplTeam iplteam) throws ClassNotFoundException, SQLException
	{
		String msg=dao.AddIplteam(iplteam);
		return msg;
	}
	
	//update
	public String Update(String teamName,int teamCode) throws ClassNotFoundException, SQLException
	{
		String msg=dao.Update(teamName, teamCode);
		return msg;
	}
	
	//updateAll
	public String updateAll(IplTeam iplteam) throws ClassNotFoundException, SQLException
	{
		String msg=dao.updateAll(iplteam);
		return msg;
	}
	///delete
	public String Delete(int teamCode) throws ClassNotFoundException, SQLException
	{
		String msg=dao.Delete(teamCode);
		return msg;
	}

}
