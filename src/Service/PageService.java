package Service;

import java.util.List;

import Bean.PageBean;
import Dao.HnewDao;
import Vo.newHvo;

public class PageService {

	public PageBean Page(int pageNum, int pageSize)
	{
		HnewDao hd =new HnewDao();
		PageBean pb =null;
   		int totalRecord;
		try {
			totalRecord = hd.getPage(pageSize);
	 		 pb = new PageBean (pageNum , pageSize ,totalRecord);
			int startIndex = pb .getStartIndex();
			pb .setList(hd .SelectAll(startIndex,pageSize));
	
   
		}
		
		 catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
   		return pb;
	}
	
	public static void main(String[] args) {
		PageService ps=new PageService();
		System.out.println(ps.Page(2,30).getEnd());
		System.out.println(ps.Page(2,30).getPageNum());	
		System.out.println(ps.Page(2,30).getPageSize());	
		System.out.println(ps.Page(2,30).getStart());	
		System.out.println(ps.Page(2,30).getStartIndex());	
		System.out.println(ps.Page(2,30).getTotalPage());
		System.out.println(ps.Page(2,30).getTotalRecord());
	}
}
