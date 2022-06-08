<%@ include file="header.jsp" %>
<div class="container-fluid">

    <!-- Area Chart -->
    <div>
        <!-- Begin Page Content -->
        <div>

            <!-- Page Heading -->
            <h1 class="h3 mb-2 text-gray-800">Jedi training</h1>
            <p class="mb-4">Fear is the path to the dark side. Fear leads to anger. Anger leads to hate. Hate leads to suffering.</p>

            <br>
            <br>

            <!-- DataTales Example -->
            <div class="card shadow mb-4">
                <div class="card-header py-3">
                    <h6 class="m-0 font-weight-bold text-primary">The greatest teacher, failure is.</h6>
                </div>
                <div class="card-body">
                    <div class="table-responsive">
                        <table class="table table-bordered">
                            <thead>
                            <tr>
                                <th style="width: 5%">id</th>
                                <th style="width: 20%">Title</th>
                                <th style="width: 10%">Subject</th>
                                <th style="width: 15%">Last Effectiveness</th>
                                <th style="width: 50%">Actions</th>
                            </tr>
                            </thead>
                            <tbody>
                            <c:forEach items="${quizList}" var="elem">
                                <tr>
                                    <td>${elem.id}</td>
                                    <td>${elem.quizname}</td>
                                    <td>${elem.subject.name}</td>
                                    <td>
                                        <a href="/dashboard/learn/${elem.id}/statistic" class="btn btn-danger" type="button"><i class="fas fa-search fa-sm"></i> Statistics </a>
                                    </td>
                                    <td>
                                        <a href="/dashboard/learn/${elem.id}/browse/0" class="btn btn-success" type="button"><i class="fas fa-search fa-sm"></i> Browse </a>
<%--                                        <a href="/dashboard/learn/${elem.id}/know/0" class="btn btn-success" type="button"><i class="fas fa-search fa-sm"></i> Know?</a>--%>
<%--                                        <a href="/dashboard/learn/${elem.id}/write/0" class="btn btn-success" type="button"><i class="fas fa-search fa-sm"></i> Write </a>--%>
                                        <a href="/dashboard/learn/${elem.id}/quiz/0" class="btn btn-success" type="button"><i class="fas fa-search fa-sm"></i> Quiz </a>
                                        <a href="/dashboard/learn/${elem.id}/jedi/0" class="btn btn-success" type="button"><i class="fas fa-search fa-sm"></i> Jedi </a>
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