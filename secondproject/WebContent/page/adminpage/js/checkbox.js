$(function() {
	$('#checkedAll').click(function() {
			// 만약 checkedAll 이 'checked'되어 있다면
			if ($('#checkedAll').prop('checked')) {
				// checkbox 타입의 input 중 name이 subCheck 인 것들의 checked의 prop 값을 true로 변경
				$('input[name=checkbox]:checkbox').each(function() {
					$(this).prop('checked', true);
				});
				// checkedAll 이 checked 되어 있지 않다면
			} else {
				// checkbox 타입의 input 중 name이 subCheck 인 것들의 checked의 prop 값을 false로 변경
				$('input[name=checkbox]:checkbox').each(function() {
					$(this).prop('checked', false);
				});
			}
		})
	});