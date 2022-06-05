<%@ include file="header.jsp" %>

<div class="container-fluid">
    <div class="row justify-content-center">

        <div class="col-xl-10 col-lg-12 col-md-9">

            <div class="card o-hidden border-0 shadow-lg my-5">
                <div class="card-body p-0">
                    <!-- Nested Row within Card Body -->
                    <div class="row">
                        <div class="col-lg-6 d-none d-lg-block bg-bb8-image"></div>
                        <div class="col-lg-6">
                            <div class="p-5">
                                <br>
                                <div class="text-center">
                                    <h1 class="h4 text-gray-900 mb-4">Update your data!</h1>
                                    <h3>Fear is the path to the dark side. Fear leads to anger. Anger leads to hate. Hate leads to suffering.</h3>                                    </div>
                                <hr>
                                <form:form method="post"
                                           modelAttribute="user" action="/dashboard/user/edit">
                                    <form:hidden path="id"/>
                                    User Name: <form:input type="text" path="username" /><br>
                                    Email: <form:input type="email" path="email"/><br>
                                    New password: <form:input type="password" path="password" /><br>
                                    <br><br><br>
                                    <input type="submit" type="button" class="btn btn-primary btn-user btn-block" value="Update"><br>
                                </form:form>
                                <br><br><br>
                            </div>
                        </div>
                    </div>
                    <%--                                    ----%>
                </div>
            </div>

        </div>

    </div>
</div>
</div>
<!-- /.container-fluid -->
<%@ include file="footer.jsp" %>