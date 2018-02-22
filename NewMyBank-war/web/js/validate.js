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
    $('*[data-type="birthday"]').each(function () {
        $(this).attr("data-toggle", "popover");
        $(this).attr("title", "BirthDay Calculator");
        $(this).attr("data-content", "B'day is..");
    });
    $('*[data-type="decimal"]').each(function () {
        $(this).val(numberWithCommas($(this).val().toString().split(",").join("")));
    });
    $('*[data-line*="line-"]').each(function () {
        if ($(this).attr("data-line") === "line-1") {
            return;
        }
        $(this).attr("disabled", "");
    });
    $('[data-toggle="popover"]').popover({
        placement: 'bottom',
        trigger: 'focus',
        html: 'true',
        container: 'body'
    });
});
$('*[data="validate"]').keydown(function (e) {
    var type = $(this).attr("data-type");
    switch (type) {
        case "letterS":
        case "letterSS":
            console.log(e.keyCode);
            if ((48 <= e.keyCode && e.keyCode <= 57) || (96 <= e.keyCode && e.keyCode <= 105) || 144 <= e.keyCode || 59 == e.keyCode) {
                e.preventDefault();
            }
            break;
        case "birthday":
            break;
        case "upperCase":
            break;
        case "address":
            break;
        default :
            if ($.inArray(e.keyCode, [46, 8, 9, 27, 13, 110, 190]) !== -1 || (e.keyCode == 65 && (e.ctrlKey === true || e.metaKey === true)) || (e.keyCode == 67 && (e.ctrlKey === true || e.metaKey === true)) || (e.keyCode == 88 && (e.ctrlKey === true || e.metaKey === true)) || (e.keyCode >= 35 && e.keyCode <= 39)) {
                switch (type) {
                    case "number":
                        if (e.keyCode === 110 || e.keyCode === 190) {
                            e.preventDefault();
                        }
                        break;
                    case "decimal":
                    case "weight":
                        if ((e.keyCode === 110 || e.keyCode === 190) && $(this).val().indexOf('.') !== -1) {
                            e.preventDefault();
                        }
                        break;
                }
                return;
            }
            if ((e.shiftKey || (e.keyCode < 48 || e.keyCode > 57)) && (e.keyCode < 96 || e.keyCode > 105) || e.keyCode === 59 || e.keyCode >= 144) {
                e.preventDefault();
            }
            break;
    }

});
$('*[data="validate"]').keyup(function () {
    var type = $(this).attr("data-type");
    switch (type) {
        case "decimal":
            $(this).val(numberWithCommas($(this).val().toString().split(",").join("")));
            break;
        case "address":
            var line = $(this).attr("data-line");
            if ($(this).val() !== "" || $(this).val() !== null) {
                $('[data-line="line-' + (parseInt(line.toString().split("-")[1]) + 1) + '"]').removeAttr("disabled");
            } else {
                alert(1);
                $('[data-line="line-' + (parseInt(line.toString().split("-")[1]) + 1) + '"]').attr("disabled", "");
            }
        case "letterS":
        case "upperCase":
            $(this).val($(this).val().toString().toUpperCase());
            break;
        case "birthday":
            var elem = $(this);
            var cNICNo = elem.val();
            if (cNICNo.length === 11) {
                cNICNo = cNICNo.toString().substring(2);
                cNICNo = cNICNo + "v";
            }
            if (cNICNo === "") {
                var popover = elem.attr('data-content', "B'day is..").data('bs.popover');
                popover.setContent();
            } else if (!isNaN(cNICNo.substr(0, 8)) && (cNICNo.charAt(9) === "v" || cNICNo.charAt(9) === "V")) {
                url = "../NicGenarator";
                var a = "asd";
                $.post(url,
                        {nicNo: cNICNo},
                        function (res) {
                            var popover = elem.attr('data-content', res).data('bs.popover');
                            popover.setContent();
                        });
            } else {
                var popover = elem.attr('data-content', "B'day is..").data('bs.popover');
                popover.setContent();
            }
            break;
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
} 