<%@ include file="header.jsp" %>
<div class="container-fluid">

    <!-- Area Chart -->
    <div>
        <!-- Begin Page Content -->
        <div>

            <!-- Page Heading -->
            <h1 class="h3 mb-2 text-gray-800">Statistics</h1>
            <p>Quiz overall effectiveness:</p>
            <div class="row no-gutters align-items-center">
                <div class="col-auto">
                    <div class="h5 mb-0 mr-3 font-weight-bold text-gray-800">${quizeffectiveness}%</div>
                </div>
                <div class="col">
                    <div class="progress progress-sm mr-2">
                        <div class="progress-bar bg-info" role="progressbar"
                             style="width: ${quizeffectiveness}%" aria-valuenow="${quizeffectiveness}" aria-valuemin="0"
                             aria-valuemax="100"></div>
                    </div>
                </div>
            </div>
            <br>
            <a href="javascript:history.back()" class="btn btn-dark" type="button"><i class="fas fa-search fa-sm"></i> Back </a>
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
                                <th style="width: 20%">Question</th>
                                <th style="width: 20%">Answer</th>
                                <th style="width: 15%">Effe %</th>
                                <th style="width: 40%">...</th>
                            </tr>
                            </thead>
                            <tbody>
                            <c:forEach items="${questionseffectiveness}" var="elem">
                                <tr>
                                    <td>${elem.question.id}</td>
                                    <td>${elem.question.quest}</td>
                                    <td>${elem.question.answer}</td>
                                    <td>${elem.effe}%</td>
                                    <td>
                                        <div class="row no-gutters align-items-center">
                                            <div class="col">
                                                <div class="progress progress-sm mr-2">
                                                    <div class="progress-bar bg-info" role="progressbar"
                                                         style="width: ${elem.effe}%" aria-valuenow="${elem.effe}" aria-valuemin="0"
                                                         aria-valuemax="100"></div>
                                                </div>
                                            </div>
                                        </div>
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