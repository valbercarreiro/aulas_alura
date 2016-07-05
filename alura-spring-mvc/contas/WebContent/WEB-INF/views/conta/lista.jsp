<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<table>
		<tr>
			<th>Código</th>
			<th>Descrição</th>
			<th>Valor</th>
			<th>Tipo</th>
			<th>Paga?</th>
			<th>Data de Pagamento</th>
			<th>Ações</th>
		</tr>
		
		<c:forEach items="${todasContas}" var="conta">
			<tr>
				<td>${conta.id}</td>
				<td>${conta.descricao}</td>
				<td>${conta.valor}</td>
				<td>${conta.tipo}</td>
				<td>
					<c:if test="${conta.paga eq false}">
						Não Paga
					</c:if>
				 	<c:if test="${conta.paga eq true}">
				 		Paga
				 	</c:if>
				</td>
				<td><fmt:formatDate value="${conta.dataPagamento.time}" pattern="dd/MM/yyyy"/></td>
				<td>
					<a href="removerConta?id=${conta.id}">Deletar</a>
				</td>
				<td><a href="mostraConta?id=${conta.id}">Alterar</a></td>
			</tr>
		</c:forEach>
	
	</table>

</body>
</html>