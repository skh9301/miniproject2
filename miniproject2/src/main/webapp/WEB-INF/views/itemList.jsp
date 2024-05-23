<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
 <%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>   
 
 <div class="row m-5">
 	<div class="col text-end" >
 		<a href="writeForm" class="btn btn-outline-success">글쓰기</a>
 	</div>
 </div>
<div class="row  my-5 justify-content-center">
	<div class="col-8">
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
					<td rowspan="5">${item.itemFile }</td>
					<td>판매물품 : </td>
					<td><a href="itemDetail?itemNum=${iList.itemNum}">${iList.itemName }</a></td>
				</tr>
				<tr>
					<td>판매가격: </td>
					<td>${iList.itemPrice }</td>
				</tr>
				<tr>
					<td>남은시간: </td>
					<td>${iList.itemName }</td>
				</tr>
				<tr>
					<td>올린시간: </td>
					<td></td>
				</tr>
				<tr>
					<td></td>
					<td class="text-end">
					<input class="btn btn-primary" type="button" value="경매참여하기">
					</td>
				</tr>
				</c:forEach>
				</c:if>
			</tbody>
		</table>
	</div>
</div>

