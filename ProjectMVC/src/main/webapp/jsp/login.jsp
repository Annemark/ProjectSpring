<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<base href="<%=request.getScheme() + "://"
		+ request.getServerName() + ":"
		+ request.getServerPort()
		+ request.getContextPath() + "/"
		%>" />

<meta charset="ISO-8859-1">
<title>Authentification</title>
</head>

<body>
<h1>Authentification</h1>

<form action="login" method="post">
	<input type="text" name="userName"/> Login <br />
	<input type="password" name="password"/>Mot de passe<br />
	<input type="submit" value="S'identifier"/>
</form>

</body>
</html>