<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ taglib prefix ="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Levykauppa</title>
    <style type="text/css">
  #kuva {
		margin-left:200px;	  
		margin-bottom:150px; 
}
	a{
	font-size:20px;
	}
    </style>

</head>
<body>
<h1>Tervetuloa Levykauppaan!</h1>

<a href="/Levykauppa/artists">Näytä kaikki artistit</a><br>
<a href="/Levykauppa/artist/hae">Hae Artisteja</a><br>
<a href="/Levykauppa/albumsByTitle">Hae albumeja</a><br>
<a href="/Levykauppa/lisaaArtisti">Lisää Artisti</a>
<div id="kuva">
<img src="https://img.wennermedia.com/article-leads-horizontal/rs-record-store-day-006b5205-6245-495e-b65f-0f187b99013c.jpg"/>
</div>
</body>
</html>