<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script>
	$(function() {
		// 아이템 번호를 자바스크립트 변수에 저장
		let itemNum = "${item.itemNum}"
		
		let timer = setInterval(
				function() {

					$.ajax({
								url : "auctionTime",
								type : "post",
								data : {
									itemNum : itemNum
								},
								dataType : "json",
								success : function(resData) {
									console.log(itemNum)
									if (resData.finished) {
										clearInterval(timer);
										var memberId = $("#memberId").val();
				                        var aMemberId = resData.aMemberId;  
				                        if (aMemberId === memberId) {
				                            var memberPoint = $("#memberPoint").val();
				                            memberPoint = memberPoint - resData.aRegPrice;
				                            $.ajax({
				                                url: "deDuctionPoint",
				                                type: "post",
				                                data: {
				                                    memberPoint: memberPoint,
				                                    memberId: memberId
				                                },
				                                dataType: "json",
				                                success: function(resData) {
				                                    
				                                },
				                                error: function() {
				                                    console.log("error");
				                                }
				                            });
											
										}
										alert('경매가 종료되었습니다.');
										location.href = "itemList";
										return;
									}
									let result = "<h2 class='text-center'>&nbsp;";
									if (resData.days > 0) {
										result += resData.days + "일 ";
									}
									if (resData.hours > 0) {
										result += resData.hours + "시간 "
									}
									if (resData.minutes > 0) {
										result += resData.minutes + "분 "
									}
									if (resData.seconds > 0) {
										result += resData.seconds + "초 남음"
									}
									result += "</h2>";

									$("#actionTime").html(result);

									let result1 = '<table class="table border border-end-0 border-start-0">'
											+ '<tbody>'
											+ '<tr>'
											+ '<th>입찰번호</th>'
											+ '<th>입찰자</th>'
											+ '<th>입찰가격</th>' + '</tr>';

									if (resData.aList == null	|| resData.aList.length == 0) {
										result1 += '<tr>'
												+ '<td class="text-center" colspan="3">입찰자가 없습니다</td>'
												+ '</tr>';
									} else {
										resData.aList.forEach(function(aList) {
											result1 += '<tr>' + '<td>'
													+ aList.auctionNum
													+ '</td>' + '<td>'
													+ aList.memberId + '</td>'
													+ '<td>' + aList.regPrice
													+ '</td>' + '</tr>';
										});
									}

									result1 += '</tbody>' + '</table>';

									$("#auctionList").html(result1);

								},
								error : function() {
									console.log("error");
								}
							});
				}, 500);

	});
</script>
<div class="row my-5">
	<div class="col">
		<div class="bg-dark text-white h-100 fs-1 fw-bold" id="actionTime"></div>
	</div>
</div>
<div class="row my-5 text-center border  ">
	<form id="addAuction" action="exChange" method="post">
		<input type="hidden" id="itemNum" name="itemNum" 	value="${item.itemNum }"> 
		<input type="hidden"	name="memberId" id="memberId" value="${sessionScope.member.memberId }"> 
		<input	type="hidden" id="regPrice" name="regPrice" value="${regPrice }">
	</form>
	<div class="col">
		<!-- 이미지  -->
		<div class="row">
			<div class="col-8 ">
				<div class="row my-2">
					<div class="col">
						<img src="resources/upload/${item.itemFile}" class="w-100"
							style="height: 525px;">
					</div>
				</div>
			</div>
			<!-- 물품 설명부분 -->
			<div class="col-4 ">
				<div class="row my-3">
					<div class="col">
						<div class="input-group mb-3">
							<span class="input-group-text">물품이름</span> <input type="text"
								class="form-control" name="itemName"
								aria-label="Amount (to the nearest dollar)" readonly
								value="${item.itemName }">
						</div>
					</div>
				</div>
				<div class="row my-3">
					<div class="col">
						<div class="input-group mb-3">
							<span class="input-group-text" style="width: 90px;">브랜드</span> <input
								type="text" class="form-control" name="itemProducer"
								aria-label="Amount (to the nearest dollar)" readonly
								value="${item.itemProducer }">
						</div>
					</div>
				</div>
				<div class="row my-3">
					<div class="col">
						<div class="input-group" style="height: 320px;">
							<span class="input-group-text">물품설명</span>
							<textarea class="form-control" aria-label="With textarea"
								name="itemContent" readonly>${item.itemContent }</textarea>
						</div>
					</div>
				</div>
				<div class="row my-3">
					<div class="col">
						<div class="input-group mb-3">
							<span class="input-group-text">시작가격</span> <input type="text"
								class="form-control" name="itemPrice" id="itemPrice"
								aria-label="Amount (to the nearest dollar)" readonly
								value="${item.itemPrice }">
						</div>
					</div>
				</div>
			</div>
		</div>

		<!-- 입찰 버튼 옥션부분 -->
		<div class="row my-2">
			<div class="col-7">
				<div id="auctionList"></div>
			</div>
			<!--입찰부분  -->

			<div class="col-5 justify-content-center">
				<div class="row my-2">
					<div class="col">
						<div class="input-group mb-3">
							<span class="input-group-text text-center" id="basic-addon1"
								style="width: 525px; height: 40px;">${sessionScope.member.memberNick == null? "로그인이 되어있지 않습니다." : sessionScope.member.memberNick}</span>
						</div>
					</div>
				</div>
				<div class="row my-2">
					<div class="col">
						<div class="input-group mb-3">
							<span class="input-group-text" style="width: 130px;">남은
								포인트 :</span> <input type="text" class="form-control"
								aria-label="Amount (to the nearest dollar)" id="memberPoint"
								value="${sessionScope.memberPoint==null ? sessionScope.member.memberPoint : sessionScope.memberPoint}" readonly> <span
								class="input-group-text">point</span>
						</div>
					</div>
				</div>
				<div class="row my-2">
					<div class="col">
						<div class="input-group">
							<span class="input-group-text" id="price" style="width: 130px;">매수가격(KRW)</span>
							<input type="text" class="form-control"
								aria-label="Recipient's username with two button addons"
								id="aPrice" name="aPrice">
							<button class="btn btn-outline-secondary" type="button" id="plus">+</button>
						</div>
					</div>
				</div>
				<div class="row my-4">
					<div class="col text-start">
						<input class="btn btn-primary" type="reset" value="초기화"
							style="width: 240px;">
					</div>
					<div class="col text-end" >
						<c:if test="${not item.started}">
							<span class="btn btn-warning" style="width: 240px;">경매 준비중</span>
						</c:if>
						<!-- 경매가 시작되고 종료되지 않았으면 경매참여 버튼 활성화 -->
						<c:if test="${item.started and not item.finished}">
							<input type="button" class="btn btn-primary" style="width: 240px;" value="매 수" id="buyBtn">
						</c:if>
						<!-- 경매가 종료되었으면 -->
						<c:if test="${item.finished}">
							<span class="btn btn-danger" style="width: 240px;">경매 종료됨</span>
						</c:if>

					</div>
				</div>
				<div class="row my-4">
					<div class="col">
						<input class="btn btn-primary" type="button" value="포인트 충전하기"
							style="width: 525px;">
					</div>
				</div>
			</div>

		</div>
	</div>
</div>