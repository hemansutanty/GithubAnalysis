<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.githubanalysis.model.User" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Github Analysis</title>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.5.0/css/font-awesome.min.css">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7" crossorigin="anonymous">
	<style>
		body{
			margin: 0 auto;
		}
		.fa{
			color: #f44336;
		}
		
	</style>
</head>
<body>
	<div class="container-fluid">
		<div class="row">
			<div class="col-lg-4"></div>
			<div class="col-lg-4 text-centered" style="text-align:center">
				<h2>Github Analysis</h2>
				<h4 style="text-decoration:underline">Repositories owned and Details</h4>
			</div>
		</div>
		<br><br>
		<div class="row">
			<div class="col-lg-2"></div>
			<div class="col-lg-8">
				<form action="/GithubAnalysis/UserController" method="get">
  					<div class="form-group">
    					<label for="exampleInputEmail1">Enter Github Username</label>
    					<input class="form-control" id="exampleInputEmail1" placeholder="Github User Name" name="userName" required>
    					<br>
    					<button type="submit" class="btn btn-primary">Submit</button>
  					</div>
  				</form>
  				
  				<br><br>
  				<div class="userTable">
  				<%
  					User user = (User)session.getAttribute("userBean");
    				if(user!=null && user.getUserRepos().size()!=0){
    			%>
    			<table class="table table-striped">
					<tr>
						<th>Sl. No.</th>
						<th>Repository Name</th>
						<th>Description</th>
						<th>Forks</th>
						<th>Stars</th>
						<th>Watchers</th>
						<th>Open Issues</th>
					</tr>
					 <%
					 	for(int i=0;i<user.getUserRepos().size();i++){
					 %>
					 <tr>
					 	<td><%=i+1%></td>
					 	<td><%=user.getUserRepos().get(i).getName()%></td>
					 	<td><%=user.getUserRepos().get(i).getDescription() %></td>
					 	<td><%=user.getUserRepos().get(i).getForks_count() %></td>
					 	<td><%=user.getUserRepos().get(i).getStargazers_count() %></td>
					 	<td><%=user.getUserRepos().get(i).getWatchers_count() %></td>
					 	<td><%=user.getUserRepos().get(i).getOpen_issues_count() %></td>
					 </tr>	
					 <% 	
					 	}
					 %>
				</table>	
    			<% 		
    				}else if(user!=null && user.getUserName()!=null){
  				%>
  				<h3 style="text-align:center">Sorry the user does not exist</h3>
  				<%} %>
  				</div>
			</div>
		</div>
		<br><br>
		<div class="row">
			<div class="col-lg-4"></div>
			<div class="col-lg-4" style="text-align:center" >
				<div class="footer">
					<p><a target="_blank" href="https://github.com/hemansutanty/GithubAnalysis">For Nerds <i class="fa fa-github-alt"></a></i></p>
					<p>Made with <i class="fa fa-heart"></i> by Hemansu</p>
				</div>
			</div>
		</div>
		
	</div>	
	
</body>
</html>