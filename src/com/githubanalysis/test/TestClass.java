package com.githubanalysis.test;

import com.githubanalysis.model.User;

public class TestClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		User user = new User();
		user.getRepos("hemansutanty");
		System.out.println(user.getUserRepos().size());
	}

}
