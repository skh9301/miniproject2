<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
   <form name=checkForm" id="checkForm">
   		<input type=hidden" name="itemNum" id="itemNum" value="${itemList.itemNum }"/>
   </form>
<div class="row my-5 justify-content-center">
    <div class="col-4">
        <div class="row">
            <div class="col">
                <img src="https://via.placeholder.com/400x500">
            </div>
        </div>
    </div>
    <div class="col-4">
        <div class="row my-2">
            <div class="col">
                <div class="input-group mb-3">
				  <span class="input-group-text">물품이름</span>
				  <input type="text" class="form-control"  name="itemName" aria-label="Amount (to the nearest dollar)" value="${itemList.itemName }">
				</div>
            </div>
        </div>
        <div class="row my-2">
            <div class="col">
                <div class="input-group mb-3">
				  <span class="input-group-text" style="width:90px;">브랜드</span>
				  <input type="text" class="form-control"  name="itemProducer" aria-label="Amount (to the nearest dollar)" value="${itemList.itemProducer }">
				</div>
            </div>
        </div>
        <div class="row my-2">
            <div class="col">
             <div class="input-group" style="height:320px;">
			  <span class="input-group-text">물품설명</span>
			  <textarea class="form-control" aria-label="With textarea" name="itemContent" >${itemList.itemCountent }</textarea>
			</div>
            </div>
        </div>
        <div class="row my-2">
            <div class="col">
                <div class="input-group mb-3">
				  <span class="input-group-text">시작가격</span>
				  <input type="text" class="form-control"  name="itemPriace" aria-label="Amount (to the nearest dollar)" value="${itemList.itemPrice }">
				</div>
            </div>
        </div>
    </div>
	<!-- 버튼부분 -->
	<div class="row justify-content-center my-2">
	    <div class="col-4">
	    	 <input type="file" class="form-control" id="itemFile" style="width:380px;">
	    </div>
	    <div class="col-4 d-flex justify-content-around">
	        <input class="btn btn-primary" id="detailUpdate" type="button"  value="수정하기">
	        <input class="btn btn-primary" id="detailDelete" type="button" value="삭제하기">
	        <input class="btn btn-primary" type="button" value="목록보기" 
						onclick="location.href='itemList'"/>	
	    </div>
	</div>
</div>