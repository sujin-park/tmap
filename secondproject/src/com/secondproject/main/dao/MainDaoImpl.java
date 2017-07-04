package com.secondproject.main.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.secondproject.admin.model.ExhibitionDto;
import com.secondproject.constant.BoardConstant;
import com.secondproject.main.model.MainExhibitionDto;
import com.secondproject.util.Encoding;
import com.secondproject.util.db.DBClose;
import com.secondproject.util.db.DBConnection;

public class MainDaoImpl implements MainDao {

	private static MainDao mainDao;

	static {
		mainDao = new MainDaoImpl();
	}

	private MainDaoImpl() {
	}

	public static MainDao getMainDao() {
		return mainDao;
	}

	@Override
	public List<MainExhibitionDto> listMainExhibition() {
		List<MainExhibitionDto> list = new ArrayList<MainExhibitionDto>();

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = DBConnection.getConnection();
			StringBuffer sql = new StringBuffer();

			sql.append("select exd.exhibition_id, \n");
			sql.append("	   exd.exd_desc, exd_order, \n");
			sql.append("	   s.title, s.address, s.img, exd.shop_id, \n");
			sql.append("	   NVL((SELECT avg(score) FROM review WHERE shop_id = s.shop_id), 0) as score \n");
			sql.append("	   from exhibition e, exhibition_detail exd, shop s \n");
			sql.append("	   where e.exhibition_id = exd.exhibition_id \n");
			sql.append("	   and s.shop_id = exd.shop_id \n");
			sql.append("	   and e.ex_visiable = 1");
			pstmt = conn.prepareStatement(sql.toString());
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				MainExhibitionDto mainExhibitionDto = new MainExhibitionDto();
				mainExhibitionDto.setExhibitionId(rs.getInt("exhibition_id"));
				mainExhibitionDto.setExd_desc(rs.getString("exd_desc"));
				mainExhibitionDto.setExd_order(rs.getInt("exd_order"));
				mainExhibitionDto.setShop_name(rs.getString("title"));
				mainExhibitionDto.setAddress(rs.getString("address"));
				mainExhibitionDto.setScore(rs.getInt("score"));
				mainExhibitionDto.setShopImg(rs.getString("img"));
				mainExhibitionDto.setEx_shopid(rs.getInt("shop_id"));
				list.add(mainExhibitionDto);
			}
		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			DBClose.close(conn, pstmt, rs);
		}

		return list;
	}

	@Override
	public MainExhibitionDto viewMainExhibition(int i) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		MainExhibitionDto mainExhibitionDto = null;

		try {
			conn = DBConnection.getConnection();
			StringBuffer sql = new StringBuffer();

			sql.append("select e.exhibition_id, e.ex_title, e.ex_desc, e.ex_image, e.ex_order, \n");
			sql.append("	   e.ex_visiable, exd.exd_desc, exd_order, \n");
			sql.append("	   s.title, s.address, \n");
			sql.append("	   NVL((SELECT avg(score) FROM review WHERE shop_id = s.shop_id), 0) as score \n");
			sql.append("	   from exhibition e, exhibition_detail exd, shop s \n");
			sql.append("	   where e.exhibition_id = exd.exhibition_id \n");
			sql.append("	   and s.shop_id = exd.shop_id \n");
			sql.append("");
			pstmt = conn.prepareStatement(sql.toString());
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				mainExhibitionDto = new MainExhibitionDto();
				mainExhibitionDto.setExhibitionId(rs.getInt("exhibition_id"));
				mainExhibitionDto.setEx_title(rs.getString("ex_title"));
				mainExhibitionDto.setEx_desc(rs.getString("ex_desc"));
				mainExhibitionDto.setEx_image(rs.getString("ex_image"));
				mainExhibitionDto.setEx_order(rs.getInt("ex_order"));
				mainExhibitionDto.setEx_visiable(rs.getInt("ex_visiable"));
				mainExhibitionDto.setExd_desc(rs.getString("exd_desc"));
				mainExhibitionDto.setExd_order(rs.getInt("exd_order"));
				mainExhibitionDto.setShop_name(rs.getString("title"));
				mainExhibitionDto.setAddress(rs.getString("address"));
				mainExhibitionDto.setScore(rs.getInt("score"));
			}
		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			DBClose.close(conn, pstmt, rs);
		}

		return mainExhibitionDto;
	}

}
