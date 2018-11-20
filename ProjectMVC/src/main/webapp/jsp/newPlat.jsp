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
<title>Nouveau Plat</title>
</head>
<body>
	<h1>Ajouter un plat</h1>

	<form method="post" action="">
		<label for="nom">Nom du plat</label>
		<input type= "text" id="nom" name= "nom"/> <br/>
		
		
		<label for="prix">Prix</label>
		<input type="number" id="prix" name="prix"/>
		
		Type de plat
			<select name = "typePlat">
				<option value="ENTREE">Entrée</option>
				<option value="PLAT">Plat</option>
				<option value="ACCOMPAGNEMENT">Accompagnement</option>
				<option value="DESSERT">Dessert</option>
			</select> <br/>
		
		<input type="submit" value="Créer" />


	</form>


</body>
</html>