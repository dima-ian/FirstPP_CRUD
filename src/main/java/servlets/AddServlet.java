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
        name = "AddUser",
        description = "Ввод нового пользователя - Create...",
        urlPatterns = "/add"
)

public class AddServlet extends HttpServlet {

    private UserService usrSrv;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Add Servlet Called!");

        UserService usrSrv = new UserService();
        List<User> usrsLst = usrSrv.getAllUsers();
        req.setAttribute("usrsLst", usrsLst);

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("views/add.jsp");
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

        System.out.println(user.toString());

        usrSrv = new UserService();

        if (user.getSsn().equals("")){
            System.out.println("SSN is mandatory param!");
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        }


        if (usrSrv.addClient(user)) {
            System.out.println("User's added: " + user.toString());
            resp.setStatus(HttpServletResponse.SC_OK);
        } else {
            System.out.println("Something wrong happened...");
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        }

        req.setAttribute("user", user);
        doGet(req, resp);
    }

}
