// �ش� ���ٿ� ������ �����ͺ��̽��� ��ü�� �̿��� ������ ȸ�������� �̿��� �Լ��ۼ�


package user;
import java.sql.Connection;

import java.sql.DriverManager;

import java.sql.PreparedStatement;

import java.sql.ResultSet;

import java.sql.SQLException;



public class userDAO {



	private Connection conn;
	private ResultSet rs;
	private PreparedStatement pstmt;


	public userDAO() {

		try {

			String dbURL = "jdbc:mysql://localhost:3306/yjbbs";
			String dbID = "root";
			String dbPassword = "root";
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(dbURL, dbID, dbPassword);

		} catch (Exception e) {

			e.printStackTrace();

		}

	}

	

	public int login(String userID, String userPassword) {

		String SQL = "SELECT userPassword FROM USER WHERE userID = ?";

		try {

			PreparedStatement pstmt = conn.prepareStatement(SQL);
			pstmt.setString(1, userID); // SQL ? ��  ���̵� ����
			rs = pstmt.executeQuery();

			if(rs.next()) {

				if(rs.getString(1).equals(userPassword))

					return 1; // �α��� ����

				else

					return 0; // ��й�ȣ Ʋ��

			}

			return -1; // ���̵� ����

		} catch (SQLException e) {

			e.printStackTrace();

		}

		finally{
			try {if (conn != null) conn.close();} catch (Exception e ) {e.printStackTrace();}
			try {if (pstmt != null) pstmt.close();} catch (Exception e ) {e.printStackTrace();}
			try {if (rs != null) rs.close();} catch (Exception e ) {e.printStackTrace();}
		}
		return -2; // �����ͺ��̽� ����

	}

	

	public int join(userDTO user) {

		String SQL = "INSERT INTO USER VALUES (?,?,?,?,false,?,?,?)";

		try {
			
			
			PreparedStatement pstmt = conn.prepareStatement(SQL);

			pstmt.setString(1, user.getUserID());
			pstmt.setString(2, user.getUserPassword());
			pstmt.setString(3, user.getUserEmail());
			pstmt.setString(4, user.getUserEmailHash());
			pstmt.setString(5, user.getUserNumber());
			pstmt.setString(6, user.getUserName());
			pstmt.setString(7, user.getUserNick());
			
			
			return pstmt.executeUpdate();

		} catch (SQLException e) {

			e.printStackTrace();

		}

		return -1; // ȸ������ ����

	}

	public userDTO getUser(String userID)
	{
		String SQL = "SELECT * FROM user WHERE userID = ?";

		try {
			PreparedStatement pstmt = conn.prepareStatement(SQL); 
			pstmt.setString(1, userID);
			rs = pstmt.executeQuery();
			if (rs.next()) {
			userDTO user = new userDTO();
			user.setUserID(rs.getString(1));
			user.setUserPassword(rs.getString(2));
			user.setUserEmail(rs.getString(3));
			user.setUserEmailChecked(rs.getBoolean(4));
			user.setUserEmailHash(rs.getString(5));
			user.setUserNumber(rs.getString(6));
			user.setUserName(rs.getString(7));
			user.setUserNick(rs.getString(8));
			return user;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return null; 
	}
	
// ����ڰ� ���� �̸��� �����Ǿ��ִ� Ȯ�� 
	public String getUserEmail(String userID) {

		String SQL = "SELECT userEmail FROM user WHERE userID = ?";

		try {

			PreparedStatement pstmt = conn.prepareStatement(SQL);

			pstmt.setString(1, userID);

			rs = pstmt.executeQuery();

			while(rs.next()) {

				return rs.getString(1); // �̸��� �ּ� ��ȯ

			}

		} catch (SQLException e) {

			e.printStackTrace();

		}

		return null; // �����ͺ��̽� ����

	}

	/*�̸��� �ߺ� ���ϱ� */
	public boolean getUserEmailChecked2(String useremail) {

		String SQL = "SELECT userEmailChecked FROM USER WHERE userEmail = ?";

		try {

			PreparedStatement pstmt = conn.prepareStatement(SQL);

			pstmt.setString(1, useremail);

			rs = pstmt.executeQuery(); // �����͸� ��ȸ�Ҷ� query 

			while(rs.next()) {

				return rs.getBoolean(1); // �̸��� ��� ���� ��ȯ

			}

		} catch (SQLException e) {

			e.printStackTrace();

		}

		return false; 

	}

	
	
	public String FindUserPassword(String userID) {

		String SQL = "SELECT userPassword FROM user WHERE userID = ?";

		try {

			PreparedStatement pstmt = conn.prepareStatement(SQL);

			pstmt.setString(1, userID);

			rs = pstmt.executeQuery();

			while(rs.next()) {

				return rs.getString(1); // �̸��� �ּ� ��ȯ

			}

		} catch (SQLException e) {

			e.printStackTrace();

		}

		return null; // �����ͺ��̽� ����

	}
	
	//���� �̸��� ���� �����Լ�
	public boolean getUserEmailChecked(String userID) {

		String SQL = "SELECT userEmailChecked FROM USER WHERE userID = ?";

		try {

			PreparedStatement pstmt = conn.prepareStatement(SQL);

			pstmt.setString(1, userID);

			rs = pstmt.executeQuery(); // �����͸� ��ȸ�Ҷ� query 

			while(rs.next()) {

				return rs.getBoolean(1); // �̸��� ��� ���� ��ȯ

			}

		} catch (SQLException e) {

			e.printStackTrace();

		}

		return false; // �����ͺ��̽� ����

	}

	

	public boolean setUserEmailChecked(String userID) {

		String SQL = "UPDATE USER SET userEmailChecked = true WHERE userID = ?";

		try {

			PreparedStatement pstmt = conn.prepareStatement(SQL);

			pstmt.setString(1, userID);

			pstmt.executeUpdate();

			return true; // �̸��� ��� ���� ����

		} catch (SQLException e) {

			e.printStackTrace();

		}

		return false; // �̸��� ��� ���� ����

	}

}


