package com.secondproject.mypage.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
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
			Map<String,String> map = new HashMap<String, String>();
			map.put("userId", followCategoryDto.getUserId()+"");
			sql.append("insert into follow_category \n");
			sql.append("(follow_category_id,user_id,category_name,category_order) \n");
			sql.append("	values (seq_follow_category_id.nextval,?,?, \n");
			int size =followCategoryListView(map).size();
			if(size==0) {
				sql.append("1)");
			} else {
				sql.append("(select max(category_order) from follow_category where user_id=?)+1)");
			}
			
			pstmt = conn.prepareStatement(sql.toString());
			int idx = 0;
			pstmt.setInt(++idx, followCategoryDto.getUserId());
			pstmt.setString(++idx, followCategoryDto.getCategoryName());
			if(size!=0) {
				pstmt.setInt(++idx, followCategoryDto.getUserId());
			}

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
			sql.append("update follow_category \n");
			sql.append("set follow_name=? \n");
			sql.append("where follow_category_id=?");
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
		FollowCategoryDto fcdto =getFollowCategory(followCategoryId);
		try {
			conn = DBConnection.getConnection();
            conn.setAutoCommit(false);
            
            StringBuffer delete = new StringBuffer();
            delete.append("delete from follow_category \n");
            delete.append("where follow_category_id=?");
            pstmt = conn.prepareStatement(delete.toString());
            pstmt.setInt(1, followCategoryId);
            pstmt.executeUpdate();
            pstmt.close();
            
            StringBuffer update = new StringBuffer();
            update.append("update follow_category \n");
            update.append("set category_order=category_order-1 \n");
            update.append("where category_order>? and user_id=?");
            pstmt = conn.prepareStatement(update.toString());
            pstmt.setInt(1, fcdto.getCategoryOrder());
            pstmt.setInt(2, fcdto.getUserId());
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
		FollowUserDto fudto = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = DBConnection.getConnection();
			StringBuffer sql = new StringBuffer();
			sql.append("select follow_user_id,nvl(alias,'없음') alias,nvl(memo,'없음') memo from follow_user where follow_user_id=?");

			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setInt(1, favoriteUserId);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				fudto=new FollowUserDto();
				fudto.setFavoriteUserId(rs.getInt("follow_user_id"));
				fudto.setAlias(rs.getString("alias"));
				fudto.setMemo(rs.getString("memo"));
			}

		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			DBClose.close(conn, pstmt, rs);
		}

		return fudto;
	}


	@Override
	public List<FollowUserDto> followListView(Map<String,String> map) {
		List<FollowUserDto> list = new ArrayList<FollowUserDto>();
		FollowUserDto fudto = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = DBConnection.getConnection();
			StringBuffer sql = new StringBuffer();
			sql.append("	select b.* \n");
			sql.append("	from (select rownum rn,a.* \n");
			sql.append("		from (select fc.follow_category_id,fu.follow_user_id,nvl(fc.category_name,'없음') category_name,u.email, \n");
			sql.append("					u.status_msg,to_char(u.reg_date,'yyyy.mm.dd') as follow_reg_date, \n");
			sql.append("				to_char(fu.reg_date,'yyyy.mm.dd') as reg_date,fu.alias,fu.memo \n");
			sql.append("			from follow_user fu \n");
			sql.append("			LEFT OUTER JOIN follow_category fc ON fc.follow_category_id = fu.follow_category_id \n");
			sql.append("			join users u ON fu.reg_user_id = u.user_id  \n");
			sql.append("			where fu.user_id=? \n");
			if(!map.get("word").equals("")) {
				sql.append(" and fc.follow_category_id=? \n");
			}
			sql.append("			ORDER BY fc.category_order ASC) a \n");
			sql.append("	where rownum<=? \n");
			sql.append("		)b \n");
			sql.append("where b.rn>? \n");
			//TODO 검색조건설정
			pstmt = conn.prepareStatement(sql.toString());
			int idx=0;
			pstmt.setString(++idx, map.get("userId"));
			if(!map.get("word").equals("")) {
			pstmt.setString(++idx, map.get("word"));
			}
			pstmt.setString(++idx, map.get("end"));
			pstmt.setString(++idx, map.get("start"));
			rs = pstmt.executeQuery();
			while (rs.next()) {
				fudto=new FollowUserDto();
				fudto.setFavoriteUserId(rs.getInt("follow_user_id"));
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
	public List<FollowCategoryDto> followCategoryListView(Map<String,String> map) {
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
			pstmt.setString(1, map.get("userId"));
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


	@Override
	public int followdelete(int followUserId) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int cnt=0;
		try {
			conn = DBConnection.getConnection();
			StringBuffer sql = new StringBuffer();
			sql.append("delete from follow_user \n");
			sql.append("where follow_user_id=?");
			pstmt = conn.prepareStatement(sql.toString());

			pstmt.setInt(1, followUserId);
			cnt=pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBClose.close(conn, pstmt);
		}
		return cnt;
	}


	@Override
	public int followModify(FollowUserDto fudto) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int cnt = 0;
		try {
			conn = DBConnection.getConnection();
			StringBuffer sql = new StringBuffer();
			sql.append("update follow_user \n");
			sql.append("	set alias=?,memo=? \n");
			sql.append("	where follow_user_id=?");
			pstmt = conn.prepareStatement(sql.toString());

			pstmt.setString(1, fudto.getAlias());
			pstmt.setString(2, fudto.getMemo());
			pstmt.setInt(3, fudto.getUserId());
			
		

			cnt = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBClose.close(conn, pstmt);
		}
		return cnt;
	}


	@Override
	public int totalArticleCount(Map<String, String> map) {
		int cnt = 0;
	      Connection conn=null;
	      PreparedStatement pstmt = null;
	      ResultSet rs =null;
	      
	      try {
	         conn=DBConnection.getConnection();
	         StringBuffer sql = new StringBuffer();

	         sql.append(" select count(*) \n");
	         sql.append("	from follow_user fu \n");
	         sql.append(" 	LEFT OUTER JOIN follow_category fc ON fc.follow_category_id = fu.follow_category_id \n");
	         sql.append(" 	join users u ON fu.reg_user_id = u.user_id  \n");
	         sql.append(" 	where fu.user_id=? \n");
	         pstmt=conn.prepareStatement(sql.toString());
	         pstmt.setString(1, map.get("userId"));
	         rs=pstmt.executeQuery();
	         rs.next();
	         cnt=rs.getInt(1);
	            
	      } catch (SQLException e) {
	         
	         e.printStackTrace();
	      } finally {
	         DBClose.close(conn, pstmt, rs);
	      }
	      return cnt;
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
	public int followCategoryModify(int cateId, int seq) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int cnt = 0;
		try {
			conn = DBConnection.getConnection();
			StringBuffer sql = new StringBuffer();
			sql.append("update follow_user \n");
			sql.append("	set follow_category_id=? \n");
			sql.append("	where follow_user_id=?");
			pstmt = conn.prepareStatement(sql.toString());

			pstmt.setInt(1, cateId);
			pstmt.setInt(2, seq);			

			cnt = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBClose.close(conn, pstmt);
		}
		return cnt;
	}


}
