<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="header.jsp" %>
<link type="text/css" rel="stylesheet" href="css/style.css" />
<script type="text/javascript" src="js/function.js"></script>
<script type="text/javascript" src="js/jquery-1.11.0.min.js"></script>
<script type="text/javascript" src="js/add.js"></script>
</head>
<div id="regLogin" class="wrap">
		<div class="dialog">
			<dl class="clearfix">
				<dt>新房屋信息发布</dt>
				<dd class="past">填写房屋信息</dd>

			</dl>
			<div class="box">
				<form id="House_add_action" name="House_add_action" action="page/House_add.action" method="post">
					<div class="infos">
						<table class="field">
							<tr>
								<td class="field">标 题：</td>
								<td><input type="text" name="title" value="" id="House_add_action_title" class="text"/></td>
							</tr>
							<tr>
								<td class="field">户 型：</td>
								<td><select class="text" name="type.id" id="houseType"><!-- <option value="1000">一室一厅</option> --></select></td>
							</tr>
							<tr>
								<td class="field">面 积：</td>
								<td><input type="text" name="floorage" value="" id="House_add_action_floorage" class="text"/></td>
							</tr>
							<tr>
								<td class="field">价 格：</td>
								<td><input type="text" name="price" value="" id="House_add_action_price" class="text"/></td>
							</tr>

							<tr>
								<td class="field">房产证日期：</td>
								<td><input type="text" class="text" name="pubDate" /></td>
							</tr>

							<tr>
								<td class="field">位 置：</td>
								<td>区：<select class="text" name="district.id" id="houseDistrict" onchange="onchangeDistrict(this)"></select> 
								街：<select class="text" name="street.id" id="houseStreet"></select>
								</td>
							</tr>
							<tr>
								<td class="field">联系方式：</td>
								<td><input type="text" name="contact" value="" id="House_add_action_contact" class="text"/></td>
							</tr>
							<tr>
								<td class="field">详细信息：</td>
								<td><textarea name="description"></textarea></td>
							</tr>
						</table>
						<div class="buttons" onclick="addHouse()">
							<input type="button" id="House_add_action_0" value="立即发布" onclick='document.location="list.jsp"'/>

						</div>
					</div>
				</form>
			</div>
		</div>
	</div>
	
	<script type="text/javascript">
   function onchangeDistrict(oSelect){
	   var obj=$("#houseDistrict").find("option:selected").attr("value");

	   $.getJSON("street.action",{id:obj},function(data){
		   if(data.code==1){
			   $("#houseStreet").html("");
				var obj = data.obj;
				for ( var i = 0; i < obj.length; i++) {
					$("#houseStreet").append("<option  value='" + obj[i].id + "'>" + obj[i].name + "</option>");  
				}
			}
	   });  
   }
	
	//房子类型
	$(function(){
		$.ajax({
			type:"POST",
			url:"houseType.action",
			dataType:"JSON",
			success:function(data){
				if(data.code==1){
					var obj = data.obj;
					for ( var i = 0; i < obj.length; i++) {
						$("#houseType").append("<option  value='" + obj[i].id + "'>" + obj[i].name + "</option>");  
					}
				}
			}
		});
		$.ajax({
			type:"POST",
			url:"district.action",
			dataType:"JSON",
			success:function(data){
				if(data.code==1){
					var obj=data.obj;
					for ( var i = 0; i < obj.length; i++) {
						$("#houseDistrict").append("<option id='districtId' value='" + obj[i].id + "'>" + obj[i].name + "</option>");  
					
					}
				}
			}
		});
	});
	function addHouse(){
		$.ajax({
			type:"POST",
			url:"addHouse.action",
			data:$("#House_add_action").serialize(),
			dataType:"JSON",
			success:function(data){
				if(data.code==1){
					
				}
			}
		});
	
		
	}
</script>
	
<%@include file="bottom.jsp" %>