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
import com.secondproject.mypage.model.FavoriteCategoryDto;
import com.secondproject.mypage.model.FavoriteUserDto;

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
	public int followCategoryMake(FavoriteCategoryDto favoriteCategoryDto) {
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

			pstmt.setInt(++idx, favoriteCategoryDto.getUserId());
			pstmt.setString(++idx, favoriteCategoryDto.getCategoryName());
			pstmt.setInt(++idx, favoriteCategoryDto.getUserId());
		

			cnt = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBClose.close(conn, pstmt);
		}
		return cnt;
	}

	@Override
	public int followCategoryModify(FavoriteCategoryDto favoriteCategoryDto) {
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

			pstmt.setString(1, favoriteCategoryDto.getCategoryName());
			pstmt.setInt(2, favoriteCategoryDto.getFavoriteCategoryId());
			
		

			cnt = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBClose.close(conn, pstmt);
		}
		return cnt;
	}

	@Override
	public int followCategoryDelete(int favoriteCategoryId) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int cnt=0;
		try {
			conn = DBConnection.getConnection();
			StringBuffer sql = new StringBuffer();
			sql.append("delete from favorite_categoty \n");
			sql.append("where favorite_category_id=?");
			pstmt = conn.prepareStatement(sql.toString());

			pstmt.setInt(1, favoriteCategoryId);
			
			cnt=pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBClose.close(conn, pstmt);
		}
		return cnt;


	}


	@Override
	public int followCategoryOrder(int favoriteCategoryId, int category_order) {
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
			pstmt.setInt(2, favoriteCategoryId);
			
			cnt=pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBClose.close(conn, pstmt);
		}
		return cnt;
	}


	@Override
	public FavoriteCategoryDto getFollowCategory(int favoriteCategoryId) {
		FavoriteCategoryDto fcdto = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = DBConnection.getConnection();
			StringBuffer sql = new StringBuffer();
			sql.append("select favorite_category_id,user_id,parent_category_id, \n");
			sql.append("		category_name,category_order \n");
			sql.append("from favorite_category \n");
			sql.append("where favorite_category_id=?");

			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setInt(1, favoriteCategoryId);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				fcdto=new FavoriteCategoryDto();
				fcdto.setFavoriteCategoryId(favoriteCategoryId);
				fcdto.setUserId(rs.getInt("user_id"));
				fcdto.setParentCategoryId(rs.getInt("parent_category_id"));
				fcdto.setCategoryName(rs.getString("category_name"));
				fcdto.setCategoryOrder(rs.getString("category_order"));
			}

		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			DBClose.close(conn, pstmt, rs);
		}

		return fcdto;
	}


	@Override
	public FavoriteUserDto getFollow(int favoriteUserId) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public List<FavoriteUserDto> followListView(int userId) {
		// TODO Auto-generated method stub
		return null;
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
	public List<FavoriteCategoryDto> followCategoryListView(int userId) {
		List<FavoriteCategoryDto> list = new ArrayList<FavoriteCategoryDto>();
		FavoriteCategoryDto fcdto = null;
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
				fcdto=new FavoriteCategoryDto();
				fcdto.setFavoriteCategoryId(rs.getInt("follow_category_id"));
				fcdto.setUserId(rs.getInt("user_id"));
				fcdto.setCategoryName(rs.getString("category_name"));
				fcdto.setCategoryOrder(rs.getString("category_order"));
				list.add(fcdto);
			}

		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			DBClose.close(conn, pstmt, rs);
		}

		return list;
	}

}
