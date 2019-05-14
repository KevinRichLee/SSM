<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html>
<html>
<head>
<title>修改密码</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="Eminent Login Form Widget Responsive, Login form web template,Flat Pricing tables,Flat Drop downs  Sign up Web Templates, Flat Web Templates, Login signup Responsive web template, Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyEricsson, Motorola web design" />
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
<link href="${pageContext.request.contextPath}/css/style.css" rel='stylesheet' type='text/css' media="all" />

<script>
   function checkForm(){

   //校验表单内的数据
   //定义出来如果有错误，将flag置为false即可
   var flag = true;
   //进行判断
   //1.当前用户，不允许修改用户名(将文本框置为readyonly只读属性) 需要显示用户名(从session获得即可)
   //2.获得用户输入的旧密码要与原来密码一致
   var oldPwd = "${user.userPassword}";
   var inputOldPwd = $("#oldPassword").val();
   if(oldPwd!=inputOldPwd){
	   alert("输入的旧密码错误 请重新输入");
	   flag = false; //表示表单将不会提交
   }
   //3.判断新密码不能为Null,并且确认密码必须和新密码一致
   var newPwd = $("#newPassword").val();
   var rePwd = $("#rePassword").val();
   if(newPwd.length==0){
	   alert("新密码不能为空");
	   flag=false;
   }
   if(newPwd!=rePwd){
	   alert("新密码和确认密码不一致 请修改后尝试");
	   flag=false;
   }
   //否则返回true
      return flag;
   }
</script>

</head>
<body>

<h1>Eminent Modify Form</h1>

<div class="form-w3ls">
    
    
        <div id="signin-agile">   
			<form action="${pageContext.request.contextPath}/Users/modify.action" method="post" onsubmit="return checkForm()">
				<!-- <input type="hidden" id="checkFlag" value="true"/> -->
				
				<p class="header">User Name</p>
				<input type="text"  name="userName" value="${user.userName }"  readonly="readonly">
				
				<p class="header">Old Password</p>
				<input type="password" id="oldPassword" name="oldPassword" value="" onfocus="this.value = '';" >
				
				<p class="header">New Password</p>
				<input type="password" id="newPassword" name="userPassword" value="" onfocus="this.value = '';" >
				
				<p class="header">Confirm Password</p>
				<input type="password" id="rePassword" name="rePassword" value="" onfocus="this.value = '';" >
				
				<input type="submit" class="sign-in" value="Modify In">
				
				
			</form>
		</div>
    
</div> <!-- /form -->	  
<p class="copyright">© 2018 Eminent Login Form. All Rights Reserved | Design by mycodes.net</p>
<!-- js files -->
<script type="text/javascript" src="${pageContext.request.contextPath }/jquery/jquery-1.9.1.js"></script>
<script src='${pageContext.request.contextPath}/js/jquery.min.js'></script>
<script src="${pageContext.request.contextPath}/js/index.js"></script>
<!-- /js files -->
</body>
</html>
