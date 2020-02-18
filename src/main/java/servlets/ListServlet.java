package servlets;

import entities.User;
import model.Model;
import service.UserService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;


@WebServlet(
        name = "ShowAllUsers",
        description = "Вывод всех пользователей - списком...",
        urlPatterns = "/list"
)

public class ListServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //PrintWriter writer = resp.getWriter();
        //writer.println("Method GET from ListServlet");
        System.out.println("List Servlet Called!");

        UserService usrSrv = new UserService();
        List<User> usrsLst = usrSrv.getAllUsers();
        req.setAttribute("usrsLst", usrsLst);

//        Model model = Model.getInstance();
//        List<String> names = model.list();
//        req.setAttribute("userNames", names);

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("views/list.jsp");
        requestDispatcher.forward(req, resp);
    }

}
