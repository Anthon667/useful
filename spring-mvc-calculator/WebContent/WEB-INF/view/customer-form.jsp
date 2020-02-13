<%@ taglib prefix="form" uri ="http://www.springframework.org/tags/form" %>
<html>
<head>
	<title>Calculator form</title>
	
</head>

<body>

<i>Fill out the form. </i>

	<form:form action="processForm" modelAttribute="calculator">
	
	Enter expression for calculation: <form:input path="input" />
	
	<br><br>
	
	<input type="submit" value="Submit" />
	
	</form:form>
	
	The result: ${calculator.result} ${calculator.input}

</body>


</html>