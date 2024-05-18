$(function() {
	var carouselWrap = $('#carousel-example-generic'),
		 typedTxtArr = [
			'First Carousel Text',
			'Second Carousel Text',
			'Third Carousel Text'
		 ],
		 typed, typedObj;	

	var typedFunc = function( a, b ) {
		typed = new Typed(a[0], {
			strings: [
				typedTxtArr[ b ]
			],
			stringsElement: null,
			typeSpeed: 70,
			startDelay: 1000,
			smartBackspace: false,
			backSpeed: 60,
			backDelay: 5000,
			loop: true,
			loopCount: 5,
			showCursor: false,
			cursorChar: "|",
			attr: null,
			contentType: 'html',
			callback: function() {},
			preStringTyped: function() {},
			onStringTyped: function() {
				setTimeout(function(){
					carouselWrap.carousel('next');
				}, 1000);
			},
			resetCallback: function() {},
			onReset: function(self) { 
				
			}
		});
	}

	carouselWrap.on('slid.bs.carousel', function () {
		var idx =$(this).find('.active').index(),
			 typedObj = $('.typing').eq( idx );
			 typed.destroy();
			 typedFunc( typedObj, idx );
	});
	
	// init
	typedFunc( $('.typing').eq(0), 0); 
});