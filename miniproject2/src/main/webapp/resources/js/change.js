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
   $("#exchangeLink").on("click", function(event) {
        event.preventDefault(); // 기본 동작인 링크 이동을 방지합니다.

        // 아이템 목록을 가져오는 AJAX 요청을 보냅니다.
        $.ajax({
            url: "header.ajax",
            success: function(iList) {
                if (iList.length > 0) {
                    // 아이템 목록이 비어있지 않으면 랜덤한 아이템 번호를 가져옵니다.
                    var randomItemNum = getRandomItemNum(iList);

                    // AJAX 요청을 보냅니다.
                    $.ajax({
                        url: "exChange",
                        data: {
                            itemNum: randomItemNum
                        },
                        success: function(response) {
                            console.log("Exchange 페이지로 이동합니다.");
                            window.location.href = "exChange?itemNum=" + randomItemNum;
                        },
                        error: function(xhr, status, error) {
                            console.error("AJAX 요청이 실패했습니다.");
                        }
                    });
                } else {
                    // 아이템 목록이 비어있는 경우에 대한 처리
                    console.log("아이템 목록이 비어있습니다.");
                    // 사용자에게 메시지를 표시할 수 있습니다.
                }
            },
            error: function(xhr, status, error) {
                console.error("AJAX 요청이 실패했습니다.");
            }
        });
    });

    // 랜덤한 아이템 번호를 반환하는 함수
    function getRandomItemNum(iList) {
        // 아이템 목록에서 랜덤한 아이템 번호를 선택하여 반환합니다.
        var randomIndex = Math.floor(Math.random() * iList.length);
        return iList[randomIndex].itemNum;
    }
	
	
	
});