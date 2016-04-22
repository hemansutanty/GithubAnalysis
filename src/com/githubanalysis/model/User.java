package com.githubanalysis.model;

import java.util.ArrayList;

import com.githubanalysis.accessapi.GetRepo;

public class User {
	String userName;
	ArrayList<Repository> userRepos = new ArrayList<Repository>();
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
	public void getRepos(String userName){
		setUserName(userName);
		GetRepo obj = new GetRepo();
		userRepos = obj.getPublicRepositories(userName);
	}

	public ArrayList<Repository> getUserRepos() {
		return userRepos;
	}

	public void setUserRepos(ArrayList<Repository> userRepos) {
		this.userRepos = userRepos;
	}
	
}
