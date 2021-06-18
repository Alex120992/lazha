package ru.zateev.javaee_jdbc.servlets;

import ru.zateev.javaee_jdbc.Entity.Person;
import ru.zateev.javaee_jdbc.service.PersonServiceImpl;
import ru.zateev.javaee_jdbc.users.UserImpl1;
import ru.zateev.javaee_jdbc.users.Users;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/addnewperson")
public class AddNewPerson extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Person person = new Person();
        req.setAttribute("person", person);
        getServletContext().getRequestDispatcher("/view/person-info.jsp").forward(req,resp);

    }
}
