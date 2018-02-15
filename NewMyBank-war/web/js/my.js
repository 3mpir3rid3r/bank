function activeTextField(currentTextFieldId, activeFieldId) {
    var currentTextValue = document.getElementById(currentTextFieldId).value;
    if (currentTextValue.length > 0) {

        document.getElementById(activeFieldId).removeAttribute("disabled");
    } else {

        document.getElementById(activeFieldId).setAttribute("disabled", "");
    }

}

function inActiveTextField(activeFieldId) {
    document.getElementById(activeFieldId).setAttribute("disabled", "");
}
//removeTags for remove < > this html tag
function removeTags(id) {

    var outData = document.getElementById(id).value;
    outData = outData.replace("<", "");
    outData = outData.replace(">", "");
    document.getElementById(id).value = outData;
}