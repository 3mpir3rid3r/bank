<%-- 
    Document   : unicode_converter
    Created on : Dec 18, 2017, 11:15:54 AM
    Author     : mmh
--%>

<script type="text/javascript" src="../js/lan_convert.js"></script>
<div class="modal fade" id="myModal" role="dialog">
    <div class="modal-dialog">

        <!-- Modal content-->
        <div class="modal-content">
            <div class="modal-header bg-gradient-9">
                <button type="button" class="close" data-dismiss="modal">&times;</button>
                <h3 class="modal-title" style="color: black">Converter</h3>
            </div>

            <div class="well well-sm">
                <div class="modal-body">
                    <p>Singlish</p><br/>
                    <input id="txtSinglish" type="text" style="width: 100%;font-size: 18px;" >
                </div>

                <div class="modal-body">
                    <p>Unicode</p><br/>
                    <input id="txtUnicode" type="text" style="width: 100%;font-size: 18px;">
                </div>
                
                <div class="modal-body">
                    <p>Amali</p><br/>
                    <input id="txtAmali" type="text" style="width: 100%;font-size: 18px;" class="convertSinhalaAmali">
                </div>
            </div>

            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
            </div>
        </div>

    </div>
</div>