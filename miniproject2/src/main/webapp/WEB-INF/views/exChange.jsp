<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="row my-5 text-center" style="border: 1px solid">
	<div class="col-9 ">
		<div class="row">
			<div class="col">
				<img src="https://via.placeholder.com/950x500">
			</div>
		</div>
		<div class="row">
			<div class="col" style="border:1px solid">
				<div class="row my-2">
					<div class="col-7" style="border:1px solid">
						<table class="table table-hover">
							<tbody>
								<tr>
									<th>입찰번호</th>
									<th>입찰자</th>
									<th>입찰가격</th>
								</tr>
								<c:if test="${empty auction}">
								<c:forEach var="auction" items="${auction}">
								<tr>
									<td>&{auction.auctionNum}</td>
									<td>&{memberNick }</td>
									<td>&{auction.regPrice }</td>
								</tr>
								</c:forEach>
								</c:if>
							</tbody>
						</table>
					</div>
					<div class="col-5 justify-content-center" style="border:1px solid">
						<div class="row my-2">
							<div class="col">
							<div class="input-group mb-3">
							  <span class="input-group-text" id="basic-addon1" style="width:385px;">&{SessionScope.memberId}</span>
							</div>
							</div>
						</div>
						<div class="row my-2">
							<div class="col">
								<div class="input-group mb-3">
									<span class="input-group-text" style="width:130px;">남은 포인트 :</span>
									 <input	type="text" class="form-control"	aria-label="Amount (to the nearest dollar)" value="${member.point }"> 
									 <span	class="input-group-text">point</span>
								</div>
							</div>
						</div>
						<div class="row my-2">
							<div class="col">
								<div class="input-group">
									<span class="input-group-text" id="price" style="width:130px;">매수가격(KRW)</span> 
									<input type="text" class="form-control" 	aria-label="Recipient's username with two button addons"  value="${aList.regPrice }">
									<button class="btn btn-outline-secondary" type="button" 	id="plus">+</button>
									<button class="btn btn-outline-secondary" type="button" 	id="minus">-</button>
								</div>
							</div>
						</div>
						<div class="row my-4">
							<div class="col">
								<div class="input-group">
									<span class="input-group-text" id="quantity" style="width:130px;">주문수량</span> 
									<input	type="text" class="form-control"
										aria-label="Recipient's username with two button addons" value="1">
									<button class="btn btn-outline-secondary" type="button"
										id="quantityPlus">+</button>
									<button class="btn btn-outline-secondary" type="button"
										id="quantityMinus">-</button>
								</div>
							</div>
						</div>
						<div class="row my-4"  >
							<div class="col text-start">
								<input class="btn btn-primary" type="reset" value="초기화" style="width:130px;">
							</div>
							<div class="col text-end">
								<input class="btn btn-primary" type="button" value="매 수" style="width:130px;">
							</div>
						</div>
						<div class="row my-4">
							<div class="col">
								<input class="btn btn-primary" type="button" value="포인트 충전하기"  style="width:385px;">
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<div class="col-3" style="border:1px solid">
		<div class="row">
			<div class="col">
				 <table class="table table-hover">
					<thead>
						<tr>
							<td class="text-center" colspan="3"> 물품 현황 리스트</td>
						</tr>
						<c:if test="${empty iList }">
							<tr>
								<td>
									게시글이 존재하지 않습니다.
								</td>
							</tr>
						</c:if>
						<c:if test="${not empty iList }">
							<c:forEach var="iList" items="${iList }">
							<tr>
							
								<td>
									<a href="itemDetail?itemNum=${iList.itemNum}" class="link-dark">${iList.itemName}</a>
								</td>
								<td>
									${iList.itemPrice}
								</td>
								<td>
									${iList.memberId}
								</td>
							</tr>
							</c:forEach>
						</c:if>
					</thead>
				</table> 
			</div>
		</div>
	</div>
</div>