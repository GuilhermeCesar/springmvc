<%--
  Created by IntelliJ IDEA.
  User: guilherme
  Date: 22/01/19
  Time: 22:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>

<html>
<head>
    <title>Livros de Java, Android.Iphone</title>
</head>
<body>
    <form:form action="${s:mvcUrl('PC#grava').build()}" method="POST" commandName="produto">
        <div>
            <label>Titulo</label>
            <div><form:errors path="titulo"/></div>
            <input type="text" name="titulo">
        </div>
        <div>
            <label>Descrição</label>
            <div><form:errors path="descricao"/></div>
            <textarea rows="10" cols="20" name="descricao">
            </textarea>
        </div>
        <div>
            <label>Paginas</label>
            <div><form:errors path="paginas"/></div>
            <input type="number" name="paginas">
        </div>
        <div>
            <label>Data de lançamento</label>
            <input name="dataLancamento" type="text">
            <form:errors path="dataLancamento"/>
        </div>
        <c:forEach items="${tipos}" var="tipoPreco" varStatus="status">
            <div>
                <label>${tipoPreco}</label>
                <input type="text" name="precos  [${status.index}].valor">
                <input type="hidden" name="precos[${status.index}].tipo" value="${tipoPreco}">
            </div>
        </c:forEach>
        <div>
            <button type="submit">Cadastrar</button>
        </div>
    </form:form>
</body>
</html>
