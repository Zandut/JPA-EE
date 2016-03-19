<%-- 
    Document   : displayManufacturer
    Created on : Mar 19, 2016, 3:55:59 PM
    Author     : ZANDUT
--%>

<%@page import="entityClasses.Manufacturer"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <table>
            <thead>
                <tr>
                    <td>ID</td>
                    <td>Name Manufacturer</td>
                    <td>Delete</td>
                </tr>
                
            </thead>
            <tbody>
                <% 
                    List<Manufacturer> array = (List<Manufacturer>)session.getAttribute("array");
                    for (Manufacturer manu : array)
                    {
                        
                    
                %>
                
                <tr>
                    <td><%= ""+manu.getManufacturerId() %></td>
                    <td><%= manu.getName() %></td>
                    <td><a href="ManufacturerServlet?action=delete&id=<%= ""+manu.getManufacturerId() %>">Hapus</a></td>
                </tr>
                
                <% 
                    }
                %>
            </tbody>
        </table>
    </body>
</html>
