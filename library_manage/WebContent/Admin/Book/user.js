$(document).ready(function(){
	shouUserList(1);                     //显示第一页用户列表
	showPage();                          //显示页码
	getPageElement();
})

var pageNow = 1;	//显示当前页码
var userId = 0;
//显示用户列表
function shouUserList(page){
	
	var userPhone = $(".input-text").val();                //获取手机号码
	
	$.ajax({
		type: "post",
		url: "user.jhtm?method=getUserList",
		data:{userPhone:userPhone,page:page},
		dataType: "json",
		success: function(json){
			
			$(".tr_data").html("");
			var state_1 = "";                  //状态文字
			var spanColor = "";              //状态颜色
			var operation = "";              //操作

			for(var i in json.userList){
				
				var edittemp = "编辑";
				var editurl = "Admin/User/edit.html?userId="+json.userList[i].userId+"";
				var showtemp= "Show";
				var showurl = "Admin/User/member-show.html?userId="+json.userList[i].userId+"";	
				var changetemp = "修改密码";
				var changeurl = "Admin/User/change-password.html?userId="+json.userList[i].userId+"";
				
				if( json.userList[i].userState == 0){
					
					state = "已删除";
					spanColor = "label label-danger radius";
					operation = '<td class="td-manage"><a style="text-decoration:none" href="javascript:;" onClick="member_huanyuan(this,'+json.userList[i].userId+','+json.userList[i].userState+')" title="还原"><i class="Hui-iconfont">&#xe66b;</i></a> </td>';
				}else if( json.userList[i].userState == 1 ){
					
					state = "已启用";
					spanColor = "label label-success radius";

					operation = '<td class="td-manage"><a title="编辑" href="javascript:;" onclick="member_edit('+'\''+edittemp+'\''+','+'\''+editurl+'\''+',4,510)" class="ml-5" style="text-decoration:none"><i class="Hui-iconfont">&#xe6df;</i></a> <a style="text-decoration:none" class="ml-5" onClick="change_password()" href="javascript:;" title="修改密码"><i class="Hui-iconfont">&#xe63f;</i></a> <a title="删除" href="javascript:;" onclick="member_del(this,'+json.userList[i].userId+','+json.userList[i].userState+')" class="ml-5" style="text-decoration:none"><i class="Hui-iconfont">&#xe6e2;</i></a></td>';

					operation = '<td class="td-manage"><a title="编辑" href="javascript:;" onclick="member_edit('+'\''+edittemp+'\''+','+'\''+editurl+'\''+',4,510)" class="ml-5" style="text-decoration:none"><i class="Hui-iconfont">&#xe6df;</i></a> <a style="text-decoration:none" class="ml-5" onClick="change_password('+'\''+changetemp+'\''+','+'\''+changeurl+'\''+',4,410)" href="javascript:;" title="修改密码"><i class="Hui-iconfont">&#xe63f;</i></a> <a title="删除" href="javascript:;" onclick="member_del(this,'+json.userList[i].userId+','+json.userList[i].userState+')" class="ml-5" style="text-decoration:none"><i class="Hui-iconfont">&#xe6e2;</i></a></td>';

				}
		
				$(".tr_data").append(
					'<tr class="text-c">'
						+'<td><input type="checkbox" value="1" name=""></td>'
						+'<td>'+json.userList[i].userId+'</td>'
						+'<td class="hidden-xs"><u style="cursor:pointer" class="text-primary" onclick="member_show('+'\''+showtemp+'\''+','+'\''+showurl+'\''+',4,510)">'+json.userList[i].userNickname+'</u></td>'
						+'<td>'+json.userList[i].userSex+'</td>'
						+'<td>'+json.userList[i].userPhone+'</td>'
						+'<td>'+json.userList[i].userEmail+'</td>'
						+'<td>'+json.userList[i].userAccount+'</td>'
						+'<td class="td-status"><span class="'+spanColor+'">'+state+'</span></td>'
						+''+operation+''
					+'</tr>'
				)
			}
		}
	})
}

 

//显示页码
function showPage(){
	
	$.ajaxSetup({                    //设置同步
	    async : false  
	}); 
	
	var pageAll = 0;
	var userPhone = $(".input-text").val();                //获取手机号码
	
	$.post("./user.jhtm", {
		method : "getUserNumber",
		userPhone:userPhone,
	}, function(json) {
		
		document.getElementById("all_data").innerHTML = json;          //总数据
		pageAll = Math.ceil(json/10);               //页数
	});
	
	
	layui.config({
		base: './Admin/Mode/plugins/layui/modules/'
	}); 

	layui.use(['icheck', 'laypage','layer'], function() {
		var $ = layui.jquery,
			laypage = layui.laypage,
			layer = parent.layer === undefined ? layui.layer : parent.layer;
		$('input').iCheck({
			checkboxClass: 'icheckbox_flat-green'
	});

	//page
	laypage({
		cont: 'page',
		pages: pageAll //总页数
			,
		groups: 5 //连续显示分页数
			,
		jump: function(obj, first) {
			//得到了当前页，用于向服务端请求对应数据
			var curr = obj.curr;
			if(!first) {
				shouUserList(curr)     //跳转
			}
		}
	});
	});
}

//根据手机查找用户
function shouUserByPhone(page){
	
	shouUserList(page);
	showPage();
}

//修改用户状态
function changeUserState(userId,userState){
	
	$.ajax({
		type: "post",
		url: "./user.jhtm?method=changeUserState",
		data:{userId:userId,userState:userState},
		dataType: "json",
		success: function(json){
			 shouUserList(pageNow);
			 showPage();
		}
	})
}

//获得url参数
function getUrlName(name){
     var reg = new RegExp("(^|&)"+ name +"=([^&]*)(&|$)");
     var r = window.location.search.substr(1).match(reg);
     if(r!=null)return  unescape(r[2]); return null;
}

//获得这个用户在这个界面所有的按钮权限
function getPageElement(){
	
	var pageName = getUrlName("pageName");
	$.ajax({
		type: "post",
		url: "user.jhtm?method=getPagePower",
		data:{pageName:pageName},
		dataType: "json",
		success: function(json){
			
			for(var i=0;i<json.result.length;i++){
				
				$(""+json.result[i].elementName+"").show();
			}
		}
	})
}

