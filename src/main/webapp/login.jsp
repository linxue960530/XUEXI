<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@include file="header.jsp" %>
<link type="text/css" rel="stylesheet" href="css/style.css" />
<script type="text/javascript" src="js/function.js"></script>
<script type="text/javascript" src="js/jquery-1.11.0.min.js"></script>
<div id="regLogin" class="wrap">
		<div class="dialog">
			<div class="box">
				<h4>用户登录</h4>
				<form id="User_login_action" name="User_login_action" action="page/User_login.action" method="post">
					<div class="infos">
						<table class="field">
							<tr>
								<td  colspan="2" style="text-align:center; color:red"></td>
							</tr>
							<tr>
								<td class="field">用 户 名：</td>
								<td>
									 <input type="text" name="username" value="" id="User_login_action_username" class="text" required="true"/>
								</td>
							</tr>
							<tr>
								<td class="field">密&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;码：</td>
								<td>
									<input type="password" name="password" id="User_login_action_password" class="text" required="true"/>
								</td>
							</tr>
						<!-- <tr>
							<td class="field">验 证 码：</td>
							<td><input type="text" class="text verycode" name="veryCode" /></td>
						</tr> -->
						</table>
						<div class="buttons" onclick="toLogin()">
							<input type="button" id="User_login_action_0" value="立即登录"/>

							<input type='button' value='注册' onclick='document.location="register.jsp"' />
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>
<script type="text/javascript">
  function toLogin(){
	  $.ajax({
		  type:"POST",
		  url:"toLogin.action",
		  data:$("#User_login_action").serialize(),
		  dataType:"JSON",
		  success:function(data){
			  if(data.code==1){
				 location.href="list.jsp";
			  }else{
				  alert(data.errmsg)
			  }
		  }
	  });
  }
</script>
	<%@include file="bottom.jsp" %>