<%--
  Created by IntelliJ IDEA.
  User: guilherme
  Date: 22/01/19
  Time: 22:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Livros de Java, Android.Iphone</title>
</head>
<body>
    <form action="/casadocodigo/produtos" method="post">
        <div>
            <label>Titulo</label>
            <input type="text" name="titulo">
        </div>
        <div>
            <label>Descrição</label>
            <textarea rows="10" cols="20" name="descricao">

            </textarea>
        </div>
        <div>
            <label>Paginas</label>
            <input type="number" name="paginas">
        </div>
        <button type="submit">Cadastrar</button>
    </form>
</body>
</html>