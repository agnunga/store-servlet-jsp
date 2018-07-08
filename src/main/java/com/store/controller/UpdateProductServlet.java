package com.store.controller;

import com.store.bean.ProductBeanI;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.store.model.Product;
import javax.ejb.EJB;

@WebServlet("/update_product")
public class UpdateProductServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    @EJB
    ProductBeanI productBean;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("productBean", productBean);
        if (request.getParameter("id") != null) {
            RequestDispatcher rd = request.getRequestDispatcher("/updateProduct.jsp");
            rd.forward(request, response);
        } else {
            request.setAttribute("updated", "Invalid Option. No record selected for update");
            RequestDispatcher rd = request.getRequestDispatcher("/viewProducts.jsp");
            rd.forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("productBean", productBean);
        Product product = productBean.viewById(Long.parseLong(request.getParameter("id")));
        product.setName(request.getParameter("name"));
            product.setPrice(Double.valueOf(request.getParameter("price")));

        if (productBean.update(product) != null) {
            request.setAttribute("updated", product.getName()+"(ID : "+ product.getId()+") updated successfully.");
            RequestDispatcher rd = request.getRequestDispatcher("/viewProducts.jsp");
            rd.forward(request, response);
        } else {
            request.setAttribute("updated", "Update failed.");
            RequestDispatcher rd = request.getRequestDispatcher("/viewProducts.jsp");
            rd.forward(request, response);
        }
    }
}
