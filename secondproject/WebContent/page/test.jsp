<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<br />
<br />
<br />
<br />
<br />
<br />
<br />
<br />
<br />
<br />
<br />
<button id="test">TEST</button>
<button id="test2">TEST2</button>
<script>
$("#test").on('click', function() {
	$.ajax({
		method: 'post',
		url: CONTEXT_PATH + '/shop',
		data: {
			'act': 'test',
			'key' : 'isChange'
		},
		success: function(data) {
			console.log(data);
		},
		error: function(error) {
			alert('검색오류');
			SYSOUT(error);
		}
	})
});
$("#test2").on('click', function() {
	$.ajax({
		method: 'post',
		url: CONTEXT_PATH + '/shop',
		data: {
			'act': 'test2'
		},
		success: function(data) {
			console.log(data);
		},
		error: function(error) {
			alert('검색오류');
			SYSOUT(error);
		}
	})
});
</script>