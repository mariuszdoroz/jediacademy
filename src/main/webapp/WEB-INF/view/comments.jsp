<%@ include file="header.jsp" %>
<div class="container-fluid">

    <!-- Area Chart -->
    <div>
        <!-- Begin Page Content -->
        <div>

            <!-- Page Heading -->
            <h1 class="h3 mb-2 text-gray-800">Comments</h1>
            <p class="mb-4">Miss them do not. Attachment leads to jealousy.</p>
            <form:form method="post"
                       modelAttribute="comment">
               Comment: <form:textarea type="textarea" path="content" />
            <input class="btn btn-success fa-cash-register fa-sm" type="submit" value="Add comment!">
            </form:form>
            <br>
            <br>

            <!-- DataTales Example -->
            <div class="card shadow mb-4">
                <div class="card-header py-3">
                    <h6 class="m-0 font-weight-bold text-primary">${quizname} - comments!</h6>
                </div>
                <div class="card-body">
                    <div class="table-responsive">
                        <table class="table table-bordered thead-dark">
                            <thead>
                            <tr>
                                <th style="width: 5%">id</th>
                                <th style="width: 65%">Comment</th>
                                <th style="width: 15%">Date</th>
                                <th style="width: 15%">User Name</th>
                            </tr>
                            </thead>
                            <tbody>
                            <c:forEach items="${comments}" var="elem">
                                <tr>
                                    <td>${comments.id}</td>
                                    <td>${comments.content}</td>
                                    <td>${comments.date}</td>
                                    <td>${comments.user}</td>
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