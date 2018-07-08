<jsp:include page="header_cust.jsp" />
<div class="col-md-2"></div>
<div class="content-wrapper">
    <section class="content">
        <div class="row">

            <%@page import="com.store.model.Customer"%>
            <%@page import="com.store.bean.CustomerBeanI"%>
            <%@page import="java.util.List"%>
            <%@page import="java.util.Iterator"%>
            <div class="col-xs-12">
                <div class="box">
                    <h3>
                        <%= ((request.getAttribute("updated") != null) ? request.getAttribute("updated") + " " : "")%>
                    </h3>
                    <div class="box-header">
                        <h3 class="box-title">Customer Details</h3>
                    </div>
                    <!-- /.box-header -->
                    <div class="box-body">
                        <table id="example1" class="table table-bordered table-striped">
                            <thead>
                            <tr>
                                <th>Customer ID</th>
                                <th>Name</th>
                                <th>Location</th>
                                <th></th>
                                <th></th>
                            </tr>
                            </thead>
                            <tbody>
                            <%
                                String id = "";
                                if (request.getParameter("id") != null) {
                                    id = request.getParameter("id");
                                }
                                CustomerBeanI customerBean = (CustomerBeanI) request.getAttribute("customerBean");
                                List<Customer> customers = customerBean.viewAll();
                                Iterator<Customer> iterator = customers.iterator();
                                while (iterator.hasNext()) {
                                    Customer customer = iterator.next();
                            %>
                            <tr>
                                <td><%=customer.getId()%></td>
                                <td><%=customer.getName()%></td>
                                <td><%=customer.getLocation()%></td>
                                <td>
                                    <a href="/store/update_customer?id=<%=customer.getId()%>">
                                        <button class="btn btn-warning btn-xs icon-edit"> Edit </button>
                                    </a>
                                </td>
                                <td>
                                    <a href="/store/delete_customer?id=<%=customer.getId()%>">
                                        <button class="btn btn-danger btn-xs icon-edit"> Delete </button>
                                    </a>
                                </td>
                            </tr>
                            <%
                                }
                            %>
                            </tbody>
                            <tfoot>
                            <str>
                                </tr>
                            </tfoot>
                        </table>
                    </div>
                </div>
            </div>



        </div>
    </section>
</div>
<jsp:include page="assets/footer.jsp"/>