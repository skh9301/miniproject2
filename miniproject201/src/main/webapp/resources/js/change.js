$(function() {
	
	// 즐겨찾기 눌렀을때
		$(".ItemMark").on("click", function() {

    var memberId = $("#SmemberId").val();
    var itemNum = $(this).data('itemnum');


    $.ajax({
        url: 'addBid.ajax',
        type: 'POST',
        data: { 
            fonkyItemNum: itemNum,
            fonkyMemberId: memberId,
        },
        success: function(response) {
              alert(response.message);

            
        },
        error: function(error) {
        console.log(memberId);
            console.log(itemNum);
        }
    });
});
		
		// 가격 출력부분 영역
		var price;
		 if($("#regPrice").val()){
			 price = parseFloat($("#regPrice").val());
		}else{
			 price = parseFloat($("#itemPrice").val());
		}
		
		
		
		$("#aPrice").val(price);
		$("#plus").on("click",function(){
		
			price= price+price/100*5
			price = Math.floor(price); 
			$("#aPrice").val(price);
			
		});
		
		$("#buyBtn").on("click",function(){
			let itemNum = $("#itemNum").val() 	;
			let memberId =  $("#memberId").val();
			
			if(memberId.length==0){
				alert("로그인이 되어있지 않습니다.");
				return false;
			}
			let memberPoint = parseFloat($("#memberPoint").val());
			if(memberPoint<price){
				alert("포인트가 부족합니다.");
				return false;
			}
			$.ajax({
				url:"insertAuction",
				type: "post",
				data : {
					itemNum : itemNum,
					regPrice:price,
					memberId: memberId,
				},
				dataType : "json",
				success : function(resData) {
					console.log(resData)
					 
					
					},
				error: function(xhr, status) {
				price = price * 1.05;
                        price = Math.floor(price);
                        $("#aPrice").val(price);
				console.log("error : " + status);
				}
			});
				
	});
		//
		
		
	
	
});