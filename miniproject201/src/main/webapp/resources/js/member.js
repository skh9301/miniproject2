$(function(){

	//5월 27일 수정
	$("#joinForm").on("submit",function(){
		var pass1 = $("#LogPass1").val();
		var pass2 = $("#LogPass2").val();
		var id = $("#LogMemberId").val();
		var name = $("#LogMemberNick").val();
		var phone = $("#phone1").val();
		var zipcode = $("#memberZipcod").val();
		var address1 = $("#memberAddress").val();
		var address2 = $("#memberAddress2").val();
		var email =$("#emailId").val();
		var address = $("#address2").val();
		
			if(phone.length > 0 && phone.length != 11){
			console.log(phone.length);
			alert("휴대폰 번호 11자리를 입력해주세요");
			$("#phone1").focus();
			return false
		}
		if(id.length<=0){
			alert("아이디가 입력되지 않았습니다.");
			$("#LogMemberId").focus();
			return false
		}
		if(name.length<=0){
			alert("닉네임이 입력되지 않았습니다.");
			$("#LogMemberNick").focus();
			return false
		}
		if(pass1.length<=0){
			alert("비밀번호가 입력되지 않았습니다.");
			$("#LogPass1").focus();
			return false
		}
		if($("#zipcode").val().length <=0){
		alert("주소가 입력되지 않았습니다.")
		$("#zipcode").focus();
		return false
		}
		if(address2.length <= 0){
		alert("상세주소를 입력해 주세요.")
		$("#address").focus();
		return false
		}
		if(email.length <=0){
		alert("이메일이 입력되지 않았습니다.\n이메일을 입력해 주세요.")
		$("#emailId").focus();
		return false
		}
		return false
		
	});
	
	//아이디 중복확인 
	$("#LogMemberId").on("keyup", function() {

		var regExp = /[^A-Za-z0-9]/gi;
	
		if(regExp.test($(this).val())) {
			$("#oId").css("color", "red").text("영문 대소문자, 숫자만 입력할 수 있습니다.");
			$(this).val($(this).val().replace(regExp, ""));
			return false;
		}
		
		if($(this).val().length == 0) {
			$("#oId").css("color", "red").text("아이디를 입력해주세요");
			return false;
		}
		
		if($(this).val().length < 5) {
			$("#oId").css("color", "red").text("아이디는 5자 이상 입력해주세요.");
			return false;
		}else{
			$("#oId").text("");
		}
		
		$.ajax({
			url : "idCheck.ajax",			
			type : "post",			
			data : {memberId : $(this).val()},			
			dataType : "json",			
			success : function(data){
				// {"result": "true"} 또는 {"result" : "false"}
				console.log(data);
				
				if(! data.result) {
					$("#oId").css("color", "blue").text("사용 가능한 아이디 입니다.");
					
				} else {
					$("#oId").css("color", "red").text("사용할 수 없는 아이디 입니다.");
				}
				
			},	//end success		
			error : function(xhr, status, error){
				console("error : " + xhr.statusText + ", " + status + ", " + error);
			}
		});// end ajax
		
	});	
		
	
	// 비밀번호
	$("#LogPass1").on("keyup", function() {

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
	
	// 비밀번호2
	$("#LogPass2").on("keyup", function() {

		var regExp = /[^A-Za-z0-9!@#$%^&*]/gi;
		
		var pass1 = $("#LogPass1").val();
		var pass2 = $("#LogPass2").val();
	
		if(pass1 != pass2){
		$("#oPass2").css("color", "red").text("비밀번호가 같지 않습니다.");
		}else{
		$("#oPass2").text("");
		}
		return false;
	}); 	
	
	// 닉네임
	$("#LogMemberNick").on("keyup", function() {

		
		var name = $("#LogMemberNick").val();
	
		
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
	
	//회원 정보 수정 폼에서 비밀번호 확인을 입력했을 때 이벤트 처리
	//회원정보 수정폼에서 기존 비밀번호가 맞는지를 Ajax통신을 통해 확인
	$("#oldmemberPass").on("keyup", function(){
	
		var oldId = $("#memberId").val();
		var oldPass = $("#oldmemberPass").val();
		var oldPass2 = $("#pass1").val();
	
		if($.trim(oldPass).length == 0){
			$("#oPassCheck").css("color", "red").text("기존 비밀번호를 입력해주세요.");
			return false;
		}
		
		
		
		var data = "memberId=" + oldId + "&memberPass=" + oldPass;
		console.log("data : " + data);
		
		$.ajax({
			"url" : "passCheck.ajax",
			"type" : "get",
			"data" : data,
			"dataType" : "json",
			"success" : function(resData){
				if(resData.result){
					$("#oPassCheck").css("color", "blue").text("비밀번호가 확인되었습니다.");
					$("#oldmemberPass").attr("disabled", true);
					$("#oldmemberPass").attr("readonly", true);
					$("pass1").focus();
				}else{
					$("#oPassCheck").css("color", "red").text("비밀번호를 다시 확인해주세요");
				}
			},
			"error": function() {
				console.log("error");
			}
		
		});// end ajax 
	
	}); //$("#oldmemberPass")
	

	//회원정보 수정 폼에서 수정하기 버튼이 클릭되면 유효성 검사를 하는 함수
	$("#memberUpdateForm").on("submit", function(){
	
	var oldPass = $("#oldmemberPass").val();
		var oldPass2 = $("#pass1").val();
	
	if(! $("#oldmemberPass").attr("disabled")){
		alert("기존 비밀번호를 확인해주세요.")
		return false;
	}
	
	if(oldPass == oldPass2){
		$("#oPassCheck2").css("color", "red").text("기존 비밀번호와 다르게 입력해주세요.");
		return false;
	}
	if(oldPass2.length == 0){
		$("#oPassCheck2").css("color", "red").text("비밀번호를 입력해 주세요.");
		return false;
	}
	
		return joinFormCheck();
	}); // end 수정버튼
	
	//회원 탈퇴 폼에서 탈퇴하기 버튼이 클릭되면 	
	$("#memberDeleteForm").on("submit", function(){
	
	var oldPass = $("#oldmemberPass").val();
	
		if(oldPass2.length == 0){
		$("#oPassCheck").css("color", "red").text("기존 비밀번호를 입력해 주세요.");
		return false;
		
	
	}
	
		return joinFormCheck();
	
	});//memberDeletForm

	// 비밀번호2
	$("#pass1").on("keyup", function(){
	
		var oldPass2 = $("#pass1").val();
		
		if(oldPass2.length < 8){
			$("#oPassCheck2").css("color", "red").text("비밀번호는 8자 이상입니다.");
		}else{
		$("#oPassCheck2").text("");
		}
		
		
	
	}); //end oldPassCheck2
	
	
		// 이메일 입력 셀렉트 박스에서 선택된 도메인을 설정하는 함수 
	$("#selectDomain").on("change", function() {
		var str = $(this).val();
		
		if(str == "직접입력") {	
			$("#emailDomain").val("");
			$("#emailDomain").prop("readonly", false);
		} else if(str == "네이버"){	
			$("#emailDomain").val("naver.com");			
			$("#emailDomain").prop("readonly", true);
			
		} else if(str == "다음") {		
			$("#emailDomain").val("daum.net");
			$("#emailDomain").prop("readonly", true);
			
		} else if(str == "한메일"){	
			$("#emailDomain").val("hanmail.net");
			$("#emailDomain").prop("readonly", true);
			
		} else if(str == "구글") {		
			$("#emailDomain").val("gmail.com");
			$("#emailDomain").prop("readonly", true);
		}
	});
		
	
}); // end $(function());




 //주소
function findZipcode(){ 
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
			$("#memberAddress2").focus();
       	}
	}).open();
}