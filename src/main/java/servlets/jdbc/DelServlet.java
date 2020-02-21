package servlets.jdbc;

import entities.User;
import service.UserJdbcService;

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

        UserJdbcService usrSrv = new UserJdbcService();
        List<User> usrsLst = usrSrv.getAllUsers();
        req.setAttribute("usrsLst", usrsLst);

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("views/jdbc/del.jsp");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserJdbcService usrSrv = new UserJdbcService();
        String ssn = req.getParameter("ssn");

        if (!ssn.isEmpty()) {
            usrSrv.deleteUser(ssn);
            resp.setStatus(HttpServletResponse.SC_OK);
        } else {
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        }

        req.setAttribute("ssn", ssn);
        doGet(req, resp);
    }
}
