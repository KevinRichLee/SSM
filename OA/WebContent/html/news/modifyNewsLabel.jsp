<%@ page language="java" contentType="text/html; charset=UTF-8"    pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>栏目管理</title>
<link href="${pageContext.request.contextPath}/css/style.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.9.1.js"></script>
<script>
function xiugai2()
{
	var str = confirm("是否确定修改栏目名称？");
	if(str == true)
	{
		alert("确定修改！");
		$(function(){
			$("#form1").submit();
			alert("修改成功")
		});
		
	}
	else
	{
		alert("取消修改！");
	}
}
</script>

</head>

<body leftmargin="0" topmargin="0" marginwidth="0" marginheight="0">
<center>
  <table width="100%" border="0" cellspacing="0" cellpadding="0">
    <tr>
      <td height="25" align="center" valign="bottom" class="td06"> <table width="100%"  border="0" align="center" cellpadding="0" cellspacing="0">
        <tr>
          <td width="2%" valign="middle" background="${pageContext.request.contextPath}/images/bg_03.gif">&nbsp;</td>
          <td width="2%" valign="middle" background="${pageContext.request.contextPath}/images/bg_03.gif"><img src="${pageContext.request.contextPath}/images/main_28.gif" width="9" height="9" align="absmiddle"></td>
          <td height="30" valign="middle" background="${pageContext.request.contextPath}/images/bg_03.gif"><div align="left"><font color="#FFFFFF">栏目修改</font></div></td>
        </tr>
      </table></td>
    </tr>
  </table>
  <form id="form1" method="post" action="${pageContext.request.contextPath }/test/modifyNewsLabel1.do">
    <table width="95%" border="0" align="center" cellpadding="0" cellspacing="0" class="table01">
      <tr>
        <td class="td_02">栏目名称</td>
        <td class="td_02"><input name="label_name" type="text" class="input" style="width:99% " value="${newslabel.label_name }"></td>
      </tr>
      <tr>
        <td class="td_02">上级栏目名称</td>
        <td class="td_02">          
            <select name="parent_id"  style="width:99% ">
            <!-- <option value="--请选择--" selected>--请选择--</option> -->
            <option value="${newslabel.id }">无</option>
            <c:forEach items="${parents }" var="parent">
               <option value="${newslabel.id }"  ${parent.id == newslabel.parent.id ? 'selected' :' '}  >${parent.label_name }</option>
            </c:forEach>
            
          </select></td>
      </tr>
      <tr>
        <td width="14%" class="td_02">栏目描述</td>
        <td width="86%" class="td_02">
          <textarea name="label_content" rows="5" style="width:99% "></textarea>
        </td>
      </tr>
    </table>
    <br>
    <table width="95%"  border="0" align="center" cellpadding="0" cellspacing="0">
      <tr>
        <td class="td_page"><div align="center">
            
            <input name="Submit" type="submit" class="buttonface02" value="  修 改  " onClick="xiugai2()">
            &nbsp;&nbsp;
            <input name="Submit" type="reset" class="buttonface02" value="  重 置  ">
            &nbsp; 
            <input name="Submit" type="submit" class="buttonface02" value="  关 闭  " onClick="window.close()">
        </div></td>
      </tr>
    </table>
    <p>&nbsp;</p>
  </form>
</center>
</body>
</html>
