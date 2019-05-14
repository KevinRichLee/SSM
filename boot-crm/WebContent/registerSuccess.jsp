<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>Document</title>
	<style type="text/css">
.body{
    background: #ffffff;
    width: 100%;
    height: 100%;
    margin-top: 1%;
    text-align: center;
}
.img{
    padding-top: 10%;
}
.body-h{
    letter-spacing: 20px;
    font-size: 40px;
    margin-left: 6%
}


	</style>
</head>
<body>
<marquee><h1><font color="green">恭喜你!用户名:${users.userName }</font></h1></marquee>
	<div class="container-fluid container-fluid-bg">
    <div class="row">
        <nav class="header-top">
            
            <div  style="float: right;display: none;" id="count-down">
                <span style="padding-right: 30px"><label id="timedown">3</label>秒后将跳转至主页</span>
            </div>
        </nav>
    </div>
</div>
<div class="container-fluid main">
    <div class="row">
        <div class="body">
            <div>
                <img class="img" src="${pageContext.request.contextPath}/images/success.png" alt="注册成功">
            </div>
            <div>
                <h3 class="body-h">注册成功！</h3>
                <h3 class="body-h"><a href="${pageContext.request.contextPath}/index.jsp">returnLogin</a></h3>
            </div>
        </div>
    </div>
</div>

</body>
</html>