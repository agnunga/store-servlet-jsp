<%@include file="assets/header.jsp"%>
<div style="margin: 20%">
    <h2 style="text-align: left;">
        Sorry! It seems this page ran into a situation it may not recover from:<br/>
    </h2>
    <h3 style="text-align: center;">
        <% response.sendRedirect("view_products"); %>
    </h3>
</div>
<%@include file="assets/footer.jsp"%>