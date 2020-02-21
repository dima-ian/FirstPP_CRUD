package servlets.hibr;

import entities.User;
import service.UserHibrService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;


@WebServlet(
        name = "ShowAllUsersHbr",
        description = "Вывод всех пользователей - списком...",
        urlPatterns = "/listhbr"
)

public class ListServletHbr extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest reqv, HttpServletResponse resp) throws ServletException, IOException {

        UserHibrService uhs = new UserHibrService();
        List<User> usrsLst = uhs.getAllUsers();
        reqv.setAttribute("usrsLst", usrsLst);

        RequestDispatcher requestDispatcher = reqv.getRequestDispatcher("views/hibr/listhbr.jsp");
        requestDispatcher.forward(reqv, resp);

//        System.out.println(req.getPathInfo());
//
//        RequestDispatcher requestDispatcher = req.getRequestDispatcher("views/hibr/listhbr.jsp");
//        requestDispatcher.forward(req, resp);

//        resp.setContentType("text/html");
//        PrintWriter out = resp.getWriter();
//        out.println("test session attributes<br>");
//
//        HttpSession session = reqv.getSession();
//
//        if (session.isNew()) {  out.println("This is a new session."); out.println(session.getId()); }
//        else {  out.println("Welcome back!");  out.println(session.getId() );  }



//        UserService usrSrv = new UserService();
//        List<User> usrsLst = usrSrv.getAllUsers();
//        req.setAttribute("usrsLst", usrsLst);
//
//        RequestDispatcher requestDispatcher = req.getRequestDispatcher("views/listhbr.jsp");
//        requestDispatcher.forward(req, resp);
    }
}
