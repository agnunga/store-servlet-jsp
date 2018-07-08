package com.store.controller;

import com.store.bean.CustomerBeanI;
import com.store.model.Customer;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/update_customer")
public class UpdateCustomerServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    @EJB
    CustomerBeanI customerBean;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("customerBean", customerBean);
        if (request.getParameter("id") != null) {
            RequestDispatcher rd = request.getRequestDispatcher("/updateCustomer.jsp");
            rd.forward(request, response);
        } else {
            request.setAttribute("updated", "Invalid Option. No record selected for update");
            RequestDispatcher rd = request.getRequestDispatcher("/viewCustomers.jsp");
            rd.forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("customerBean", customerBean);
        Customer customer = customerBean.viewById(Long.parseLong(request.getParameter("id")));
        customer.setName(request.getParameter("name"));
            customer.setLocation(request.getParameter("location"));

        if (customerBean.update(customer) != null) {
            request.setAttribute("updated", customer.getName()+"(ID : "+ customer.getId()+") updated successfully.");
            RequestDispatcher rd = request.getRequestDispatcher("/viewCustomers.jsp");
            rd.forward(request, response);
        } else {
            request.setAttribute("updated", "Update failed.");
            RequestDispatcher rd = request.getRequestDispatcher("/viewCustomers.jsp");
            rd.forward(request, response);
        }
    }
}
