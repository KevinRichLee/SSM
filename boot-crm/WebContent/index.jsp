<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html>
<html>
<head>
<title>Eminent Login Form Flat Responsive widget Template :: xmoban.cn</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="Eminent Login Form Widget Responsive, Login form web template,Flat Pricing tables,Flat Drop downs  Sign up Web Templates, Flat Web Templates, Login signup Responsive web template, Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyEricsson, Motorola web design" />
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
<link href="${pageContext.request.contextPath}/css/style.css" rel='stylesheet' type='text/css' media="all" />
<script type="text/javascript">
    function checkUser(){
    	//1.焦点离开事件绑定
    	//2.获得文本框的数据
    	var userName=$("#userName").val();
    	//3.发送ajax请求
    	
    	$.post("${pageContext.request.contextPath }/Users/check.action",{"userName":userName},
    			//回调函数
    			function(data){
    		        
    		      if(data=="1"){
    		    	  //用户的注册名已经存在
    		    	  alert("用户的注册名已经存在");
    		    	  //阻止表单提交
    		    	  $("#checkFlag").val("false");
    		    	  return;
    		      }else if(!$("#userName").val()){
    		    	  alert("用户名不能为空");
    		      }
    		  
    		      else{
    		    	  //用户的注册名不存在
    		    	  alert("恭喜你此用户可使用");
    		    	  $("#checkFlag").val("true"); 
    		    	  return;
    		      }
    	})
    }
    //表单提交事件 当表单提交的时候 会执行该方法 该方法的返回值 如果是false 表单不会提交 如果是ture表单提交
    function checkSubmit(){
    	var flag = $("#checkFlag").val();
    	if(flag=="true"){
    		
    		return true;
    	}else{
    		alert("请更换用户名再次提交");
    		return false;
    	}
    }
/*     function checkLogin(){
    	if(${user}==null){
    		alert("您输入的用户名或密码错误请重新输入");
    		var flag = $("#checkFlag").val("false");
    		return flag;
    	}else{
    		var flag = $("#checkFlag").val("true");
    		return flag;
    	}
    } */
</script>

</head>
<body>

<h1>Eminent Login Form</h1>
<center><h3 style="color: white">${error}</h3></center>
<div class="form-w3ls">
    <ul class="tab-group cl-effect-4">
        <li class="tab active"><a href="#signin-agile">Sign In</a></li>
		<li class="tab"><a href="#signup-agile">Join Us</a></li>        
    </ul>
    <div class="tab-content">
        <div id="signin-agile">   
			<form action="${pageContext.request.contextPath}/Users/login.action" method="post" >
				<!-- <input type="hidden" id="checkFlag" value="true"/> -->
				
				<p class="header">User Name</p>
				<input type="text"  name="userName" value="User Name" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'User Name';}">
				
				<p class="header">Password</p>
				<input type="password" name="userPassword" value="Password" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'Password';}">
				
				<input type="checkbox" id="brand" value="">
				<label for="brand"><span></span> Remember me?</label>
				
				<input type="submit" class="sign-in" value="Sign In">
				
				<ul class="links">
					<li class="pass-w3ls"><a href="#">Forgot Password</a></li>
				</ul>
			</form>
		</div>
		<div id="signup-agile">   
			<form action="${pageContext.request.contextPath }/Users/register.action" method="post" onsubmit="return checkSubmit()" >
				<!-- 表单的内部任意一处加上隐藏域 该隐藏域表示表单是否可以被提交，表单默认可以提交 -->
				<input type="hidden" id="checkFlag" value="true"/>
				<p class="header">User Name</p>
				<input type="text" id="userName" name="userName" value="Your Full Name" onfocus="this.value = '';" onblur="checkUser()">
				
				<p class="header">Password</p>
				<input type="password" name="userPassword" value="Password" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'Password';}">
				
				<p class="header">Confirm Password</p>
				<input type="password" name="password" value="Confirm Password" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'Password';}">
				
				<p class="header">Phone</p>
				<input type="tel" name="userPhone" value="Your Phone Number" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'Your Phone Number';}">
				
				<p class="header">Email Address</p>
				<input type="email" name="userEmailAdr" value="Email@address.com" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'Email@address.com';}">
				
				
				
				<input type="submit" class="register" value="Register">
			</form>
		</div> 
    </div><!-- tab-content -->
</div> <!-- /form -->	  
<p class="copyright">© 2018 Eminent Login Form. All Rights Reserved | Design by mycodes.net</p>
<!-- js files -->
<script type="text/javascript" src="${pageContext.request.contextPath }/jquery/jquery-1.9.1.js"></script>
<script src='${pageContext.request.contextPath}/js/jquery.min.js'></script>
<script src="${pageContext.request.contextPath}/js/index.js"></script>
<!-- /js files -->
</body>
</html>
