package com.store.controller;

import com.store.bean.ProductBeanI;
import com.store.model.Product;

import java.io.IOException;
import javax.ejb.EJB;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/add_product")
public class AddProductServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @EJB
    ProductBeanI productBean;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher rd = request.getRequestDispatcher("/addProduct.jsp");
        rd.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        Product product = new Product();
        product.setName(request.getParameter("name"));
        product.setPrice(Double.valueOf(request.getParameter("price")));

        if (productBean.add(product) != null) {
            request.setAttribute("message", "Success! Product Added, Add another product.");
            RequestDispatcher rd = request.getRequestDispatcher("/addProduct.jsp");
            rd.forward(request, response);
        } else {
            request.setAttribute("message", "Error! Product registration failed");

            RequestDispatcher rd = request.getRequestDispatcher("/addProduct.jsp");
            rd.forward(request, response);
        }
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

}
