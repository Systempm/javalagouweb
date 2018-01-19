package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Vo.newHvo;
public class HnewDao extends DbConnection{
	public List Hselect(int page,String city){
	List list=new ArrayList();
	
	 Connection con=this.getconnection();
	PreparedStatement ps =null;
	  ResultSet rs=null;
	 try {
		ps=con.prepareStatement("select * from lagou where city =?");
		ps.setString(1, city);
		rs=ps.executeQuery();
		while(rs.next()){	
			newHvo hvo=new newHvo();
			hvo.setCompanshortname(rs.getString(1));
			hvo.setCompanyFullName(rs.getString(2));
			hvo.setPositionName(rs.getString(3));
			hvo.setPositionId(rs.getString(4));
			hvo.setPositionAdvantage(rs.getString(5));
			hvo.setSalary(rs.getString(6));
			hvo.setMinsalary(rs.getInt(7));
			hvo.setMaxsalary(rs.getInt(8));
			hvo.setMaxjianminslary(rs.getInt(8)-rs.getInt(7)		);
			hvo.setWorkYear(rs.getString(9));
			hvo.setEducation(rs.getString(10));
			hvo.setCity(rs.getString(11));
			hvo.setDistrict(rs.getString(12));
			hvo.setCompanySize(rs.getString(13));
			hvo.setCompanyLogo("//"+rs.getString(14));
			hvo.setCompanyLabelList(rs.getString(15));
			
			hvo.setCreateTime(rs.getDate(16));
			list.add(hvo);
			
//		System.out.println("ID��"+rs.getString(1));
//		System.out.println("��˾��"+rs.getString(2));
//		System.out.println("ְλ��"+rs.getString(3));
//		System.out.println("���ʷ�Χ��"+rs.getString(4));
//		System.out.println("��͹��ʣ�"+rs.getInt(5));
//		System.out.println("��߹��ʣ�"+rs.getInt(6));	
//		System.out.println("�����ص㣺"+rs.getString(7));	
//		System.out.println("�ص㣺"+rs.getString(8));	
//		System.out.println("logo��"+rs.getString(9));	
//		System.out.println("��˾url��"+rs.getString(10));	
//		System.out.println("����url��"+rs.getString(11));	
//		System.out.println("���ʱ�䣺"+rs.getDate(12));	
////		
		}
	} catch (SQLException e) {
			
			e.printStackTrace();
		}finally{
			this.closeResultSet(rs);
			this.closeStatement(ps);
			this.closeConnection(con);
		}
		 return list;
	}
	
	
	  public int getPage(int pagesize) throws Exception{
		  Connection con=this.getconnection();
		  PreparedStatement ps =null;
		  ResultSet rs=null;
	        //��coun(*)��ȡ��ǰ���������ע�ⷵ�ص�ֻ��һ�����ݣ�������������
	        String sql="select count(*) from Lagou";
	        ps=con.prepareStatement(sql);
	        rs=ps.executeQuery();
	        //��ôrs.next()��Ȼ��ָ����һ��
	        rs.next();
	        //��Ϊ������������Ȼ�Ǹ�����������Ҫ����1.0���С����Ȼ����Math.ceil��ȡ ���ڻ��ߵ��� ��ǰ���� ��С����ֵ��
	        int pageCount=(int)Math.ceil(1.0*rs.getInt(1)/pagesize);
	        return pageCount;
	    }
	
	  public ArrayList<newHvo> SelectAll(int pageSize, int  startIndex) throws Exception{
	        //����һ����ǰҪ��ȡ��������͵����飻
		  Connection con=this.getconnection();
		  PreparedStatement ps =null;
		  ResultSet rs=null;
	        ArrayList<newHvo> list=new ArrayList<newHvo>();
	        //mysql�ķ�ҳ��䣻
	        
	        String sql="select * from lagou order by createTime DESC limit ?,?";
	        ps=con.prepareStatement(sql);
	        ps.setInt(1, (startIndex-1)*pageSize);
	        ps.setInt(2, startIndex);
	        rs=ps.executeQuery();
	    
	        //���rs.next��true�����Ȱ�Ҫ��ֵ����ʵ��������ôͨ��whileѭ����ÿ���ֶ�Ԫ�ظ�ֵ����Ӧ����ı����У�
	        while(rs.next()){
	        	newHvo hvo=new newHvo();
				hvo.setCompanshortname(rs.getString(1));
				hvo.setCompanyFullName(rs.getString(2));
				hvo.setPositionName(rs.getString(3));
				hvo.setPositionId(rs.getString(4));
				hvo.setPositionAdvantage(rs.getString(5));
				hvo.setSalary(rs.getString(6));
				hvo.setMinsalary(rs.getInt(7));
				hvo.setMaxsalary(rs.getInt(8));
				hvo.setMaxjianminslary(rs.getInt(8)-rs.getInt(7)		);
				hvo.setWorkYear(rs.getString(9));
				hvo.setEducation(rs.getString(10));
				hvo.setCity(rs.getString(11));
				hvo.setDistrict(rs.getString(12));
				hvo.setCompanySize(rs.getString(13));
				hvo.setCompanyLogo("//"+rs.getString(14));
				hvo.setCompanyLabelList(rs.getString(15));
				hvo.setCreateTime(rs.getDate(16));
				list.add(hvo);
	        }
	        //��󷵻س�ȥ
	        return list;
	    }
	
	  public static void main(String[] args) {

			HnewDao hd =new HnewDao();
//			HVo hv = new HVo();
//			List<newHvo> list = hd .Hselect(3,"�Ϻ�") ;  
//			for  (newHvo hvo:list )
//			{
//		   System.out.println(hvo.getCompanyLogo());
//			}
			
		try {
		System.out.println(hd.SelectAll(1, 30));	
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
//			System.out.println( list.get(1).getCompanshortname());
			}

}
