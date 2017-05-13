package library_manage.tool;


import java.sql.Connection;
import java.sql.SQLException;

/**
 * 
 * ��������� 
 * 
 *
 * ���ߣ�ariclee		ʱ�䣺2016��6��11������9:51:53
 */
public class TransactionUtil {
	
	/**
	 * 
	 * ά��ͬһ���߳��е�Connection����
	 */
	private static ThreadLocal<Connection> tl =  new ThreadLocal<Connection>();
	
	/**
	 * �������ƣ�getConnection
	 * ����������
	 * ����˵����
	 * ����ֵ��Connection
	 * ��ע��
	 * 
	 * ���ߣ�ariclee		ʱ�䣺2016��6��16������2:46:19
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
	 *���ߣ�ZhangHuanMing
	 *ʱ�䣺2017��1��6������8:52:51
	 *��������startTransaction
	 *���ܣ���������
	 *������
	 *����ֵ��void
	 * @throws SQLException 
	 */
	public static void startTransaction() throws SQLException {
		Connection conn = (Connection) tl.get();
		
        if(conn == null){              //�ж�conn�Ƿ�Ϊ��
             
        	conn = getConnection();                  //Ϊ�գ���������  
        }  
    	try {
			conn.setAutoCommit(false);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	
	}
	
	/**
	 * 
	 *���ߣ�ZhangHuanMing
	 *ʱ�䣺2017��1��6������9:24:34
	 *��������roolback
	 *���ܣ��ع�����
	 *������
	 *����ֵ��void
	 * @throws SQLException 
	 */
	public static void roolback() throws SQLException {
		Connection conn = (Connection) tl.get();
		if(conn==null){
			 throw new SQLException("û�п�������,���ܻع�����");
		}
		try {
			conn.rollback();
			conn.setAutoCommit(true);
	        conn.close();            //����ع��󣬹ر����� 
	        tl.remove();             //�������Ƴ�ThreadLocal  
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	/**
	 * 
	 *���ߣ�ZhangHuanMing
	 *ʱ�䣺2017��1��6������9:29:30
	 *��������commit
	 *���ܣ������ύ
	 *������
	 *����ֵ��void
	 * @throws SQLException 
	 */
	public static void commit() throws SQLException {
		Connection conn = (Connection) tl.get();
		if(conn==null){
			 throw new SQLException("û�п�������,�����ύ����");
		}
		try {
			conn.commit();
			conn.setAutoCommit(true);
	        conn.close();                  //�����ύ�󣬹ر�����  
	        tl.remove();                 //�������Ƴ�ThreadLocal  
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	/**
	 * �������ƣ�release
	 * �����������ͷ�����
	 * ����˵����
	 * ����ֵ��void
	 * ��ע��
	 * 
	 * ���ߣ�ariclee		ʱ�䣺2016��6��11������9:53:11
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
	 *���ߣ�ZhangHuanMing
	 *ʱ�䣺2017��1��6������9:31:19
	 *��������releaseConnection
	 *���ܣ��ͷŲ��������������
	 *������
	 *����ֵ��void
	 */
	public static void releaseConnection(Connection connection) throws SQLException {  
         
		Connection conn = (Connection) tl.get(); 
        if(connection != null && conn != connection){          //������������뵱ǰ�������Ӳ���ȣ���˵���������Ӳ����������ӣ����Թرգ�����������ر�  
           
            if(!connection.isClosed()){           //�������û�б��رգ��ر�
                connection.close();  
                System.out.println("���ӱ��ͷ�");
            }  
            System.out.println("�Ѿ����ͷ�");
        }  
    } 
	
}

