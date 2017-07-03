<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR" import="com.secondproject.constant.ContextPath"%>

<script src="http://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.4/summernote.js"></script>
<script>
	$('#content').summernote({
		height : 300,
		callbacks: {
			onImageUpload : function(files) {
				for (var i = 0; i < files.length; i++) {
					uploadFile(files[i]);
				}
			}
		}
	});

	function uploadFile(file) {
		data = new FormData();
		data.append("uploadFile", file);
		$.ajax({
			data : data,
			type : "POST",
			url : CONTEXT_PATH + "/upload?folder=review_content",
			enctype: 'multipart/form-data',
			cache: false,
			contentType: false,
			processData: false,
			async: false,
			success : function(data) {
				$('#content').summernote('insertImage', data, 'asdf');
			},
			error : function(e) {
				alert("##ERROR\n" + e);
			}
		});
	}
</script>