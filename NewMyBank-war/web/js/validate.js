/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
$("*[required]").attr("style", "border-bottom-color: red;");
$("*[required]").focusout(function () {
    if ($.trim($(this).val()) !== "") {
        $(this).attr("style", "border-bottom-color: '';");
    } else {
        $(this).attr("style", "border-bottom-color: red;");
    }
    if ($.trim($(this).val()) !== "0") {
        $(this).attr("style", "border-bottom-color: '';");
    } else {
        $(this).attr("style", "border-bottom-color: red;");
    }
});
$(window).on("load", function () {
    $("*[required]").each(function () {
        if ($.trim($(this).val()) !== "") {
            $(this).attr("style", "border-bottom-color: '';");
        } else {
            $(this).attr("style", "border-bottom-color: red;");
        }
    });
    $("select[required]").each(function () {
        if ($.trim($(this).val()) !== "0") {
            $(this).attr("style", "border-bottom-color: '';");
        } else {
            $(this).attr("style", "border-bottom-color: red;");
        }
    });
});