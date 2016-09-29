<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<html>
<head>
<!-- <link rel="stylesheet" href="/WEB-INF/world.css" type="text/css" /> -->
<style type="text/css">
    <%@include file="/WEB-INF/world.css" %>
    </style>
<title><spring:message code="country.plural" /></title>
</head>
<body>
	<h1>
		<spring:message code="application.name" />
	</h1>
	<table>
		<tr>
			<td align="right" valign="bottom">
				<button onclick="window.location='countryForm.html'">Create</button>
			</td>
		</tr>
		<tr>
			<td>
				<table class="silver" width="180">
					<tr>
						<th></th>
						<th><spring:message code="country.plural" /></th>
					</tr>
					<c:forEach items="${countries}" var="country">
						<tr>
							<td width="20"><a
								href="<c:url value='countryForm?id=${country.id}'/>"> 
								<img src="/home/bridgeit/workspace/MvcForm/src/main/webapp/edit.gif" width="10px" height="10px" style="border-style: none;" />
							</a></td>
							<td><a href="countryDetails?id=${country.id}">
									${country.name} </a></td>
						</tr>
					</c:forEach>
				</table>
			</td>
		</tr>
	</table>
</body>
</html>