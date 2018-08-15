<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@include file="header.jsp" %>
<link type="text/css" rel="stylesheet" href="css/style.css" />
<script type="text/javascript" src="js/function.js"></script>
<script type="text/javascript" src="js/jquery-1.11.0.min.js"></script>

    <div id="regLogin" class="wrap">
	<div class="dialog">
		<dl class="clearfix">
			<dt>新用户注册</dt>
			<dd class="past">填写个人信息</dd>
		</dl>
		<div class="box">
			<form id="User_register_action" name="User_register_action" action="page/User_register.action" method="post">
				<div class="infos">
					<table class="field">
						<tr>
							<td  colspan="2" style="text-align:center; color:red"></td>
						</tr>
						<tr>
							<td class="field">用 户 名：</td>
							<td><input type="text" class="text" name="username" /></td>
						</tr>
						<tr>
							<td class="field">密　　码：</td>
							<td><input type="password" class="text" name="password" /></td>
						</tr>
						<tr>
							<td class="field">确认密码：</td>
							<td><input type="password" class="text" name="repassword" /> </td>
						</tr>
						<tr>
							<td class="field">电　　话：</td>
							<td><input type="text" class="text" name="telephone" /> </td>
						</tr>
						<tr>
							<td class="field">用户姓名：</td>
							<td><input type="text" class="text" name="name" /> </td>
						</tr>
					</table>
					<div class="buttons"  onclick="toReg()"><input id="toReg" type="button"  value="立即注册"/></div>
				</div>
			</form>
		</div>
	</div>
</div>
<script type="text/javascript">
function toReg(){
	
	   $.ajax({
		   type:"POST",
	       url:"toReg.action",
	       data:$("#User_register_action").serialize(),
	       dataType:"JSON",
	       success:function(data){
	    	   if(data.code==1){
				location.href="login.jsp";
	    	   }else{
	    		   alert("注册失败");
	    	   }
	    	   
	       }
	   });
}
</script>
	<%@include file="bottom.jsp" %>