<jsp:include page="header_cust.jsp"/>
<div class="col-md-8">
    <div class="container">
        <%=request.getAttribute("message") != null ? request.getAttribute("message") : "" %>

        <form class="well form-horizontal" action="add_customer" method="post"
              id="contact_form">
            <fieldset>
                <!-- Form Name -->
                <legend>Add Customer</legend>

                <div class="form-group">
                    <label class="col-md-4 control-label">Customer Name:</label>
                    <div class="col-md-4 inputGroupContainer">
                        <div class="input-group">
                            <input name="name" placeholder="Customer Name" class="form-control" type="text">
                        </div>
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-md-4 control-label">Customer Location:</label>
                    <div class="col-md-4 inputGroupContainer">
                        <div class="input-group">
                            <input name="location" placeholder="Customer Price" class="form-control" type="text">
                        </div>
                    </div>
                </div>

                <!-- Button -->
                <div class="form-group">
                    <label class="col-md-4 control-label"></label>
                    <div class="col-md-4">
                        <button type="submit" class="btn btn-success">
                            Add Customer
                        </button>
                    </div>
                </div>

            </fieldset>
        </form>
    </div>
</div>
<jsp:include page="assets/footer.jsp"/>