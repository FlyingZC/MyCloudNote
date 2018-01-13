//在控制台,checkName为显示方法,checkName()为执行方法
//focus()方法不加参数,是.focus()事件.加参数为触发事件
//mysql查询不区分大小写
$(function(){
	$("#login").click(loginAction);//调function时不加()
	$("#count").focus().blur(checkName);
	$("#password").focus().blur(checkPassword);
});
//发送登录按钮的ajax请求
function loginAction(){
	console.log("login click");
	//收集用户名和密码数据
	var name=$("#count").val();
	var password=$("#password").val();
	//验证用户名和密码
	var pass=checkName()+checkPassword();
	if(pass!=2){//name和psw有一个不正确
		return;
	}
	//js对象,中name属性,password属性
	var args={'name':name,'password':password}; 
	//发送ajax请求
	$.ajax({
		url:'user/login.do',
		data:args,
		dataType:'json',
		type:'POST',
		success:function(result){
			if(result.state==0){//SUCCESS
				console.log("success");
				location.href='edit.html';
				return;
			}else if(result.state==2){
				//用户名错误
				$('#count-msg').text(result.message);
			}else if(result.state==3){
				//密码错误
				$("#password-msg").text(result.message);
			}
		},
		error:function(){
			console.log("error");
			alert('ajax请求失败');
		}	
	});
	
}

function checkName(){
	var name=$("#count").val();
	if(name==null||name==""){
		//提示错误
		$("#count-msg").text("用户名不能为空");
		return false;
	}
	var reg=/^\w{3,10}$/;
	if(!reg.test(name)){
		$("#count-msg").text("用户名格式不对");
		return false;
	}
	$("#count-msg").empty();
	return true;
}

function checkPassword(){
	var password=$("#password").val();
	if(password==null||password==""){
		$("#password-msg").text("密码不能为空");
		return false;
	}
	var reg=/^\w{3,10}$/;
	if(!reg.test(password)){
		$("#password-msg").text("密码格式不对");
		return false;
	}
	$("#password-msg").empty();
	return true;
	
}