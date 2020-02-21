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
        name = "AddUser",
        description = "Ввод нового пользователя - Create...",
        urlPatterns = "/add"
)

public class AddServlet extends HttpServlet {

    private UserJdbcService usrSrv;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        UserJdbcService usrSrv = new UserJdbcService();
        List<User> usrsLst = usrSrv.getAllUsers();
        req.setAttribute("usrsLst", usrsLst);

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("views/jdbc/add.jsp");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String sex = req.getParameter("sex");
        byte age = (byte) Integer.parseInt(req.getParameter("age"));
        String email = req.getParameter("email");
        String ssn = req.getParameter("ssn");

        User user = new User(name, sex, age, email, ssn);
        usrSrv = new UserJdbcService();

        if (user.getSsn().equals("")) {
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        }
        if (usrSrv.addUser(user)) {
            resp.setStatus(HttpServletResponse.SC_OK);
        } else {
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        }

        req.setAttribute("user", user);
        doGet(req, resp);
    }
}
