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

@WebServlet("/view_customers")
public class ViewCustomerServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @EJB
    CustomerBeanI customerBean;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setAttribute("customerBean", customerBean);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/viewCustomers.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

}
