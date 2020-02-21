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
        name = "ShowAllUsers",
        description = "Вывод всех пользователей - списком...",
        urlPatterns = "/list"
)

public class ListServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserJdbcService usrSrv = new UserJdbcService();
        List<User> usrsLst = usrSrv.getAllUsers();
        req.setAttribute("usrsLst", usrsLst);

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("views/jdbc/list.jsp");
        requestDispatcher.forward(req, resp);
    }
}
