<%-- 
    Document   : newjsp
    Created on : May 27, 2015, 8:45:22 AM
    Author     : mmh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="../css/bootstrap.css" rel="stylesheet" type="text/css"/>
        <link href="../css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <link href="../css/AdminLTE.css" rel="stylesheet" type="text/css"/>
        <link href="../css/my/setDefalutFont.css" rel="stylesheet" type="text/css"/>

        <link href="../font/css/font-awesome.css" rel="stylesheet" type="text/css"/>
        <link href="../font/css/font-awesome.min.css" rel="stylesheet" type="text/css"/>

        <script src="../js/bootbox.js" type="text/javascript"></script>
        <script src="../js/bootbox.min.js" type="text/javascript"></script>
        <script src="../js/bootstrap.min.js" type="text/javascript"></script>
        <script src="../js/jquery.min.js" type="text/javascript"></script>

        <script type="text/javascript">

            function overlay() {
                el = document.getElementById("overlay");
                el.style.visibility = (el.style.visibility == "visible") ? "hidden" : "visible";
            }
        </script>
        <style type="text/css">

            #overlay {
                visibility: hidden;
                position: absolute;
                left: 0px;
                top: 0px;
                width:100%;
                height:100%;
                text-align:center;
                z-index: 1000;
            }

            #overlay div {
                width:300px;
                margin: 100px auto;
                background-color: #fff;
                border:1px solid #000;
                padding:15px;
                text-align:center;
            }

        </style>
        <script type="text/javascript">

            function printContent(el) {
                var restorepage = document.body.innerHTML;
                var printcontent = document.getElementById(el).innerHTML;
                document.body.innerHTML = printcontent;
                window.print();
                document.body.innerHTML = restorepage;
            }

            //   function printContent(el) {
//                var restorepage = $('body').html();
//                var printcontent = $('#' + el).clone();
//                $('body').empty().html(printcontent);
//                window.print();
//                $('body').html(restorepage);
//            }

            function PrintMe(DivID) {
                var disp_setting = "toolbar=yes,location=no,";
                disp_setting += "directories=yes,menubar=yes,";
                disp_setting += "scrollbars=yes,width=650, height=600, left=100, top=25";
                var content_vlue = document.getElementById(DivID).innerHTML;
                var docprint = window.open("", "", disp_setting);
                docprint.document.open();
                docprint.document.write('<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN"');
                docprint.document.write('"http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">');
                docprint.document.write('<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en">');
                docprint.document.write('<head><title></title>');
                docprint.document.write('<style type="text/css">body{ margin:0px;');
                docprint.document.write('font-family:verdana,Arial;color:#000;');
                docprint.document.write('font-family:Verdana, Geneva, sans-serif; font-size:12px;}');
                docprint.document.write('a{color:#000;text-decoration:none;} </style>');
                docprint.document.write('</head><body onLoad="self.print()"><center>');
                docprint.document.write(content_vlue);
                docprint.document.write('</center></body></html>');
                docprint.document.close();
                docprint.focus();
            }
        </script>
    </head>
    <body>
        <div id="a">zdvfxcfbgfbfgbfgඤඳචඳවදෆගදෆගද</div>
        <div>sfdghfhngjgfjghjgjn nfg</div>
        <button id="print" onclick="PrintMe('a')" >Print</button>
        <div id="overlay">
            <div>
                <p>Content you want the user to see goes here.zcdfsdf</p>


                <button class="btn btn-default btn-sm">close</button>
            </div>
        </div>
        <a href='#' onclick='overlay()'>Click here to show the overlay</a>
    </body>
</html>
