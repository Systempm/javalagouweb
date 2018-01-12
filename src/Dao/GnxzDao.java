package Dao;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;



/**
 * 
 * 没用
 * 
 * 
 * 
 * **/


public class GnxzDao extends DbConnection {
	public List select(){
		List list=new ArrayList();
		 Connection con=this.getconnection();
		 Statement st =null;
		 ResultSet rs=null;
		 try {
			st=con.createStatement();
			rs=st.executeQuery("select *from Xzgn");
			while(rs.next()){	
			System.out.println("ID："+rs.getString(1));
			System.out.println("user："+rs.getString(2));
			System.out.println("功能1："+rs.getInt(3));
			System.out.println("功能2："+rs.getInt(4));
			System.out.println("功能3："+rs.getInt(5));
			System.out.println("功能4："+rs.getInt(6));	
		
			}
//
//			for(EmpVo empVo:list){
//				System.out.print(empVo.getEmpno()+"\t");
//				System.out.print(empVo.getEname()+"\t");
//				System.out.println(empVo.getJob()+"\t");
//			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally{
			this.closeResultSet(rs);
			this.closeStatement(st);
			this.closeConnection(con);
		}
		 return list;
	}
	
	public boolean gnpd(int a){
	
		 Connection con=this.getconnection();
		 java.sql.PreparedStatement st =null;
		 ResultSet rs=null;
		 boolean aa=false;
		 try {
			 
			 String gn= "gn"+a;
			 String sql= "select * from xzgn where "+gn+"=1";
			st=con.prepareStatement(sql);
			rs=st.executeQuery();
			
			System.out.println(sql);
			if(rs.next()){	
		aa=true;
			}
//
//			for(EmpVo empVo:list){
//				System.out.print(empVo.getEmpno()+"\t");
//				System.out.print(empVo.getEname()+"\t");
//				System.out.println(empVo.getJob()+"\t");
//			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally{
			this.closeResultSet(rs);
			this.closeStatement(st);
			this.closeConnection(con);
		}
		 return aa;
	}
	
	public static void main(String[] args) {
		GnxzDao a=new GnxzDao();
		a.select();
	}
	
	
	
}
