<%@ include file="header.jsp" %>
<div class="container-fluid">

    <!-- Area Chart -->
    <div>
        <!-- Begin Page Content -->
        <div>

            <!-- Page Heading -->
            <h1 class="h3 mb-2 text-gray-800">Quiz details!</h1>
            <form:form method="post"
                       modelAttribute="question" action="/dashboard/question/add">

                Question: <form:input type="text" path="question" />
                Answer: <form:input type="text" path="answer" />
                <form:hidden path="quiz.id"/>

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
                                <th style="width: 47%">Question</th>
                                <th style="width: 48%">Answer</th>

                            </tr>
                            </thead>
                            <tbody>
                            <c:forEach items="${questionList}" var="elem">
                                <tr>
                                    <td>${elem.id}</td>
                                    <td>${elem.question}</td>
                                    <td>${elem.answer}</td>
                                    <td>
                                        <a href="/dashboard/question/edit/${elem.id}" class="btn btn-info" type="button"><i class="fas fa-search fa-sm"></i> Edit </a>
                                        <a href="/dashboard/question/delete/${elem.id}" class="btn btn-danger" type="button"><i class="fas fa-search fa-sm"></i> Delete </a>
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