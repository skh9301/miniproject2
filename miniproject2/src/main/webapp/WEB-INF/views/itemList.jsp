<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<script src="resources/js/skill.js"></script>
<form name="searchForm" id="searchForm" action="itemList">
<input type="hidden" value="${sessionScope.member.memberId }"
		id="SmemberId">
<div class="row m-5 py-3  border-bottom justify-content-center">
	<div class="col-auto ">
		<select name="type" class="form-select">
			<option value="item_name">제목</option>
			<option value="member_id">작성자</option>
			<option value="item_producer">브랜드</option>
		</select>
	</div>
	<div class="col-4">
		<input type="text" name="keyword" class="form-control">
	</div>
	<div class="col-auto">
		<input type="submit" value="검 색" class="btn btn-primary">
	</div>
	</form>
	<div class="row my-2">
		<div class="col">
			<c:if test="${ searchOption }">
			<div class="col text-center " >
				"${ keyword }" 검색 결과
				</div>
				</c:if>
		</div>
	</div>
		<div class="row my-3">
			<div class="col text-end ">
				<a href="writeForm?pageNum=${ currentPage }&type=${ type }&keyword=${ keyword }" class="btn btn-outline-success" id="write">글쓰기</a>
			</div>
		</div>
	
</div>
<div class="row  my-5 justify-content-center">
	<div class="col-10">
		<table class="table table-hover ">
			<tbody>
				<!-- 검색x 리스트x -->
				<c:if test="${empty iList and not searchOption}">
					<tr>
						<td>현재 게시물은 존재하지 않습니다</td>
					</tr>
				</c:if>
				<!-- 검색o 리스트x -->
				<c:if test="${empty iList and searchOption}">
					<tr>
						<td>"${ keyword }"가 포함된 게시 글이 존재하지 않습니다.</td>
					</tr>
				</c:if>
				<!-- 검색x 리스트o -->
				<c:if test="${not empty iList and not searchOption}">
					<c:forEach var="iList" items="${iList }">
						<tr>
							<td rowspan="5"
								class="align-items-center justify-content-center ">
								<a 	href="itemDetail?itemNum=${iList.itemNum}&pageNum=${currentPage}"	>
								<img 	src="resources/upload/${iList.itemFile}" style="height:300px;width:600px;">
								</a>
							</td>
							<td>판매물품 :</td>
							<td><a
								href="itemDetail?itemNum=${iList.itemNum}&pageNum=${currentPage}"
								class="link-dark text-decoration-none">${iList.itemName }</a></td>
						</tr>
						<tr>
							<td>브랜드:</td>
							<td>${iList.itemProducer }</td>
						</tr>
						<tr>
							<td>판매가격:</td>
							<td><fmt:formatNumber value="${( iList.itemPrice / 10000 ) }" type="number" maxFractionDigits="0" />만원</td>
						</tr>
						<tr>
							<td>남은 시간:</td>
							<td>
								<div class="timer" data-start="${iList.itemStartDate}" data-end="${iList.itemEndDate}"></div>
							</td>
						</tr>
						<tr>
							<td></td>
							<td class="text-end">
								<!-- 아이디 가 admin이 아닐때 --> <a class="btn btn-primary AuctionJoin"
								href="exChange?itemNum=${iList.itemNum}">경매참여</a>
								 <!-- 세션과 아이디 가 같을때  -->
								<c:if test="${sessionScope.member.memberId ==iList.memberId}">

									<input class="btn btn-primary endBtn" type="button"
										value="경매중지">
								</c:if>
							</td>
						</tr>
					</c:forEach>
				</c:if>
				<!-- 검색o 리스트o -->
				<c:if test="${not empty iList and searchOption}">
					<c:forEach var="iList" items="${iList }">
						<tr>
							<td rowspan="5"
								class="align-items-center justify-content-center ">
								<img 	src="resources/upload/${iList.itemFile}" style="height:300px;width:600px;">
							</td>
							<td>판매물품 :</td>
							<td><a	href="itemDetail?itemNum=${iList.itemNum}&pageNum=${currentPage}&type=${ type }&keyword=${ keyword }"
								class="link-dark text-decoration-none">${iList.itemName }</a></td>
						</tr>
						<tr>
							<td>브랜드:</td>
							<td>${iList.itemProducer }</td>
						</tr>
						<tr>
							<td>판매가격:</td>
							<td><fmt:formatNumber value="${( iList.itemPrice / 10000 ) }" type="number" maxFractionDigits="0" />만원</td>
						</tr>
						<tr>
							<td>남은 시간:</td>
							<td>
								<div class="timer" data-start="${iList.itemStartDate}" data-end="${iList.itemEndDate}"></div>
							</td>
						</tr>
						<tr>
							<td></td>
							<td class="text-end">
								<!-- 아이디 가 admin이 아닐때 --> 
								<a class="btn btn-primary AuctionJoin" href="exChange?itemNum=${iList.itemNum}" >경매참여
								</a> 
								<!-- 아이디 가 admin일때 -->
								<c:if test="${sessionScope.member.memberId ==iList.memberId}">

									<input class="btn btn-primary endBtn" type="button"
										value="경매중지">
								</c:if>
							</td>
						</tr>
					</c:forEach>
				</c:if>
			</tbody>
		</table>
	</div>
</div>
<!-- 검색x 리스트o -->
<c:if test="${not searchOption and not empty iList }">
<div class="row">
	<div class="col">
		<nav aria-label="Page navigation">
			<ul class="pagination justify-content-center">
				<c:if test="${ startPage > pageGroup }">
					<li class="page-item"><a class="page-link"
						href="itemList?pageNum=${ startPage -
pageGroup }">Pre</a></li>
				</c:if>
				<c:forEach var="i" begin="${startPage}" end="${endPage}">
					<c:if test="${i == currentPage }">
						<li class="page-item active" aria-current="page"><span
							class="page-link">${i}</span></li>
					</c:if>
					<c:if test="${i != currentPage }">
						<li class="page-item"><a class="page-link"
							href="itemList?pageNum=${ i }">${i}</a></li>
					</c:if>
				</c:forEach>
				<c:if test="${ endPage < pageCount }">
					<li class="page-item">
					<a class="page-link"	href="itemList?pageNum=${ startPage +pageGroup }">Next
					</a></li>
				</c:if>
			</ul>
		</nav>
	</div>
</div>
</c:if>
<!-- 검색o 리스트o -->
<c:if test="${searchOption and not empty iList }">
<div class="row">
	<div class="col">
		<nav aria-label="Page navigation">
			<ul class="pagination justify-content-center">
				<c:if test="${ startPage > pageGroup }">
					<li class="page-item"><a class="page-link"
						href="itemList?pageNum=${ startPage - pageGroup }&type=${ type }&keyword=${ keyword }">Pre</a></li>
				</c:if>
				<c:forEach var="i" begin="${startPage}" end="${endPage}">
					<c:if test="${i == currentPage }">
						<li class="page-item active" aria-current="page">
						<span class="page-link">${i}</span></li>
					</c:if>
					<c:if test="${i != currentPage }">
						<li class="page-item"><a class="page-link"
							href="itemList?pageNum=${ i }&type=${ type }&keyword=${ keyword }">${i}</a></li>
					</c:if>
				</c:forEach>
				<c:if test="${ endPage < pageCount }">
					<li class="page-item"><a class="page-link"
						href="itemList?pageNum=${ startPage +
pageGroup }&type=${ type }&keyword=${ keyword }">Next</a></li>
				</c:if>
			</ul>
		</nav>
	</div>
</div>
</c:if>

