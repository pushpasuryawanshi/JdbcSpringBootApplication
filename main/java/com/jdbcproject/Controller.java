package com.jdbcproject;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import jakarta.websocket.server.PathParam;

@RestController
public class Controller {
	@Autowired
	Service service;
	@GetMapping("/iplteams")
	public List<IplTeam> getiplTeam() throws ClassNotFoundException, SQLException
	{
		List<IplTeam> list=service.getIplTeams();
		return list;
	}
	
	
	@PostMapping("/iplteams")
	public String AddIpltteam(@RequestBody IplTeam iplteam) throws ClassNotFoundException, SQLException
	{
		String msg=service.AddIplteam(iplteam);
		return msg;
	}
	
	@PutMapping("/iplteams/{teamName}/{teamCode}")
	public String update(@PathVariable String teamName,@PathVariable int teamCode) throws ClassNotFoundException, SQLException
	{
		
	      String msg=service.Update(teamName, teamCode);
	      return msg;
	}
	
	@PutMapping("/iplteams")
	public String updateAll(@RequestBody IplTeam iplTeam) throws ClassNotFoundException, SQLException
	{
		String msg=service.updateAll(iplTeam);
		return msg;
		
	}
	
	@DeleteMapping("/iplteams/{teamCode}")
	public String deleteData(@PathVariable int teamCode) throws ClassNotFoundException, SQLException
	{
		String msg=service.Delete(teamCode);
		return msg;
	}
	
	

}
