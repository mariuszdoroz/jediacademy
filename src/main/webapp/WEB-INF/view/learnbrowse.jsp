<%@ include file="header.jsp" %>

<div class="container-fluid">
    <div class="row justify-content-center">

        <div class="col-xl-10 col-lg-12 col-md-9">

            <div class="card o-hidden border-0 shadow-lg my-5">
                <div class="card-body p-0">
                    <!-- Nested Row within Card Body -->
                    <div class="row">
                        <div class="col-lg-6 d-none d-lg-block bg-browse-image"></div>
                        <div class="col-lg-6">
                            <div class="p-5">
                                <br><br><br>
                                <div class="text-center">
                                    <h1 class="h4 text-gray-900 mb-4">${quiz.quizname}</h1>
                                    <h3>${question.quest}</h3>
                                    <h3>???</h3>
                                    <h3>${question.answer}</h3>
                                </div>
                                <hr>
                                <br>
                                <a href="/dashboard/learn/${quiz.id}/browse/${questionid}" class="btn btn-primary btn-user btn-block">Next >></a>
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