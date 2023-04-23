<%@ page import="kz.shop.entities.Users" %><%
  Users currentUser = (Users) session.getAttribute("CURRENT_USER");
%>
<nav class="navbar navbar-expand-lg bg-body-tertiary">
  <div class="container-fluid">

    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarText" aria-controls="navbarText" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarText">
      <ul class="navbar-nav me-auto mb-2 mb-lg-0">
        <li class="nav-item">
          <b class="navbar-brand" href="/home">BITLAB SHOP</b>
        </li>
      </ul>
      <span class="navbar-text" >
        <a href="/home" style="text-decoration: none; padding: 10px 10px;"> Top sales </a>
        <a href="#" style="text-decoration: none; padding: 10px 10px;"> New sales </a>
        <a href="#" style="text-decoration: none; padding: 10px 10px;"> By category </a>
        <a href="/login" style="text-decoration: none; padding: 10px 10px;"> Sign in </a>
      </span>
    </div>
  </div>
</nav>