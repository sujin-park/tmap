package com.secondproject.util.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public final class Dummy {

	static {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public static void review(int loop) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int seq = 0;
		for (int i = 1; i <= loop; i++) {
			try {
				conn = getConnection();
				StringBuffer sql = new StringBuffer();
				sql.append("INSERT INTO review VALUES (?, ?, ?, ?, ?, ?, ?, ?, sysdate, sysdate)");
				pstmt = getConnection().prepareStatement(sql.toString());
				int k = 0;
				seq = getSequenceNextVal("SEQ_REVIEW_ID");
				pstmt.setInt(++k, seq); // review_id
				pstmt.setInt(++k, 1); // shop_id
				pstmt.setInt(++k, 1); // user_id
				pstmt.setString(++k, "제목" + i); // title
				pstmt.setString(++k, "내용" + i); // content
				pstmt.setInt(++k, i % 10 + 1); // score
				pstmt.setString(++k, ""); // img
				pstmt.setInt(++k, 0); // is_blind
				pstmt.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				DBClose.close(conn, pstmt);
			}
			System.out.println("INSERT REVIEW " + i);
			review_good_bad(seq, 30);
			review_comment(seq, 20);
		}
	}

	public static void review_good_bad(int parentSeq, int loop) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		for (int i = 1; i <= loop; i++) {
			try {
				conn = getConnection();
				StringBuffer sql = new StringBuffer();
				sql.append("INSERT INTO review_good_bad VALUES (?, ?, ?, ?)");
				pstmt = getConnection().prepareStatement(sql.toString());

				int good = 0;
				int bad = 0;
				if (parentSeq % i != 0) {
					good = 1;
					bad = 0;
				} else {
					good = 0;
					bad = 1;
				}

				int k = 0;
				pstmt.setInt(++k, parentSeq); // review_id
				pstmt.setInt(++k, 1); // user_id
				pstmt.setInt(++k, good); // good
				pstmt.setInt(++k, bad); // bad
				pstmt.executeUpdate();

			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				DBClose.close(conn, pstmt);
			}
			System.out.println("INSERT REVIEW_GOOD_BAD " + i);
		}
	}

	public static void review_comment(int parentSeq, int loop) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int seq = 0;
		for (int i = 1; i <= loop; i++) {
			try {
				conn = getConnection();
				StringBuffer sql = new StringBuffer();
				sql.append("INSERT INTO review_comment VALUES (?, ?, ?, ?)");
				pstmt = getConnection().prepareStatement(sql.toString());
				seq = getSequenceNextVal("SEQ_REVIEW_COMMENT_ID");
				int k = 0;
				pstmt.setInt(++k, seq); // review_comment_id
				pstmt.setInt(++k, parentSeq); // review_id
				pstmt.setInt(++k, 1); // user_id
				pstmt.setString(++k, "댓글 " + i); // review_content
				pstmt.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				DBClose.close(conn, pstmt);
			}
			System.out.println("INSERT REVIEW_COMMENT " + i);
		}
	}

	public static Connection getConnection() {
		Connection conn = null;
		try {
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1522:orcl", "map", "map");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}

	public static int getSequenceNextVal(String sequenceName) {
		int sequence = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = getConnection();
			StringBuffer sql = new StringBuffer();
			sql.append("SELECT ");
			sql.append(sequenceName + ".nextval as sequence FROM DUAL");
			pstmt = conn.prepareStatement(sql.toString());
			rs = pstmt.executeQuery();
			if (rs.next()) {
				sequence = rs.getInt("sequence");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBClose.close(conn, pstmt, rs);
		}
		return sequence;
	}

//	public static void main(String[] args) {
//		review(100);
//		System.out.println("INSERT DONE!!");
//	}

}
