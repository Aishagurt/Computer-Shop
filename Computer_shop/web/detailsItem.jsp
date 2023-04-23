<%@ page import="kz.shop.entities.Items" %>

<html>

<head>

    <title>TEST</title>

</head>

<body>

<%

    Items item = (Items) request.getAttribute("item");

    if(item!=null){

%>

<form action = "/saveitem" method="post">

    <input type="hidden" name="id" value="<%=item.getId()%>">

    NAME: <input type="text" name="name" value="<%=item.getName()%>">

    DESCRIPTION: <input type="text" name="description" value="<%=item.getDescription()%>">

    PRICE: <input type="text" name="price" value="<%=item.getPrice()%>">

    <button>SAVE Item</button>

</form>

<form action="/deleteitem" method="post">

    <input type="hidden" name="id" value="<%=item.getId()%>">

    <button>DELETE ITEM</button>

</form>

<%

    }

%>

</body>

</html>