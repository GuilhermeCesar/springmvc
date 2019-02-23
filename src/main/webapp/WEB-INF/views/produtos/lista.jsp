<%--
  Created by IntelliJ IDEA.
  User: guilherme
  Date: 22/01/19
  Time: 22:09
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>

<%@ page contentType="text/html;charset=UTF-8"%>
<html>
<head>
    <title>Livros de Java, Android.Iphone</title>
</head>
<body>
    <h1>Lista de produtos</h1>

    <div>${sucesso}</div>
    <div>${falha}</div>

    <table>
        <tr>
            <td>Título</td>
            <td>Descrição</td>
            <td>Páginas</td>
        </tr>
        <c:forEach items="${produtos}" var="produto">
            <tr>
                <td>
                    <a href="${s:mvcUrl('PC#detalhe').arg(0,produto.id).build()}">${produto.titulo}</a>
                </td>
                <td>${produto.descricao}</td>
                <td>${produto.paginas}</td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
