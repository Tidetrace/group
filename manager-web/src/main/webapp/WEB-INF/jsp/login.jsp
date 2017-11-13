<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017.11.02
  Time: 17:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<!doctype html>
<html>

<head>
    <base href="${BaseContext}">
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>Amaze UI Admin index Examples</title>
    <meta name="description" content="这是一个 index 页面">
    <meta name="keywords" content="index">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="renderer" content="webkit">
    <meta http-equiv="Cache-Control" content="no-siteapp" />
    <link rel="icon" type="image/png" href="static/assets/i/favicon.png">
    <link rel="apple-touch-icon-precomposed" href="static/assets/i/app-icon72x72@2x.png">
    <meta name="apple-mobile-web-app-title" content="Amaze UI" />
    <link rel="stylesheet" href="static/assets/css/amazeui.min.css" />
    <link rel="stylesheet" href="static/assets/css/admin.css">
    <link rel="stylesheet" href="static/assets/css/app.css">
</head>

<body data-type="login">

<div class="am-g myapp-login">
    <div class="myapp-login-logo-block  tpl-login-max">
        <div class="myapp-login-logo-text">
            <div class="myapp-login-logo-text">
                Amaze UI<span> Login</span> <i class="am-icon-skyatlas"></i>

            </div>
        </div>

        <div class="login-font">
            <i>Log In </i> or <span> Sign Up</span>
        </div>
        <div class="am-u-sm-10 login-am-center">
            <form class="am-form" method="post">
                <fieldset>
                    <div class="am-form-group">
                        <input type="email" class="" id="doc-ipt-email-1" placeholder="输入电子邮件" name="username">
                    </div>
                    <div class="am-form-group">
                        <input type="password" class="" id="doc-ipt-pwd-1" placeholder="设置个密码吧" name="password">
                    </div>
                    <p><button type="button" class="am-btn am-btn-default" id="submitBtn">登录</button></p>
                    <a href="buser/forward.do" class="am-btn am-fr am-kai">还没有账号? go ...</a>
                </fieldset>
            </form>
        </div>
    </div>
</div>
<script src="static/assets/js/jquery.min.js"></script>
<script src="static/assets/js/amazeui.min.js"></script>
<script src="static/assets/js/app.js"></script>
</body>
<script type="text/javascript">
    $(function(){
        //表单的提交按钮添加js事件时，按钮的类型一定不要用submit
        $('#submitBtn').click(
            function(){
                alert("ooooooooooooo")
                var username = $('#doc-ipt-email-1').val();
                var password = $('#doc-ipt-pwd-1').val();
                alert(username)
                alert(password)
                $.post('buser/go.do',
                    {'username':username,'password':password},
                    function(ruselt){
                        if(ruselt.success){
                            alert(ruselt.msg)
                            window.location.href="goodscat/index.do"
                        }else{
                            window.location.reload();


                            alert(ruselt.msg)
                        }

                    },'json');
            });
    });

</script>
</html>