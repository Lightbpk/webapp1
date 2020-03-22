package app.servlets;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class GetServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("views/get.jsp");
        requestDispatcher.forward(req,resp);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String ID = req.getParameter("ID");
        String reqFileName = "request_get_"+ID;
        String respFileName = "response_get_"+ID;
        try {
            File reqFile = new File(req.getSession().getServletContext().getRealPath(""), reqFileName+".txt");
            FileWriter writer = new FileWriter(reqFile,false);
            writer.write(respFileName+" GET "+ID);
            writer.flush();
        }catch (IOException ioe){
            ioe.printStackTrace();
        }

        req.setAttribute("respFile",respFileName+".txt");
        doGet(req, resp);
    }
}
