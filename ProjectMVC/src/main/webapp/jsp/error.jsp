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
<title>Error!</title>
</head>
<body>

	<h1>OUPS...</h1>
	${ erreur }

</body>
</html>