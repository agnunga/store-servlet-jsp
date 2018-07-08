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
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/add_customer")
public class AddCustomerServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @EJB
    CustomerBeanI customerBean;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher rd = request.getRequestDispatcher("/addCustomer.jsp");
        rd.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        Customer customer = new Customer();
        customer.setName(request.getParameter("name"));
        customer.setLocation(request.getParameter("location"));

        if (customerBean.add(customer) != null) {
            request.setAttribute("message", "Success! Customer Added, Add another customer.");
            RequestDispatcher rd = request.getRequestDispatcher("/addCustomer.jsp");
            rd.forward(request, response);
        } else {
            request.setAttribute("message", "Error! Customer registration failed");

            RequestDispatcher rd = request.getRequestDispatcher("/addCustomer.jsp");
            rd.forward(request, response);
        }
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

}
