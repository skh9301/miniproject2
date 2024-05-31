<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>  

<!-- header  -->
<div class="row border-bottom border-primary align-item-center" id="global-header">
	<div class= "row d-flex align-items-center my-2">
		<div class="col-3  " >
			<a href="main" class="align-item-center">
				<img src="resources/images/로고최종a.png"
					style="height: 80px; width: 240px">
			</a>
		</div>
		<div class="col-1 ">
			<a class="nav-link " href="exChange?itemNum=${itemNum}" style="font-size:25px;">거래소</a>
		</div>
		<div class="col-2 mx-3">
			<a class="nav-link " href="itemList" style="font-size:25px;">물품리스트</a>
		</div>
		<div class="col d-flex justify-content-end">
				<c:if test="${ sessionScope.isLogin }" >
					<a class="nav-link" href="bidListForm"  style="font-size:20px;">즐겨찾기</a>
					&nbsp;&nbsp;&nbsp;&nbsp;
					</c:if>
				<a class="nav-link "  style="font-size:20px;"${ not sessionScope.isLogin ? "data-bs-toggle='modal' data-bs-target='#loginModal'" : ""}
							href='${ sessionScope.isLogin ? "logout" : "#" }'>
							${ sessionScope.isLogin ? "로그아웃" : " 로그인" }</a>&nbsp;&nbsp;&nbsp;&nbsp;
				<c:if test="${ not sessionScope.isLogin }" >
					<a class="nav-link" href="joinForm"  style="font-size:20px;">회원가입</a>
				</c:if>
				<c:if test="${ sessionScope.isLogin }" >
					<a class="nav-link" href="memberUpdateForm"  style="font-size:20px;">정보수정</a>
				</c:if>
		</div>
	</div>
</div>