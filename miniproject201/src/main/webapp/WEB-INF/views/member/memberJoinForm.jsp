<%-- 회원가입 폼 요청 처리 결과를 출력할 View 페이지 --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- 
	새로운 5자리 우편번호로 회원 주소를 입력 받기 위해 daum.net에서
	제공하는 우편번호 찾기 API를 사용하였다.
	참고 사이트 : http://postcode.map.daum.net/guide
-->
<script
	src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<div class="row my-5" id="global-content">
	<div class="col">
		<div class="row my-3 text-center">
			<div class="col">
				<h2 class="fs-3 fw-bold">First Served 회원가입</h2>
			</div>
		</div>
		<form action="joinResult" name="joinForm" method="post" id="joinForm">

			<%-- 
				회원 아이디 중복 검사를 했는지의 정보를 hidden 필드로 저장 
			--%>
			<input type="hidden" name="isIdCheck" id="isIdCheck" value="false" />

			<div class="row justify-content-center">
			
			<!-- 아이디 -->
				<div class="col-4">
					<input type="text" class="form-control" name="memberId" id="memberId"
						placeholder="아이디"> 
						<label id="oId"style="font-size: 10px;" data-id-value="${id }"></label>
				</div>
			</div>

			<div class="row justify-content-center">
				<div class="col-4">

					<input type="text" class="form-control" name="memberNick" id="memberNick"
						placeholder="닉네임">
						<label id="oNick"style="font-size: 10px;" data-id-value="${name }"></label>

				</div>
			</div>
			<div class="row justify-content-center">
				<div class="col-4">
					<input type="password" class="form-control" name="memberPass" id="pass1"
						placeholder="비밀번호">
						<label id="oPass1"style="font-size: 10px;"  data-id-value="${pass1 }"></label>
				</div>
			</div>
			<div class="row justify-content-center">
				<div class="col-4 ">
					<input type="password" class="form-control" name="pass2" id="pass2"
						placeholder="비밀번호 확인">
						<label id="oPass2"style="font-size: 10px;"  data-id-value="${pass2 }"></label>
				</div>
			</div>
			<div class="row justify-content-center">
				<div class="col-4">
					<div class="row">
						<div class="col">
							<input type="text" class="form-control my-2" name="zipcode"
								id="zipcode" maxlength="5" readonly placeholder="우편번호"
								onclick="findZipcode()"> <input type="text"
								class="form-control my-2" name="memberAddress" id="address1" readonly
								placeholder="주소" onclick="findZipcode()"> <input
								type="text" class="form-control my-2" name="address2"
								id="address2" placeholder="상세주소">
						</div>
					</div>
				</div>
			</div>

			<div class="row justify-content-center">
				<div class="col-4">
					<div class="row">
						<div class="col d-flex">
							<div class="col-md-4">
								<input type="text" class="form-control" name="emailId"
									id="emailId" placeholder="이메일 아이디">
									
							</div>
							<div class= "col">
								<span>@</span>
							</div>
							<div class="col-md-4">
							<input type="text" class="form-control" 
								name="emailDomain" id="emailDomain">
						</div>
							<div class="col-md-3">
								<select class="form-select  border" name="selectDomain"
									id="selectDomain">
									<option>직접입력</option>
									<option>네이버</option>
									<option>다음</option>
									<option>한메일</option>
									<option>구글</option>
								</select>
								<label id="label1"style="font-size: 10px;"></label>
							</div>
						</div>
					</div>
				</div>
			</div>

			<div class="row justify-content-center">
				<div class="col-4">
					<input type="text" class="form-control" name="memberPhone" id="phone1"
						maxlength="11" placeholder="휴대폰 번호">
						<label id="label1"style="font-size: 10px;"></label>
				</div>
			</div>
			<div class="row mt-3 justify-content-center">
				<div class="col-4">
					<input type="submit" value="가입하기"
						class="btn btn-outline-primary h-100 w-100">
				</div>
			</div>
		</form>
	</div>
</div>


