 <html>
<head>
<base href="<%=request.getScheme() + "://"
		+ request.getServerName() + ":"
		+ request.getServerPort()
		+ request.getContextPath() + "/"
		%>" />
		<link rel="stylesheet" href="css/style.css" type="text/css"/>
</head>

<body>

<h2>Bienvenue � la cantine ${ sessionScope.user } ! </h2>

<a href="accueil">Acceuil de la cantine</a>
<br>
<a href="default">Acceuil de la cantine</a>
<br>

<form action="accueil" method="post">
	Lieu <input type="text" name="lieu" /><br>
	Date de r�ouverture <input type="date" name="dateReouverture"/>
	<input type="submit" value="proposer"/>
	
</form>


<a href="home2/demo">Alternative de remplacement subsidiaire 2</a>
<br>
<a href="home2/demo/tutu">Avec un param�tre</a>
<br>
<a href="menu/V�g�tarien/Day/Lundi">Le menu du jour</a>
<br>
<a href="jsp/carte.jsp">Acc�s � notre carte</a>
<br>
<a href="carte">Acc�s � notre carte-par carteController</a>
<br>
<a href="plat/new">Ajouter un Plat- passe par controller</a>
<br>


<h2>
<a href="login">Se connecter</a>
</h2>




<br>

</body>
</html>
