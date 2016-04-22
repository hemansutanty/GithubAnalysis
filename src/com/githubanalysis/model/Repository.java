package com.githubanalysis.model;

public class Repository {

	String name;
	String url;
	String description;
	Integer forks_count;
	Integer stargazers_count;
	Integer watchers_count;
	Integer open_issues_count;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Integer getForks_count() {
		return forks_count;
	}
	public void setForks_count(Integer forks_count) {
		this.forks_count = forks_count;
	}
	public Integer getStargazers_count() {
		return stargazers_count;
	}
	public void setStargazers_count(Integer stargazers_count) {
		this.stargazers_count = stargazers_count;
	}
	public Integer getWatchers_count() {
		return watchers_count;
	}
	public void setWatchers_count(Integer watchers_count) {
		this.watchers_count = watchers_count;
	}
	public Integer getOpen_issues_count() {
		return open_issues_count;
	}
	public void setOpen_issues_count(Integer open_issues_count) {
		this.open_issues_count = open_issues_count;
	}
}
