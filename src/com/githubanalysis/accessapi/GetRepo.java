package com.githubanalysis.accessapi;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import com.eclipsesource.json.Json;
import com.eclipsesource.json.JsonArray;
import com.eclipsesource.json.JsonValue;
import com.githubanalysis.model.Repository;

public class GetRepo {
	
	public ArrayList<Repository> getPublicRepositories(String user){
		ArrayList<Repository> repositories = new ArrayList<Repository>(); 
		try{

			CloseableHttpClient httpclient = HttpClients.createDefault();
			HttpGet httpget = new HttpGet("https://api.github.com/users/"+user+"/repos");
			CloseableHttpResponse response = httpclient.execute(httpget);
			
			//get all headers		
			/*Header[] headers = response.getAllHeaders();
			for (Header header : headers) {
				System.out.println("Key : " + header.getName() 
				      + " ,Value : " + header.getValue());
			}*/
			BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
			StringBuilder result = new StringBuilder();
			String line = "";
			while ((line = rd.readLine()) != null) {
			    result.append(line);
			}
			JsonValue value = Json.parse(result.toString());
			JsonArray repos = value.asArray();
			
			for (JsonValue item : repos){
					if(item.asObject().get("fork").asBoolean()==false){
					Repository repo = new Repository();
					repo.setName(item.asObject().get("name").asString());
					repo.setDescription(item.asObject().get("description").asString());
					repo.setForks_count(item.asObject().get("forks_count").asInt());
					repo.setOpen_issues_count(item.asObject().get("open_issues_count").asInt());
					repo.setStargazers_count(item.asObject().get("stargazers_count").asInt());
					repo.setUrl(item.asObject().get("url").asString());
					repo.setWatchers_count(item.asObject().get("watchers_count").asInt());
					repositories.add(repo);
					}
		    }
			//System.out.println(value);
			response.close();
			
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
		return repositories;
	}
}
