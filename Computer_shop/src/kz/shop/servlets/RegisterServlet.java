package kz.shop.servlets;

import kz.shop.entities.Users;
import kz.shop.db.DBManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/register")

public class RegisterServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)

            throws ServletException, IOException {



        Long id = Long.parseLong(request.getParameter("idSave"));

        String fullname = request.getParameter("fullnameSave");

        String email = request.getParameter("emailSave");

        String password = request.getParameter("passwordSave");

        Users user = DBManager.getUser(id);

        if(user!=null){

            user.setFullName(fullname);

            user.setEmail(email);

            user.setPassword(password);

            DBManager.updateUser(user);

        }

        response.sendRedirect("/home");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)

            throws ServletException, IOException {

    }


}
