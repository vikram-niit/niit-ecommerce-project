<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<style>
a {
color:#ffffff;
}


ul li a.categories > a:focus, a:hover{
background:coral !important;
}

ul li a.categories{
background:none !important;
}

.caret{
color:#ffffff;
}
</style>
<nav id="mainNav" class="navbar navbar-default navbar-fixed-top">
        <div id="main-nav" class="container-fluid" >
        
      <%--  <c:out value="${pageContext.request.userPrincipal.name }"></c:out> --%>
            <!-- Brand and toggle get grouped for better mobile display -->
            <div class="navbar-header">
                <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                    <span class="sr-only">Toggle navigation</span> Menu <i class="fa fa-bars"></i>
                </button>
                 <c:if test="${loggedin == true}">   
                  <ul class="nav navbar-nav "> 
                 <li>
                        <a class="page-scroll" href="#">Welcome <c:out value="${userDetails.username }"></c:out>
                        
                        
                       <%--  ${pageContext.request.userPrincipal.name }
                        <c:out value="${pageContext.request.userPrincipal.name }"></c:out>--%>
                        </a> 
      </li>
      </ul>
      </c:if>
      <c:if test="${not empty pageContext.request.userPrincipal.name }">   
                  <ul class="nav navbar-nav "> 
                 <li>
                      <%--   <a class="page-scroll" href="#">Welcome <c:out value="${userDetails.username }"></c:out> --%>
                           <a class="page-scroll" href="#">Welcome <c:out value="${pageContext.request.userPrincipal.name }"></c:out>
                        <span class="icon__kTqJY"></span>
                        
                       <%--  ${pageContext.request.userPrincipal.name }
                        <c:out value="${pageContext.request.userPrincipal.name }"></c:out>--%>
                        </a> 
      </li>
      </ul>
      </c:if>
              <!--   <a class="navbar-brand page-scroll" href="#page-top">Start Bootstrap</a> -->
            </div>

            <!-- Collect the nav links, forms, and other content for toggling -->
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <ul class="nav navbar-nav navbar-right">
                	<li>
                        <a class="page-scroll" href='<c:url value="/home"></c:url>'>Home</a>
                    </li>
                    <li>
                        <a class="page-scroll" href='<c:url value="/about"></c:url>'>About</a>
                    </li>
                    <li class="dropdown">
                       <%--  <a class="page-scroll" href='<c:url value="/Products"></c:url>'>Products</a> --%>
                       
							   <a href='<c:url value="/Products"></c:url>'
							    class="categories" data-toggle="dropdown">Categories
							   <span class="caret" ></span>
							   </a>
							   <ul class="dropdown-menu">
							   <c:forEach items="${categories }" var="category">				
									<li>								
										<a  href='<c:url value="/getProductsByCategory/${category.id }"></c:url>'>
											<strong><c:out value="${category.name }"/></strong>
										</a>	
									
									</li>
								</c:forEach>
							   </ul>						
                    </li>
                    <li>
                        <a class="page-scroll" href='<c:url value="/contact"></c:url>'>Contact</a>
                    </li>
                    <%--  <li>
                        <a class="page-scroll" href='<c:url value="/LoginForm"></c:url>'>Login</a>
                     </li> --%>
                     <%-- <c:choose>
                     	<c:when test="${loggedin == true}">
                     		<li>	
      							<a href='<c:url value="/logout"></c:url>'>
      								<span class="glyphicon glyphicon-log-out"></span> Logout
      							</a>
      						</li>
      						
      						 <li>
                        <a class="page-scroll glyphicon glyphicon-shopping-cart" href="#" ></a>
                    </li>
      
                     	</c:when>
                     	<c:otherwise>
                     		<li><a href='<c:url value="/RegistrationForm"></c:url>'><span class="glyphicon glyphicon-user"></span> Sign Up</a></li>
      						<li><a href='<c:url value="/login"></c:url>'><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
                     	</c:otherwise>
                     </c:choose> --%>
                     
                     <c:choose>
                     	<c:when test="${not empty pageContext.request.userPrincipal.name}">
                     		<li>	
      							<a href='<c:url value="/logout"></c:url>'>
      								<span class="glyphicon glyphicon-log-out"></span> Logout
      							</a>
      						</li>
      						
      						 <li>
                        <a class="page-scroll glyphicon glyphicon-shopping-cart" href="#" ></a>
                    </li>
      
                     	</c:when>
                     	<c:otherwise>
                     		<li><a href='<c:url value="/RegistrationForm"></c:url>'><span class="glyphicon glyphicon-user"></span> Sign Up</a></li>
      						<li><a href='<c:url value="/login"></c:url>'><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
                     	</c:otherwise>
                     </c:choose>
                     <%-- <c:if test="${loggedin == false}">
                     <li><a href='<c:url value="/RegistrationForm"></c:url>'><span class="glyphicon glyphicon-user"></span> Sign Up</a></li>
      <li><a href='<c:url value="/login"></c:url>'><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
                    </c:if>
                    
                      <c:if test="${loggedin == true}">                     
      <li>
      <c:url value="/logout" var="logoutUrl"/>
            
             form method="post" action="${logoutUrl }" >
      
    <input type="submit" value="Log out" />
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>.
		</form>
		
      <a href='<c:url value="/logout"></c:url>'><span class="glyphicon glyphicon-log-out"></span> Logout</a></li>
      
     
     
                    </c:if>
                   --%>
                    
                 
                  
                </ul>
            </div>
            <!-- /.navbar-collapse -->
        </div>
        <!-- /.container-fluid -->
    </nav>
    
   