<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
  <script src="resources/js/formcheck.js"></script> 
    
   <form name="checkForm" id="checkForm">
   		<input type="hidden" name="itemNum" id="itemNum" value="${itemList.itemNum }"/>
   </form>
<div class="row my-5 justify-content-center" >
    <div class="col-6 d-flex align-items-center justify-content-center">
        <div class="row w-100"  >
            <div class="col ">
                <img src="resources/upload/${itemList.itemFile}" class="w-100" >
            </div>
        </div>
    </div>
    <div class="col-4">
        <div class="row my-2">
            <div class="col">
                <div class="input-group mb-3">
				  <span class="input-group-text">물품이름</span>
				  <input type="text" class="form-control"  name="itemName" aria-label="Amount (to the nearest dollar)" readonly value="${itemList.itemName }">
				</div>
            </div>
        </div>
        <div class="row my-2">
            <div class="col">
                <div class="input-group mb-3">
				  <span class="input-group-text" style="width:90px;">브랜드</span>
				  <input type="text" class="form-control"  name="itemProducer" aria-label="Amount (to the nearest dollar)" readonly value="${itemList.itemProducer }">
				</div>
            </div>
        </div>
        <div class="row my-2">
            <div class="col">
             <div class="input-group" style="height:320px;">
			  <span class="input-group-text">물품설명</span>
			  <textarea class="form-control" aria-label="With textarea" name="itemContent" readonly>${itemList.itemContent }</textarea>
			</div>
            </div>
        </div>
<div class="row my-2">
				<div class="col">
					<div class="input-group" style="height: 40px;">
						<span class="input-group-text" style="width: 90px;">시작 날짜</span> <input
							type="text" id="startDate" class="form-control"
							name="itemStartDate" value="${ itemList.itemStartDate}" readonly>
					</div>
				</div>
			</div>
			<div class="row my-2">
				<div class="col">
					<div class="input-group" style="height: 40px;">
						<span class="input-group-text" style="width: 90px;">종료 날짜</span> <input
							type="text" id="endDate" class="form-control" name="itemEndDate" value="${ itemList.itemEndDate}" readonly>
					</div>
				</div>
			</div>
        <div class="row my-2">
            <div class="col">
                <div class="input-group mb-3">
				  <span class="input-group-text">시작가격</span>
				  <input type="text" class="form-control"  name="itemPriace" aria-label="Amount (to the nearest dollar)" readonly  value="${itemList.itemPrice }">
				</div>
            </div>
        </div>
    </div>
	    	
	<!-- 버튼부분 -->
	<div class="row justify-content-center my-2">
	    <div class="col-6">
				<c:if test="${ empty itemList.itemFile  }">
				첨부파일 없음
				</c:if>
				<c:if test="${ not empty itemList.itemFile  }">
				<a href="fileDownload?fileName=${ itemList.itemFile }">파일 다운로드</a>
				</c:if>
	    </div>
	    <div class="col-4 d-flex justify-content-around">
	    	<!-- 회원 본인일때 -->
	    	<c:if test="${sessionScope.member.memberId == itemList.memberId}">
			    <input class="btn btn-primary" id="detailUpdate" type="button" value="수정하기">
			    <input class="btn btn-primary" id="detailDelete" type="button" value="삭제하기">
			    <input class="btn btn-primary" type="button" value="목록보기" onclick="location.href='itemList'"/>
			</c:if>
			<!-- 회원 아닐때 -->
			${sessionScope.member.memberId}
			<c:if test="${sessionScope.member.memberId != itemList.memberId}">
			    <input class="btn btn-primary" id="detailItem" type="button" value="즐겨찾기">
			    <input class="btn btn-primary" type="button" value="목록보기" onclick="location.href='itemList'"/>
			</c:if>
	    </div>
	</div>
</div>