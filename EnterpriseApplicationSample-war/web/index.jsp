<%-- 
    Document   : index
    Created on : Mar 19, 2016, 3:39:01 PM
    Author     : ZANDUT
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="ManufacturerServlet?action=insert" method="post" >
            <input type="number" name="id" placeholder="ID manufacturer" />
            <br>
            <input type="text" name="name" placeholder="Nama Manufacturer" />
            <br>
            <button type="submit" >Simpan</button>
        </form>
        
        <br>
        <a href="ManufacturerServlet?action=display" >Display Manufacturer</a>
    </body>
</html>
