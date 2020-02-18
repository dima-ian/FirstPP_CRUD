package servlets;

import entities.User;
import service.UserService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(
        name = "DelUser",
        description = "Удаление пользователя - Removing...",
        urlPatterns = "/del"
)

public class DelServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Del Servlet Called!");

        UserService usrSrv = new UserService();
        List<User> usrsLst = usrSrv.getAllUsers();
        req.setAttribute("usrsLst", usrsLst);

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("views/del.jsp");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserService usrSrv = new UserService();
        String ssn = req.getParameter("ssn");
        System.out.println("Deleting user having this SSN = " + ssn);

        if (!ssn.isEmpty()) {
            usrSrv.deleteUser(ssn);
            resp.setStatus(HttpServletResponse.SC_OK);
        } else {
            System.out.println("Something wrong happened...");
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        }

        req.setAttribute("ssn", ssn);
        doGet(req, resp);
    }


}
