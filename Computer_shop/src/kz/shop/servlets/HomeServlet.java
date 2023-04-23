package kz.shop.servlets;


import kz.shop.entities.Items;

import kz.shop.db.DBManager;

import javax.servlet.ServletException;

import javax.servlet.annotation.WebServlet;

import javax.servlet.http.HttpServlet;

import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpServletResponse;

import java.io.IOException;

import java.util.ArrayList;



@WebServlet(value = "/home")

public class HomeServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)

            throws ServletException, IOException {

        String name = request.getParameter("name");

        String description = request.getParameter("description");

        double price = Double.parseDouble(request.getParameter("price"));



        DBManager.addItem(new Items(null, name, description, price));

        response.sendRedirect("/home");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)

            throws ServletException, IOException {

        ArrayList<Items> items = DBManager.getAllItems();

        request.setAttribute("items", items);

        request.getRequestDispatcher("/home.jsp").forward(request, response);

    }

}