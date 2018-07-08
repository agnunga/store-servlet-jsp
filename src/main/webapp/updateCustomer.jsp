<jsp:include page="header_cust.jsp"/>
<div class="col-md-8">
    <div class="container">
        <%=request.getAttribute("message") != null ? request.getAttribute("message") : "" %>

        <%@page import="com.store.model.Customer"%>
        <%@page import="com.store.bean.CustomerBeanI"%>
        <%
            CustomerBeanI customerBean = (CustomerBeanI) request.getAttribute("customerBean");
            Customer customer = customerBean.viewById(Long.parseLong(request.getParameter("id")));
        %>
        <form class="well form-horizontal" action="update_customer" method="post" id="contact_form">
            <fieldset>
                <!-- Form Name -->
                <legend>Update Customer Details</legend>
                <input type="hidden" name="id" readonly="" value="<%= customer.getId()%>" required>

                <div class="form-group">
                    <label class="col-md-4 control-label">Customer Name :</label>
                    <div class="col-md-4 inputGroupContainer">
                        <div class="input-group">
                            <input name="name" placeholder="Customer Name" value="<%=customer.getName()%>" class="form-control" type="text">
                        </div>
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-md-4 control-label">Customer Location : </label>
                    <div class="col-md-4 inputGroupContainer">
                        <div class="input-group">
                            <input name="location" placeholder="Customer Location" value="<%=customer.getLocation()%>" class="form-control" type="text">
                        </div>
                    </div>
                </div>

                <div class="form-group">
                    <label class="col-md-4 control-label"></label>
                    <div class="col-md-4">
                        <button type="submit" class="btn btn-warning">
                            Update Customer's Details<span class=""></span>
                        </button>
                    </div>
                </div>

            </fieldset>
        </form>


    </div>
<jsp:include page="assets/footer.jsp"/>