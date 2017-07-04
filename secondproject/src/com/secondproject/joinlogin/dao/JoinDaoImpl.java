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
	public int attest(Map<String, String> map) {
		int cnt = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		int gender = Integer.parseInt(map.get("attestgender"));
		int age = Integer.parseInt(map.get("attestage"));
		
		try {
			conn = DBConnection.getConnection();
//			conn.setAutoCommit(false); //트랜잭션 관리를 위한 
			
			// 우선 정보 DB 저장
			StringBuffer attest_ins = new StringBuffer();
			attest_ins.append("insert into users \n");
			attest_ins.append("(user_id, email, password, type, gender, age, status_msg, reg_date, reg_ip, update_date) \n");
			attest_ins.append("values (SEQ_USERS_ID.nextval, ?, ?, 1, ?, ?, '환영합니다.', sysdate, 'localhost', sysdate)");
			//회원타입 9번은 이메일 인증 대기 상태
			pstmt = conn.prepareStatement(attest_ins.toString());
			pstmt.setString(1, map.get("attestemail"));
			pstmt.setString(2, map.get("attestpassword"));
			pstmt.setInt(3, gender);
			pstmt.setInt(4, age);
			cnt = pstmt.executeUpdate();
			
//			pstmt.close(); //insert에 해당하는 pstmt 닫기
			
			
			//인증 메일에 추가할 session용 userDto 얻기
//			StringBuffer attest_sel = new StringBuffer();
//			attest_sel.append("select user_id, email, type, update_date \n");
//			attest_sel.append("from users \n");
//			attest_sel.append("where email = ? and password = ? \n");
//			pstmt = conn.prepareStatement(attest_sel.toString());
//			pstmt.setString(1, map.get("useremail"));
//			pstmt.setString(2, map.get("userpw"));
//			rs = pstmt.executeQuery();
//			System.out.println("5");
//			if(rs.next()) {
//				userDto = new UserDto();
//				userDto.setUser_id(rs.getInt("user_id"));
//				userDto.setEmail(rs.getString("email"));
//				userDto.setType(rs.getInt("type"));
//				userDto.setUpdate_date(rs.getString("update_date"));
//				System.out.println("6");
//			}
//			System.out.println("7");
//			conn.commit();
			
		} catch (SQLException e) {
			e.printStackTrace();
//			try{
//				conn.rollback();
//				userDto = null;
//			} catch (SQLException e1) {
//				e1.printStackTrace();
//			}
		} finally {
			DBClose.close(conn, pstmt);
		}
		return cnt;
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

	@Override
	public UserDto lastcheck(Map<String, String> map) {
		UserDto userDto = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = DBConnection.getConnection();
			StringBuffer check_sql = new StringBuffer();
//			// TODO sql문 쿼리 짜기 select 
			
//			빛나지 그 누구보다 더 밝게 빛나지
//			그 누가 발하는 빛보다 더 진하지
//			비교조차 할 수가 없어
//			shining like sunshine
//			
//			내 강렬한 선명함에 눈이 부실지 몰라
//			어두운 눈동자가 활짝 열릴지 몰라 
//			난 스스로 빛나는 걸 
//			just bling like silver&gold
//			vivid lively aaaa
//			
//			아~몰레~~드 아몰레 몰레 몰레 아~~몰레드 
//			난 너무 예뻐
//			아~몰레~~드 아몰레 몰레 몰레 아~~몰레드 
//			난 너의 아몰레드
//			
//			
//			아몰레드 아몰레드 아아아아몰레 
//			암소 플라이 보이
//			아몰레 아몰레 아아아 아몰레드
//
//			머리속은 환히 빛나
//			눈이 부시도록 빛나
//			머리에서 발끝까지 별처럼 빛나지 블링블링
//			
//			난 소소 어트랙티브 밝게 빛나는 듯
//			난 쏘쏘쏘쏘 어트랙티브 반짝이는 입술
//			난 쏘쏘 어트랙티브 너무 완벽한 나
//			난 쏘쏘쏘쏘 어트랙티브 난 뭔가 다른걸
			
			
			
			pstmt = conn.prepareStatement(check_sql.toString());
			pstmt.setString(0, null);
			pstmt.setString(0, null);
			rs = pstmt.executeQuery();
		
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBClose.close(conn, pstmt, rs);
		}
		return userDto;
	}

}
