$(function(){
	
	$("#joinForm").submit(function(){
		var pass1 = $("#pass1").val();
		var pass2 = $("#pass2").val();
		var id = $("#memberId").val();
		var name = $("#memberNice").val();
		var phone = $("#phone1").val();
		
		
		if(phone.length > 0 && phone.length != 11){
			console.log(phone.length);
			alert("휴대폰 번호 11자리를 입력해주세요");
			$("#phone1").focus();
			return false
		}
		
		if(pass1!=pass2){
			alert("두 비밀번호가 같지가 않습니다.");
			$("#pass2").focus();
			return false
		}
		
		if(id.length<=0){
			alert("아이디가 입력되지 않았습니다.");
			$("#pass2").focus();
			return false
		}
		if(pass1.length<=0){
			alert("비밀번호가 입력되지 않았습니다.");
			$("#pass1").focus();
			return false
		}
		if(name.length<=0){
			alert("닉네임이 입력되지 않았습니다.");
			$("#memberNice").focus();
			return false
		}
	
		return false
	});

	//아이디
	$("#memberId").on("keyup", function() {

		var regExp = /[^A-Za-z0-9]/gi;
		
		var id = $("#memberId").val();
		url="overlapIdCheck?id=" + id;
	
		if(regExp.test($(this).val())) {
			$("#oId").css("color", "red").text("영문 대소문자, 숫자만 입력할 수 있습니다.");
		return false;
		}
		
		if(id.length == 0) {
		$("#oId").css("color", "red").text("아이디를 입력해주세요");
		return false;
		}
		
		if(id.length < 5) {
			$("#oId").css("color", "red").text("아이디는 5자 이상 입력해주세요.");
		}else{
			$("#oId").text("");
		}
		return false;
	
	}); 	
	
	// 비밀번호
	$("#pass1").on("keyup", function() {

		var regExp = /[^A-Za-z0-9!@#$%^&*]/gi;
		
		var pass1 = $("#pass1").val();
	
		if(regExp.test($(this).val())) {
			$("#oPass1").css("color", "red").text("영문 대소문자, 숫자 !~*까지만 입력할 수 있습니다.");
		return false;
		}
		
		if(pass1.length == 0) {
		$("#oPass1").css("color", "red").text("비밀번호를 입력해주세요");
		return false;
		}
		
		if(pass1.length < 8) {
			$("#oPass1").css("color", "red").text("비밀번호는 8자 이상 입력해주세요.");
		}else{
			$("#oPass1").text("");
		}
		return false;
	
	}); 	
	
	// 비밀번호
	$("#pass2").on("keyup", function() {

		var regExp = /[^A-Za-z0-9!@#$%^&*]/gi;
		
		var pass2 = $("#pass2").val();
	
		if(regExp.test($(this).val())) {
			$("#oPass2").css("color", "red").text("영문 대소문자, 숫자 !~*까지만 입력할 수 있습니다.");
		return false;
		}
		
		if(pass2.length == 0) {
		$("#oPass2").css("color", "red").text("비밀번호를 입력해주세요");
		return false;
		}
		
		if(pass2.length < 8) {
			$("#oPass2").css("color", "red").text("비밀번호는 8자 이상 입력해주세요.");
		}else{
			$("#oPass2").text("");
		}
		
		
		return false;
	
	}); 	
	
	// 닉네임
	$("#memberNick").on("keyup", function() {

		
		var name = $("#memberNick").val();
	
		
		if(name.length == 0) {
		$("#oNick").css("color", "red").text("닉네임를 입력해주세요");
		return false;
		}
		
		if(name.length < 3) {
			$("#oNick").css("color", "red").text("닉네임는 3자 이상 입력해주세요.");
		}else{
			$("#oNick").text("");
		}
		return false;
	
	}); 	
	
	//아이디 중복검사
	$("#memberId").on("keyup", function() {
		
		var id = $(this).val();
		
		if(id.length < 5) {
			return false;
		}
		// document.joinForm.id.value = id;
		// document.joinForm.isIdCheck.value = true;
		
		// $.ajax() 이용해서 서버에서 
		// ajax() 함수의 success 의 콞백 함수 안에서 
		// $("#label1").css("color", "red").text("사용하실 수 있는 아이디 입니다.");  
		
		$.ajax({			
			url: "overlapIdcheck.ajax",
			
			type: "post",
			
			data : { recommend: com, no : $("#no").val()},

		
			dataType: "json",
			success: function(data) {	
			 
						
			},
			error: function(xhr, status, error) {
				alert("error : " + xhr.statusText + ", " + status + ", " + error);
			}
		});
	});
	
	// 회원 로그인 폼이 submit 될 때 폼 유효성 검사를 위한 이벤트 처리
	$("#loginForm").submit(function() {
		var id = $("#userId").val();
		var pass = $("#userPass").val();
		if(id.length <= 0) {
		alert("아이디가 입력되지 않았습니다.\n아이디를 입력해주세요");
		$("#userId").focus();
		return false;
		}
		if(pass.length <= 0) {
		alert("비밀번호가 입력되지 않았습니다.\n비밀번호를 입력해주세요");
		$("#userPass").focus();
		return false;
		}
	});
});




function findZipcode() {
	new daum.Postcode({
        oncomplete: function(data) {
            // 우편번호 검색 결과 항목을 클릭했을때 실행할 코드를 여기에 작성한다.
            // 각 주소의 노출 규칙에 따라 주소를 조합한다.
            // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
            var addr = ''; // 주소 변수
            var extraAddr = ''; // 참고 항목 변수

            //사용자가 선택한 주소 타입과 상관없이 모두 도로명 주소로 처리            
            addr = data.roadAddress;			
            
            // 법정동명이 있을 경우 추가한다. (법정리는 제외)
            // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
            if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
                extraAddr += data.bname;
            }
            // 건물명이 있고, 공동주택일 경우 추가한다.
            if(data.buildingName !== '' && data.apartment === 'Y'){
                extraAddr += (extraAddr !== '' ? 
										', ' + data.buildingName : data.buildingName);
            }
            
            // 표시할 참고 항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
            if(extraAddr !== ''){
                extraAddr = ' (' + extraAddr + ')';
            }
			
            // 조합된 참고 항목을 상세주소에 추가한다.
            addr += extraAddr;
            

			// 우편번호와 주소 정보를 해당 입력상자에 출력한다.
			$("#zipcode").val(data.zonecode);
			$("#address1").val(addr);
			
			// 커서를 상세주소 입력상자로 이동한다.
			$("#address2").focus();
       	}
	}).open();
}