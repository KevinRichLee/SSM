<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>栏目管理</title>
<link href="${pageContext.request.contextPath}/css/style.css" rel="stylesheet" type="text/css">
<script language="javascript" src="${pageContext.request.contextPath}/js/util.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-1.9.1.js"></script>
<script>

function form1(){
	
	$(function(){
		$("#myform").submit();
	});
}
function shanchu()
{
	var  str = confirm("是否确定删除上级栏目？");
	if(str == true)
	{
		alert("确定删除！");
		alert("${message}");
	}
	else
	{
		alert("取消删除！");
		
	}
}
</script>
</head>

<body leftmargin="0" topmargin="0" marginwidth="0" marginheight="0">
<center>
  <table width="100%" border="0" cellspacing="0" cellpadding="0">
    <tr>
      <td height="25" align="center" valign="bottom" class="td06"><table width="100%"  border="0" align="center" cellpadding="0" cellspacing="0">
        <tr>
          <td width="2%" valign="middle" background="${pageContext.request.contextPath}/images/bg_03.gif">&nbsp;</td>
          <td width="2%" valign="middle" background="${pageContext.request.contextPath}/images/bg_03.gif"><img src="${pageContext.request.contextPath}/images/main_28.gif" width="9" height="9" align="absmiddle"></td>
          <td height="30" valign="middle" background="${pageContext.request.contextPath}/images/bg_03.gif"><div align="left"><font color="#FFFFFF">栏目管理</font></div></td>
        </tr>
      </table></td>
    </tr>
  </table>
  <form id="myform"  method="post" action="${pageContext.request.contextPath}/test/queryNewsLabel.do">
    <table width="95%" border="0" align="center" cellpadding="0" cellspacing="0" class="table01">
      <tr>
        <td colspan="2" class="td_02"><SPAN class=td_title>根据栏目名称查询</SPAN></td>
      </tr>
      <tr>
        <td width="14%" class="td_02">栏目名称</td>
        <td width="86%" class="td_02">
          <select name="id" class="input" style="width:99% " onchange="form1()">
            <option value="0" >--请选择--</option>
            <c:forEach items="${parents }" var="parent">
               <option value="${parent.id }" <c:if test="${parent.id==id }">selected</c:if>> ${parent.label_name }</option>
            </c:forEach>
          </select>
        </td>
      </tr>
     <!--  <tr>
        <td class="td_02">二级栏目名称</td>
        <td class="td_02">
          <select name="select" class="input" style="width:99% ">
            <option value="1" selected>--请选择--</option>
            <option value="2">天下足球</option>
            <option value="3">我猜</option>
          </select>
        </td>
      </tr> -->
    </table>
    <br>
    <table width="95%"  border="0" align="center" cellpadding="0" cellspacing="0">
      <tr>
        <td class="td_page" align="left">
          <div align="right">
            <input name="Submit" type="submit" class="buttonface02" value="添加栏目" onClick="javascript:windowOpen('${pageContext.request.contextPath}/html/news/addNewsLabel.jsp','','',700,300,'','','')">
          </div></td>
      </tr>
    </table>
    <table width="95%" border="0" align="center" cellpadding="0" cellspacing="0" class="table01">
    
      <tr>
      <c:choose>
      <c:when test="${page.totalRows==0 }">
             <td colspan="5" align="right" class="td07"><img src="${pageContext.request.contextPath}/images/1.gif" width="4" height="5" align="absmiddle"> 首页　 <img src="${pageContext.request.contextPath}/images/2.gif" width="3" height="5" align="absmiddle"> 上一页　 <img src="${pageContext.request.contextPath}/images/2-2.gif" width="3" height="5" align="absmiddle"> 下一页 <img src="${pageContext.request.contextPath}/images/3.gif" width="4" height="5" align="absmiddle"> 末页　共 ${page.pagenum }/ ${page.totalPages }页 共${page.totalRows } 条记录</td>          
          </c:when>
      <%--只有一页的情况 --%>
      <c:when test="${page.totalPages==1 }">
             <td colspan="5" align="right" class="td07"><img src="${pageContext.request.contextPath}/images/1.gif" width="4" height="5" align="absmiddle"> 首页　 <img src="${pageContext.request.contextPath}/images/2.gif" width="3" height="5" align="absmiddle"> 上一页　 <img src="${pageContext.request.contextPath}/images/2-2.gif" width="3" height="5" align="absmiddle"> 下一页 <img src="${pageContext.request.contextPath}/images/3.gif" width="4" height="5" align="absmiddle"> 末页　共 ${page.pagenum }/ ${page.totalPages }页 共${page.totalRows } 条记录</td>          
          </c:when>
          <%--当前页是第一页--%>
          <c:when test="${page.pagenum==1 }">
             <td colspan="5" align="right" class="td07"><img src="${pageContext.request.contextPath}/images/1.gif" width="4" height="5" align="absmiddle"> 首页　 <img src="${pageContext.request.contextPath}/images/2.gif" width="3" height="5" align="absmiddle"> 上一页　 <img src="${pageContext.request.contextPath}/images/2-2.gif" width="3" height="5" align="absmiddle"> <a href="${pageContext.request.contextPath }/test/queryNewsLabel.do?pagenum=${page.pagenum+1}">下一页</a>　 <img src="${pageContext.request.contextPath}/images/3.gif" width="4" height="5" align="absmiddle"> <a href="${pageContext.request.contextPath }/test/queryNewsLabel.do?pagenum=${page.totalPages}">末页</a>　　共 ${page.pagenum }/ ${page.totalPages }页 共${page.totalRows } 条记录</td>          
          </c:when>
          <%--当前页是第末页--%>
             <c:when test="${page.pagenum==page.totalPages }">
             <td colspan="5" align="right" class="td07"><img src="${pageContext.request.contextPath}/images/1.gif" width="4" height="5" align="absmiddle"> <a href="${pageContext.request.contextPath }/test/queryNewsLabel.do?pagenum=1">首页</a>　 <img src="${pageContext.request.contextPath}/images/2.gif" width="3" height="5" align="absmiddle"><a href="${pageContext.request.contextPath }/test/queryNewsLabel.do?pagenum=${page.pagenum-1}"> 上一页</a>　 <img src="${pageContext.request.contextPath}/images/2-2.gif" width="3" height="5" align="absmiddle"> 下一页　 <img src="${pageContext.request.contextPath}/images/3.gif" width="4" height="5" align="absmiddle"> 末页　　共 ${page.pagenum }/ ${page.totalPages }页 共${page.totalRows } 条记录</td>          
          </c:when>
          <%--当前页是中间页--%>
          <c:otherwise>
             <td colspan="5" align="right" class="td07"><img src="${pageContext.request.contextPath}/images/1.gif" width="4" height="5" align="absmiddle"> <a href="${pageContext.request.contextPath }/test/queryNewsLabel.do?pagenum=1">首页</a>　 <img src="${pageContext.request.contextPath}/images/2.gif" width="3" height="5" align="absmiddle"><a href="${pageContext.request.contextPath }/test/queryNewsLabel.do?pagenum=${page.pagenum-1}"> 上一页</a>　 <img src="${pageContext.request.contextPath}/images/2-2.gif" width="3" height="5" align="absmiddle"> <a href="${pageContext.request.contextPath }/test/queryNewsLabel.do?pagenum=${page.pagenum+1}">下一页</a>　 <img src="${pageContext.request.contextPath}/images/3.gif" width="4" height="5" align="absmiddle"> <a href="${pageContext.request.contextPath }/test/queryNewsLabel.do?pagenum=${page.totalPages}">末页</a>　　共 ${page.pagenum }/ ${page.totalPages }页 共${page.totalRows } 条记录</td>          
          
          </c:otherwise>
      </c:choose>
      </tr>
      <tr>
        <td width="17%" class="td_top">栏目名称</td>
        <td width="15%" class="td_top">上级栏目名称</td>
        <td width="44%" class="td_top">栏目描述</td>
        <td width="12%" class="td_top">删除</td>
        <td width="12%" class="td_top">修改</td>
      </tr>
      <c:forEach items="${page.datas }" var="datas">
      <tr>
        <td class="td07">${datas.label_name }</td>
        <td class="td07">${datas.parent.label_name ==null? "无": datas.parent.label_name}</td>
        <td class="td07">${datas.label_content }</td>
        <td class="td07"><a href="${pageContext.request.contextPath }/test/deleteNewsLabel.do?id=${datas.id}" onClick="shanchu()">删除</a></td>
        <td class="td07"><a href="${pageContext.request.contextPath }/test/modifyNewsLabel.do?id=${datas.id}" >修改</a>
        </td>
      </tr>
      </c:forEach>
      
    </table>
    <p>&nbsp;</p>
  </form>
</center>
</body>
</html>
