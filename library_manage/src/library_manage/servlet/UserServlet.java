package library_manage.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import library_manage.entity.User;
import library_manage.service.UserService;
import library_manage.serviceImpl.UserServiceImpl;


public class UserServlet extends BaseServlet{

	private UserService instance = UserServiceImpl.getInstance();
	
//	/**
//	 * 
//	 *作者：ZhangHuanMing
//	 *时间：2017年3月18日下午7:14:28
//	 *函数名：getUserList
//	 *功能：获得用户列表
//	 *参数：
//	 *返回值：void
//	 */
//	public void getUserList(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
//		
//		int page = Integer.parseInt(request.getParameter("page"));                   //获取页码
//		String userPhone = request.getParameter("userPhone");                        //获取用户手机
//		
//		if( userPhone == null || userPhone.trim().isEmpty()){
//			
//			userPhone = "";
//		}
//		
//		List<User> result = instance.getUserList(page, userPhone);                   //获得用户列表
//		
//		Gson gson = new Gson();
//		JsonObject json = new JsonObject();
//		PrintWriter out = response.getWriter();
//		try{
//			json.add("userList", new JsonParser().parse(gson.toJson(result)).getAsJsonArray());
//			out.println(json);
//			out.flush(); 
//			out.close();
//		}catch(Exception e){
//			e.printStackTrace();
//		}
//	}
//	
//	/**
//	 * 
//	 *作者：ZhangHuanMing
//	 *时间：2017年3月18日下午9:00:02
//	 *函数名：getUserNumber
//	 *功能：获取用户列表总数
//	 *参数：
//	 *返回值：void
//	 */
//	public void getUserNumber(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
//		
//		String userPhone = request.getParameter("userPhone");                        //获取用户手机
//		
//		if( userPhone == null || userPhone.trim().isEmpty()){
//			
//			userPhone = "";
//		}
//		
//		int number = instance.getUserNumber(userPhone);                              //获得列表总数
//		
//		PrintWriter out = response.getWriter();
//		try{
//			out.println(number);
//			out.flush(); 
//			out.close();
//		}catch(Exception e){
//			e.printStackTrace();
//		}
//	}
	
	
}