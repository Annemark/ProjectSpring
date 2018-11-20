<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="core" %>
<!DOCTYPE html>
<html>
<head>
<base href="<%=request.getScheme() + "://"
		+ request.getServerName() + ":"
		+ request.getServerPort()
		+ request.getContextPath() + "/"
		%>" />

<meta charset="ISO-8859-1">
<title>Carte</title>
</head>
<body>
	<h1>Voici notre carte</h1>
	
	<table>
		<tr>
			<th>Plat</th>	
			<th>Type</th>
			<th>Prix</th>
			<th>Image</th>
			<th>Action</th>
		</tr>
		<!-- ICI ON FERA NOTRE FOREAHC -->
		
		<core:forEach var="plattoto" items="${ listePlatsMiamia }">
		<tr>
			<td>${ plattoto.nom }</td>	
			<td>${ plattoto.typePlat}</td>
			<td>${ plattoto.prix }</td>
			
			<td><img src="uploaded/${ plattoto.image }" width="100"/></td>
			
			<td>
				<form action="plat/delete" method = "post">
					<input type="hidden" name = "id" value="${plattoto.id }" />
					<input type="submit" value="Supprimer"/>
				</form>
				<br/>
				
				<form method="post" enctype="multipart/form-data" action="plat/upload">	
							<input type="hidden" name = "id" value="${plattoto.id }" />
							<input type="file" name="image_plat"/>		
							<input type="submit" value="Upload d'image"/>
							
				</form>
			</td>
		
		</tr>
		
		</core:forEach>
		
		
		
		<!-- FIN DU FOREACH -->
		
	
	</table>
	
	${ msg }
	
	
</body>
</html>