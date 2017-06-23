package com.secondproject.mypage.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.secondproject.util.db.DBClose;
import com.secondproject.util.db.DBConnection;
import com.secondproject.mypage.model.FollowCategoryDto;
import com.secondproject.mypage.model.FollowUserDto;

public class MypageFollowDaoImpl implements MypageFollowDao {

	private static MypageFollowDao mypageFollowDao;
	
	static {
		mypageFollowDao= new MypageFollowDaoImpl();
	}
	
	private MypageFollowDaoImpl() {

	}
	
	
	public static MypageFollowDao getMypageFollowDao() {
		return mypageFollowDao;
	}


	@Override
	public int followCategoryMake(FollowCategoryDto followCategoryDto) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int cnt = 0;
		try {
			conn = DBConnection.getConnection();
			StringBuffer sql = new StringBuffer();
			sql.append("insert into follow_category \n");
			sql.append("(follow_category_id,user_id,category_name,category_order) \n");
			sql.append("	values (follow_category_seq.nextval,?,?,(select max(category_order) from follow_category \n");
			sql.append("	where user_id=?)+1)");
			pstmt = conn.prepareStatement(sql.toString());
			int idx = 0;

			pstmt.setInt(++idx, followCategoryDto.getUserId());
			pstmt.setString(++idx, followCategoryDto.getCategoryName());
			pstmt.setInt(++idx, followCategoryDto.getUserId());
		

			cnt = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBClose.close(conn, pstmt);
		}
		return cnt;
	}

	@Override
	public int followCategoryModify(FollowCategoryDto followCategoryDto) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int cnt = 0;
		try {
			conn = DBConnection.getConnection();
			StringBuffer sql = new StringBuffer();
			sql.append("update favorite_categoty \n");
			sql.append("set category_name=? \n");
			sql.append("where favorite_category_id=?");
			pstmt = conn.prepareStatement(sql.toString());

			pstmt.setString(1, followCategoryDto.getCategoryName());
			pstmt.setInt(2, followCategoryDto.getFollowCategoryId());
			
		

			cnt = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBClose.close(conn, pstmt);
		}
		return cnt;
	}

	@Override
	public int followCategoryDelete(int followCategoryId) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int cnt=0;
		try {
			conn = DBConnection.getConnection();
			StringBuffer sql = new StringBuffer();
			sql.append("delete from favorite_categoty \n");
			sql.append("where favorite_category_id=?");
			pstmt = conn.prepareStatement(sql.toString());

			pstmt.setInt(1, followCategoryId);
			
			cnt=pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBClose.close(conn, pstmt);
		}
		return cnt;


	}


	@Override
	public int followCategoryOrder(int followCategoryId, int category_order) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int cnt=0;
		try {
			conn = DBConnection.getConnection();
			StringBuffer sql = new StringBuffer();
			sql.append("update favorite_categoty \n");
			sql.append("set category_order=? \n");
			sql.append("where favorite_category_id=?");
			pstmt = conn.prepareStatement(sql.toString());

			pstmt.setInt(1, category_order);
			pstmt.setInt(2, followCategoryId);
			
			cnt=pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBClose.close(conn, pstmt);
		}
		return cnt;
	}


	@Override
	public FollowCategoryDto getFollowCategory(int followCategoryId) {
		FollowCategoryDto fcdto = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = DBConnection.getConnection();
			StringBuffer sql = new StringBuffer();
			sql.append("select follow_category_id,user_id, \n");
			sql.append("		category_name,category_order \n");
			sql.append("from follow_category \n");
			sql.append("where follow_category_id=?");

			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setInt(1, followCategoryId);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				fcdto=new FollowCategoryDto();
				fcdto.setFollowCategoryId(followCategoryId);
				fcdto.setUserId(rs.getInt("user_id"));
				fcdto.setCategoryName(rs.getString("category_name"));
				fcdto.setCategoryOrder(rs.getInt("category_order"));
			}

		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			DBClose.close(conn, pstmt, rs);
		}

		return fcdto;
	}


	@Override
	public FollowUserDto getFollow(int favoriteUserId) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public List<FollowUserDto> followListView(int userId) {
		List<FollowUserDto> list = new ArrayList<FollowUserDto>();
		FollowUserDto fudto = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = DBConnection.getConnection();
			StringBuffer sql = new StringBuffer();
			sql.append("select fc.category_name,u.email,u.status_msg,to_char(u.reg_date,'yyyy.mm.dd') as follow_reg_date, \n");
			sql.append("		to_char(fu.reg_date,'yyyy.mm.dd') as reg_date,fu.alias,fu.memo \n");
			sql.append("from follow_user fu \n");
			sql.append("join follow_category fc ON fu.follow_category_id = fc.follow_category_id \n");
			sql.append("join users u ON fu.reg_user_id = u.user_id \n");
			sql.append("where fu.user_id = ?");
			
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setInt(1, userId);
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				fudto=new FollowUserDto();
				fudto.setCategoryName(rs.getString("category_name"));
				fudto.setEmail(rs.getString("email"));
				fudto.setStatusMsg(rs.getString("status_msg"));
				fudto.setRegDate(rs.getString("follow_reg_date"));
				fudto.setFavoriteRegDate(rs.getString("reg_date"));
				fudto.setAlias(rs.getString("alias"));
				fudto.setMemo(rs.getString("memo"));
				list.add(fudto);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBClose.close(conn, pstmt, rs);
		}

		return list;
	}


	@Override
	public int followMove(Map<String, String> map) {
		// TODO Auto-generated method stub
		return 0;
	}


	@Override
	public int followDelete(int favoriteUserId) {
		// TODO Auto-generated method stub
		return 0;
	}


	@Override
	public int followModify(Map<String, String> map) {
		// TODO Auto-generated method stub
		return 0;
	}


	@Override
	public List<FollowCategoryDto> followCategoryListView(int userId) {
		List<FollowCategoryDto> list = new ArrayList<FollowCategoryDto>();
		FollowCategoryDto fcdto = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = DBConnection.getConnection();
			StringBuffer sql = new StringBuffer();
			sql.append("select * from follow_category \n");
			sql.append("where user_id=? \n");
			sql.append("order by category_order");

			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setInt(1, userId);
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				fcdto=new FollowCategoryDto();
				fcdto.setFollowCategoryId(rs.getInt("follow_category_id"));
				fcdto.setUserId(rs.getInt("user_id"));
				fcdto.setCategoryName(rs.getString("category_name"));
				fcdto.setCategoryOrder(rs.getInt("category_order"));
				list.add(fcdto);
			}

		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			DBClose.close(conn, pstmt, rs);
		}

		return list;
	}


	@Override
	public int upOrder(int followCategoryId) {
		FollowCategoryDto fcdto = getFollowCategory(followCategoryId);

		int cnt =0;
		if(fcdto.getCategoryOrder()==1) {
			cnt =0;
		} else {

		
	         Connection conn = null;
	         PreparedStatement pstmt = null;
	         
	         try {
	            conn = DBConnection.getConnection();
	            conn.setAutoCommit(false);
	            
	            StringBuffer update_preorder = new StringBuffer();
	            update_preorder.append("update follow_category \n");
	            update_preorder.append("set category_order=category_order+1 \n");
	            update_preorder.append("where user_id = ? and category_order=?");
	            pstmt = conn.prepareStatement(update_preorder.toString());
	            pstmt.setInt(1, fcdto.getUserId());
	            pstmt.setInt(2, fcdto.getCategoryOrder()-1);
	            pstmt.executeUpdate();
	            pstmt.close();
	            
	            StringBuffer update_myorder = new StringBuffer();
	            update_myorder.append("update follow_category \n");
	            update_myorder.append("set category_order=category_order-1 \n");
	            update_myorder.append("where follow_category_id=?");
	            pstmt = conn.prepareStatement(update_myorder.toString());
	            pstmt.setInt(1, followCategoryId);
	            pstmt.executeUpdate();
	            pstmt.close();
	            conn.commit();
	           

	            cnt = 1;
	         } catch (SQLException e) {
	            e.printStackTrace();
	            try {
	               conn.rollback();
	               cnt = 0;
	            } catch (SQLException e1) {
	               e1.printStackTrace();
	            }
	         } finally {
	            DBClose.close(conn, pstmt);
	         }

		}
		return cnt;
	}


	@Override
	public int downOrder(int followCategoryId) {
		FollowCategoryDto fcdto = getFollowCategory(followCategoryId);
			int cnt =0;
	         Connection conn = null;
	         PreparedStatement pstmt = null;      
	         try {
	            conn = DBConnection.getConnection();
	            conn.setAutoCommit(false);
	        
	            StringBuffer update_nextorder = new StringBuffer();
	            update_nextorder.append("update follow_category \n");
	            update_nextorder.append("set category_order=category_order-1 \n");
	            update_nextorder.append("where user_id = ? and category_order=?");
	            pstmt = conn.prepareStatement(update_nextorder.toString());
	            pstmt.setInt(1, fcdto.getUserId());
	            pstmt.setInt(2, fcdto.getCategoryOrder()+1);
	            pstmt.executeUpdate();
	            pstmt.close();
	            
	            StringBuffer update_myorder = new StringBuffer();
	            update_myorder.append("update follow_category \n");
	            update_myorder.append("set category_order=category_order+1 \n");
	            update_myorder.append("where follow_category_id=?");
	            pstmt = conn.prepareStatement(update_myorder.toString());
	            pstmt.setInt(1, followCategoryId);
	            pstmt.executeUpdate();
	            pstmt.close();
	            conn.commit();
	           

	            cnt = 1;
	         } catch (SQLException e) {
	            e.printStackTrace();
	            try {
	               conn.rollback();
	               cnt = 0;
	            } catch (SQLException e1) {
	               e1.printStackTrace();
	            }
	         } finally {
	            DBClose.close(conn, pstmt);
	         }

		
		return cnt;
	}


	@Override
	public FollowCategoryDto getCategoryId(int userId, int category_order) {
		FollowCategoryDto fcdto = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = DBConnection.getConnection();
			StringBuffer sql = new StringBuffer();
			sql.append("select * from follow_category \n");
			sql.append("where user_id=? \n");
			sql.append("and category_order=?");
			
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setInt(1, userId);
			pstmt.setInt(2, category_order);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				fcdto=new FollowCategoryDto();
				fcdto.setFollowCategoryId(rs.getInt("follow_category_id"));
				fcdto.setUserId(rs.getInt("user_id"));
				fcdto.setCategoryName(rs.getString("category_name"));
				fcdto.setCategoryOrder(rs.getInt("category_order"));
			}

		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			DBClose.close(conn, pstmt, rs);
		}

		return fcdto;
	}

}
