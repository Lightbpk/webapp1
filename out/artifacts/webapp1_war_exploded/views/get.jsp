<%@ page import="java.io.FileReader" %>
<%@ page import="java.io.File" %>
<%@ page import="java.io.IOException" %><%--
  Created by IntelliJ IDEA.
  User: Light
  Date: 13.03.2020
  Time: 15:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Get Animal</title>
    <link rel="stylesheet" href="styles/w3.css">
</head>
<body class="w3-light-grey">
<div class="w3-container w3-blue-grey w3-opacity w3-right-align">
    <h1>Get Animal by ID</h1>
</div>
<div class="w3-container w3-padding">
    <%
        if(request.getAttribute("respFile")!=null){
            try {
                File respFile = new File(request.getSession().getServletContext().getRealPath(""),
                        (String) request.getAttribute("respFile"));
                FileReader reader = new FileReader(respFile);
                int c;
                while((c=reader.read())!=-1){
                    out.println((char)c);
                }
            }catch (IOException IOe){
                IOe.printStackTrace();
                out.println(IOe);
            }
        }
    %>
</div>
<div class="w3-card-4">
    <div class="w3-container w3-center w3-green">
        <h2>Animal info</h2>
    </div>

    <form method="post" class="w3-selection w3-light-grey w3-padding">
        <lable>ID:
            <input type="text" name="ID" class="w3-input w3-animate-input w3-border w3-round-large" style="width: 30%"><br />
        </lable>

            <button type = "submit" class="w3-btn w3-green w3-round-large w3-margin-bottom">Submit</button>
    </form>
</div>
<div class="w3-container w3-grey w3-opacity w3-right-align w3-padding">
    <button class="w3-btn w3-round-large" onclick="location.href='/'">Back to main</button>
</div>
</body>
</html>
