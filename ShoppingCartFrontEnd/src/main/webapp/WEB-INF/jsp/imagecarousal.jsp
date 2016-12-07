<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

    
<div id="myCarousel" class="carousel slide" data-ride="carousel">
  <!-- Indicators -->
  <ol class="carousel-indicators">
    <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
    <li data-target="#myCarousel" data-slide-to="1"></li>
    <li data-target="#myCarousel" data-slide-to="2"></li>
    <li data-target="#myCarousel" data-slide-to="3"></li>
    <li data-target="#myCarousel" data-slide-to="4"></li>
    <li data-target="#myCarousel" data-slide-to="5"></li>
  </ol>

  <!-- Wrapper for slides -->
  <div class="carousel-inner" role="listbox">
    <div class="item active">
      <a href="<c:url value="/resources/img/electronicDevices/1.jpg" />" >
       <img src="<c:url value="/resources/img/electronicDevices/1.jpg" />" class="img-responsive" alt="">
    </div>

    <div class="item">
      <a href="<c:url value="/resources/img/electronicDevices/2.jpg" />" >
       <img src="<c:url value="/resources/img/electronicDevices/2.jpg" />" class="img-responsive" alt="">
    </div>

    <div class="item">
       <a href="<c:url value="/resources/img/electronicDevices/3.jpg" />" >
       <img src="<c:url value="/resources/img/electronicDevices/3.jpg" />" class="img-responsive" alt="">
    </div>

    <div class="item">
     <a href="<c:url value="/resources/img/electronicDevices/4.jpg" />" >
       <img src="<c:url value="/resources/img/electronicDevices/4.jpg" />" class="img-responsive" alt="">
    </div>
    
     <div class="item">
     <a href="<c:url value="/resources/img/electronicDevices/6.jpg" />" >
       <img src="<c:url value="/resources/img/electronicDevices/6.jpg" />" class="img-responsive" alt="">
    </div>    
    
    <div class="item">
     <a href="<c:url value="/resources/img/electronicDevices/7.jpg" />" >
       <img src="<c:url value="/resources/img/electronicDevices/7.jpg" />" class="img-responsive" alt="">
    </div>
  </div>

  <!-- Left and right controls -->
  <a class="left carousel-control" href="#myCarousel" role="button" data-slide="prev">
    <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
    <span class="sr-only">Previous</span>
  </a>
  <a class="right carousel-control" href="#myCarousel" role="button" data-slide="next">
    <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
    <span class="sr-only">Next</span>
  </a>
</div>
 

</body>
</html>