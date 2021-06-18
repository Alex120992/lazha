package ru.zateev.javaee_jdbc.servlets;

import ru.zateev.javaee_jdbc.Entity.Person;
import ru.zateev.javaee_jdbc.service.PersonService;
import ru.zateev.javaee_jdbc.service.PersonServiceImpl;
import ru.zateev.javaee_jdbc.users.UserImpl1;
import ru.zateev.javaee_jdbc.users.Users;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/all-information")
public class GetAllPersonsServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        RequestDispatcher requestDispatcher = req.getRequestDispatcher("view/all-information.jsp");
//        requestDispatcher.forward(req, resp);

//        String path = req.getContextPath() + "/person-info";
//            resp.sendRedirect(path);
        Users users = new UserImpl1();
        List<Person> personList = new PersonServiceImpl().personList(users);
        Person person = new Person();
        person.setName("Aleks");
        req.setAttribute("allPeop", personList);
        getServletContext().getRequestDispatcher("/view/all-information.jsp").forward(req,resp);

    }


}
