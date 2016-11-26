<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Creative - Start Bootstrap Theme</title>

    <!-- Bootstrap Core CSS -->
  <!--   <link href="/resources/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet"> -->
       <%-- <link href="/resources/css/bootstrap.min.css" rel="stylesheet">
		<link href="<c:url value="/resources/css/bootstrap.min.css"/>" 
		rel="stylesheet" />
		<link href="<c:url value="/resources/css/test.css"/>"
rel="stylesheet" />
<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/test.css" />" /> --%>

<!-- Bootstrap Core CSS (location of links modified -->
<link href="<c:url value="/resources/vendor/bootstrap/css/bootstrap.min.css" />" rel="stylesheet" type=""/>

    <!-- Custom Fonts -->
    <!-- <link href="vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
    <link href='https://fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,600italic,700italic,800italic,400,300,600,700,800' rel='stylesheet' type='text/css'>
    <link href='https://fonts.googleapis.com/css?family=Merriweather:400,300,300italic,400italic,700,700italic,900,900italic' rel='stylesheet' type='text/css'> -->

<!-- Custom Fonts(location of links modified -->
<link href="<c:url value="/resources/vendor/font-awesome/css/font-awesome.min.css" />" rel="stylesheet" type="text/css" />
<link href='https://fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,600italic,700italic,800italic,400,300,600,700,800' rel='stylesheet' type='text/css'>
    <link href='https://fonts.googleapis.com/css?family=Merriweather:400,300,300italic,400italic,700,700italic,900,900italic' rel='stylesheet' type='text/css'> 

    <!-- Plugin CSS -->
    <!-- <link href="/resources/vendor/magnific-popup/magnific-popup.css" rel="stylesheet"> -->
    
    <!-- Plugin CSS(links modified -->
	<link href="<c:url value="/resources/vendor/magnific-popup/magnific-popup.css" />" rel="stylesheet" type="text/css" />
	
    <!-- Theme CSS -->
    <!-- <link href="/resources/css/creative.min.css" rel="stylesheet"> -->

	<!-- Theme CSS(links modified) -->
	<link href="<c:url value="/resources/css/creative.min.css" />" rel="stylesheet" type="text/css" />	
	
    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

<style>
  .modal-header, h4, .close {
      background-color: #5cb85c;
      color:white !important;
      text-align: center;
      font-size: 30px;
  }
  .modal-footer {
      background-color: #f9f9f9;
  }
  
  button#myBtn{
  
  	font-size: 13px;
    margin-top: 5px;
    margin-left: 50px;
    margin-right:50px;
    border:none;
    font-weight:100px;
   // border-radius:0px;
  }
  
 
  .carousel-inner > .item > img,
  .carousel-inner > .item > a > img {
      width: 30%;
      margin: auto;
      height:500px;
      max-height:500px;
      width:auto
  }
 
 span#social-media{
 margin:60%;
 
 }
 
 header{
 padding-top:100px;
 }
  </style>

</head>

<body id="page-top">
  
    <jsp:include page="menubar.jsp"/>

    <header>
    <div id="content">
    <a href="flows">Start flow</a>
    <c:if test="${isAdmin }">
     <jsp:include page="./admin/admin.jsp"></jsp:include>
     </c:if>
     
    
    
    
        <c:if test="${displayLoginPage }">
     <jsp:include page="loginForm.jsp"></jsp:include>
     </c:if>
     
    
     
     <c:if test="${displayRegistrationForm }">
     <jsp:include page="registrationForm.jsp"></jsp:include>
     </c:if>
     
     <c:if test="${displayProductsPage }">
     <jsp:include page="products.jsp"></jsp:include>
     </c:if>
   
<c:if test="${displayAboutPage }">
     <jsp:include page="about.jsp"></jsp:include>
     </c:if>
     
     <c:if test="${displayContactPage }">
     <jsp:include page="contact.jsp"></jsp:include>
     </c:if>
     
     
    </header>
 </div>
    


    <div>
    	 <c:if test="${displayManageCategoriesPage }">
     <jsp:include page="admin/categories.jsp"></jsp:include>
     </c:if>
    </div>
    
    <c:if test="${displayHomePage }">
       <jsp:include page="home.jsp"/>
        </c:if>
        
    
<jsp:include page="footer.jsp"></jsp:include>
    
    

  
    <!-- jQuery -->
  <!--   <script src="vendor/jquery/jquery.min.js"></script> -->
    
    <!-- jQuery -->
    <script src="<c:url value="/resources/vendor/jquery/jquery.min.js" /> "></script>

    <!-- Bootstrap Core JavaScript -->
 <!--    <script src="vendor/bootstrap/js/bootstrap.min.js"></script> -->

 <!-- Bootstrap Core JavaScript(links modified -->
    <script src="<c:url value="/resources/vendor/bootstrap/js/bootstrap.min.js" /> " ></script>

    <!-- Plugin JavaScript -->
   <!--  <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-easing/1.3/jquery.easing.min.js"></script>
    <script src="vendor/scrollreveal/scrollreveal.min.js"></script>
    <script src="vendor/magnific-popup/jquery.magnific-popup.min.js"></script> -->

	<!-- Plugin JavaScript(links modified) -->
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-easing/1.3/jquery.easing.min.js"></script>
    <script src="<c:url value="/resources/vendor/scrollreveal/scrollreveal.min.js" /> " ></script>
    <script src="<c:url value="/resources/vendor/magnific-popup/jquery.magnific-popup.min.js" /> " ></script>
	
	
    <!-- Theme JavaScript -->
   <!--  <script src="js/creative.min.js"></script> -->
    
     <!-- Theme JavaScript(links modified -->
    <script src="<c:url value="/resources/js/creative.min.js" /> " ></script>
    
  

</body>

</html>
