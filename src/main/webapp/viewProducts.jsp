<jsp:include page="header_pro.jsp" />
<div class="col-md-2"></div>
<div class="content-wrapper">
    <section class="content">
        <div class="row">

            <%@page import="com.store.model.Product"%>
            <%@page import="com.store.bean.ProductBeanI"%>
            <%@page import="java.util.List"%>
            <%@page import="java.util.Iterator"%>
            <div class="col-xs-12">
                <div class="box">
                    <h3>
                        <%= ((request.getAttribute("updated") != null) ? request.getAttribute("updated") + " " : "")%>
                    </h3>
                    <div class="box-header">
                        <h3 class="box-title">Product Details</h3>
                    </div>
                    <!-- /.box-header -->
                    <div class="box-body">
                        <table id="example1" class="table table-bordered table-striped">
                            <thead>
                            <tr>
                                <th>Product ID</th>
                                <th>Name</th>
                                <th>Price</th>
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
                                ProductBeanI productBean = (ProductBeanI) request.getAttribute("productBean");
                                List<Product> products = productBean.viewAll();
                                Iterator<Product> iterator = products.iterator();
                                while (iterator.hasNext()) {
                                    Product product = iterator.next();
                            %>
                            <tr>
                                <td><%=product.getId()%></td>
                                <td><%=product.getName()%></td>
                                <td><%=product.getPrice()%></td>
                                <td>
                                    <a href="/store/update_product?id=<%=product.getId()%>">
                                        <button class="btn btn-warning btn-xs icon-edit"> Edit </button>
                                    </a>
                                </td>
                                <td>
                                    <a href="/store/delete_product?id=<%=product.getId()%>">
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