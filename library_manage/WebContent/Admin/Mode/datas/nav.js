//$(document).ready(function(){  
//	
//	$.ajaxSetup({                //设置同步
//	    async : false  
//	}); 
//	var result;
//	$.ajax({
//		type: "post",
//		url: "./user.jhtm?method=getUserMenuPower",
//		dataType: "json",
//		success: function(json){
//			
//			result = json
//		}
//	})
//	showData(result)
//	
//})
//
////动态加载数据
//function showData(json){
//	
//	if(json == null){
//		
//		window.location.reload();
//		return;
//	}
//	navs = [];
//	for(var i=0; i<json.result.length; i++){
//		
//		var sonMenu = [];
//		for( var j=0; j<json.result[i].menus.length;j++){
//			
//			var url = json.result[i].menus[j].menuUrl + "?pageName=" + splitUrl(json.result[i].menus[j].menuUrl);
//			var sonMenuEach = {"title":json.result[i].menus[j].menuName,"icon": "&#xe639;","href":url};
//			sonMenu.push(sonMenuEach);
//		}
//		var fuEach = {"title":json.result[i].faMenuName,"icon":"fa-cubes","spread": false,"children":sonMenu};
//		navs.push(fuEach);
//	}
//}
//
////分割url
//function splitUrl(url){
//	
//	var split = url.split("/");
//	return split[split.length-1];
//}

navs = [{
	"title": "用户管理",
	"icon": "fa-cubes",
	"spread": false,
	
},  
 {
	"title": "书类列表",
	"icon": "&#xe621;",
	"spread": false,
 },{
		"title": "书籍列表",
		"icon": "&#xe62d;",
		"href": "./Admin/Book/bookList.html?menuName=书籍列表"
	}, {
		"title": "评论管理",
		"icon": "&#xe62d;",
		"href": "judge.jhtm?menuName=主题列表"
	}
];




