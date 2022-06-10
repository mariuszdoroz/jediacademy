<%@ include file="header.jsp" %>

<div class="container-fluid">
    <div class="row justify-content-center">
        <div class="col-xl-10 col-lg-12 col-md-9">
            <div class="card o-hidden border-0 shadow-lg my-5">
                <div class="card-body p-0">
                    <div class="row">
                        <div class="col-lg-6 d-none d-lg-block bg-browse-image"></div>
                        <div class="col-lg-6">
                            <div class="p-5">
                                <br>
                                <div class="text-center">
                                    <h1 class="h4 text-gray-900 mb-4">${quiz.quizname}</h1>
                                    <h3>${question.quest}</h3>
                                    <h3>???</h3>
                                    <form method="post">
                                        <input type="hidden" name="goodid" id="goodid" value="${question.id}"/>
                                    <c:forEach items="${answer}" var="elem">
                                        <label>
                                            <input type="radio" name="answerid" id="answerid"
                                                   value="${elem.id}" required/>${elem.answer}
                                        </label>
                                        <br>
                                    </c:forEach>
                                    <input class="btn btn-primary btn-user btn-block" type="submit" value="Next >>"><br>
                                    </form>
                                </div>
                                <hr>
                                <br>
                                <br>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</div>
<!-- /.container-fluid -->
<%@ include file="footer.jsp" %>