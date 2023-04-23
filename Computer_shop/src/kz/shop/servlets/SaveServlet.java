package kz.shop.servlets;

import kz.shop.entities.Items;
import kz.shop.db.DBManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/saveitem")

public class SaveServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)

            throws ServletException, IOException {



        Long id = Long.parseLong(request.getParameter("id"));

        String name = request.getParameter("name");

        String description = request.getParameter("description");

        double price = Double.parseDouble(request.getParameter("price"));

        Items item = DBManager.getItem(id);

        if(item!=null){

            item.setName(name);

            item.setDescription(description);

            item.setPrice(price);

            DBManager.updateItem(item);

        }

        response.sendRedirect("/home");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)

            throws ServletException, IOException {

    }


}
