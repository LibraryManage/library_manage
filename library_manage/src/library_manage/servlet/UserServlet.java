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
//	 *���ߣ�ZhangHuanMing
//	 *ʱ�䣺2017��3��18������7:14:28
//	 *��������getUserList
//	 *���ܣ�����û��б�
//	 *������
//	 *����ֵ��void
//	 */
//	public void getUserList(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
//		
//		int page = Integer.parseInt(request.getParameter("page"));                   //��ȡҳ��
//		String userPhone = request.getParameter("userPhone");                        //��ȡ�û��ֻ�
//		
//		if( userPhone == null || userPhone.trim().isEmpty()){
//			
//			userPhone = "";
//		}
//		
//		List<User> result = instance.getUserList(page, userPhone);                   //����û��б�
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
//	 *���ߣ�ZhangHuanMing
//	 *ʱ�䣺2017��3��18������9:00:02
//	 *��������getUserNumber
//	 *���ܣ���ȡ�û��б�����
//	 *������
//	 *����ֵ��void
//	 */
//	public void getUserNumber(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
//		
//		String userPhone = request.getParameter("userPhone");                        //��ȡ�û��ֻ�
//		
//		if( userPhone == null || userPhone.trim().isEmpty()){
//			
//			userPhone = "";
//		}
//		
//		int number = instance.getUserNumber(userPhone);                              //����б�����
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