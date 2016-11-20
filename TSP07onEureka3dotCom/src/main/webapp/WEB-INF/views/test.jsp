<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" 
           prefix="c" %>

<%@ taglib uri="http://test10.eureka3.com/tags/ResultTag"
           prefix="result"%>

<!DOCTYPE html>
<html>

<head>

<meta http-equiv="Content-type" content="text/html; charset=utf-8">

<%@ include file="commonreference.jsp" %>

<title>
Insert title here
</title>
</head>

<body>

<div class="centerContents">

<%@ include file="commonheader.jsp" %>

<form action="/TSP07onEureka3dotCom/test" method="post">
<div class="oneLineInSearchForm">
郵便番号上3桁・範囲検索<br/>
</div>
<div class="oneLineInSearchForm">
<span class="oneItemInSearchForm1of5">開始条件</span>
<span class="oneItemInSearchForm2of5"></span>
<span class="oneItemInSearchForm3of5">終了条件</span>
<span class="oneItemInSearchForm4of5"></span>
<span class="oneItemInSearchForm5of5"></span>
</div>
<div class="oneLineInSearchForm">
<span class="oneItemInSearchForm1of5"><input type="text" name="codeFrom" class="oneItemInSearchForm1of5"></span>
<span class="oneItemInSearchForm2of5">〜</span>
<span class="oneItemInSearchForm3of5"><input type="text" name="codeTo" class="oneItemInSearchForm3of5"></span>
<span class="oneItemInSearchForm4of5"></span>
<span class="oneItemInSearchForm5of5"></span>
</div>
<div class="oneLineInSearchForm">
<span class="oneItemInSearchForm1of5"></span>
<span class="oneItemInSearchForm2of5"></span>
<span class="oneItemInSearchForm3of5"></span>
<span class="oneItemInSearchForm4of5"></span>
<span class="oneItemInSearchForm5of5"><input type="submit" value="submit"></span>
</div>
</form>
</div>

<div class="centerContents">
<%
  String codeFrom = "";
  String codeTo = "";
  String methodName = request.getMethod();
  if (methodName.equals("GET")) {
  } else {
    codeFrom = request.getParameter("codeFrom");
    codeTo = request.getParameter("codeTo");
  }
%>
<result:ResultTag searchFrom="<%=codeFrom %>" searchTo="<%=codeTo %>" methodName="<%=methodName %>" />
</div>

</body>

</html>