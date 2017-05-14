var page = 1;
var num = 0;
var name = null;
var author = null;
var currentNum = 0;
$(document).ready(function()
{ 
	showList(null,null)
	showPage();
	getType()
})

function showListbycondition(){
	name = $('#name').val();
	author = $('#author').val();
	showList(name,author);
}
function showList(name,author){
	var json={
			"author":author,
		    "name":name
		}
		$.getJSON("../../BOOK",{
			"method":"selectBook",
			"jsonStr":JSON.stringify(json),
			"page":page
		},function(data){
			var json = data.data;
			var spanColor = "";
			var state = "";
			num = data.num;
			$("#num").empty();
			$("#num").append(num);
			
			$("#booklist").empty();
			for(var i=0;i<json.length;i++){
                 if( json[i].state == 0){
                    state = "已删除";
					spanColor = "label label-danger radius";
				}else if( json[i].state == 1 ){
					
					state = "已启用";
					spanColor = "label label-success radius";
				}
			$("#booklist").append(
						'<tr class="text-c">'+
						'<td><input type="checkbox" value="'+json[i].id+'" name="BookId"></td>'+
						'<td>'+json[i].id+'</td>'+
						'<td class="hidden-xs"><u style="cursor:pointer" class="text-primary">'+json[i].name+'</u></td>'+
						'<td>'+json[i].id+'</td>'+
						'<td>'+json[i].author+'</td>'+
						'<td>'+json[i].press+'</td>'+
						'<td class="text-l">'+json[i].des+'</td>'+
						'<td>'+json[i].img_path+'</td>'+
						'<td class="td-status"><span class="'+spanColor+'">'+state+'</span></td>'+
						'<td class="td-manage">'+
						'<a title="编辑" class="ml-5" style="text-decoration:none" onclick="a()"><i class="Hui-iconfont">&#xe6df;</i></a></td> '+
					'</tr>'
             );
			}
			
			
		})
}

function a(){
	member_edit("编辑框","edit.html",800,1000)
}

//page
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
		alert(pageAll)
	});
	
	
	layui.config({
		base: '../Mode/plugins/layui/modules/'
	}); 

	layui.use(['icheck', 'laypage','layer'], function() {
		var $ = layui.jquery,
			laypage = layui.laypage,
			layer = parent.layer === undefined ? layui.layer : parent.layer;
		$('input').iCheck({
			checkboxClass: 'icheckbox_flat-green'
	});

	pageAll = Math.ceil(num/10);               //页数
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
			page = curr;
			if(!first) {
				showList(null,null)     //跳转
			}
		}
	});
	});
}


function deleteAll(){
	var IdAll = document.getElementsByName('BookId');
	var IdStr = null;
	var n=0;
	for(var k=0;k<IdAll.length;k++){
		if(IdAll[k].checked){
			if(n == 0){
				IdStr = IdAll[k].value;
			}else{
				IdStr += ','+IdAll[k].value;
				}
			n++			 
		} 
			
     }
	$.getJSON("../../BOOK",{
		"method":"deleteBook",
		"idStr":IdStr
	},function(data){
		alert(Number(data.data))
	})
}

function getType(){
	$.getJSON("../../BOOK",{
		"method":"getType",
	},function(data){
		var json = data.data;
		$("#booktype").empty();
		for(var i=0;i<json.length;i++){
			
			$("#booktype").append(
                      '<option value="'+json[i].id+'">'+json[i].name+'</option>')
		}
	})
}

function createBook(){
	var json = {
			"bookname":$("#bookname").value(),
			"booktype":$("#booktype").value(),
			"author":$("#author").value(),
			"press":$("#press").value(),
			"des":$("#des").value(),
			"bookPath":$("#book_path").value(),
			"imgPath":$("#img_path").value(),
	}
	alert(JSON.stringify(json))
}
