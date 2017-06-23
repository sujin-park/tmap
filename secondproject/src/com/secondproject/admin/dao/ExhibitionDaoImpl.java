package com.secondproject.admin.dao;

import java.sql.*;
import java.util.*;

import com.secondproject.admin.model.ExhibitionDetailDto;
import com.secondproject.admin.model.ExhibitionDto;
import com.secondproject.shop.model.ShopDto;
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

	// 새 기획전 등록
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

	// 기획전 글번호
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

	// 기획전 리스트
	@Override
	public List<ExhibitionDto> listExhibition(Map<String, String> map) {
		List<ExhibitionDto> list = new ArrayList<ExhibitionDto>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = DBConnection.getConnection();
			StringBuffer sql = new StringBuffer();
			String key = map.get("key");
			String word = map.get("word");
			String order = map.get("order");
			String column = map.get("column");
			String columnBasic = "ex_order";

			// System.out.println(1234234);
			sql.append("select exhibition_id, ex_title, ex_desc, ex_image, ex_order, ex_visiable \n");
			sql.append("from exhibition \n");
			if (!key.isEmpty() && !word.isEmpty()) {
				if (key.equals("title")) {
					sql.append("	  where ex_title like '%' ||?|| '%'\n");
				}
			}
			if (!column.isEmpty()) {
				if (column.equals("orderby")) {
					columnBasic = "ex_order";
				} else if (column.equals("nameby")) {
					columnBasic = "ex_title";
				} else {
					columnBasic = "ex_visiable";
				}
				sql.append("order by " + columnBasic + " " + order);
			} else {
				sql.append("order by ex_order");
			}
			System.out.println(sql);
			pstmt = conn.prepareStatement(sql.toString());
			int idx = 0;
			if (!key.isEmpty() && !word.isEmpty()) {
				pstmt.setString(++idx, map.get("word"));
			}
			rs = pstmt.executeQuery();
			while (rs.next()) {
				ExhibitionDto exhibitionDto = new ExhibitionDto();
				exhibitionDto.setExhibitionId(rs.getInt("exhibition_id"));
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

	// 기획전 디테일 보기
	@Override
	public ExhibitionDetailDto viewExhibition(int seq) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ExhibitionDetailDto exhibitionDetailDto = null;
		try {
			conn = DBConnection.getConnection();
			StringBuffer sql = new StringBuffer();
			sql.append("select ex.exhibition_id, ex_title, ex_desc, ex_image, ex_order, ex_visiable, \n");
			sql.append("   	   shop_id, exd_order, exd_desc \n");
			sql.append("       from exhibition ex, exhibition_detail exd \n");
			sql.append("       where ex.exhibition_id = exd.exhibition_id \n");
			sql.append("and ex.exhibition_id = ?");
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setInt(1, seq);
			// System.out.println(seq);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				exhibitionDetailDto = new ExhibitionDetailDto();
				exhibitionDetailDto.setExhibitionId(rs.getInt("exhibition_id"));
				exhibitionDetailDto.setExTitle(rs.getString("ex_title"));
				exhibitionDetailDto.setExDesc(rs.getString("ex_desc"));
				exhibitionDetailDto.setExImage(rs.getString("ex_image"));
				exhibitionDetailDto.setExOrder(rs.getInt("ex_order"));
				exhibitionDetailDto.setExVisiable(rs.getInt("ex_visiable"));
				exhibitionDetailDto.setShopId(rs.getInt("shop_id"));
				exhibitionDetailDto.setExdOrder(rs.getInt("exd_order"));
				exhibitionDetailDto.setExdDesc(rs.getString("exd_desc"));

			}
		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			DBClose.close(conn, pstmt, rs);
		}

		return exhibitionDetailDto;
	}

	// 기획전 등록할 때 매장추가부분
	@Override
	public List<ShopDto> shopExhibition() {
		List<ShopDto> list = new ArrayList<ShopDto>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = DBConnection.getConnection();
			StringBuffer sql = new StringBuffer();
			sql.append("select shop_id, category_title, title, lat, lng, score, nvl(owner_id,0) owner_id, \n");
			sql.append("	   reserve_url, address, tel, business_time, detail \n");
			sql.append("from shop s, shop_category sc\n");
			sql.append("where s.category_id = sc.category_id \n");

			pstmt = conn.prepareStatement(sql.toString());
			rs = pstmt.executeQuery();
			while (rs.next()) {
				ShopDto shopDto = new ShopDto();
				shopDto.setShopId(rs.getInt("shop_id"));
				shopDto.setCategoryTitle(rs.getString("category_title"));
				shopDto.setTitle(rs.getString("title"));
				shopDto.setLat(rs.getInt("lat"));
				shopDto.setLng(rs.getInt("lng"));
				shopDto.setScore(rs.getInt("score"));
				shopDto.setOwnerId(rs.getInt("owner_id"));
				shopDto.setReserveUrl(rs.getString("reserve_url"));
				shopDto.setAddress(rs.getString("address"));
				shopDto.setTel(rs.getString("tel"));
				shopDto.setBusinessTime(rs.getString("business_time"));
				shopDto.setDetail(rs.getString("detail"));

				list.add(shopDto);
			}
		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			DBClose.close(conn, pstmt, rs);
		}
		return list;
	}

	@Override
	public int deleteExhibition(int seq) {
		int cnt = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = DBConnection.getConnection();
			conn.setAutoCommit(false);

			String sql = "delete exhibition_detail where exhibition_id = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, seq);
			pstmt.executeUpdate();
			pstmt.close();

			String sql2 = "delete exhibition where exhibition_id = ?";
			pstmt = conn.prepareStatement(sql2);
			pstmt.setInt(1, seq);
			pstmt.executeUpdate();
			pstmt.close();

			conn.commit();
			cnt = 1;
		} catch (SQLException e) {

			e.printStackTrace();

			try {
				conn.rollback();
			} catch (SQLException e1) {

				e1.printStackTrace();
			}
			cnt = 0;
		} finally {
			DBClose.close(conn, pstmt);
		}

		return cnt;
	}

}
