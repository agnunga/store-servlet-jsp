package com.store.controller;

import com.store.bean.ProductBeanI;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javax.ejb.EJB;

@WebServlet("/delete_product")
public class DeleteProductServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @EJB
    ProductBeanI productBean;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("productBean", productBean);

        if (request.getParameter("id") != null) {
            if (productBean.delete(Long.parseLong(request.getParameter("id")))) {
                request.setAttribute("deleted", "Deleted successfully");
                RequestDispatcher rd = request.getRequestDispatcher("/viewProducts.jsp");
                rd.forward(request, response);
            }
        } else {
            request.setAttribute("deleted", "Deletion failed");
            RequestDispatcher rd = request.getRequestDispatcher("/viewProducts.jsp");
            rd.forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
