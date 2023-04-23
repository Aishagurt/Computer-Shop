package kz.shop.servlets;



import kz.shop.entities.Users;

import javax.servlet.ServletException;

import javax.servlet.annotation.WebServlet;

import javax.servlet.http.HttpServlet;

import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpServletResponse;

import java.io.IOException;



@WebServlet(value = "/profile")

public class ProfileServlet extends HttpServlet {

    @Override

    protected void doGet(HttpServletRequest request, HttpServletResponse response)

            throws ServletException, IOException {

        Users currentUser = (Users) request.getSession().getAttribute("CURRENT_USER");

        if(currentUser!=null) {

            request.getRequestDispatcher("/profile.jsp").forward(request, response);

        }else{

            response.sendRedirect("/login");

        }

    }

}