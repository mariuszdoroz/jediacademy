<%@ include file="header.jsp" %>
<div class="container-fluid">

    <!-- Area Chart -->
    <div>
        <!-- Begin Page Content -->
        <div>

            <!-- Page Heading -->
            <h1 class="h3 mb-2 text-gray-800">Force control</h1>
            <p class="mb-4">The fear of loss is a path to the dark side. Death is a natural part of life. Rejoice for those around you who transform into the Force. Mourn them do not. Miss them do not. Attachment leads to jealousy. The shadow of greed that is. Train yourself to let go of everything you fear to lose.</p>
            <form:form method="post"
                       modelAttribute="quiz" action="/dashboard/quiz/add">
               Quiz Title: <form:input type="text" path="quizname" />
            <form:select itemValue="id" itemLabel="name" path="subject"
                         items="${subjects}" />
            <input class="btn btn-success fa-cash-register fa-sm" type="submit" value="Add new quiz!">
            </form:form>
            <br>
            <br>

            <!-- DataTales Example -->
            <div class="card shadow mb-4">
                <div class="card-header py-3">
                    <h6 class="m-0 font-weight-bold text-primary">Force control - quiz list!</h6>
                </div>
                <div class="card-body">
                    <div class="table-responsive">
                        <table class="table table-bordered thead-dark">
                            <thead>
                            <tr>
                                <th style="width: 5%">id</th>
                                <th style="width: 35%">Title</th>
                                <th style="width: 10%">Subject</th>
<%--                                <th style="width: 10%">Comments</th>--%>
                                <th style="width: 20%">Actions</th>
                            </tr>
                            </thead>
                            <tbody>
                            <c:forEach items="${quizList}" var="elem">
                                <tr>
                                    <td>${elem.id}</td>
                                    <td>${elem.quizname}</td>
                                    <td>${elem.subject.name}</td>
<%--                                    <td>--%>
<%--                                        <a href="/dashboard/comments/${elem.id}" class="btn btn-info" type="button"><i class="fas fa-search fa-sm"></i> Comments </a>--%>
<%--                                    </td>--%>
                                    <td>
                                        <a href="/dashboard/quiz/details/${elem.id}" class="btn btn-warning" type="button"><i class="fas fa-search fa-sm"></i> Details </a>
                                        <a href="/dashboard/quiz/delete/${elem.id}" class="btn btn-danger" type="button"><i class="fas fa-search fa-sm"></i> Delete </a>
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