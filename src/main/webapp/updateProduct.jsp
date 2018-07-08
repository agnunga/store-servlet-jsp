<jsp:include page="header_pro.jsp"/>
<div class="col-md-8">
    <div class="container">
        <%=request.getAttribute("message") != null ? request.getAttribute("message") : "" %>

        <%@page import="com.store.model.Product"%>
        <%@page import="com.store.bean.ProductBeanI"%>
        <%
            ProductBeanI productBean = (ProductBeanI) request.getAttribute("productBean");
            Product product = productBean.viewById(Long.parseLong(request.getParameter("id")));
        %>
        <form class="well form-horizontal" action="update_product" method="post" id="contact_form">
            <fieldset>
                <!-- Form Name -->
                <legend>Update Product Details</legend>
                <input type="hidden" name="id" readonly="" value="<%= product.getId()%>" required>

                <div class="form-group">
                    <label class="col-md-4 control-label">Product Name :</label>
                    <div class="col-md-4 inputGroupContainer">
                        <div class="input-group">
                            <input name="name" placeholder="Product Name" value="<%=product.getName()%>" class="form-control" type="text">
                        </div>
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-md-4 control-label">Product Price : </label>
                    <div class="col-md-4 inputGroupContainer">
                        <div class="input-group">
                            <input name="price" placeholder="Product Price" value="<%=product.getPrice()%>" class="form-control" type="text">
                        </div>
                    </div>
                </div>

                <div class="form-group">
                    <label class="col-md-4 control-label"></label>
                    <div class="col-md-4">
                        <button type="submit" class="btn btn-warning">
                            Update Product's Details<span class=""></span>
                        </button>
                    </div>
                </div>

            </fieldset>
        </form>


    </div>
<jsp:include page="assets/footer.jsp"/>