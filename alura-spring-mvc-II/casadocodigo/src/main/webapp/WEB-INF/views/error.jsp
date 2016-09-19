
<%@ taglib tagdir="/WEB-INF/tags" prefix="tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<tags:pageTemplate titulo="Erro Inesperado">
	<c:url value="/" var="contextPath" />
	<section id="index-section" class="container middle">

		<h2>Ocorreu um Erro Inesperado!</h2>
		
		<!--
			Mensagem: ${exception.message}
		 	<c:forEach items="${exception.stackTrace}" var="stack">
		 		${stack}
		 	</c:forEach> 
		-->

	</section>
</tags:pageTemplate>