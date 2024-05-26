<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
 <%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>   
 <script src="resources/js/skill.js"></script>
 
 <div class="row m-5">
 	<div class="col text-end" >
 		<a href="writeForm" class="btn btn-outline-success" id="write">글쓰기</a>
 	</div>
 </div>
<div class="row  my-5 justify-content-center">
	<div class="col-10">
		<table class="table table-hover">
			<tbody>
			
				<c:if test="${empty iList }">
				<tr>
					<td>현재 게시물은 존재하지 않습니다</td>
				</tr>
				</c:if>
				<c:if test="${not empty iList }">
				<c:forEach var="iList" items="${iList }">
				<tr>
					<td rowspan="5" class="align-items-center justify-content-center ">
						<img src="resources/upload/${iList.itemFile}" class="w-100 h-75">
					</td>
					<td>판매물품 : </td>
					<td><a href="itemDetail?itemNum=${iList.itemNum}">${iList.itemName }</a></td>
				</tr>
				<tr>
					<td>브랜드: </td>
					<td>${iList.itemProducer }</td>
				</tr>
				<tr>
					<td>판매가격: </td>
					<td>${iList.itemPrice }</td>
				</tr>
				<tr>
					<td>남은 시간: </td>
					<td>
					    <div class="timer"></div>
					</td>
				</tr>
				<tr>
					<td></td>
					<td class="text-end">
					
					<!-- 아이디 가 admin이 아닐때 -->
						<a class="btn btn-primary" href="exChange?itemNum=${iList.itemNum}">경매참여</a>
					<!-- 아이디 가 admin일때 -->
					<c:if test="${sessionScope.member.memberId ==iList.memberId}">
					
						<input class="btn btn-primary endBtn" type="button" value="경매중지">
					</c:if>
					</td>
				</tr>
				</c:forEach>
				</c:if>
			</tbody>
		</table>
	</div>
</div>

