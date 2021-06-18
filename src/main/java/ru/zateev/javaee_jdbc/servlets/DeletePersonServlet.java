package ru.zateev.javaee_jdbc.servlets;

import ru.zateev.javaee_jdbc.Entity.Person;
import ru.zateev.javaee_jdbc.service.PersonServiceImpl;
import ru.zateev.javaee_jdbc.users.UserImpl1;
import ru.zateev.javaee_jdbc.users.Users;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/deletePerson")
public class DeletePersonServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("empId"));
        Users users = new UserImpl1();
        new PersonServiceImpl().personDelete(id,users);

        String path = req.getContextPath() + "/all-information";
            resp.sendRedirect(path);
    }
}
