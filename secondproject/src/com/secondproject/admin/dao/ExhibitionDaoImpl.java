package com.secondproject.admin.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.secondproject.admin.model.ExhibitionDetailDto;
import com.secondproject.admin.model.ExhibitionDto;
import com.secondproject.util.db.DBClose;
import com.secondproject.util.db.DBConnection;

public class ExhibitionDaoImpl implements ExhibitionDao {

	private static ExhibitionDao exhibitionDao;

	static {
		exhibitionDao = new ExhibitionDaoImpl();
	}

	private ExhibitionDaoImpl() {
	};

	public static ExhibitionDao getExhibitionDao() {
		return exhibitionDao;
	}

	@Override
	public int writeExhibition(ExhibitionDetailDto exhibitionDetailDto) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int cnt = 0;
		try {
			conn = DBConnection.getConnection();
			StringBuffer sql = new StringBuffer();
			sql.append("insert all \n");
			sql.append("	into exhibition (exhibition_id, ex_title, ex_desc, ex_image, ex_order, ex_visiable) \n");
			sql.append("	values (?, ?, ?, ?, ?, ?) \n");
			sql.append("	into exhibition_detail (exhibition_id, shop_id, exd_order, exd_desc) \n");
			sql.append("	values (?,?,?,?) \n");
			
			sql.append("select * from dual");
			pstmt = conn.prepareStatement(sql.toString());
			int idx = 0;
			pstmt.setInt(++idx, exhibitionDetailDto.getExhibitionId());
			pstmt.setString(++idx, exhibitionDetailDto.getExTitle());
			pstmt.setString(++idx, exhibitionDetailDto.getExDesc());
			pstmt.setString(++idx, exhibitionDetailDto.getExImage());
			pstmt.setInt(++idx, exhibitionDetailDto.getExOrder());
			pstmt.setInt(++idx, exhibitionDetailDto.getExVisiable());
			pstmt.setInt(++idx, exhibitionDetailDto.getExhibitionId());
			pstmt.setInt(++idx, exhibitionDetailDto.getShopId());
			pstmt.setInt(++idx, exhibitionDetailDto.getExdOrder());
			pstmt.setString(++idx, exhibitionDetailDto.getExdDesc());
			cnt = pstmt.executeUpdate();
			
		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			DBClose.close(conn, pstmt);
		}
		return cnt;
	}

	@Override
	public int getNextSeq() {
		int seq = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = DBConnection.getConnection();
			String sql = "select exhibition_id_seq.nextval from dual";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			rs.next();
			seq = rs.getInt(1);
		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			DBClose.close(conn, pstmt, rs);
		}

		return seq;
	}

	@Override
	public List<ExhibitionDto> listExhibition() {
		List<ExhibitionDto> list = new ArrayList<ExhibitionDto>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = DBConnection.getConnection();
			StringBuffer sql = new StringBuffer();
			sql.append("select ex_title, ex_desc, ex_image, ex_order, ex_visiable \n");
			sql.append("from exhibition \n");
			sql.append("order by ex_order");
			
			pstmt = conn.prepareStatement(sql.toString());
			rs =pstmt.executeQuery();
			while(rs.next()) {
				ExhibitionDto exhibitionDto = new ExhibitionDto();
				exhibitionDto.setExTitle(rs.getString("ex_title"));
				exhibitionDto.setExDesc(rs.getString("ex_desc"));
				exhibitionDto.setExImage(rs.getString("ex_image"));
				exhibitionDto.setExOrder(rs.getInt("ex_order"));
				exhibitionDto.setExVisiable(rs.getInt("ex_visiable"));
				
				list.add(exhibitionDto);
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		} finally {
			DBClose.close(conn, pstmt, rs);
		}
		
		return list;
	}

}
