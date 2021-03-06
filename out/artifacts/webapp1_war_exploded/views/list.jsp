<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: Light
  Date: 13.03.2020
  Time: 15:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Users list</title>
    <link rel="stylesheet" href="styles/w3.css">
</head>
<body class="w3-light-grey">
    <div class="w3-container w3-blue-grey w3-opacity w3-right-align">
        <h1>List Users Page</h1>
    </div>
    <div class="w3-container w3-center w3-margin-bottom w3-padding">
        <div class="w3-container w3-light-blue">
            <h2>Users</h2>
        </div>
        <div>
            <%
                List<String> respAll = (List<String>) request.getAttribute("allInfo");

                if (respAll != null && !respAll.isEmpty()) {
                    out.println("<ul class=\"w3-ul\">");
                    for (String s : respAll) {
                        out.println("<li class=\"w3-hover-sand\">" + s + "</li>");
                    }
                    out.println("</ul>");

                } else out.println("<div class=\"w3-panel w3-red w3-display-container w3-card-4 w3-round\">\n"
                        +
                        "   <span onclick=\"this.parentElement.style.display='none'\"\n" +
                        "   class=\"w3-button w3-margin-right w3-display-right w3-round-large w3-hover-red w3-border w3-border-red w3-hover-border-grey\">×</span>\n" +
                        "   <h5>There are no users yet!</h5>\n" +
                        "</div>");
            %>
        </div>
    </div>
    <div class="w3-container w3-grey w3-opacity w3-right-align w3-padding">
        <button class="w3-btn w3-round-large" onclick="location.href='/'">Back to main</button>
    </div>
</body>
</html>
