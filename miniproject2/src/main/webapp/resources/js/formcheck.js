$(function() {
	
				
		
		//타이머 부분
		 const timers = $('.timer');
    
	    timers.each(function() {
	        const timer = $(this);
	        const startDate = new Date(timer.data('start'));
	        const endDate = new Date(timer.data('end'));
	        const now = new Date();
	        
	        if (startDate > now) {
	            timer.text('아직 판매 중이 아닙니다.');
	        } else if (endDate < now) {
	            timer.text('판매가 종료되었습니다.');
	        } else {
	            function updateTimer() {
	                const now = new Date();
	                const timeLeft = endDate - now;
	                const daysLeft = Math.floor(timeLeft / (1000 * 60 * 60 * 24));
	                const hoursLeft = Math.floor((timeLeft % (1000 * 60 * 60 * 24)) / (1000 * 60 * 60));
	                const minutesLeft = Math.floor((timeLeft % (1000 * 60 * 60)) / (1000 * 60));
	                const secondsLeft = Math.floor((timeLeft % (1000 * 60)) / 1000);
	
	                timer.text(`${daysLeft}일 ${hoursLeft}시간 ${minutesLeft}분 ${secondsLeft}초`);
	
	                if (timeLeft <= 0) {
	                    timer.text('판매가 종료되었습니다.');
	                    clearInterval(timerInterval);
	                }
	            }
	
	            updateTimer();
	            const timerInterval = setInterval(updateTimer, 1000);
	        }
	    });




	$("#updateList").submit(function(){
			var startDateString = $("#startDate").val();
			var endDateString = $("#endDate").val();
			
			var startDate = new Date(startDateString);
			var endDate = new Date(endDateString);
			
			
			if($("#itemName").val().length<=0){
				alert("아이템의 이름이 입력되지 않았습니다.");
				$("#itemName").focus();
				return false
			}
			if($("#itemProducer").val().length<=0){
				alert("아이템의 브렌드가 입력되지 않았습니다.");
				$("#itemProducer").focus();
				return false
			}
			if($("#itemContent").val().length<=0){
				alert("아이템의 내용이 입력되지 않았습니다.");
				$("#itemContent").focus();
				return false
			}
			if( startDateString.length<=0){
				alert("판매날짜가 입력되지 않았습니다.");
				$("#startDate").focus();
				return false
			}
			if(endDateString.length<=0){
				alert("종료날짜가 입력되지 않았습니다.");
				$("#endDate").focus();
				return false
			}
			if (startDate > endDate) {
			    alert("시작날짜와 종료날짜를 올바르게 설정해주세요");
				return false
			} 
			
			if($("#itemPrice").val().length<=0){
				alert("아이템의 가격이 입력되지 않았습니다.");
				$("#itemPrice").focus();
				return false
			}
			if($("#itemFile").val().length<=0){
				alert("아이템의 사진을 등록해주세요.");
				return false
			}
		});


	// 클릭햇을때 세션에 아이디가 있는지
	$("#write").on("click",function(){
		var SId = $("#SmemberId").val();
		
		if(!SId){
			alert("로그인을 해주세요");
			return false;
		}
	});
	
	$("#writeForm").submit(function(){
		var startDateString = $("#startDate").val();
		var endDateString = $("#endDate").val();
		
		var startDate = new Date(startDateString);
		var endDate = new Date(endDateString);
		
		
		if($("#itemName").val().length<=0){
			alert("아이템의 이름이 입력되지 않았습니다.");
			$("#itemName").focus();
			return false
		}
		if($("#itemProducer").val().length<=0){
			alert("아이템의 브렌드가 입력되지 않았습니다.");
			$("#itemProducer").focus();
			return false
		}
		if($("#itemContent").val().length<=0){
			alert("아이템의 내용이 입력되지 않았습니다.");
			$("#itemContent").focus();
			return false
		}
		if( startDateString.length<=0){
			alert("판매날짜가 입력되지 않았습니다.");
			$("#startDate").focus();
			return false
		}
		if(endDateString.length<=0){
			alert("종료날짜가 입력되지 않았습니다.");
			$("#endDate").focus();
			return false
		}
		if (startDate > endDate) {
		    alert("시작날짜와 종료날짜를 올바르게 설정해주세요");
			return false
		} 
		
		if($("#itemPrice").val().length<=0){
			alert("아이템의 가격이 입력되지 않았습니다.");
			$("#itemPrice").focus();
			return false
		}
		if($("#itemFile").val().length<=0){
			alert("아이템의 사진을 등록해주세요.");
			return false
		}
	});
	
	
	
	
	$("#detailUpdate").on("click",function(){
		$("#checkForm").attr("action","update");
		$("#checkForm").attr("method","post");
		$("#checkForm").submit();
		
	});
	
	$("#detailDelete").on("click",function(){
		$("#checkForm").attr("action","delete");
		$("#checkForm").attr("method","post");
		$("#checkForm").submit();
		
	});
	
	$("#writeForm").on("submit", function(){
		var $startDate =$("#strartDate").val();
		var $endDate =$("#endDate").val();
		console.log($startDate);
	});
	
	//업데이트 
	$("#updateList").submit(function(){
		var startDateString = $("#startDate").val();
		var endDateString = $("#endDate").val();
		
		var startDate = new Date(startDateString);
		var endDate = new Date(endDateString);
		
		
		if($("#itemName").val().length<=0){
			alert("아이템의 이름이 입력되지 않았습니다.");
			$("#itemName").focus();
			return false
		}
		if($("#itemProducer").val().length<=0){
			alert("아이템의 브렌드가 입력되지 않았습니다.");
			$("#itemProducer").focus();
			return false
		}
		if($("#itemContent").val().length<=0){
			alert("아이템의 내용이 입력되지 않았습니다.");
			$("#itemContent").focus();
			return false
		}
		if( startDateString.length<=0){
			alert("판매날짜가 입력되지 않았습니다.");
			$("#startDate").focus();
			return false
		}
		if(endDateString.length<=0){
			alert("종료날짜가 입력되지 않았습니다.");
			$("#endDate").focus();
			return false
		}
		if (startDate > endDate) {
		    alert("시작날짜와 종료날짜를 올바르게 설정해주세요");
			return false
		} 
		
		if($("#itemPrice").val().length<=0){
			alert("아이템의 가격이 입력되지 않았습니다.");
			$("#itemPrice").focus();
			return false
		}
		if($("#itemFile").val().length<=0){
			alert("아이템의 사진을 등록해주세요.");
			return false
		}
	});
	
	
	$("#detailUpdate").on("click",function(){
		$("#checkForm").attr("action","update");
		$("#checkForm").attr("method","post");
		$("#checkForm").submit();
		
	});
	$("#detailDelete").on("click",function(){
		$("#checkForm").attr("action","delete");
		$("#checkForm").attr("method","post");
		$("#checkForm").submit();
		
	});
	
	$("#writeForm").on("submit", function(){
		var $startDate =$("#strartDate").val();
		var $endDate =$("#endDate").val();
		console.log($startDate);
	});
	
	
	
	
});