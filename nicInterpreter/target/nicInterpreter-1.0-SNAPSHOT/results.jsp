<%-- 
    Document   : results
    Created on : Sep 11, 2013, 10:54:08 PM
    Author     : Bhagya
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="maven.nic.NicCalc"%>
<%@page import="maven.nic.NicInvalidPropException"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>NIC Interpreter Results</title>
    </head>
    <body>
        <h1>Results of the NIC interpretation</h1>
        <% try {
            String num = request.getParameter("nic");
            NicCalc cal = new NicCalc(num);
        %>
        <%
        out.print("NIC number : " + cal.getNic());
        %>
        <br>
        <b>Birthday</b>
        <br>
        <%
        out.print("Year - " + cal.getYear());
        %>
        <br>
        <% out.print("Month - " + cal.getMonth()); %>
        <br>
        <% out.print("Day - " + cal.getDate()); %>
        <br>
        <br><b>Gender :</b> 
        <% out.print(cal.getGender()); %>
        <br>
        <br><b>Voter : </b>
        <% out.print(cal.isVoter());
        }
        catch(Exception ex){
            out.println(ex.getMessage());
        }
        %>
    </body>
</html>
