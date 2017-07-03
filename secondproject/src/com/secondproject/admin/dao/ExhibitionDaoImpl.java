package com.secondproject.admin.dao;

import java.sql.*;
import java.util.*;

import com.secondproject.admin.model.ExhibitionDetailDto;
import com.secondproject.admin.model.ExhibitionDto;
import com.secondproject.constant.BoardConstant;
import com.secondproject.shop.model.ShopDto;
import com.secondproject.util.Encoding;
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
	public int writeExhibition(ExhibitionDto exhibitionDto) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int cnt = 0;
		try {
			conn = DBConnection.getConnection();
			StringBuffer sql = new StringBuffer();
			sql.append("insert \n");
			sql.append("	into exhibition (exhibition_id, ex_title, ex_desc, ex_image, ex_order, ex_visiable) \n");
			sql.append("	values (?, ?, ?, ?, (select nvl(max(ex_order),0) from exhibition) + 1, ?) \n");
			
			pstmt = conn.prepareStatement(sql.toString());
			int idx = 0;
			pstmt.setInt(++idx, exhibitionDto.getExhibitionId());
			pstmt.setString(++idx, exhibitionDto.getExTitle());
			pstmt.setString(++idx, exhibitionDto.getExDesc());
			pstmt.setString(++idx, exhibitionDto.getExImage());
			pstmt.setInt(++idx, exhibitionDto.getExVisiable());
			cnt = pstmt.executeUpdate();

		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			DBClose.close(conn, pstmt);
		}
		return cnt;
	}

	// 기획전 리스트
	@Override
	public List<ExhibitionDto> listExhibition(Map<String, Object> params) {
		List<ExhibitionDto> list = new ArrayList<ExhibitionDto>();
		
		String key = (String) params.get("key");
		String word = Encoding.isoToEuc((String) params.get("word"));
		String orderKey = (String) params.get("orderKey");
		String orderValue = (String) params.get("orderValue");
		int pageEnd = (int) params.get("pg") * BoardConstant.LIST_SIZE;
		int pageStart = pageEnd - BoardConstant.LIST_SIZE;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = DBConnection.getConnection();
			StringBuffer sql = new StringBuffer();

			sql.append("select b.* \n");
			sql.append("from ( \n");
			sql.append("   select rownum rn, a.* \n");
			sql.append("   from ( \n");
			sql.append("      select exhibition_id, ex_title, ex_desc, ex_image, ex_order, ex_visiable \n");
			sql.append("      from exhibition e \n");

			if (!key.isEmpty() && !word.isEmpty()) {
				if (key.equals("title")) {
					sql.append("	  where ex_title like '%' ||?|| '%'\n");
				}
			}
			if (!orderKey.isEmpty()) {
				if (orderKey.equals("orderby")) {
					orderKey = "ex_order";
				} else if (orderKey.equals("nameby")) {
					orderKey = "ex_title";
				} else {
					orderKey = "ex_visiable";
				}
				sql.append("order by " + orderKey + " " + orderValue);
			} else {
				sql.append("order by ex_order");
			}
			sql.append("         ) a \n");
			sql.append("      where rownum <=? \n");
			sql.append("      ) b \n");
			sql.append("   where b.rn>?");
			
			pstmt = conn.prepareStatement(sql.toString());
			int idx = 0;
			if (!key.isEmpty() && !word.isEmpty()) {
				pstmt.setString(++idx, word);
			}
			pstmt.setInt(++idx, pageEnd);
			pstmt.setInt(++idx, pageStart);
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
	public ExhibitionDto viewExhibition(int seq) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ExhibitionDto exhibitionDto = null;
		try {
			conn = DBConnection.getConnection();
			StringBuffer sql = new StringBuffer();
			sql.append("select exhibition_id, ex_title, ex_desc, ex_image, ex_order, ex_visiable \n");
			sql.append("       from exhibition \n");
			sql.append("where exhibition_id = ?");
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setInt(1, seq);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				exhibitionDto = new ExhibitionDto();
				exhibitionDto.setExhibitionId(rs.getInt("exhibition_id"));
				exhibitionDto.setExTitle(rs.getString("ex_title"));
				exhibitionDto.setExDesc(rs.getString("ex_desc"));
				exhibitionDto.setExImage(rs.getString("ex_image"));
				exhibitionDto.setExOrder(rs.getInt("ex_order"));
				exhibitionDto.setExVisiable(rs.getInt("ex_visiable"));

			}
		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			DBClose.close(conn, pstmt, rs);
		}

		return exhibitionDto;
	}

	// 기획전 등록할 때 매장추가부분
	@Override
	public List<ShopDto> shopExhibition(Map<String, Object> params) {
		List<ShopDto> list = new ArrayList<ShopDto>();
		
		String key = (String) params.get("key");
		String word = Encoding.isoToEuc((String) params.get("word"));
		int pageEnd = (int) params.get("pg") * BoardConstant.LIST_SIZE;
		int pageStart = pageEnd - BoardConstant.LIST_SIZE;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = DBConnection.getConnection();
			StringBuffer sql = new StringBuffer();
			sql.append("select b.* \n");
			sql.append("from ( \n");
			sql.append("   select rownum rn, a.* \n");
			sql.append("   from ( \n");
			sql.append("select shop_id, category_title, title, lat, lng, nvl(owner_id,0) owner_id, \n");
			sql.append("	   reserve_url, address, tel, business_time, detail \n");
			sql.append("from shop s, shop_category sc\n");
			sql.append("where s.category_id = sc.category_id \n");
			
			if (!key.isEmpty() && !word.isEmpty()) {
				if (key.equals("title")) {
					sql.append("and title like '%' ||?|| '%'\n");
				} else {
					sql.append("and category_title like '%' ||?|| '%'\n");
				}
			}
			sql.append("         ) a \n");
			sql.append("      where rownum <=? \n");
			sql.append("      ) b \n");
			sql.append("   where b.rn>?");
			pstmt = conn.prepareStatement(sql.toString());
			int idx = 0;
			if (!key.isEmpty() && !word.isEmpty()) {
				pstmt.setString(++idx, word);
			}
			pstmt.setInt(++idx, pageEnd);
			pstmt.setInt(++idx, pageStart);
			
			rs = pstmt.executeQuery();
			while (rs.next()) {
				ShopDto shopDto = new ShopDto();
				shopDto.setShopId(rs.getInt("shop_id"));
				shopDto.setCategoryTitle(rs.getString("category_title"));
				shopDto.setTitle(rs.getString("title"));
				shopDto.setLat(rs.getDouble("lat"));
				shopDto.setLng(rs.getDouble("lng"));
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

	// 기획전 삭제하기
	@Override
	public int deleteExhibition(String[] exhibitions) {
		int cnt = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		int size = 0;
		try {
			conn = DBConnection.getConnection();
			conn.setAutoCommit(false);
			if (exhibitions != null) {
				size = exhibitions.length;
			} else {
				size = 0;
			}

			for (int i = 0; i < size; i++) {
				String sql = "delete exhibition_detail where exhibition_id = ?";
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, Integer.parseInt(exhibitions[i]));
				pstmt.executeUpdate();
				pstmt.close();

				String sql2 = "delete exhibition where exhibition_id = ?";
				pstmt = conn.prepareStatement(sql2);
				pstmt.setInt(1, Integer.parseInt(exhibitions[i]));
				pstmt.executeUpdate();
				pstmt.close();

				conn.commit();
				cnt = 1;
			}
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
	// 매장추가 (수정중)

	@Override
	public int plusExhibition(String[] shops, int seq) {
		int cnt = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = DBConnection.getConnection();

			int size = shops.length;
			for (int i = 0; i < size; i++) {
				String sql = "insert into exhibition_detail (exhibition_id, shop_id, exd_order, exd_desc) \n";
				sql += "						 values	(?, ?, ?, 'dsd') \n";
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, seq);
				pstmt.setInt(2, Integer.parseInt(shops[i]));
				pstmt.setInt(3, 8); // 8번이라고 가정
				System.out.println("db에 몇번 왔다갔다 하나 8ㅅ8 ");
				cnt = pstmt.executeUpdate();
				pstmt.close();
			}
		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			DBClose.close(conn, pstmt);
		}

		return cnt;
	}

	@Override
	public int modifyExhibition(ExhibitionDto exhibitionDto) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int cnt = 0;
		try {
			conn = DBConnection.getConnection();
			StringBuffer sql = new StringBuffer();
			sql.append("update exhibition set ex_title =?, ex_desc =?, \n");
			sql.append("	   ex_image = ?, ex_order =?, ex_visiable =? \n");
			sql.append("where exhibition_id = ?");
			pstmt = conn.prepareStatement(sql.toString());
			int idx = 0;
			pstmt.setString(++idx, exhibitionDto.getExTitle());
			pstmt.setString(++idx, exhibitionDto.getExDesc());
			pstmt.setString(++idx, exhibitionDto.getExImage());
			pstmt.setInt(++idx, exhibitionDto.getExOrder());
			pstmt.setInt(++idx, exhibitionDto.getExVisiable());
			pstmt.setInt(++idx, exhibitionDto.getExhibitionId());

			cnt = pstmt.executeUpdate();

		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			DBClose.close(conn, pstmt);
		}
		return cnt;
	}

	// 추가 되어있는 매장 리스트 가져오기
	@Override
	public List<ShopDto> shopUpdated(int seq) {
		List<ShopDto> list = new ArrayList<ShopDto>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = DBConnection.getConnection();
			StringBuffer sql = new StringBuffer();
			sql.append("select s.shop_id, category_title, s.title, lat, lng, nvl(owner_id,0) owner_id, \n");
			sql.append("	   reserve_url, address, tel, business_time, detail \n");
			sql.append("from shop s, shop_category sc, exhibition_detail ed \n");
			sql.append("where s.category_id = sc.category_id \n");
			sql.append("and s.shop_id = ed.shop_id \n");
			sql.append("and ed.exhibition_id = ?");
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setInt(1, seq);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				ShopDto shopDto = new ShopDto();
				shopDto.setShopId(rs.getInt("shop_id"));
				shopDto.setCategoryTitle(rs.getString("category_title"));
				shopDto.setTitle(rs.getString("title"));
				shopDto.setLat(rs.getDouble("lat"));
				shopDto.setLng(rs.getDouble("lng"));
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
	public int deleteShopList(int exseq, int shopseq) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int cnt = 0;
		try {
			conn = DBConnection.getConnection();
			StringBuffer sql = new StringBuffer();
			sql.append("delete exhibition_detail \n");
			sql.append("where exhibition_id = ? \n");
			sql.append("and shop_id = ? \n");
			
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setInt(1, exseq);
			pstmt.setInt(2, shopseq);
			cnt = pstmt.executeUpdate();
		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			DBClose.close(conn, pstmt);
		}
		return cnt;
	}
}
