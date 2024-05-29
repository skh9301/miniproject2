$(function() {
	var price = parseInt($("#itemPrice").val());
	
	/*$("#plus").on("click",function(){
			price= price+price/100*5
			price = Math.floor(price); 
			$("#itemPrice").val(price);
		});
		
		$("#buyBtn").on("click",function(){
			price =$("#itemPrice").val();
			
		
			$.ajax({
				url="insertAcution.ajax",
				data="",
				
				
				
		});
	});*/
	$(".AuctionJoin").click(function(event) {
    // 클릭된 요소의 timerText를 가져옵니다.
		     var clickedTimerText = $(this).closest("tr").find(".timer").text();
		    var itemNum = $(this).data("item-num");
		    console.log("클릭된 timerText: " + clickedTimerText);
		     if (clickedTimerText === "판매가 종료되었습니다.") {
	            alert("판매가 종료되었습니다.");
	            event.preventDefault();
	            return;
	        }
		  
		     
		    // AJAX 요청을 보냅니다.
		    $.ajax({
		        url: "AuctionJoin.ajax",
		        type: "get", // 요청 방법을 명시합니다.
		        data: { itemNum: itemNum },
		        dataType: "json",
		        success: function(response) {
		            // 요청이 성공했을 때 처리
		            console.log(response);
		             // 판매가 종료된 경우 
					 
		
		            window.location.href = "exChange?itemNum=" + itemNum;
		        },
		        error: function(xhr, status, error) {
		            // 요청이 실패했을 때 처리
		            console.error("AJAX 요청 실패:", status, error);
		        }
		    });
		
		    // 클릭 이벤트를 취소합니다.
		    event.preventDefault();
		});
	
	
});