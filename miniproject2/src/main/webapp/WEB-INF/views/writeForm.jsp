<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<div class="row my-5 justify-content-center">
    <div class="col-4">
        <div class="row">
            <div class="col">
                <img src="https://via.placeholder.com/400x500">
            </div>
        </div>
    </div>
    <div class="col-4">
        <div class="row my-4">
            <div class="col">
                물품이름 : <input type="text" name="itemName">
            </div>
        </div>
        <div class="row my-4">
            <div class="col">
               	브렌드 : 
                <input type="text" name="itemProducer"><br>
            </div>
        </div>
        <div class="row my-4">
            <div class="col">
              설명 : 
				  <textarea class="form-control" aria-label="With textarea" name="itemContent"></textarea>
            </div>
        </div>
        <div class="row my-4">
            <div class="col">
                물품 시작가 : <input type="text" name="itemPriace">
            </div>
        </div>
    </div>
</div>
<!-- 버튼부분 -->
<div class="row justify-content-center">
    <div class="col-4">
    	 <input type="file" class="form-control" id="itemFile">
    </div>
    <div class="col-4 d-flex justify-content-between">
        <a href="#" class="btn btn-primary">물품등록</a>
        <a href="#" class="btn btn-secondary">취소하기</a>
    </div>
</div>