<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/4/28 0028
  Time: 下午 21:44
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
    <title>电子路单上传</title>


    <!--[if lt IE 9]>
    <script src="js/html5shiv.js"></script>
    <![endif]-->
    <link type="image/x-icon" rel="shortcut icon" href="${pageContext.request.contextPath }/images/favicon.ico"/>
    <link href="css/normalize.css" rel="stylesheet"/>
    <link href="css/jquery-ui.css" rel="stylesheet"/>
    <link href="css/jquery-ui-timepicker-addon.css" rel="stylesheet"/>
    <link href="css/jquery.idealforms.min.css" rel="stylesheet" media="screen"/>
    <link href="css/cityLayout.css" rel="stylesheet"/>
    <link href="layer/theme/default/layer.css" rel="stylesheet"/>
    <style type="text/css">
        body {
            font: normal 15px/1.5 Arial, Helvetica, Free Sans, sans-serif;
            color: #222;
            background: url(pattern.png);
            overflow-y: scroll;
            /*padding: 60px 0 0 0;*/
        }

        #my-form {
            width: 755px;
            margin: 0 auto;
            border: 1px solid #ccc;
            padding: 3em;
            border-radius: 3px;
            box-shadow: 0 0 2px rgba(0, 0, 0, .2);
        }

        #comments {
            width: 350px;
            height: 100px;
        }

        .none {
            width: 0px;
            height: 0px;
            display: none;
        }
    </style>
</head>
<body>
<div style="margin: 0 auto; text-align: center">
    <h1>电子路单</h1>
</div>
<div class="row">
    <!-- Begin Form -->
    <form id="my-form" action="${pageContext.request.contextPath }/mainServlet" method="post">
        <div class="eightcol last">
            <div title="上游企业运输单号">
                <label>原始单号:</label>
                <input id="originalDocumentNumber" name="originalDocumentNumber" type="text"/>
            </div>
            <div title="本电子路单号">
                <label>托运单号:</label>
                <input id="shippingNoteNumber" name="shippingNoteNumber" type="text"/>
            </div>
            <div title="无车承运试点企业名称">
                <label>承运人:</label>
                <input id="carrier" name="carrier" type="text"/>
            </div>
            <div title="无车承运人的统一社会信用代码">
                <label>统一社会信用代码:</label>
                <input id="unifiedSocialCreditIdentifier" name="unifiedSocialCreditIdentifier" type="text"/>
            </div>
            <div title="无车承运人的道路运输经营许可证（无车承运）编号 ">
                <label>许可证编号:</label>
                <input id="permitNumber" name="permitNumber" type="text"/>
            </div>
            <div><label>业务类型:</label>
                <select id="businessTypeCode" name="businessTypeCode">
                    <option value="default">&ndash; 选择业务类型 &ndash;</option>
                    <option value="1002996">干线普货运输</option>
                    <option value="1003997">城市配送</option>
                    <option value="1003998">农村配送</option>
                    <option value="1002998">集装箱运输</option>
                    <option value="1003999">其他</option>
                </select>
            </div>
            <div title="货物装车后的发车时间">
                <label>发运实际日期时间:</label>
                <input id="despatchActualDateTime" name="despatchActualDateTime" type="text"/>
            </div>
            <div title="货物运到后的签收时间。如签收时间无法确定，填货物运到收货地的时间">
                <label>收货日期时间:</label>
                <input id="goodsReceiptDateTime" name="goodsReceiptDateTime" type="text"/>
            </div>
            <div title="单位或个人，如集装箱运输业务无法明确实际发货人可填货代信息">
                <label>发货人:</label>
                <input id="consignor" name="consignor" type="text"/>
            </div>
            <div>
                <label>个人证件:</label>
                <input id="personalIdentityDocument" name="personalIdentityDocument" type="text"/>
            </div>
            <div title="选填，实际装货的详细地点">
                <label>装货详细地点:</label>
                <input id="placeOfLoading" name="placeOfLoading" type="text"/>
            </div>
            <div title="实际装货的地区">
                <label>装货地区:</label>
                <input id="countrySubdivisionCode" name="countrySubdivisionCode" type="text" style="min-width: 225px"/>
            </div>
            <div title="单位或个人">
                <label>收货人:</label>
                <input id="consignee" name="consignee" type="text"/>
            </div>
            <div title="选填，具体的收货地址">
                <label>收货详细地点:</label>
                <input id="goodsReceiptPlace" name="goodsReceiptPlace" type="text"/>
            </div>
            <div title="实际收货的地区">
                <label>收货地区:</label>
                <input id="countrySubdivisionCode1" name="countrySubdivisionCode1" type="text"
                       style="min-width: 225px"/>
            </div>
            <div title="托运人付给无车承运人企业的运输费用，货币单位为人民币，
保留 3 位小数，如整数的话，以.000 填充。如是一笔业务分几辆车运，
需将托运人针对这笔业务付给无车承运人企业的运输费用分摊到每辆车上。">
                <label>货币总金额:</label>
                <input id="totalMonetaryAmount" name="totalMonetaryAmount" type="text" class="easyui-numberbox"
                       precision="2"/>
            </div>
            <div>
                <label>备注:</label>
                <input id="remark" name="remark" type="text" value="人民币"/>
            </div>
            <div><label>牌照类型:</label>
                <select id="licensePlateTypeCode" name="licensePlateTypeCode">
                    <option value="default">&ndash; 选择车牌类型 &ndash;</option>
                    <option value="01" title="黄底黑字(含02式号牌部分)">大型汽车号牌</option>
                    <option value="02" title="蓝底白字(含02式号牌部分)">小型汽车号牌</option>
                    <option value="99">其他号牌</option>
                </select>
            </div>

            <div>
                <label>车辆牌照号:</label>
                <input id="vehicleNumber" name="vehicleNumber" type="text"/>
            </div>
            <div>
                <label>车辆分类:</label>
                <select id="vehicleClassificationCode" name="vehicleClassificationCode">
                    <option value="default">&ndash; 选择车辆分类 &ndash;</option>
                    <option value="H01">普通货车</option>
                    <option value="H02">厢式货车</option>
                    <option value="H04">罐式货车</option>
                    <option value="Q00">牵引车</option>
                    <option value="G01">普通挂车</option>
                    <option value="G03">罐式挂车</option>
                    <option value="G05">集装箱挂车</option>
                    <option value="H09">仓栅式货车</option>
                    <option value="H03">封闭货车</option>
                    <option value="H05">平板货车</option>
                    <option value="H06">集装箱车</option>
                    <option value="H07">自卸货车</option>
                    <option value="H08">特殊结构货车</option>
                    <option value="Z00">专项作业车</option>
                    <option value="G02">厢式挂车</option>
                    <option value="G07">仓栅式挂车</option>
                    <option value="G04">平板挂车</option>
                    <option value="G06">自卸挂车</option>
                    <option value="G09">专项作业挂车</option>
                    <option value="X91">车辆运输车</option>
                    <option value="X92">车辆运输车(单排)</option>
                </select>
            </div>
            <div title="默认单位：吨，保留两位小数，如整数的话，以.00 填充。小数点不计入总长。">
                <label>车辆载质量:</label>
                <input id="vehicleTonnage" name="vehicleTonnage" type="text"/>
            </div>
            <div title="必填。车辆的道路运输证号，填道路运输证证件编号">
                <label>道路运输证号:</label>
                <input id="roadTransportCertificateNumber" name="roadTransportCertificateNumber" type="text"/>
            </div>
            <div>
                <label>挂车牌照号:</label>
                <input id="trailerVehiclePlateNumber" name="trailerVehiclePlateNumber" type="text"/>
            </div>
            <div title="选填。车辆所有人（或企业）的名称或姓名">
                <label>车辆所有人:</label>
                <input id="owner" name="owner" type="text"/>
            </div>
            <div title="选填。车辆所属业户的道路运输经营许可证编号">
                <label>许可证编号:</label>
                <input id="permitNumber1" name="permitNumber1" type="text"/>
            </div>
            <div>
                <label>驾驶员姓名:</label>
                <input id="nameOfPerson1" name="nameOfPerson1" type="text"/>
            </div>
            <div title="驾驶员从业资格证号">
                <label>从业资格证号:</label>
                <input id="qualificationCertificateNumber1" name="qualificationCertificateNumber1" type="text"/>
            </div>
            <div title="驾驶员电话号码">
                <label>电话号码:</label>
                <input id="telephoneNumber1" name="telephoneNumber1" type="text"/>
            </div>
            <div>
                <label>驾驶员姓名:</label>
                <input id="nameOfPerson2" name="nameOfPerson2" type="text"/>
            </div>
            <div title="驾驶员从业资格证号">
                <label>从业资格证号:</label>
                <input id="qualificationCertificateNumber2" name="qualificationCertificateNumber2" type="text"/>
            </div>
            <div title="驾驶员电话号码">
                <label>电话号码:</label>
                <input id="telephoneNumber2" name="telephoneNumber2" type="text"/>
            </div>
            <div>
                <label>货物名称:</label>
                <input id="descriptionOfGoods" name="descriptionOfGoods" type="text"/>
            </div>

            <div>
                <label>货物类型分类:</label>
                <select id="cargoTypeClassificationCode" name="cargoTypeClassificationCode">
                    <option value="default">&ndash; 货物类型分类 &ndash;</option>
                    <option value="90">电子产品</option>
                    <option value="92">商品汽车</option>
                    <option value="93">冷藏货物</option>
                    <option value="94">大宗货物</option>
                    <option value="95">快速消费品</option>
                    <option value="96">农产品</option>
                    <option value="999">其他</option>
                </select>
            </div>

            <div title="必填。重量单位以 KGM 千克填写数值，
保留 3 位小数，如整数的话，以.000 填
充。小数点不计入总长。如是轻泡货等
货物，请估算重量。如是一笔业务分几
辆车运，需报送每辆车实际运输的货物
重量。">
                <label>货物项毛重:</label>
                <input id="goodsItemGrossWeight" name="goodsItemGrossWeight" type="text"/>
            </div>
            <div title="选填。体积单位以 DMQ 立方米填写数
值，保留 4 位小数，如整数的话，以.0000
填充。小数点不计入总长。">
                <label>体积:</label>
                <input id="cube" name="cube" type="text"/>
            </div>
            <div>
                <label>总件数:</label>
                <input id="totalNumberOfPackages" name="totalNumberOfPackages" type="text"/>
            </div>


            <div>
                <hr/>
            </div>

            <div>
                <button type="submit">提交</button>
                <button id="reset" type="button">重置</button>
                <button id="batch" type="button">批量上传</button>

            </div>

        </div>
    </form>

    <div class="none">
        <input type="file" name="files[]" accept=".xls" id="excel" data-url="${pageContext.request.contextPath }/uploadServlet" multiple>
    </div>
    <%--<div>--%>
    <%--<form name="frm_test" action="${pageContext.request.contextPath }/uploadServlet" method="post" enctype="multipart/form-data">--%>
    <%--文件：   <input type="file" name="file_img">   <br/>--%>
    <%--<input type="submit" value="提交">--%>
    <%--</form>--%>
    <%--</div>--%>

    <!-- End Form -->


</div>


<script type="text/javascript" src="js/jquery-1.8.2.min.js"></script>
<script type="text/javascript" src="js/jquery-ui.min.js"></script>
<script type="text/javascript" src="js/jquery.idealforms.js"></script>
<script type="text/javascript" src="js/jquery-ui-timepicker-addon.js"></script>
<script type="text/javascript" src="js/jquery.ui.datepicker-zh-CN.js.js"></script>
<script type="text/javascript" src="js/jquery-ui-timepicker-zh-CN.js"></script>
<script type="text/javascript" src="js/cityselect.js"></script>
<script type="text/javascript" src="js/vendor/jquery.ui.widget.js"></script>
<script type="text/javascript" src="js/jquery.iframe-transport.js"></script>
<script type="text/javascript" src="js/jquery.fileupload.js"></script>
<script type="text/javascript" src="js/jquery.jmpopups.js"></script>
<script type="text/javascript" src="layer/layer.js"></script>


<script type="text/javascript">

    jQuery(function () {
        // 时间设置
        jQuery('#despatchActualDateTime').datetimepicker({
            timeFormat: "HH:mm:ss",
            dateFormat: "yy-mm-dd"
        });
        jQuery('#goodsReceiptDateTime').datetimepicker({
            timeFormat: "HH:mm:ss",
            dateFormat: "yy-mm-dd"
        });

    });

    /*
     * 获取工程的路径
     */
    function getRootPath() {
        var pathName = window.location.pathname.substring(1);
        var webName = pathName == '' ? '' : pathName.substring(0, pathName
                .indexOf('/'));
        var url = window.location.protocol + '//' + window.location.host + '/'
            + webName + '/';
        return url;
    }

    /**
     * 显示loading画面
     * @param desc
     * @return
     */
    function showLoading(desc) {

        $("body").append("<div id=\"processingdiv\" style=\"display:none;\"><div class=\"popup\"> <div class=\"popup-body\"><div class=\"loading\"><span>" + desc + "</span></div></div></div></div>");

        //alert($("head").html());

        $.openPopupLayer({
            name: "processing",
            width: 500,
            height: 200,
            target: "processingdiv"
        });
    }

    /**
     * 关闭loading画面
     * @param desc
     * @return
     */
    function hideLoading() {
        $.closePopupLayer('processing');
        $("#processingdiv").remove();
    }

    $("#batch").click(function () {
        //alert("batch");
        var index
        $("#excel").click();
        $('#excel').fileupload({
            dataType: 'json',
            add: function (e, data) {
                index = layer.open({
                    type: 1,
                    title: false,
                    skin: "layui-layer-lan",
                    closeBtn: 0,
                    anin: 2,
                    scrollbar: false,
                    shadeClose: false,
                    content:'<div style="padding: 50px; line-height: 22px; background-color: #393D49; color: #fff; font-weight: 300;"><div class="layui-layer-loading"></div>正在上传，请稍等</div>'
                });
                data.submit();
            },
            done: function (e, data) {
               layer.close(index);
               //console.log(data.result.result);
               layer.alert(data.result.result);
            }
        });
//        $("#excel").live("change", function () {
//            var fd = new FormData($("#frm"));
////            fd.append("file_img", $("#excle").files);
//            $.ajax({
//                url: "/logistics/uploadServlet",
//                type: "POST",
//                processData: false,
//                contentType: false,
//                data: fd,
//                success: function (d) {
//                    console.log(d);
//                }
//            });
//        })
    });


    $(function () {
        init_city_select($("#countrySubdivisionCode,#countrySubdivisionCode1"));
    });

    var options = {

        onFail: function () {
            alert("有" + $myform.getInvalid().length + '项必填项未填写，请重新填写')
        },
        onSuccess: function () {

        },

        inputs: {
            'originalDocumentNumber': {
                filters: 'required ',
            },
            'shippingNoteNumber': {
                filters: 'required ',
            },
            'carrier': {
                filters: 'required ',
            },

            'despatchActualDateTime': {
                filters: 'required ',
            },
            'goodsReceiptDateTime': {
                filters: 'required ',
            },
            'countrySubdivisionCode': {
                filters: 'required ',
            },
            'countrySubdivisionCode1': {
                filters: 'required ',
            },
            'roadTransportCertificateNumber': {
                filters: 'required ',
            },
            'descriptionOfGoods': {
                filters: 'required ',
            },
            'totalMonetaryAmount': {
                filters: 'required decimals',
            },
            'goodsItemGrossWeight': {
                filters: 'required decimals',
            },
            'vehicleNumber': {
                filters: 'required vehicle',
            },
            'vehicleTonnage': {
                filters: 'required twodecimals',
            },
            'cube': {
                filters: 'fourdecimals',
            },

            'businessTypeCode': {
                filters: 'exclude',
                data: {exclude: ['default']},
                errors: {
                    exclude: '此处是必填的'
                }
            },

            'licensePlateTypeCode': {
                filters: 'exclude',
                data: {exclude: ['default']},
                errors: {
                    exclude: '此处是必填的'
                }
            },

            'vehicleClassificationCode': {
                filters: 'exclude',
                data: {exclude: ['default']},
                errors: {
                    exclude: '此处是必填的'
                }
            },
            'cargoTypeClassificationCode': {
                filters: 'exclude',
                data: {exclude: ['default']},
                errors: {
                    exclude: '此处是必填的'
                }
            },
            'langs[]': {
                filters: 'min max',
                data: {min: 2, max: 3},
                errors: {
                    min: 'Check at least <strong>2</strong> options.',
                    max: 'No more than <strong>3</strong> options allowed.'
                }
            }
        }

    };

    var $myform = $('#my-form').idealforms(options).data('idealforms');

    $('#reset').click(function () {
        $myform.reset().fresh().focusFirst()
    });

    $myform.focusFirst();
</script>
</body>
</html>
