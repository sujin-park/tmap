var mainVisualSlide = (function(i) {
	var index = 0;
	var imgs = $('.visual-imgs > div');
	var imgsLength = imgs.length;

	imgs.eq(index).addClass("active");
	index++;

	setInterval(function() {
		if (index >= imgsLength) {
			index = 0;
		}
		imgs.removeClass('active').eq(index).addClass("active");
		index++;
	}, 8000);
})();

$('.ex-slick-container').slick({
	arrows : true,
	dots: true,
	slidesToShow : 4,
	infinite: false,
	lazyLoad: 'ondemand',
	responsive : [
		{
			breakpoint : 1024,
			settings : {
				arrows : true,
				dots: true,
				slidesToShow : 3,
				infinite: false,
				lazyLoad: 'ondemand',
			}
		},
		{
			breakpoint : 768,
			settings : {
				arrows : true,
				dots: true,
				slidesToShow : 2,
				infinite: false,
				lazyLoad: 'ondemand',
			}
		},
		{
			breakpoint : 480,
			settings : {
				arrows : true,
				centerMode : true,
				slidesToShow : 1,
				dots: true,
				infinite: false,
				lazyLoad: 'ondemand',
			}
		}
	]
});
