$(document).ready(function(){
$("#extable #checkall").click(function () {
        if ($("#extable #checkall").is(':checked')) {
            $("#extable input[type=checkbox]").each(function () {
                $(this).prop("checked", true);
            });

        } else {
            $("#extable input[type=checkbox]").each(function () {
                $(this).prop("checked", false);
            });
        }
    });

});