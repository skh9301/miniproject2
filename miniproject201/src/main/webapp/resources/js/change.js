$(function() {
	var price = parseInt($("#aPrice").val());
	
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
			let memberPoint = $("#memberPoint").val();
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
				error : function() {
					console.log("error");
				}
			});
				
	});
	
	
	
});