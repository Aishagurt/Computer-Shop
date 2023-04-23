package kz.shop.servlets;

import kz.shop.db.DBManager;

import kz.shop.entities.Items;

import javax.servlet.ServletException;

import javax.servlet.annotation.WebServlet;

import javax.servlet.http.HttpServlet;

import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(value = "/deleteitem")

public class DeleteServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)

            throws ServletException, IOException {



        Long id = Long.parseLong(request.getParameter("id"));

        Items item = DBManager.getItem(id);

        if(item!=null){

            DBManager.deleteItem(id);

        }

        response.sendRedirect("/home");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)

            throws ServletException, IOException {

    }

}