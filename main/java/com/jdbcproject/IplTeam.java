package com.jdbcproject;

public class IplTeam {
	
	String teamName;
	int teamCode;
	int noOfMembers;
	
	public IplTeam() {
		// TODO Auto-generated constructor stub
	}

	public IplTeam(String teamName, int teamCode, int noOfMembers) {
		super();
		this.teamName = teamName;
		this.teamCode = teamCode;
		this.noOfMembers = noOfMembers;
	}

	public String getTeamName() {
		return teamName;
	}

	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}

	public int getTeamCode() {
		return teamCode;
	}

	public void setTeamCode(int teamCode) {
		this.teamCode = teamCode;
	}

	public int getNoOfMembers() {
		return noOfMembers;
	}

	public void setNoOfMembers(int noOfMembers) {
		this.noOfMembers = noOfMembers;
	}

	@Override
	public String toString() {
		return "IplTeam [teamName=" + teamName + ", teamMember=" + teamCode + ", noOfMembers=" + noOfMembers
				+ ", getTeamName()=" + getTeamName() + ", getTeamCode()=" + getTeamCode() + ", getNoOfMembers()="
				+ getNoOfMembers() + "]";
	}
	
	
	

}
