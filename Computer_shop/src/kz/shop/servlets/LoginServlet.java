package kz.shop.servlets;

import kz.shop.entities.Users;

import kz.shop.db.DBManager;

import javax.servlet.ServletException;

import javax.servlet.annotation.WebServlet;

import javax.servlet.http.HttpServlet;

import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpServletResponse;

import java.io.IOException;

import java.util.ArrayList;



@WebServlet(value = "/login")

public class LoginServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)

            throws ServletException, IOException {
        String redirect = "/login?emailerror";

        String email = request.getParameter("email");

        String password = request.getParameter("password");

        Users user = DBManager.getUser(email);

        if(user!=null){

            redirect = "/login?passworderror";

            if(user.getPassword().equals(password)){

                redirect = "/profile";

                request.getSession().setAttribute("CURRENT_USER", user);

            }

        }

        response.sendRedirect(redirect);



//        String email = request.getParameter("email");
//
//        String password = request.getParameter("password");
//
//        String fullname = request.getParameter("fullname");
//
//        DBManager.addUser(new Users(null, email, password, fullname));
//
//        response.sendRedirect("/login");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)

            throws ServletException, IOException {

        ArrayList<Users> users = DBManager.getAllUsers();
        request.setAttribute("users", users);

        request.getRequestDispatcher("/login.jsp").forward(request, response);

    }

}