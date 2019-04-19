<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security"%>
<%@ taglib prefix="ftm" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<header id="layout-header">
    <div class="clearfix container">
        <a href="/" id="logo"> </a>
        <div id="header-content">
            <nav id="main-nav">

                <ul class="clearfix">
                    <li>
                        <a href="${s:mvcUrl('CCC#itens')}" rel="nofollow">
                            <fmt:message key="menu.carrinho"/> (${carrinhoCompras.quantidade})
                        </a>
                    </li>
                    <li>
                        <a href="/pages/sobre-a-casa-do-codigo" rel="nofollow">
                            <fmt:message key="menu.sobre"/>
                        </a>
                    </li>
                    <li><a href="/pages/perguntas-frequentes" rel="nofollow">Perguntas Frequentes</a></li>
                </ul>
            </nav>
        </div>
    </div>
</header>
<nav class="categories-nav">
    <ul class="container">
        <li class="category">
            <a href="http://www.casadocodigo.com.br">
                <fmt:message key="navegacao.categoria.home"/>
            </a>
        </li>
        <li class="category">
            <a href="/collections/livros-de-agile">
                <ftm:message key="navegacao.categoria.agile"/>
            </a>
        </li>
        <li class="category">
            <a href="/collections/livros-de-front-end">
                <ftm:message key="navegacao.categoria.front_end"/>
            </a>
        </li>
        <li class="category">
            <a href="/collections/livros-de-games">
                <ftm:message key="navegacao.categoria.games" />
            </a>
        </li>
        <li class="category">
            <a href="/collections/livros-de-java">
                <ftm:message key="navegacao.categoria.java" />
            </a>
        </li>
        <li class="category">
            <a href="/collections/livros-de-mobile">
                <ftm:message key="navegacao.categoria.mobile"/>
            </a>
        </li>
        <li class="category">
            <a href="/collections/livros-desenvolvimento-web">
                <ftm:message key="navegacao.categoria.web"/>
            </a>
        </li>
        <li class="category">
            <a href="/collections/outros">
                <ftm:message key="navegacao.categoria.outros"/>
            </a>
        </li>
    </ul>
</nav>
