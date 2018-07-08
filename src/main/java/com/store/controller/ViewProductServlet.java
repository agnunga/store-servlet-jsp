package com.store.controller;

import com.store.bean.ProductBeanI;
import java.io.IOException;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/view_products")
public class ViewProductServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @EJB
    ProductBeanI productBean;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setAttribute("productBean", productBean);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/viewProducts.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

}
