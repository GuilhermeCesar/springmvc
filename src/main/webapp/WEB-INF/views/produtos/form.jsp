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
        <form:form action="${s:mvcUrl('PC#gravar').build()}" method="POST"
                   commandName="produto"
                   enctype="multipart/form-data">
            <div>
                <label>Titulo</label>
                <form:input path="titulo"/>
                <form:errors path="titulo"/>
            </div>
            <div>
                <label>Descrição</label>
                <form:textarea path="descricao" rows="10" cols="20"/>
                <form:errors path="descricao"/>
            </div>
            <div>
                <label>Paginas</label>
                <form:input path="paginas"/>
                <form:errors path="paginas"/>
            </div>
            <div>
                <label>Data de lançamento</label>
                <form:input path="dataLancamento"/>
                <form:errors path="dataLancamento"/>
            </div>
            <c:forEach items="${tipos}" var="tipoPreco" varStatus="status">
                <div>
                    <label>${tipoPreco}</label>
                    <form:input path="precos[${status.index}].valor"/>
                    <form:hidden path="precos[${status.index}].tipo" value="${tipoPreco}"/>
                </div>
            </c:forEach>
            <div>
                <label>Sumário</label>
                <input name="sumario" type="file"/>
            </div>
            <div>
                <button type="submit">Cadastrar</button>
            </div>
           </form:form>
    </body>
</html>
