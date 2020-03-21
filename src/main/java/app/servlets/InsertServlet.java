package app.servlets;

import app.entities.Animal;
import app.model.Model;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.rowset.serial.SerialException;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class InsertServlet extends HttpServlet  {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("views/insert.jsp");
        requestDispatcher.forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String reqFileName = "reqFile2312367657";
        String respFileName= "request_insert_1 INSERT";
        String photoURL = req.getParameter("photoURL");
        String name = req.getParameter("name");
        String type = req.getParameter("type");
        String status = req.getParameter("status");
        Animal animal = new Animal(photoURL,name,status,type);
        Model model= Model.getInstance();
        model.add(animal);
        try {
            File reqFile = new File(req.getSession().getServletContext().getRealPath(""), reqFileName+".txt");
            FileWriter writer = new FileWriter(reqFile,false);
            writer.write(respFileName+" "+animal.getReqLine());
            writer.flush();
        }catch (IOException ioe){
            ioe.printStackTrace();
        }

        req.setAttribute("userName",name);
        req.setAttribute("respFile",respFileName+".txt");
        doGet(req, resp);
    }
}
