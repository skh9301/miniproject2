$(function() {
	const content = "First served에 오신것을 환영합니다. \n 보다 안전한 거래가 되도록 노력하겠습니다.";
	const text = document.querySelector(".text");
	let i = 0;
	
	function typing(){
	    let txt = content[i++];
	    text.innerHTML += txt === "\n" ? "<br/>" : txt;
	    if (i < content.length) {
	        setTimeout(typing, 80); // Schedule the next character typing
	    }
	}
	
	typing(); // Start the typing effect
});