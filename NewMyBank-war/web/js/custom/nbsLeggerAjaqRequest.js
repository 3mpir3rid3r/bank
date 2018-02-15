/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


function sendRequestAjax(mid) {
    var obj;
    var c2 = 0, c3 = 0;
    var c1 = document.getElementById('act1').value;
    var f = document.getElementById("T1");
    var row = f.rows.length;
    if (window.XMLHttpRequest) {
        obj = new XMLHttpRequest();
    } else if (window.ActiveXObject) {
        obj = new ActiveXObject("Microsoft.XMLHTTP");
    } else {
        alert("Browser Dosent Support ajax!");
    }

    if (obj !== null) {
        obj.onreadystatechange = function () {
            if (obj.readyState < 4) {

            } else if (obj.readyState === 4) {
                var res_xml = obj.responseXML;
                if (mid == 1) {

                    var root_element = res_xml.getElementsByTagName("row");
                    alert(c1);
                    for (var i = 0; i < root_element.length; i++) {
                        var accno = root_element[0].getElementsByTagName("accno")[0].firstChild.nodeValue;
                        var subacc = root_element[i].getElementsByTagName("subaccno")[0].firstChild.nodeValue;
                        var des = root_element[i].getElementsByTagName("des")[0].firstChild.nodeValue;

                        var r = f.insertRow(f.rows.length);
//
                        var a = r.insertCell(0);
                        var b = r.insertCell(1)
                        var c = r.insertCell(2)
                        var d = r.insertCell(3)
//

                        a.innerHTML = accno;
                        b.innerHTML = subacc;
                        c.innerHTML = des;
                        d.innerHTML = "<a href='#' class='btn btn-default btn-sm btn-block'>Select</a>";
                    }

                }




//                for (var i = 0; i < root_element.length; i++) {
//                    var fname = root_element[i].getElementsByTagName("fname")[0].firstChild.nodeValue;
//                    var lname = root_element[i].getElementsByTagName("lname")[0].firstChild.nodeValue;
//                    var gender = root_element[i].getElementsByTagName("gender")[0].firstChild.nodeValue;
//
//                    var f = document.getElementById("T");
//                    var r = f.insertRow(f.rows.length);
//
//                    var a = r.insertCell(0);
//                    var b = r.insertCell(1)
//                    var c = r.insertCell(2)
//
//                    a.innerHTML = fname;
//                    b.innerHTML = lname;
//                    c.innerHTML = gender;
//                }
            }
        }
//        ?mid=" + mid + "&c1=" + c1 + "&c2=" + c2 + "&c3=" + c3
        obj.open("POST", "../CommonLedgerAjaxServlet?mid=" + mid + "&c1=" + c1 + "&c2=" + c2 + "&c3=" + c3, true);
        obj.setRequestHeader("Content-Type", "application/x-www-form-urlencoded"); // PostMethod
        obj.send(null);  //postMethod
    }
}