<%@ include file="header.jsp" %>

<div class="container-fluid">
    <div class="row justify-content-center">

        <div class="col-xl-10 col-lg-12 col-md-9">

            <div class="card o-hidden border-0 shadow-lg my-5">
                <div class="card-body p-0">
                    <!-- Nested Row within Card Body -->
                    <div class="row">
                        <div class="col-lg-6 d-none d-lg-block bg-login-image"></div>
                        <div class="col-lg-6">
                            <div class="p-5">
                                <br><br><br>
                                <div class="text-center">
                                    <h1 class="h4 text-gray-900 mb-4">Truly wonderful the mind of a child is.</h1>
                                    <br>
                                    <c:choose>
                                        <c:when test="${progress != null}">
                                            <br>
                                            <h3>Score: ${progress.goodanswers}/${progress.total}</h3>
                                            <br>
                                        </c:when>
                                        <c:otherwise>
                                            <br>
                                        </c:otherwise>
                                    </c:choose>
                                    <br>
                                    <h3>${notification}</h3>
                                    <br>
                                    <h3>${achiv.name}</h3>
                                    <h3><img src="${achiv.img}"></h3>
                                    <h3></h3>
                                </div>
                                <hr>
                                <br>
                                <a href="/dashboard/learn" class="btn btn-primary btn-user btn-block">Quiz list</a>
                                <br><br><br>
                                <br><br><br>
                                <br><br><br>
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