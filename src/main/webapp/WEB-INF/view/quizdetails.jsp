<%@ include file="header.jsp" %>
<div class="container-fluid">

    <!-- Area Chart -->
    <div>
        <!-- Begin Page Content -->
        <div>

            <!-- Page Heading -->
            <h1 class="h3 mb-2 text-gray-800">Quiz details!</h1>
            <form:form method="post"
                       modelAttribute="question" action="/dashboard/quiz/details/${quiz.id}">

                Question: <form:input path="quest" />
                Answer: <form:input path="answer" />

                <input class="btn btn-success fa-cash-register fa-sm" type="submit" value="Add new question!">
            </form:form>

            <br>
            <br>

            <!-- DataTales Example -->
            <div class="card shadow mb-4">
                <div class="card-header py-3">
                    <h6 class="m-0 font-weight-bold text-primary">${quiz.quizname}</h6>
                </div>
                <div class="card-body">
                    <div class="table-responsive">
                        <table class="table table-bordered">
                            <thead>
                            <tr>
                                <th style="width: 5%">id</th>
                                <th style="width: 37%">Question</th>
                                <th style="width: 38%">Answer</th>
                                <th style="width: 20%">Actions</th>

                            </tr>
                            </thead>
                            <tbody>
                            <c:forEach items="${questionList}" var="elem">
                                <tr>
                                    <td>${elem.id}</td>
                                    <td>${elem.quest}</td>
                                    <td>${elem.answer}</td>
                                    <td>
                                        <a href="/dashboard/quiz/${quiz.id}/question/delete/${elem.id}" class="btn btn-danger" type="button"><i class="fas fa-search fa-sm"></i> Delete </a>
                                    </td>
                                </tr>
                            </c:forEach>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        </div>
        <!-- /.container-fluid -->
    </div>
</div>
<%@ include file="footer.jsp" %>