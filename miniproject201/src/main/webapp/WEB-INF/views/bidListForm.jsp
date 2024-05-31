<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%> 
<script src="resources/js/skill.js"></script>
<form>
<input type="hidden" value="${sessionScope.member.memberId }"
		id="SmemberId" name="memberId">
<input type="hidden" value="${sessionScope.fonkyMemberId }"
		 name="fonkyMemberId">
<div class="row  my-3s justify-content-center">
	<span class="text-center fw-bold fs-1 my-4	">즐겨찾기 리스트</span>
	<div class="col-10">
	
		<table class="table table-hover border border-end-0 border-start-0">
			<tbody>
				
				<!-- 검색x 리스트x -->
				<c:if test="${empty bidList }">
					<tr colspan="5">
						<td class="text-center">즐겨찾기 물품이 없습니다.</td>
					</tr>
				</c:if>
		<c:forEach var="bidList" items="${bidList }">
						<tr>
							<td rowspan="5"
								class="align-items-center justify-content-center ">
								<a
								href="itemDetail?itemNum=${bidList.itemNum}"
								class="link-dark text-decoration-none">
								<img 	src="resources/upload/${bidList.itemFile}" style="height:300px;width:600px;">
								</a>
							</td>
							<td>판매물품 :</td>
							<td><a
								href="itemDetail?itemNum=${bidList.itemNum}"
								class="link-dark text-decoration-none">${bidList.itemName }</a></td>
						</tr>
						<tr>
							<td>브랜드:</td>
							<td>${bidList.itemProducer }</td>
						</tr>
						<tr>
							<td>판매가격:</td>
							<td>${bidList.itemPrice }</td>
						</tr>
						<tr>
							<td>${ not bidList.started ? "경매 시작 시간 : " : "경매 종료 시간: "}</td>
							<td>
								<div class="timer">									
									<c:if test="${ not bidList.started }">
										<!-- 경매가 시작되지 않았으면 시작 시간을 표시 -->
										${bidList.itemStartDate.split('T')[0]} ${bidList.itemStartDate.split('T')[1]}${ bidList.started }
									</c:if>
									<c:if test="${ bidList.started }">
										<!-- 경매가 시작되었으면 종료 시간을 표시 -->
										${bidList.itemEndDate.split('T')[0]} ${bidList.itemEndDate.split('T')[1]}
									</c:if>
								</div>
							</td>
						</tr>
						<tr >
							<td  colspan="2">
							 <div class="row d-flex justify-content-around ">
								<!-- 아이디 가 admin이 아닐때 --> 
								<div class="col">
								<c:if test="${sessionScope.member.memberId !=bidList.memberId && sessionScope.member.memberId != null}">
								<input class="btn btn-warning ItemMark"  type="button" value="즐겨찾기" data-itemnum="${bidList.itemNum}">
								</c:if>
								<c:if test="${sessionScope.member.memberId ==bidList.memberId}">
									<input class="btn btn-danger endBtn" type="button"
										value="경매중지">					
								</c:if>	
								</div>
								<!-- 경매가 시작되지 않았으면  -->
								<div class="col">
								<c:if test="${not bidList.started}">
								<span class="btn btn-warning">경매 준비중</span> 
								</c:if>									
								<!-- 경매가 시작되고 종료되지 않았으면 경매참여 버튼 활성화 -->
								<c:if test="${bidList.started and not bidList.finished}">
								<a class="btn btn-primary"
									href="exChange?itemNum=${bidList.itemNum}">경매참여</a> 
								</c:if>
								<!-- 경매가 종료되었으면 -->
								<c:if test="${bidList.finished}">
									<span class="btn btn-danger">경매 종료됨</span> 
								</c:if>
									</div>
								
								<!-- 아이디 가 admin일때 -->
								</div>							
							</td>
						</tr>
					</c:forEach>
		</tbody>
		</table>
	</div>
</div>

	</form>