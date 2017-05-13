package library_manage.tool;


import java.sql.Connection;
import java.sql.SQLException;

/**
 * 
 * 事务控制类 
 * 
 *
 * 作者：ariclee		时间：2016年6月11日下午9:51:53
 */
public class TransactionUtil {
	
	/**
	 * 
	 * 维护同一个线程中的Connection连接
	 */
	private static ThreadLocal<Connection> tl =  new ThreadLocal<Connection>();
	
	/**
	 * 函数名称：getConnection
	 * 功能描述：
	 * 参数说明：
	 * 返回值：Connection
	 * 备注：
	 * 
	 * 作者：ariclee		时间：2016年6月16日下午2:46:19
	 */
	public static Connection getConnection() {
		Connection conn = (Connection)tl.get();
		if (conn==null) {
			conn = JdbcUtils_DBCP.getConnection();
			tl.set(conn);
		} 
		return conn;
	}
	
	/**
	 * 
	 *作者：ZhangHuanMing
	 *时间：2017年1月6日下午8:52:51
	 *函数名：startTransaction
	 *功能：开启事务
	 *参数：
	 *返回值：void
	 * @throws SQLException 
	 */
	public static void startTransaction() throws SQLException {
		Connection conn = (Connection) tl.get();
		
        if(conn == null){              //判断conn是否为空
             
        	conn = getConnection();                  //为空，则开启事务  
        }  
    	try {
			conn.setAutoCommit(false);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	
	}
	
	/**
	 * 
	 *作者：ZhangHuanMing
	 *时间：2017年1月6日下午9:24:34
	 *函数名：roolback
	 *功能：回滚事务
	 *参数：
	 *返回值：void
	 * @throws SQLException 
	 */
	public static void roolback() throws SQLException {
		Connection conn = (Connection) tl.get();
		if(conn==null){
			 throw new SQLException("没有开启事务,不能回滚事务");
		}
		try {
			conn.rollback();
			conn.setAutoCommit(true);
	        conn.close();            //事务回滚后，关闭连接 
	        tl.remove();             //将连接移出ThreadLocal  
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	/**
	 * 
	 *作者：ZhangHuanMing
	 *时间：2017年1月6日下午9:29:30
	 *函数名：commit
	 *功能：事务提交
	 *参数：
	 *返回值：void
	 * @throws SQLException 
	 */
	public static void commit() throws SQLException {
		Connection conn = (Connection) tl.get();
		if(conn==null){
			 throw new SQLException("没有开启事务,不能提交事务");
		}
		try {
			conn.commit();
			conn.setAutoCommit(true);
	        conn.close();                  //事务提交后，关闭连接  
	        tl.remove();                 //将连接移出ThreadLocal  
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	/**
	 * 函数名称：release
	 * 功能描述：释放连接
	 * 参数说明：
	 * 返回值：void
	 * 备注：
	 * 
	 * 作者：ariclee		时间：2016年6月11日下午9:53:11
	 */
	public static void release() {
		try {
			Connection conn = (Connection) tl.get();
			if(conn!=null){
				conn.close();
				tl.remove();
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	/**
	 * 
	 *作者：ZhangHuanMing
	 *时间：2017年1月6日下午9:31:19
	 *函数名：releaseConnection
	 *功能：释放不属于事务的连接
	 *参数：
	 *返回值：void
	 */
	public static void releaseConnection(Connection connection) throws SQLException {  
         
		Connection conn = (Connection) tl.get(); 
        if(connection != null && conn != connection){          //如果参数连接与当前事务连接不相等，则说明参数连接不是事务连接，可以关闭，否则交由事务关闭  
           
            if(!connection.isClosed()){           //如果连接没有被关闭，关闭
                connection.close();  
                System.out.println("连接被释放");
            }  
            System.out.println("已经被释放");
        }  
    } 
	
}

