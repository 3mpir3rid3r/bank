/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
$("*[required]").attr("style", "border-bottom-color: red;");
$("*[required]").focusout(function () {
    var val = $.trim($(this).val());
    if (val == "") {
        $(this).attr("style", "border-bottom-color: red;");
    } else if (val == "0") {
        $(this).attr("style", "border-bottom-color: red;");
    } else {
        $(this).attr("style", "border-bottom-color: '';");
    }
});
$(document).ready(function () {

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
    $('*[data-type="decimal"]').each(function () {
        $(this).val(numberWithCommas($(this).val().toString().split(",").join("")));
    });
});
$("*[data=number]").keydown(function (e) {
    var type = $(this).attr("data-type");
    if ($.inArray(e.keyCode, [46, 8, 9, 27, 13, 110, 190]) !== -1 || (e.keyCode == 65 && (e.ctrlKey === true || e.metaKey === true)) || (e.keyCode == 67 && (e.ctrlKey === true || e.metaKey === true)) || (e.keyCode == 88 && (e.ctrlKey === true || e.metaKey === true)) || (e.keyCode >= 35 && e.keyCode <= 39)) {
        switch (type) {
            case "number":
                if (e.keyCode === 110) {
                    e.preventDefault();
                }
                break;
            case "decimal":
                if (e.keyCode === 110 && $(this).val().indexOf('.') !== -1) {
                    e.preventDefault();
                }
                break;
            case "weight":
                if (e.keyCode === 110 && $(this).val().indexOf('.') !== -1) {
                    e.preventDefault();
                }
                break;
        }
        return;
    }
    if ((e.shiftKey || (e.keyCode < 48 || e.keyCode > 57)) && (e.keyCode < 96 || e.keyCode > 105)) {
        e.preventDefault();
    }

});
$("*[data=number]").keyup(function (e) {
    var type = $(this).attr("data-type");
    switch (type) {
        case "decimal":
            $(this).val(numberWithCommas($(this).val().toString().split(",").join("")));
            break;
        case "birthday":

    }

});
function numberWithCommas(nStr) {
    nStr += '';
    x = nStr.split('.');
    x1 = x[0];
    x2 = x.length > 1 ? '.' + x[1] : '';
    var rgx = /(\d+)(\d{3})/;
    while (rgx.test(x1)) {
        x1 = x1.replace(rgx, '$1' + ',' + '$2');
    }
    return x1 + x2;
//    var num = "";
//    while (nStr.length > 2) {
//        num = nStr.toString().substring(nStr.length - 3) + "," + num;
//        nStr = nStr.toString().substring(0, nStr.length - 3);
//    }
//    num = nStr + "," + num;
//    num = num.replace(/.$/, "");
//    num = num.replace(/^\,/, "");
//    return num;
} 