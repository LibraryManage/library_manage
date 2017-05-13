package library_manage.servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import library_manage.entity.User;
import library_manage.service.UserService;
import library_manage.serviceImpl.UserServiceImpl;
import library_manage.tool.Constants;



public class LoginAction extends HttpServlet {
	
	private String wrongMessage = null;
	
	@Override
	public void init() throws ServletException {
		wrongMessage = this.getInitParameter("WRONG_MESSAGE");                //获得错误类型
		
		if( wrongMessage == null || wrongMessage.trim().isEmpty() ){
			wrongMessage = "服务器错误";
		}
	}
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException{
    	resp.setCharacterEncoding("utf-8");
    	req.setCharacterEncoding("utf-8");
    	super.service(req, resp);
    }
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String userAccount = request.getParameter("account");
		String userPassword = request.getParameter("password");
		
		User user = new User();
		user.setUserAccount(userAccount);
		user.setUserPassword(userPassword);
		
		UserService instance = UserServiceImpl.getInstance();
		User result = instance.isExitUser(user);
		
		if( result == null ){                 //不存在该账号
			
			request.setAttribute(Constants.ERROR, wrongMessage);
			request.getRequestDispatcher("Admin/Login/login.jsp").forward(request, response);
			return;
		}
		
		HttpSession session = request.getSession();
		User userSession = (User)request.getAttribute(Constants.USER_KEY);
		
		if( userSession == null ){
			session.setAttribute(Constants.USER_KEY, result);                   //将用户对象存进session
		}
		request.getRequestDispatcher("Admin/Index/index.html").forward(request, response);
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
