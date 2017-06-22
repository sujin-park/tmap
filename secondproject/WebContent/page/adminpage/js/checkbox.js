$(document).ready(function(){
	$("#extable #checkall").click(function () {
		$("#extable .checkthis").prop("checked", $(this).attr("checked"));
//        if ($("#extable #checkall").is(':checked')) {
//            $("#extable input[type=checkbox]").each(function () {
//                $(this).prop("checked", true);
//            });
//        } else {
//            $("#extable input[type=checkbox]").each(function () {
//                $(this).prop("checked", false);
//            });
//        }
    });

});