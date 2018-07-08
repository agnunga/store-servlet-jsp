package com.store.controller;

import com.store.bean.CustomerBeanI;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/delete_customer")
public class DeleteCustomerServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @EJB
    CustomerBeanI customerBean;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("customerBean", customerBean);

        if (request.getParameter("id") != null) {
            if (customerBean.delete(Long.parseLong(request.getParameter("id")))) {
                request.setAttribute("deleted", "Deleted successfully");
                RequestDispatcher rd = request.getRequestDispatcher("/viewCustomers.jsp");
                rd.forward(request, response);
            }
        } else {
            request.setAttribute("deleted", "Deletion failed");
            RequestDispatcher rd = request.getRequestDispatcher("/viewCustomers.jsp");
            rd.forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
