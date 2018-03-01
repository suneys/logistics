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
    <title>成功上传</title>


    <!--[if lt IE 9]>
    <script src="js/html5shiv.js"></script>
    <![endif]-->

    <link href="css/normalize.css" rel="stylesheet"/>
    <link href="css/jquery-ui.css" rel="stylesheet"/>
    <link href="css/jquery-ui-timepicker-addon.css" rel="stylesheet"/>
    <link href="css/jquery.idealforms.min.css" rel="stylesheet" media="screen"/>
    <link href="css/cityLayout.css" rel="stylesheet"/>
    <style type="text/css">
        body {
            font: normal 15px/1.5 Arial, Helvetica, Free Sans, sans-serif;
            color: #222;
            background: url(pattern.png);
            overflow-y: scroll;
            padding: 60px 0 0 0;
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
    </style>
</head>
<body>
<div class="row">
    <div style="margin: 0 auto ; text-align: center">
        <h2>上传成功</h2>
        <a href="${pageContext.request.contextPath }/index.jsp">返回主页</a>
    </div>
</div>


<script type="text/javascript" src="js/jquery-1.8.2.min.js"></script>
<script type="text/javascript" src="js/jquery-ui.min.js"></script>
<script type="text/javascript" src="js/jquery.idealforms.js"></script>
<script type="text/javascript" src="js/jquery-ui-timepicker-addon.js"></script>
<script type="text/javascript" src="js/jquery.ui.datepicker-zh-CN.js.js"></script>
<script type="text/javascript" src="js/jquery-ui-timepicker-zh-CN.js"></script>
<script type="text/javascript" src="js/cityselect.js"></script>

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

    $(function(){
        init_city_select($("#countrySubdivisionCode,#countrySubdivisionCode1"));
    });

    var options = {

        onFail: function () {
            alert("有"+$myform.getInvalid().length + '项必填项未填写，请重新填写')
        },

        inputs: {
            'originalDocumentNumber': {
                filters: 'required originalDocumentNumber',
            },
            'shippingNoteNumber': {
                filters: 'required shippingNoteNumber',
            },
            'carrier': {
                filters: 'required carrier',
            },

            'despatchActualDateTime': {
                filters: 'required despatchActualDateTime',
            },
            'goodsReceiptDateTime': {
                filters: 'required goodsReceiptDateTime',
            },
            'countrySubdivisionCode': {
                filters: 'required countrySubdivisionCode',
            },
            'countrySubdivisionCode1': {
                filters: 'required countrySubdivisionCode1',
            },
            'roadTransportCertificateNumber': {
                filters: 'required roadTransportCertificateNumber',
            },
            'descriptionOfGoods': {
                filters: 'required descriptionOfGoods',
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
