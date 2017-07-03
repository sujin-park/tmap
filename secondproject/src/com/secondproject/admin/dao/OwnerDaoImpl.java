package com.secondproject.admin.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

import com.secondproject.admin.model.OwnerConfirmDto;
import com.secondproject.constant.BoardConstant;
import com.secondproject.userdto.UserDto;
import com.secondproject.util.Encoding;
import com.secondproject.util.db.DBClose;
import com.secondproject.util.db.DBConnection;

public class OwnerDaoImpl implements OwnerDao {

	private static OwnerDao ownerDao;

	static {
		ownerDao = new OwnerDaoImpl();
	}
	private OwnerDaoImpl(){}
	
		
	public static OwnerDao getOwnerDao() {
		return ownerDao;
	}

	
	@Override
	public ArrayList<OwnerConfirmDto> getArticles(Map<String, Object> params) {
		ArrayList<OwnerConfirmDto> list = new ArrayList<OwnerConfirmDto>();
		
		String key = (String) params.get("key");
		String word = Encoding.isoToEuc((String) params.get("word"));
		String orderKey = (String) params.get("orderKey");
		String orderValue = (String) params.get("orderValue");
		int pageEnd = (int) params.get("pg") * BoardConstant.LIST_SIZE;
		int pageStart = pageEnd - BoardConstant.LIST_SIZE;
		int confirm_ok = (int) params.get("confirm_ok");
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = DBConnection.getConnection();
			StringBuffer sql = new StringBuffer();
			sql.append("select u.email, u.reg_date, s.title, s.tel, s.address \n");
			sql.append("from users u, shop s, OWNER_CONFIRM o \n");
			sql.append("where u.user_id = o.user_id and o.shop_id = s.shop_id \n");
			sql.append("and confirm_ok = ? \n");
			
			if (!word.isEmpty() && !key.isEmpty()) {
				sql.append("and "+ key +" like '%' || ? || '%' \n");
			}
			
			if (!orderValue.isEmpty() && !orderKey.isEmpty()) {
				sql.append("order by " + orderKey + " " + orderValue);
			} else {
				sql.append("order by u.reg_date desc");
			}
			pstmt = conn.prepareStatement(sql.toString());

			int idx = 0;
			pstmt.setInt(++idx, confirm_ok);
			if (!word.isEmpty() && !key.isEmpty()){
				pstmt.setString(++idx, word);
			}
			rs = pstmt.executeQuery();
			while (rs.next()) { // 있으면 true 없으면 false return
				OwnerConfirmDto ownerConfirmDto = new OwnerConfirmDto();
				ownerConfirmDto.setUserEmail(rs.getString("email"));
				ownerConfirmDto.setUserRegDate(rs.getString("reg_date"));
				ownerConfirmDto.setShopTitle(rs.getString("title"));
				ownerConfirmDto.setShopTel(rs.getString("tel"));
				ownerConfirmDto.setShopAddress(rs.getString("address"));

				list.add(ownerConfirmDto);
			}
				
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBClose.close(conn, pstmt, rs);
		}

		return list;
		}
		
	
	
	
	public ArrayList<OwnerConfirmDto> modifyArticles(String[] user_id, int ownerOk) {
		ArrayList<OwnerConfirmDto> list = new ArrayList<OwnerConfirmDto>();
		Connection conn = null;
		PreparedStatement pstmt = null;
	

			try {
				conn = DBConnection.getConnection();
				int size = user_id.length;
				
				for (int i = 0; i < size; i++){
					if (user_id[i] != null){
						String sql = "update owner_confirm set confirm_ok = ? \n";
						sql += "where user_id = (select user_id from users where email = ?) \n";
						pstmt = conn.prepareStatement(sql);
						pstmt.setInt(1, ownerOk);
						pstmt.setString(2, user_id[i]);
						pstmt.executeUpdate();
						pstmt.close();						
					}
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				DBClose.close(conn, pstmt);
			}
		
		return list;
	}
}
