<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags" %>

<html>
<head>
    <meta content="text/html; charset=utf-8" http-equiv="Content-Type"/>
    <title>Who said that ?</title>
</head>

<link href="style/social-buttons.css" rel="stylesheet"/>
<link href="style/bootstrap.min.css" rel="stylesheet">
<style>
.signinDiv {
  margin:auto;
  text-align:center;
}
</style>

<body>
<tag:notloggedin>
	<div class="signinDiv">
		<a href="signin" class="btn btn-lg btn-social btn-twitter"> 
			<i class="fa fa-twitter"></i> 
			Sign in with Twitter
		</a>
	</div>
</tag:notloggedin>
<tag:loggedin>
    <h1>Welcome ${twitter.screenName} (${twitter.id})</h1>
    <form action="./post" method="post">
        <textarea cols="80" rows="2" name="text"></textarea>
        <input type="submit" name="post" value="update"/>
    </form>
    <a href="./logout">logout</a>
</tag:loggedin>
</body>
</html>