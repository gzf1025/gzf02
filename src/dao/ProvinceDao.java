package dao;
//使用jdbc访问数据库

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import entity.Province;
import util.DButils;

public class ProvinceDao {
	 Connection conn = null;
	 PreparedStatement ps = null;
	 ResultSet rs = null;
	 
	 //根据id获取名称
	 public String queryProviceNameById(Integer id) {
		 String name = "";
		 try {
			 //获取数据库连接
			conn = DButils.getConnection();
			//创建数据库操作对象
			String sql ="select name from province where id=?";	
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			while(rs.next()) {
				name = rs.getString("name");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if (rs!=null) {
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (ps!=null) {
				try {
					ps.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (conn!=null) {
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return name;
	 }
		
	 
	 //根据id获取一个完整的Province对象
	 public Province queryProviceById(Integer id) {
		 Province p = null;
		 try {
			 p = new Province();
			 //获取数据库连接
			conn = DButils.getConnection();
			//创建数据库操作对象
			String sql ="select * from province where id=?";	
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			while(rs.next()) {
				p.setId(rs.getInt("id"));
				p.setName(rs.getString("name"));
				p.setJiancheng(rs.getString("jiancheng"));
				p.setShenghui(rs.getString("shenghui"));
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if (rs!=null) {
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (ps!=null) {
				try {
					ps.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (conn!=null) {
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return p;
	 }
}
