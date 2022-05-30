<%@ include file="header.jsp" %>
    <div class="row gutters-sm">
        <div class="col-md-4 mb-3">
            <div class="card">
                <div class="card-body">
                    <div class="d-flex flex-column align-items-center text-center">
                        <img src="https://bootdey.com/img/Content/avatar/avatar7.png" alt="Admin" class="rounded-circle" width="150">
                        <div class="mt-3">
                            <h4>${user.username}</h4>
                            <p class="text-secondary mb-1">${user.tier.tiername}</p>
                            <div class="col-sm-12">
                                <a class="btn btn-info " target="__blank" href="/dashboard/user/edit">Edit</a>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="col-md-8">
            <div class="card mb-3">
                <div class="card-body">
                    <div class="row">
                        <div class="col-sm-3">
                            <h6 class="mb-0">Id</h6>
                        </div>
                        <div class="col-sm-9 text-secondary">
                            ${user.id}
                        </div>
                    </div>
                    <hr>
                    <div class="row">
                        <div class="col-sm-3">
                            <h6 class="mb-0">Name</h6>
                        </div>
                        <div class="col-sm-9 text-secondary">
                            ${user.username}
                        </div>
                    </div>
                    <hr>
                    <div class="row">
                        <div class="col-sm-3">
                            <h6 class="mb-0">Email</h6>
                        </div>
                        <div class="col-sm-9 text-secondary">
                            ${user.email}
                        </div>
                    </div>
                    <hr>
                    <div class="row">
                        <div class="col-sm-3">
                            <h6 class="mb-0">Achievements:</h6>
                        </div>
                        <div class="col-sm-9 text-secondary">
                            <c:forEach items="${user.achievements}" var="achi">
                                <img src="${achi.img}" title="${achi.name}">
                            </c:forEach>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<!-- /.container-fluid -->
<%@ include file="footer.jsp" %>
