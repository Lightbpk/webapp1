package app.servlets;

import app.model.Model;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class ListServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String getAllStr = "";
        Model model = Model.getInstance();
        List<String> getAllResp = new ArrayList<>();
        FileReader reader = new FileReader(req.getSession().getServletContext().getRealPath("")
                + "response_getall.txt");
        char[] buf = new char[8096];
        int c;
        while ((c = reader.read(buf)) > 0) {
            if (c < 8096) {
                buf = Arrays.copyOf(buf, c);
            }
            getAllStr = new String(buf);
        }
        System.out.println("getAllStr = " + getAllStr);
        for (String oneLine : getAllStr.split("<next>")) {
            getAllResp.add(oneLine);
        }
        req.setAttribute("allInfo", getAllResp);

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("views/list.jsp");
        requestDispatcher.forward(req, resp);
    }
}
