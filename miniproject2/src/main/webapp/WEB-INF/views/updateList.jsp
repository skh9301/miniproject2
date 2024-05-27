<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <form name="updateList" action="updateProcess" id="updateList"  method="post">
    <input type="hidden" name="itemNum" value="${itemList.itemNum }">
    <input type="hidden" name="pageNum" id="itemNum" value="${pageNum}"/>
    <c:if test="${ searchOption }">
		<input type="hidden" name="type" value="${ type }" />
		<input type="hidden" name="keyword" value="${ keyword }" />
	</c:if>
<div class="row my-5 justify-content-center">
		<div class="col-6 ">
			<div class="row">
				<div class="col">
					<img src="https://via.placeholder.com/550x630">
				</div>
			</div>
		</div>
    <div class="col-4">
        <div class="row my-2">
            <div class="col">
                <div class="input-group mb-3">
				  <span class="input-group-text">물품이름</span>
				  <input type="text" class="form-control"  id="itemName" name="itemName" aria-label="Amount (to the nearest dollar)" value="${itemList.itemName }">
				</div>
            </div>
        </div>
        <div class="row my-2">
            <div class="col">
                <div class="input-group mb-3">
				  <span class="input-group-text" style="width:90px;">브랜드</span>
				  <input type="text" class="form-control" id="itemProducer" name="itemProducer" aria-label="Amount (to the nearest dollar)"  value="${itemList.itemProducer }">
				</div>
            </div>
        </div>
        <div class="row my-2">
            <div class="col">
             <div class="input-group" style="height:350px;">
			  <span class="input-group-text">물품설명</span>
			  <textarea class="form-control" aria-label="With textarea" name="itemContent" id="itemContent"> ${itemList.itemContent}</textarea>
			</div>
            </div>
        </div>
        <div class="row my-2">
				<div class="col">
					<div class="input-group" style="height: 40px;">
						<span class="input-group-text" style="width: 90px;">시작 날짜</span>
						<input type="date" id="startDate" class="form-control"
							name="itemStartDate">
					</div>
				</div>
				</div>
			<div class="row my-2">
				<div class="col">
					<div class="input-group" style="height: 40px;">
						<span class="input-group-text" style="width: 90px;">종료 날짜</span>
						<input type="date" id="endDate" class="form-control"
							name="itemEndDate">
					</div>
				</div>
			</div>
        
        <div class="row my-2">
            <div class="coll-6">
                <div class="input-group mb-3">
				  <span class="input-group-text">시작가격</span>
				  <input type="text" class="form-control"  name="itemPrice" id="itemPrice" aria-label="Amount (to the nearest dollar)" value="${itemList.itemPrice}">
				</div>
            </div>
        </div>
    </div>
	<!-- 버튼부분 -->
	<div class="row justify-content-center my-2">
	    <div class="col-6">
	    	 <input type="file" class="form-control" id="itemFile" style="width:380px;">
	    </div>
	    <div class="col-4 d-flex justify-content-around">
	        <input type="submit" value="수정하기" class="btn btn-primary"/>
	        <c:if test="${ not searchOption }">
	        <input class="btn btn-primary" type="button" value="목록보기" 
						onclick="location.href='itemList?pageNum=${pageNum}'"/>	
			</c:if>
	        <c:if test="${ searchOption }">
	        <input class="btn btn-primary" type="button" value="목록보기" 
						onclick="location.href='itemList?pageNum=${pageNum}&type=${type }&keyword=${ keyword }'"/>	
			</c:if>
	    </div>
	</div>
</div>
</form>