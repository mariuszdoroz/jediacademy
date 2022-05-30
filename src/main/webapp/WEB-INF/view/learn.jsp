<%@ include file="header.jsp" %>
<div class="container-fluid">

    <!-- Area Chart -->
    <div>
        <!-- Begin Page Content -->
        <div>

            <!-- Page Heading -->
            <h1 class="h3 mb-2 text-gray-800">Tables</h1>
            <p class="mb-4">DataTables is a third party plugin that is used to generate the demo table below.
                For more information about DataTables, please visit the</p>
            <button class="btn btn-success" type="button"><i class="fas fa-search fa-sm"></i> Add </button>
            <br>
            <br>

            <!-- DataTales Example -->
            <div class="card shadow mb-4">
                <div class="card-header py-3">
                    <h6 class="m-0 font-weight-bold text-primary">Example Table</h6>
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
                            <tr>
                                <td>1</td>
                                <td>Quiz title</td>
                                <td>Geography</td>
                                <td>22</td>
                                <td>
                                    <button class="btn btn-info" type="button"><i class="fas fa-search fa-sm"></i> Details </button>
                                    <button class="btn btn-danger" type="button"><i class="fas fa-search fa-sm"></i> Delete </button>
                                </td>
                            </tr>
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