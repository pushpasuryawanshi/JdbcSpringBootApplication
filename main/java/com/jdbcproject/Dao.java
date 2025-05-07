package com.jdbcproject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.springframework.stereotype.Repository;

@Repository
public class Dao {
	
	
	public ArrayList<IplTeam> getiplTeam() throws ClassNotFoundException, SQLException
	{
		ArrayList<IplTeam> al=new ArrayList<IplTeam>();
	
		/*
		 * Class.forName("com.mysql.cj.jdbc.Driver");//step 1 to load driver class
		 * //step 2 connection Connection con
		 * =DriverManager.getConnection("jdbc:mysql://localhost:3306/iplTemsJdbc","root"
		 * ,"root"); //step 3 create statement
		 */	
		Connection con=DBConnection.DBConnect();
		Statement st=con.createStatement();
		//step 4 perform/fire query
		ResultSet rs=st.executeQuery("Select * from iplteams");
		
		while(rs.next())
		{
			String teamName=rs.getString("teamName");
			int teamCode =rs.getInt("teamCode");
			int onOfMembers=rs.getInt("noOfMembers");
			
			IplTeam iplteam=new IplTeam(teamName,teamCode, onOfMembers);
			al.add(iplteam);
		
	}
		return al;
		
	}
		
	
	public String AddIplteam(IplTeam iplteam) throws ClassNotFoundException, SQLException	
	{
		
		Connection con=DBConnection.DBConnect();
		PreparedStatement pst=con.prepareStatement("insert into iplteams values(?,?,?)");	
		//set data to the object
		
	    pst.setString(1,iplteam.getTeamName());
		pst.setInt(2,iplteam.getTeamCode());
		pst.setInt(3, iplteam.getNoOfMembers());
		
		pst.executeUpdate();
		
		return "data has been inserted..!";
	}	
	
	public String Update(String teamName,int teamCode) throws ClassNotFoundException, SQLException {
		
		Connection con=DBConnection.DBConnect();
		PreparedStatement pst= con.prepareStatement("update iplteams set teamName=? where teamCode=?");
		
		//set data
		pst.setString(1, teamName);
		pst.setInt(2, teamCode);
		
		pst.executeUpdate();
		
		return "data has been Updated !..";
		
		
	}
	public String updateAll(IplTeam iplteam) throws SQLException, ClassNotFoundException
	{
		Connection con =DBConnection.DBConnect();
		PreparedStatement pst=con.prepareStatement("update iplteams set teamName=?,noOfMembers=? where teamCode=?");
		
		//set data
		pst.setString(1, iplteam.getTeamName());
		pst.setInt(2, iplteam.getNoOfMembers());
		pst.setInt(3, iplteam.getTeamCode());
		
		
		pst.executeUpdate();
		
		return "Updated All successfully..!";
	}
	
	public String Delete(int teamCode) throws ClassNotFoundException, SQLException
	{
		Connection con=DBConnection.DBConnect();
		PreparedStatement pst=con.prepareStatement("delete from iplteams where teamCode=?");
		pst.setInt(1, teamCode);
		pst.executeUpdate();
		return "data has been deleted..!";
	}
}	

