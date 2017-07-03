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

			sql.append("select b.* \n");
			sql.append("from ( \n");
			sql.append("   select rownum rn, a.* \n");
			sql.append("   from ( \n");
			sql.append("      select exhibition_id, ex_title, ex_desc, ex_image, ex_order, ex_visiable \n");
			sql.append("      from exhibition e \n");


			pstmt = conn.prepareStatement(sql.toString());

			rs = pstmt.executeQuery();
			while (rs.next()) {
				MainExhibitionDto mainExhibitionDto = new MainExhibitionDto();

				list.add(mainExhibitionDto);
			}
		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			DBClose.close(conn, pstmt, rs);
		}

		return list;
	}

}
