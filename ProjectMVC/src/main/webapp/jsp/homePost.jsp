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
<title>Insert title here</title>
</head>
<body>
<h1>Acceuil de la cantine en post</h1>

Réouverture le ${datedeReouverture}
à ${lieu}
</body>
</html>