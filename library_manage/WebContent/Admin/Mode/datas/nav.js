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
	"title": "管理员管理1",
	"icon": "fa-cubes",
	"spread": false,
	"children": [{
		"title": "管理员列表",
		"icon": "&#xe612;",
		"href": "judge.jhtm?menuName=管理员列表"
	}, {
		"title": "角色管理",
		"icon": "&#xe63c;",
		"href": "judge.jhtm?menuName=角色管理"
	}, {
		"title": "权限管理",
		"icon": "&#xe63c;",
		"href": "judge.jhtm?menuName=权限管理"
	}]
}, {
	"title": "用户管理",
	"icon": "&#xe613;",
	"spread": false,
	"children": [{
		"title": "用户列表",
		"icon": "fa-table",
		"href": "judge.jhtm?menuName=用户列表"
	}]
}, {
	"title": "景点管理",
	"icon": "&#xe62e;",
	"spread": false,
	"children": [{
		"title": "地点列表",
		"icon": "&#xe634;",
		"href": "judge.jhtm?menuName=地点列表"
	}, {
		"title": "景点列表",
		"icon": "&#xe634;",
		"href": "judge.jhtm?menuName=景点列表"
	}]
}, {
	"title": "线路管理",
	"icon": "&#x1002;",
	"spread": false,
	"children": [{
		"title": "线路列表",
		"icon": "&#xe62d;",
		"href": "judge.jhtm?menuName=线路列表"
	}, {
		"title": "主题列表",
		"icon": "&#xe62d;",
		"href": "judge.jhtm?menuName=主题列表"
	}, {
		"title": "线路类型列表",
		"icon": "&#xe62d;",
		"href": "judge.jhtm?menuName=线路类型列表"
	}]
}, {
	"title": "评论管理",
	"icon": "&#x1002;",
	"spread": false,
	"children": [{
		"title": "游记评论",
		"icon": "&#xe639;",
		"href": "judge.jhtm?menuName=游记评论"
	}, {
		"title": "线路评论",
		"icon": "&#xe639;",
		"href": "judge.jhtm?menuName=线路评论"
	}]
},{
	"title": "行程管理",
	"icon": "&#x1002;",
	"href": "",
	"spread": false,
	"children": [{
		"title": "行程列表",
		"icon": "&#xe62d;",
		"href": "judge.jhtm?menuName=行程列表"
	}]
}, {
	"title": "旅行社管理",
	"icon": "&#x1002;",
	"spread": false,
	"children": [{
		"title": "旅行社列表",
		"icon": "&#xe62d;",
		"href": "judge.jhtm?menuName=旅行社列表"
	}]
}, {
	"title": "订单管理",
	"icon": "&#xe621;",
	"spread": false,
	"children": [{
		"title": "订单列表",
		"icon": "&#xe62d;",
		"href": "judge.jhtm?menuName=订单列表"
	}]
}, {
	"title": "审核管理",
	"icon": "&#x1002;",
	"spread": false,
	"children": [{
		"title": "审核列表",
		"icon": "&#xe62d;",
		"href": "judge.jhtm?menuName=审核列表"
	}]
}, {
	"title": "游记管理",
	"icon": "&#x1002;",
	"spread": false,
	"children": [{
		"title": "游记列表",
		"icon": "&#xe62d;",
		"href": "judge.jhtm?menuName=游记列表"
	}]
}];




