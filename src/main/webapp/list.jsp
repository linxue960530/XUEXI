<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="header.jsp" %>
<link type="text/css" rel="stylesheet" href="css/style.css" />
<script type="text/javascript" src="js/function.js"></script>
<script type="text/javascript" src="js/jquery-1.11.0.min.js"></script>
<script language="JavaScript" type="text/javascript" >
    function update(){
    	$.ajax({
    		type:"POST",
    		url:"update.action",
    		dataType:"JSON",
    		success:function(data){
    			if(data.code==1){
    				alert(1);
    			}
    		}
    	});
    }
    function del(id){
    	$.ajax({
    		type:"POST",
    		url:"del.action",
    		data:{id:id},
    		dataType:"JSON",
    		success:function(data){
    			if(data.code==1){
    				alert(1);
    				init(1);
    			}
    		}
    	});
    }
	$(function(){
		init(1);
	});
	function init(pages){
		alert(pages);
		$.ajax({
			type:"POST",
			url:"show.action",
			data:{pages:pages},
			dataType:"JSON",
			success:function(data){
				if(data.code==1){
					var obj=data.list;
					var str="";
					for(var i=0;i<obj.length;i++){
						//alert(obj[i].title);
						str+="<tr><td class='house-thumb'><span><a href='page/show.jsp?id=10001'>";
					    str+="<img src='images/thumb_house.gif' /></a></span></td><td><dl><dt>";
					    str+="<a href='page/show.jsp?id=10001'>"+obj[i].title+"</a></dt><dd>"+obj[i].description+"<br /> "+obj[i].contact;
						str+="</dd></dl></td><td class='house-type'><label class='ui-green'><input ";
						str+="type='button' onclick='update("+obj+")' value='修    改' /></label></td>";
						str+="<td class='house-price'><label class='ui-green'><input ";
						str+="<td class='house-price'><label class='ui-green'><input ";
						str+="type='button' onclick='del("+obj[i].id+")' value='删    除' /></label></td></tr>";
					}
					$(".house-list").html(str)
					var totalPage = data.totalPage;
					var total=data.total;
					var pagesize=data.pagesize;
					var pre = pages>1?pages-1:1;
					var next=pages<totalPage?pages+1:pages;
					//alert(next);
					
					$(".current").attr("href","javascript:init(1)");
					$(".pre").attr("href","javascript:init("+pre+")");
					$(".next").attr("href","javascript:init("+next+")");
					$(".last").attr("href","javascript:init("+totalPage+")");
					$(".total").html("");
					$(".total").append("第"+pages+"页/共"+totalPage+"页&nbsp;&nbsp;&nbsp;每页"+pagesize+"条/共"+total+"条")
				}
				
			}
		});
	}
	

</script>

<script type="text/javascript">
$(function(){
	$.ajax({
		url:"toLogin.action",
		type:"POST",
		dataTpye:"JSON",
		success:function(data){
			if(data.code==1){
				$("#loginresult").html("欢迎您："+data.obj.name+"|<a href='javascript:logout()'> 退出</a>")
			}
		}
	});
});

function logout(){
	$.ajax({
		url:"toLogin.action",
		type:"POST",
		dataTpye:"JSON",
		success:function(data){
			if(data.code==1){
				$("#loginresult").html("您尚未　<a href='login.jsp'>登录</a>&nbsp;| &nbsp; <a href='reg.jsp'>注册</a> |");

			}
		}
	});
}
</script>
<div class="search">
			<label class="ui-green"><input onclick="document.location='add.jsp'" type="button"
				name="search" value="发布房屋信息" /></label> <label class="ui-green"><input
				type="button" name="search" value="退       出"
				onclick='document.location="login.jsp"' /></label>
			<div  style="float:right" id="loginresult">
	                                    您尚未　<a href="login.jsp">登录</a>
		         &nbsp;| &nbsp; <a href="reg.html">注册</a> |
	        </div>	 
		</div>
<div class="main wrap">
		<div id="houseArea">
			<table class="house-list"></table>
			<div class="pager">
				<ul>
					<li ><a class="current" href="javascript:init(1)"> 首页</a></li>
					<li ><a class="pre" href="javascript:init(1)"> 上一页</a></li>
					<li ><a class="next" href="javascript:init(1)"> 下一页</a></li>
					<li ><a class="last" href="javascript:init(1)"> 最后一页</a></li>
				</ul>
				<span class="total"></span>
			</div>
		</div>
	</div>
	
	
	

	<%@include file="bottom.jsp" %>