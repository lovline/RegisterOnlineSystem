<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ include file="header.jsp" %>
<%@ include file="nav.jsp" %>

<script type="text/javascript">
$(document).ready(function(){
	  $("#slideshow").owlCarousel({
		  singleItem: true,
		  slideSpeed : 300,
		  paginationSpeed : 400,
		  autoPlay: true
	  });
	});
</script>

<div class="row">
	<div class='col-md-12'>
		<div id="slideshow" class="text-center">
			<div>
			<img style="width:500px" src="${pageContext.request.contextPath}/images/kaoqin.jpg"></img>
			</div>
			<div>
			<img style="width:500px" src="${pageContext.request.contextPath}/images/qingjia2.jpeg"></img>
			</div>
			<div>
			<img style="width:500px" src="${pageContext.request.contextPath}/images/jishiben.jpg"></img>
			</div>
		</div>
	</div>
</div>

<c:if test="${ not is_logged }">
<div class="row">
	<div class="md-col-12 text-center">
		<a class="btn btn-primary btn-lg" href="${pageContext.request.contextPath}/register/">注册</a>
		<a class="btn btn-primary btn-lg" href="${pageContext.request.contextPath}/login/">登录</a>
	</div>
</div>
</c:if>



<%@ include file="footer.jsp" %>