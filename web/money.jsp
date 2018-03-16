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
    <title>资金流水上传</title>


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
    <link rel="stylesheet" href="layui/css/layui.css" media="all">
    <style type="text/css">
        body {
            font: normal 15px/1.5 Arial, Helvetica, Free Sans, sans-serif;
            color: #222;
            background: url(pattern.png);
            overflow-y: scroll;
            /*padding: 60px 0 0 0;*/
        }

        .my-form {
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
    <h1>资金流水</h1>
</div>
<div class="row ">
    <!-- Begin Form -->
    <form class="my-form layui-form" id="my-form" action="" method="post">
        <div>
            <%--<div class="layui-form-item" title="本资金流水单号">--%>
            <%--<label>单证号:</label>--%>
            <%--<input id="documentNumber" name="documentNumber" type="text"/>--%>
            <%--</div>--%>
            <%--<div title="实际承运人，实际收取运输费的人员，如车队、司机等">--%>
            <%--<label>承运人:</label>--%>
            <%--<input id="carrier" name="carrier" type="text"/>--%>
            <%--</div>--%>
            <%--<div>--%>
            <%--<label>车辆牌照号:</label>--%>
            <%--<input id="vehicleNumber" name="vehicleNumber" type="text"/>--%>
            <%--</div>--%>
            <%--<div>--%>
            <%--<label>牌照类型:</label>--%>
            <%--<select id="licensePlateTypeCode" name="licensePlateTypeCode">--%>
            <%--<option value="default">&ndash; 选择车牌类型 &ndash;</option>--%>
            <%--<option value="01" title="黄底黑字(含02式号牌部分)">大型汽车号牌</option>--%>
            <%--<option value="02" title="蓝底白字(含02式号牌部分)">小型汽车号牌</option>--%>
            <%--<option value="99">其他号牌</option>--%>
            <%--</select>--%>
            <%--</div>--%>
            <div>
                <div class="layui-inline">
                    <fieldset class="layui-elem-field layui-field-title">
                        <legend>运单列表</legend>
                        <div id="shippingList">
                            <div>
                                <fieldset class="layui-elem-field site-demo-button layui-inline"
                                          style="margin: 30px 30px 0px 30px; padding: 10px; width: 600px">
                                    <div>
                                        <div title="电子路单号">
                                            <label>托运单号:</label>
                                            <input id="shippingNoteNumber" name="shippingNoteNumber" type="text"/>
                                        </div>
                                        <div>
                                            <label>备注:</label>
                                            <input id="remark" name="remark" type="text"/>
                                        </div>
                                    </div>
                                </fieldset>
                            </div>
                        </div>
                        <div style="margin: 30px 30px 0px 30px; width: 600px">
                            <input type="button" class="layui-btn layui-btn-primary" onclick="addShopping()"
                                   name="addbtn"
                                   value="添加一个运单"/>
                        </div>
                    </fieldset>
                </div>

            </div>
            <fieldset class="layui-elem-field layui-field-title">
                <legend>财务列表</legend>
                <div id="financiallist">
                    <fieldset class="layui-elem-field site-demo-button"
                              style="margin: 30px 30px 0px 30px; padding: 10px; width: 600px">
                        <div id="paymentMeans">
                            <label>付款方式:</label>
                            <select id="paymentMeansCode" name="paymentMeansCode">
                                <option value="default">&ndash; 选择付款方式 &ndash;</option>
                                <option value="33">银行汇票</option>
                                <option value="39">银行转账</option>
                                <option value="7">第三方平台支付</option>
                                <option value="71">支付宝支付</option>
                                <option value="72">微信支付</option>
                                <option value="91">油卡支付</option>
                                <option value="92">道路桥闸通行费支付</option>
                                <option value="9">其他方式支付</option>
                            </select>
                        </div>
                        <div title="银行或第三方支付平台的资金流水单号，现金等其他方式可填财务记账号">
                            <label>流水号/序列号</label>
                            <input id="sequenceCode" name="sequenceCode" type="text"/>
                        </div>
                        <div title="资金流水金额默认人民币">
                            <label>货币金额</label>
                            <input id="monetaryAmount" name="monetaryAmount" type="text"/>
                        </div>
                        <div title="资金流水实际发生时间">
                            <label>日期时间</label>
                            <input id="dateTime" name="dateTime" type="text"/>
                        </div>
                    </fieldset>
                </div>
                <div style="margin: 30px 30px 0px 30px; width: 600px">
                    <input type="button" class="layui-btn layui-btn-primary" onclick="addFinancial()" name="addbtn"
                           value="添加一个财务单"/>
                </div>
            </fieldset>

            <fieldset class="layui-elem-field layui-field-title">
                <legend>基本信息</legend>
                <div>
                    <fieldset class="layui-elem-field site-demo-button"
                              style="margin: 30px 30px 0px 30px; padding: 10px; width: 600px">
                    <div title="本资金流水单号">
                        <label>单证号</label>
                        <input id="documentNumber" name="documentNumber" type="text"/>
                    </div>
                    <div title="实际承运人，实际收取运输费的人员，如车队、司机等">
                        <label>承运人</label>
                        <input id="carrier" name="carrier" type="text"/>
                    </div>
                    <div>
                        <label>车辆牌照号</label>
                        <input id="vehicleNumber" name="vehicleNumber" type="text"/>
                    </div>
                    <div>
                        <label>牌照类型:</label>
                        <select id="licensePlateTypeCode" name="licensePlateTypeCode">
                            <option value="default">&ndash; 选择车牌类型 &ndash;</option>
                            <option value="01" title="黄底黑字(含02式号牌部分)">大型汽车号牌</option>
                            <option value="02" title="蓝底白字(含02式号牌部分)">小型汽车号牌</option>
                            <option value="99">其他号牌</option>
                        </select>
                    </div>
                    </fieldset>
                </div>
            </fieldset>
        </div>

        <div>
            <hr/>
        </div>

        <div>
            <button type="submit">提交</button>
            <button id="reset" type="button">重置</button>
            <button id="batch" type="button">批量上传</button>

        </div>


    </form>
</div>
<div class="none">
    <input type="file" name="files[]" accept=".xls" id="excel"
           data-url="${pageContext.request.contextPath }/uploadServlet" multiple>
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
        jQuery('#dateTime').datetimepicker({
            timeFormat: "HH:mm:ss",
            dateFormat: "yy-mm-dd"
        });


    });

    var bankCodeArray = [
        '&ndash; 选择银行名称 &ndash;::default', '中国银行::BKCH', '农业银行::ABOC', '工商银行::ICBK', '建设银行::PCBC',
        '邮政储蓄::PSBC', '交通银行::COMM', '招商银行::CMBC', '平安银行::SZDB', '中信银行::CIBK', '民生银行::MSBC', '广发银行::GDBK', '浦发银行::SPDB',
        '兴业银行::FJIB', '光大银行::EVER', '福建海峡银行::FZCB',

    ];

    $(document).ready(function () {
        $('#paymentMeansCode').change(function () {
            var that = $(this);
            insertBankcode("bankCode", that, 'paymentMeansCode');
        });
    })

    function insertBankcode(name, that, addAfter) {

        var index = that.children('option:selected').val();
        var $el = $('[name="' + name + '"]').length
            ? $('[name="' + name + '"]') // by name
            : $('#' + name) // by id
        if (index == 39) {
            var options1 = {
                label: '银行名称',
                name: 'bankCode',
                id:name,
                type: 'select',
                list: bankCodeArray,
                addAfter: addAfter,
                filters: 'exclude',
                data: {exclude: ['default']},
                errors: {
                    exclude: '此处是必填的'
                }
            }
            if ($el.length == 0) {
                $myform.addFields([options1]);
            }
        }
        else {
            if ($el.length) {
                $myform.removeFields([name]);
            }
        }

    }
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
                    content: '<div style="padding: 50px; line-height: 22px; background-color: #393D49; color: #fff; font-weight: 300;"><div class="layui-layer-loading"></div>正在上传，请稍等</div>'
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
            layer.alert("有" + $myform.getInvalid().length + '项必填项未填写，请重新填写')
        },
        onSuccess: function (e) {
            var index = layer.open({
                type: 1,
                title: false,
                skin: "layui-layer-lan",
                closeBtn: 0,
                anin: 2,
                scrollbar: false,
                shadeClose: false,
                content: '<div style="padding: 50px; line-height: 22px; background-color: #393D49; color: #fff; font-weight: 300;"><div class="layui-layer-loading"></div>正在上传，请稍等</div>'
            });
            e.preventDefault();
            $.ajax({
                url: getRootPath()+"/moneyServlet",
                type: 'POST',
                dataType: 'json',
                timeout: 300000,
                data:  $('#my-form').serialize(),
                error: function () {
                    layer.alert("上传失败！请重试")
                    layer.close(index);
                },
                success: function (obj) {
                    layer.close(index);
                    if (obj.IsOk) {
                        layer.alert("上传成功！")
                    } else {
                        layer.alert("上传失败！请重试")
                    }
                }
            });
        },

        inputs: {
            'documentNumber': {
                filters: 'required ',
            },
            'shippingNoteNumber': {
                filters: 'required ',
            },
            'carrier': {
                filters: 'required ',
            },

            'sequenceCode': {
                filters: 'required ',
            },
            'monetaryAmount': {
                filters: 'required ',
            },
            'dateTime': {
                filters: 'required ',
            },

            'vehicleNumber': {
                filters: 'required vehicle',
            },


            'paymentMeansCode': {
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
        }

    };

    var $myform = $('#my-form').idealforms(options).data('idealforms');

    $('#reset').click(function () {
        $myform.reset().fresh().focusFirst()
    });

    $myform.focusFirst();

    var shoppingNum = 0;
    function addShopping() {
        shoppingNum++;
        var shippingNoteNumber = "shippingNoteNumber" + shoppingNum;
        var intoId = "shopping" + shoppingNum;
        var options1 = {
            label: '托运单号',
            id: shippingNoteNumber,
            name:'shippingNoteNumber',
            type: 'text',
            title: '电子路单号',
            filters: 'required ',
            addBefore: intoId,
        }
        var remark = "remark" + shoppingNum;
        var options2 = {
            label: '备注',
            id: remark,
            name:'remark',
            type: 'text',
            addBefore: intoId,
        }


        $("#shippingList").append("<div id='" + ("shippingParent" + shoppingNum) + "'><fieldset class='layui-elem-field site-demo-button layui-inline' " +
            "style='margin: 30px 30px 0px 30px; padding: 10px; width: 600px'>" +
            "<div class='ideal-wrap'><div id='shopping" + shoppingNum + "'></div></div></fieldset>" +
            "<div class='layui-inline' style='float: none'><div class='ideal-wrap'> " +
            "<input type='button' class='layui-btn layui-btn-danger' onclick='delShipping(" + shoppingNum + ")' value='删除'/></div> </div> </div>");

        $myform.addFields([options1, options2]);
    }

    var financialNum = 0;
    function addFinancial() {

        financialNum++;
        var intoId = "financial" + financialNum;
        var paymentMeansCode = "paymentMeansCode" + financialNum;
        var paymentMeansType = ['&ndash; 选择付款方式 &ndash;::default', '银行汇票::33', '银行转账::39', '第三方平台支付::7', '支付宝支付::71', '微信支付::72', '油卡支付::91', '道路桥闸通行费支付::92', '其他方式支付::9'];
        var paymentMeansCodeOption = {
            label: '付款方式',
            name: 'paymentMeansCode',
            id: paymentMeansCode,
            type: 'select',
            list: paymentMeansType,
            filters: 'exclude',
            data: {exclude: ['default']},
            errors: {
                exclude: '此处是必填的'
            },
            addBefore: intoId,
        };
        var sequenceCode = "sequenceCode" + financialNum;
        var sequenceCodeOption = {
            label: '流水号/序列号',
            name: 'sequenceCode',
            id:sequenceCode,
            type: 'text',
            title: '银行或第三方支付平台的资金流水单号，现金等其他方式可填财务记账号',
            filters: 'required ',
            addBefore: intoId,
        };
        var monetaryAmount = "monetaryAmount" + financialNum;
        var monetaryAmountOption = {
            label: '货币金额',
            name: 'monetaryAmount',
            id:monetaryAmount,
            type: 'text',
            title: '资金流水金额默认人民币',
            filters: 'required ',
            addBefore: intoId,
        };

        var dateTime = "dateTime" + financialNum;
        var dateTimeOption = {
            label: '日期时间',
            name: 'dateTime',
            id:dateTime,
            type: 'text',
            title: '资金流水实际发生时间',
            filters: 'required ',
            addBefore: intoId,
        };

        $("#financiallist").append("<div id='" + ("financialParent" + financialNum) + "'><fieldset class='layui-elem-field site-demo-button layui-inline' " +
            "style='margin: 30px 30px 0px 30px; padding: 10px; width: 600px'>" +
            "<div class='ideal-wrap'><div id='financial" + financialNum + "'></div></div></fieldset>" +
            "<div class='layui-inline' style='float: none'><div class='ideal-wrap'> " +
            "<input type='button' class='layui-btn layui-btn-danger' onclick='delFinancial(" + financialNum + ")' value='删除'/></div> </div> </div>");
        $myform.addFields([paymentMeansCodeOption, sequenceCodeOption, monetaryAmountOption, dateTimeOption]);
        $('#' + paymentMeansCode).change(function () {
            var that = $(this);
            insertBankcode("bankCode" + financialNum, that, paymentMeansCode);
        });
        jQuery('#'+dateTime).datetimepicker({
            timeFormat: "HH:mm:ss",
            dateFormat: "yy-mm-dd"
        });
    }
    function delShipping(shoppingNum) {
        var $el = $("#shippingParent" + shoppingNum);
        $el.remove();
    }
    function delFinancial(financialNum) {
        var $el = $("#financialParent" + financialNum);
        $el.remove();
    }


</script>
</body>
</html>
