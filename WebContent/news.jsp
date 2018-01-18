<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ page import="java.util.List, io.zilker.bean.*"%>


<%
	List<Item> itemList = (List<Item>) request.getAttribute("Items");
%>

<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<link rel="stylesheet"
	href="assets/font-awesome-4.7.0/css/font-awesome.min.css">

<link rel="stylesheet" href="css/style.css">
<title>Z news</title>

</head>

<body>


	<header class="app-title">Znews</header>

	<aside class="menu-navigation">

		<ol class="list">
			<li class="active" onclick="navigation()"><i
				class="fa fa- fa-1x" aria-hidden="true"></i> <a href="index.html">Top
					Categories</a></li>
			<li>
			<i class="fa fa-rupee fa-1x" aria-hidden="true"></i>
			 <a
				href="pages/india.html">India</a>
				</li>
			<li><i class="fa fa-globe fa-1x" aria-hidden="true"></i> <a
				href="pages/international.html">International</a></li>
			<li><a href="pages/sports.html">Sports</a></li>
			<li><a href="pages/technology.html">Technology</a></li>
			<li><a href="pages/entertainment.html">Entertainment</a></li>
		</ol>

	</aside>


	<section class="main-content">


		<%
			for (int i = 0; i < itemList.size(); i++) {

				System.out.println(itemList.size());

				Item item = itemList.get(i);
		%>

		<div class="single-content">

			<div class="display-image">
				<img src="<%=item.getImageLink()%>" width="150px" height="130px"
					alt="user">

			</div>

			<div class="display-content">
				<h1>Title :</h1>
				<a href="<%=item.getLink()%>" target="_blank"><%=item.getTitle()%></a>

				<h1>Publish Date :</h1>
				<%=item.getPubDate()%>

			</div>


		</div>


		<%
			}
		%>




	</section>




</body>

<script src="js/script.js"></script>
</html>