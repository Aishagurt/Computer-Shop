<%@ page import="java.util.ArrayList" %>

<%@ page import="kz.shop.entities.Items" %>
<%@ page import="kz.shop.entities.Users" %>

<html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<head>
    <%@include file="head.jsp"%>
    <link rel="stylesheet" type="text/css" href="/css/main.css">
    <title>Computer Shop</title>
</head>

<body>
<%@include file="navbar.jsp"%>

<main>
<%

    ArrayList<Items> items = (ArrayList<Items>)request.getAttribute("items");

    int max = 0;
    for(Items i : items){
        if(max <= 6){
            String[] textArray = i.getDescription().split(";");
            out.print("<div class=\"item\">" + "<h2>" + i.getName() + "</h2>"

                    +"<p class=\"price\">£ "+i.getPrice() + " </p>" + "<table>" + " <tbody>");
            for (String text : textArray)
                 out.print("<tr> <td> " + text + " </td> </tr>");

            out.print("</table> </tbody> <p>" + "</p>"

                    + "<button>Buy Now</button> "

                    +" </div>");
            max++;
        }

    }

%>

</main>


<%--FOR ADDING ITEMS--%>

<%--<form action = "/home" method="post">--%>

<%--    NAME: <input type="text" name="name">--%>

<%--    DESCRIPTION: <input type="text" name="description">--%>

<%--    PRICE: <input type="text" name="price">--%>

<%--    <button>ADD ITEM</button>--%>

<%--</form>--%>
<%--<%--%>
<%--    if(items!=null){--%>

<%--        for(Items i : items){--%>

<%--            out.print("<h3>"+i.getId()--%>

<%--                    +" "+i.getName()--%>

<%--                    +" "+i.getDescription()--%>

<%--                    +" "+i.getPrice()--%>

<%--                    +" <a href = '/detailsItem?id="+i.getId()+"'>DETAILS</a>"--%>

<%--                    +"</h3>");--%>

<%--        }--%>

<%--    }--%>

<%--%>--%>

</body>

</html>