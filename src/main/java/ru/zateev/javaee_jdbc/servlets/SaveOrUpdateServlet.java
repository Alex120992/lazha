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

@WebServlet("/save_update")
public class SaveOrUpdateServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Users users = new UserImpl1();
        Person person = new Person();

        person.setId(Integer.parseInt(req.getParameter("id")));
        person.setName(req.getParameter("name"));
        person.setSurname(req.getParameter("surname"));
        person.setAge(Integer.parseInt(req.getParameter("age")));
        person.setMail(req.getParameter("mail"));
        System.out.println(person);

        new PersonServiceImpl().saveOrUpdate(person, users);
        String path = req.getContextPath() + "/all-information";
        resp.sendRedirect(path);


    }
}
