<%@ include file="header.jsp" %>

<div class="container-fluid">
    <div class="row justify-content-center">

        <div class="col-xl-10 col-lg-12 col-md-9">
            <div class="card o-hidden border-0 shadow-lg my-5">
                <div class="card-body p-0">
                    <!-- Nested Row within Card Body -->
                    <div class="row">
                        <div class="col-lg-6 d-none d-lg-block bg-confirm-image"></div>
                        <div class="col-lg-6">
                            <div class="p-5 text-center">
                                <div class="text-center">
                                    <h1 class="h4 text-gray-900 mb-4">Are you sure?</h1>
                                </div>
                                <hr>
                                <br>
                                <a href="/dashboard/quiz/confirmdel/${quizid}" class="btn btn-danger" type="button"><i class="fas fa-search fa-sm"></i> Delete </a>
                                <a href="javascript:history.back()" class="btn btn-dark" type="button"><i class="fas fa-search fa-sm"></i> Cancel </a>
                                <br><br><br>
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