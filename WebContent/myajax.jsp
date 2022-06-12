<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<script type="text/javascript">
		function search() {
			//1、创建异步对象
			var xmlHttp = new XMLHttpRequest();
			//2、给异步对象绑定事件，并指定一个函数
			xmlHttp.onreadystatechange = function() {
				if (xmlHttp.readyState == 4 && xmlHttp.status == 200) {
					var data = xmlHttp.responseText;
					//eval是执行括号中的代码，把json字符串转为json对象
					var jsonobj = eval("("+ data +")");
					//更新dom对象
					document.getElementById("proname").value = jsonobj.name;
					document.getElementById("projiancheng").value = jsonobj.jiancheng;
					document.getElementById("proshenghui").value = jsonobj.shenghui;
					
				}
			}
			//3、初始化异步对象
			var proid = document.getElementById("proid").value;
			//true : 异步处理请求。使用异步对象发起请求后，不用等待数据处理完毕，就可以执行其他的操作
			//fasle : 同步刷新， 异步对象必须处理完成请求，从服务器端获取数据后，才能执行send之后的代码
			xmlHttp.open("get","queryJson?proid="+proid,true);
			//4、发送请求
			xmlHttp.send();
			
			//异步刷新 可以在send之后建立其他的异步对象XMLHttpRequest,发送其他的请求处理
			
			alert("在send之后的代码");
		}
	</script>
</head>
<body>
	<p>ajax请求使用json格式的数据</p>
	<table>
		<tr>
			<td>省份编号：</td>
			<td>
				<input type="text" id="proid">
				<input type="button" value="搜索" onclick="search()">
			</td>
		</tr>
		<tr>
			<td>省份名称：</td>
			<td><input type="text" id="proname"></td>
		</tr>
		<tr>
			<td>省份简称：</td>
			<td><input type="text" id="projiancheng"></td>
		</tr>
			<tr>
			<td>省会名称：</td>
			<td><input type="text" id="proshenghui"></td>
		</tr>
	</table>
</body>
</html>