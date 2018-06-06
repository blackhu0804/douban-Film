<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
    <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
    <html lang="en">

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="ie=edge">
        <title>逗瓣Film</title>
        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Exo:100,200,400">
        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:700,400,300">
        <link rel="stylesheet" href="./CSS/style.css">
    </head>

    <body>
        <div class="bg"></div>
        <div class="grad"></div>
        <div class="header">
            <div>
                	逗<span>瓣</span>Film
            </div>
        </div>
        <br>
        <div class="login">
            <form id="accountForm">
                <input type="text" placeholder="username" id="username" name="user.username">
                <label class="user-tips">用户名不能为空!</label>
                <br>
                <input type="password" placeholder="password" name="user.password" id="password">
                <label class="pwd-tips">密码不能为空!</label>
                <label class="tips">用户名或密码错误！</label>
                <br>
                <input class="submit" id="submitButton" type="button" value="登录">
                <span class="sign-up">还没有账号，赶快去
                    <a href="./signup.jsp">注册</a>
                </span>
            </form>
        </div>
        <script src="https://cdn.bootcss.com/jquery/3.3.1/jquery.min.js"></script>
        <script>
            $(document).ready(function () {
            	function valid() {
	            	var username = $("#username").val();
	                var password = $("#password").val();
                    if (username === '') {
                        $('.user-tips').show()
                        setTimeout(() => {
                            $('.user-tips').hide(1000)
                        }, 1500);
                    } else if (password === '') {
                        $('.pwd-tips').show()
                        setTimeout(() => {
                            $('.pwd-tips').hide(1000)
                        }, 1500);
                    } else {
                        $('label').hide()
                    }
                }
            
                $("#submitButton").click(function () {
	                var username = $("#username").val();
	                var password = $("#password").val();
                    if (username == "" || password == "") {
                        valid()
                    } else {
                        $.ajax({
                            type: "post",
                            url: "LoginAction",
                            //将表单内容序列化成一个字符串，如下：username=wwc&password=wwc，如果是post请求，那么这串字符串就以请求体的方式传递给后端action                    
                            data: $("#accountForm").serialize(),
                            datatype: "json",
                            success: function (data) {
                                console.log(data);
                                var d = eval("(" + data + ")");
                                if (d.login == "success") {
                                    window.location.href = "login_success.jsp";
                                } else if (d.login == "false") {
                                	$('.tips').show()
                                	setTimeout(() => {
			                            $('.tips').hide(1000)
			                        }, 1500);
                                }
                            },
                            error: function () {
                                alert("系统异常");
                            }
                        });
                    }
                });
            });
        </script>
    </body>

    </html>