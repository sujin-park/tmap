package com.secondproject.admin.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.secondproject.admin.model.OwnerConfirmDto;
import com.secondproject.userdto.UserDto;
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
	public ArrayList<OwnerConfirmDto> getArticles(String keyword, String type, String userOrder, String column, int confirm_ok) {
		ArrayList<OwnerConfirmDto> list = new ArrayList<OwnerConfirmDto>();
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
			//			sql.append("where type != '0' \n");
			System.out.println(confirm_ok);
			if (keyword != null && type != null) {
				sql.append("and "+ type +" like '%' || ? || '%' \n");
			}
			
			if (userOrder != null && column != null) {
				sql.append("order by " + column + " " + userOrder);
			} else {
				sql.append("order by u.reg_date desc");
			}
			pstmt = conn.prepareStatement(sql.toString());

			int idx = 0;
			pstmt.setInt(++idx, confirm_ok);
			if (keyword != null && type != null){
				pstmt.setString(++idx, keyword);
			}
			System.out.println("keyword === " + keyword + " type === " + type);
			System.out.println(sql.toString());
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
