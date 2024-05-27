<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 

	<div class="row my-5" >
		<div class="col">
			<div class="timer bg-dark text-white h-100 fs-1 fw-bold text-center" data-start="${item.itemStartDate}" data-end="${item.itemEndDate}"></div>
		</div>
	</div>
<div class="row my-5 text-center border " >
	<form id="exChange" name="exChange">
		<input type="hidden" id="itemNum" value="${item.itemNum }">
	</form>
	<div class="col-8 ">
		<div class="row">
			<div class="col">
				<img src="resources/upload/${item.itemFile}" class="w-100" >
			</div>
		</div>
		<div class="row">
			<div class="col">
				<div class="row my-2">
					<div class="col-7">
						<table class="table table-hover border border-end-0 border-start-0">
							<tbody>
								<tr>
									<th>입찰번호</th>
									<th>입찰자</th>
									<th>입찰가격</th>
								</tr>
								<c:if test="${ empty aList}">
									<tr>
										<td class="text-center" colspan="3"> 입찰자가 없습니다</td>
									</tr>
								</c:if>
								<c:if test="${not empty aList}">
								<c:forEach var="aList" items="${aList}">
								<tr>
									<td>${aList.auctionNum}</td>
									<td>${aList.memberNick }</td>
									<td>${aList.regPrice }</td>
								</tr>
								</c:forEach>
								</c:if>
							</tbody>
						</table>
					</div>
					<div class="col-5 justify-content-center" >
						<div class="row my-2">
							<div class="col">
							<div class="input-group mb-3">
							  <span class="input-group-text text-end" id="basic-addon1" style="width:385px; height:40px;">${sessionScope.member.memberNick == null? "로그인이 되어있지 않습니다." : sessionScope.member.memberNick}</span>
							</div>
							</div>
						</div>
						<div class="row my-2">
							<div class="col">
								<div class="input-group mb-3">
									<span class="input-group-text" style="width:130px;">남은 포인트 :</span>
									 <input	type="text" class="form-control"	aria-label="Amount (to the nearest dollar)" value="${sessionScope.member.memberPoint }" readonly > 
									 <span	class="input-group-text">point</span>
								</div>
							</div>
						</div>
						<div class="row my-2">
							<div class="col">
								<div class="input-group">
									<span class="input-group-text" id="price" style="width:130px;">매수가격(KRW)</span> 
									<input type="text" class="form-control" 	aria-label="Recipient's username with two button addons"  
									value="${item.itemPrice}" id="itemPrice" name="auctionPrice">
									<button class="btn btn-outline-secondary" type="button" 	id="plus">+</button>
									<button class="btn btn-outline-secondary" type="button" 	id="minus">-</button>
								</div>
							</div>
						</div>
						<div class="row my-4"  >
							<div class="col text-start">
								<input class="btn btn-primary" type="reset" value="초기화" style="width:130px;">
							</div>
							<div class="col text-end">
								<input class="btn btn-primary" type="button" value="매 수" style="width:130px;" id="buyBtn">
							</div>
						</div>
						<div class="row my-4">
							<div class="col">
								<input class="btn btn-primary" type="button" value="포인트 충전하기"  style="width:345px;">
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<div class="col-4">
		<div class="row">
			<div class="col">
				 <table class="table table-hover border border-end-0 border-start-0 border-top-0">
					<thead>
						<tr>
							<td class="text-center" colspan="3"> 물품 현황 리스트</td>
						</tr>
						<tr>
								<th>
									물품이름
								</th>
								<th>
									물품가격
								</th>
								<th>
									판매자
								</th>
							</tr>
						<c:if test="${empty aiList }">
							<tr>
								<td class="text-center" colspan="3"> 게시글이 존재하지 않습니다.</td>
							</tr>
						</c:if>
						<c:if test="${not empty aiList }">
							<c:forEach var="aiList" items="${aiList }">
							<tr>
								<td>
									<a href="exChange?itemNum=${aiList.itemNum}" class="link-dark ltext-decoration-none">${aiList.itemName}</a>
								</td>
								<td>
									${aiList.itemPrice}
								</td>
								<td>
									${aiList.memberId}
								</td>
							</tr>
							</c:forEach>
						</c:if>
					</thead>
				</table> 
			</div>
		</div>
		<div class="row">
	<div class="col">
		<nav aria-label="Page navigation">
			<ul class="pagination justify-content-center">
			<c:if test="${ aStartPage > aPageGroup }">
					<li class="page-item"><a class="page-link"
						href="exChange?pageNum=${ aStartPage -
						aPageGroup }">Pre</a></li>
				</c:if>
				<c:forEach var="i" begin="${aStartPage}" end="${aEndPage}">
					<c:if test="${i == currentPage }">
						<li class="page-item active" aria-current="page"><span
							class="page-link">${i}</span></li>
					</c:if>
					<c:if test="${i != currentPage }">
						<li class="page-item"><a class="page-link"
							href="exChange?itemNum=${item.itemNum }&pageNum=${ i }">${i}</a></li>
					</c:if>
				</c:forEach>
				<c:if test="${ aEndPage < aPageCount }">
					<li class="page-item"><a class="page-link"
						href="exChange?pageNum=${ aStartPage +
								aPageGroup }">Next</a></li>
				</c:if>
			</ul>
		</nav>
	</div>
</div>
	</div>
	
</div>