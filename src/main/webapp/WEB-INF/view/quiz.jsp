<%@ include file="header.jsp" %>
<div class="container-fluid">

    <!-- Area Chart -->
    <div>
        <!-- Begin Page Content -->
        <div>

            <!-- Page Heading -->
            <h1 class="h3 mb-2 text-gray-800">Force control</h1>
            <p class="mb-4">lorem</p>
            <a href="/add" class="btn btn-success" type="button"><i class="fas fa-cash-register fa-sm"></i> Add </a>
            <br>
            <br>

            <!-- DataTales Example -->
            <div class="card shadow mb-4">
                <div class="card-header py-3">
                    <h6 class="m-0 font-weight-bold text-primary">Force control - quiz list!</h6>
                </div>
                <div class="card-body">
                    <div class="table-responsive">
                        <table class="table table-bordered">
                            <thead>
                            <tr>
                                <th style="width: 5%">id</th>
                                <th style="width: 45%">Title</th>
                                <th style="width: 10%">Subject</th>
                                <th style="width: 10%">Questions</th>
                                <th style="width: 20%">Actions</th>
                            </tr>
                            </thead>
                            <tbody>
                            <c:forEach items="${quizList}" var="elem">
                                <tr>
                                    <td>${elem.id}</td>
                                    <td>${elem.quizname}</td>
                                    <td>${elem.subject.name}</td>
                                    <td>22</td>
                                    <td>
                                        <a href="/details" class="btn btn-info" type="button"><i class="fas fa-search fa-sm"></i> Details </a>
                                        <a href="/delete" class="btn btn-danger" type="button"><i class="fas fa-search fa-sm"></i> Delete </a>
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