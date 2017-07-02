package com.secondproject.joinlogin.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

import com.secondproject.userdto.UserDto;
import com.secondproject.util.db.DBClose;
import com.secondproject.util.db.DBConnection;

public class JoinDaoImpl implements JoinDao {

	private static JoinDao joinDao;
	
	static{
		joinDao = new JoinDaoImpl();
	}
	
	private JoinDaoImpl() {}

	public static JoinDao getJoinDao() {
		return joinDao;
	}

	@Override
	public UserDto attest(Map<String, String> map) {
		UserDto userDto = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		int gender = Integer.parseInt(map.get("attestgender"));
		int age = Integer.parseInt(map.get("attestage"));
		
		try {
			conn = DBConnection.getConnection();
			conn.setAutoCommit(false); //트랜잭션 관리를 위한 
			
			// 우선 정보 DB 저장
			StringBuffer attest_ins = new StringBuffer();
			attest_ins.append("insert into users \n");
			attest_ins.append("(user_id, email, password, type, gender, age, status_msg, reg_date, reg_ip, update_date) \n");
			attest_ins.append("values (SEQ_USERS_ID.nextval, ?, ?, 9, ?, ?, '환영합니다.', sysdate, 'localhost', sysdate)");
			//회원타입 9번은 이메일 인증 대기 상태
			pstmt = conn.prepareStatement(attest_ins.toString());
			pstmt.setString(1, map.get("attestemail"));
			pstmt.setString(2, map.get("attestpassword"));
			pstmt.setInt(3, gender);
			pstmt.setInt(4, age);
			pstmt.executeUpdate();
			pstmt.close(); //insert에 해당하는 pstmt 닫기
			
			//인증 메일에 추가할 session용 userDto 얻기
			StringBuffer attest_sel = new StringBuffer();
			attest_sel.append("select user_id, email, type, update_date \n");
			attest_sel.append("from users \n");
			attest_sel.append("where email = ? and password = ? \n");
			pstmt = conn.prepareStatement(attest_sel.toString());
			pstmt.setString(1, map.get("useremail"));
			pstmt.setString(2, map.get("userpw"));
			rs = pstmt.executeQuery();
			if(rs.next()) {
				userDto = new UserDto();
				userDto.setUser_id(rs.getInt("user_id"));
				userDto.setEmail(rs.getString("email"));
				userDto.setType(rs.getInt("type"));
				userDto.setUpdate_date(rs.getString("update_date"));
			}
			conn.commit();
			
		} catch (SQLException e) {
			e.printStackTrace();
			try{
				conn.rollback();
				userDto = null;
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		} finally {
			DBClose.close(conn, pstmt, rs);
		}
		return userDto;
	}

	@Override
	public int idCheck(String sid) {
		int count = 0; //count가 0이면 해당 id를 사용할수 있습니다.
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DBConnection.getConnection();
			String sql = "select count(email) \n";
			sql += "from users \n";
			sql += "where email = ?"; 
			pstmt = conn.prepareStatement(sql); 
			pstmt.setString(1, sid);
			rs = pstmt.executeQuery(); 
			rs.next();
			count = rs.getInt(1);
		} catch (SQLException e) {
			e.printStackTrace();
			count= 1; //위에 0이라 설정해노면 이렇게 해야함
		}finally{
			DBClose.close(conn, pstmt, rs);
		}
		return count;
	}

}
