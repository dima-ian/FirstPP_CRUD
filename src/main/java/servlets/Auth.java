package servlets;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;

@WebServlet(
        name = "LoginUser",
        description = "Вход пользователя - проверка имени пользователя и пароля",
        urlPatterns = "/login"
)

public class Auth extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("Auth Servlet Called!");
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("views/login.jsp");
        requestDispatcher.forward(request, response);
    }

    protected void doPost(HttpServletRequest request,  HttpServletResponse response) throws ServletException, IOException {

        String login = request.getParameter("login");
        String password = request.getParameter("password");
        System.out.println("Login = " + login + " " + "Password = " + password);

        PrintWriter out = response.getWriter();
        out.println("Login = " + login + " " + "Password = " + password);
    }
}
