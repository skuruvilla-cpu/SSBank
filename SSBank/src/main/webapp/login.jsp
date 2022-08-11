<%@ include file="header.jsp" %>
<div class="content">
    <div class="container-fluid">
        <div class="row">
            <div class="col-md-8 offset-md-2">

                <div class="account-content">
                    <div class="row align-items-center justify-content-center">
                        <div class="col-md-12 col-lg-12 login-right">
                            <div class="login-header">
                                <h3>Login <span>SS Bank</span></h3>
                            </div>
                            <form action="https://doccure-html.dreamguystech.com/template/index.html">
                                <div class="form-group form-focus">
                                    <input type="email" class="form-control floating">
                                    <label class="focus-label">Email</label>
                                </div>
                                <div class="form-group form-focus">
                                    <input type="password" class="form-control floating">
                                    <label class="focus-label">Password</label>
                                </div>
                                <button class="btn btn-primary w-100 btn-lg login-btn"
                                    type="submit">Login</button>
                                <div class="login-or">
                                    <span class="or-line"></span>
                                    <span class="span-or">or</span>
                                </div>
                                <div class="text-center dont-have">Don't have an account ? <a href="register">Register</a></div>
                            </form>
                        </div>
                    </div>
                </div>

            </div>
        </div>
    </div>
</div>

<%@ include file="footer.jsp" %>