package com.attempt.select.controller;



import java.io.UnsupportedEncodingException;
import java.util.Collections;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.attempt.select.dao.SelectDao;
import com.attempt.select.dao.SelectDaoImpl;
import com.attempt.select.dao.SelectVx;
import com.attempt.select.vo.PageVo;
import com.attempt.select.vo.SelectVo;
import com.attempt.vo.newHvo;

import Bean.PageBean;
import Dao.HDao;
import Dao.HnewDao;
import Service.PageService;
import Vo.HVo;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import wx.attempt.select.jsonvo.CreateJson;
import wx.attempt.select.jsonvo.Jsonvo;

@Controller
public class selectcontroller {

	@RequestMapping("/selectcity")
	public String selectcity(Model model,HttpServletRequest request ) throws Exception{
		//解析点的是第几页
		System.out.println("456");//
		//先判断  city 有没有值 ；
		if (request.getParameter("city")!=null)
		{
			System.out.println("city 不为空 ");
			//在判断 是不是 有session 里面是不是有 selecinfo 
			if(request.getSession().getAttribute("selectinfo")==null)
			{
				System.out.println("第一次new ");
				//没有 session 第一次  需要new 对象 
				SelectVo svo = new SelectVo();
				svo.setCity((String)request.getParameter("city"));	
				request.getSession().setAttribute("selectinfo",svo );
			}else{
				//有session 了  说明里面已经有了  一个city ；
				 System.out.println("第二次了");
				String city  =  (String)request.getParameter("city");
				SelectVo svo=(SelectVo)request.getSession().getAttribute("selectinfo");
				String[] splitcity=svo .getCity() . split("#");
				int i = 0;
				for (String s :splitcity)
				{
					if (city .equals(s))
					{
						i ++;
					}
				
				}
				//证明 已有 列表里面没有这个city
				
			 if (i ==0)
			 {
				 svo.setCity(svo .getCity()+"#"+city );		 
			 }
				
			request.getSession().setAttribute("selectinfo",svo );	
			}
				
		}
		if (request.getParameter("position")!=null)
		{
			System.out.println("position 不为空 ");
			//在判断 是不是 有session 里面是不是有 selecinfo 
			if(request.getSession().getAttribute("selectinfo")==null)
			{
				System.out.println("第一次new ");
				//没有 session 第一次  需要new 对象 
				SelectVo svo = new SelectVo();
				svo.setPosition((String)request.getParameter("position"));	
				request.getSession().setAttribute("selectinfo",svo );
			}else{
				//有session 了  说明里面已经有了  一个city ；
				 System.out.println("第二次了");
				String position  =  (String)request.getParameter("position");
				SelectVo svo=(SelectVo)request.getSession().getAttribute("selectinfo");
			request.getSession().setAttribute("selectinfo",svo );	
			}
			
			
			
			
		}
		if (request.getParameter("salary")!=null)
		{
			System.out.println("salary 不为空 ");
			//在判断 是不是 有session 里面是不是有 selecinfo 
			if(request.getSession().getAttribute("selectinfo")==null)
			{
				System.out.println("第一次new ");
				//没有 session 第一次  需要new 对象 
				SelectVo svo = new SelectVo();
				Set<Integer> say = svo.getSalary();
				say .add(Integer.valueOf((String)request.getParameter("salary")));
				svo.setSalary(say);	
				request.getSession().setAttribute("selectinfo",svo );
			}else{
				//有session 了  说明里面已经有了  一个city ；
				 System.out.println("第二次了");
				String salary  =  (String)request.getParameter("salary");
				Integer salaryint = Integer.valueOf(salary);
				SelectVo svo=(SelectVo)request.getSession().getAttribute("selectinfo");
				Set<Integer> nsalary	=svo.getSalary();
				nsalary.add(salaryint);
				svo.setSalary(nsalary);
				
				
				
				//证明 已有 列表里面没有这个city
				
		
				
			request.getSession().setAttribute("selectinfo",svo );	
			}
				
		}
		
	//生成sql
		
		SelectVo svo=	(SelectVo)request.getSession().getAttribute("selectinfo");
		String  sql ="select * from lagou where 1=1 " ;
		if (svo.getCity()!=null)
		{
			// city 有#  
			String city = svo.getCity();
			String[] splitcity = city .split("#");
			System.out.println("splitsize "+splitcity.length);
		   for (int i = 0 ;i <splitcity.length;i++)
		   {
			   if (i ==0) {
				   sql = sql +"and city= "+  "\"" +  splitcity[i]+ "\"";
				   
			   }else 
			   {
				   sql = sql +" or city= "+"\""+ splitcity[i]+"\"";
			   }
			   
		   }
		
		}
		if (svo.getPosition()!=null)
		{
			String position = svo.getPosition();
			sql = sql + "and  position="+ position; 
		}
		
		
		if (!svo.getSalary().isEmpty())
		{
			// salary 冒泡 找最大最小
			Set<Integer> nsalary = svo.getSalary();
			System.out.println(nsalary);
			Integer minsalary = Collections.min(nsalary);
			Integer maxsalary = Collections.max(nsalary);
		         minsalary =minsalary-1;
		         maxsalary= maxsalary +2;//只加入了 最小值  最大值等于最小值+1
			   sql =   sql = sql +"and minslary< "+ minsalary+ " and maxslary >"+ maxsalary;
		   
		
		}
		System.out.println("city sql 为" +sql );
		// 拿 sql 去分页 ；
		//下面 是  放到 分页 里面 ！
		
		/*
		 * 
		 *  分页
		 */
		

		
		int page=1;
		if (request.getParameter("page")=="null")
		{
			//如果参数多 就需要考虑传值 Map 类型了 
			 SelectDaoImpl sDao = new SelectDaoImpl();
			  PageService pg = new PageService();
			PageVo pb=  pg .SelectPage(sql, page, 30);
				 model.addAttribute("pageBean", pb);
		}
		else {
			 SelectDaoImpl sDao = new SelectDaoImpl();
			 if (request.getParameter("page")==null)
			 {
					System.out.print("page=");
					System.out.println(1);
					PageService pg = new PageService();
					PageVo pb=  pg .SelectPage(sql,1, 30);
					System.out.println(pb);
//					System.out.println(pb.getList().get(1).getCompanyFullName());
						 model.addAttribute("pageBean", pb);
					
			 }
			 else {
			String s=request.getParameter("page");
			page=Integer.parseInt(s);
			System.out.print("page=");
			System.out.println(page);
			PageService pg = new PageService();
			PageVo pb=  pg .SelectPage(sql,page, 30);
			
//			System.out.println(pb.getList().get(3).getCompanshortname());
				 model.addAttribute("pageBean", pb);
			 }
		}
		
		
		
		
		
		//hasmaplist {columnnum=1, label13=1, label12=2, label11=3}
//		 model.addAttribute("json", stt.getjson());//json wenjian """"str"""""
		return "selectlist";
	}
	


	
	@RequestMapping("/cleansession")
	public String cleansession(Model model,HttpServletRequest request ) throws Exception{
		//解析点的是第几页
		
		request.getSession().removeAttribute("selectinfo");
		
		int page=1;
		if (request.getParameter("page")=="null")
		{
			//如果参数多 就需要考虑传值 Map 类型了 
			  HnewDao hd =new HnewDao();
			  PageService pg = new PageService();
			PageBean pb=  pg .Page(page, 30);
				 model.addAttribute("pageBean", pb);
		}
		else {
			 HnewDao hd =new HnewDao();
			 if (request.getParameter("page")==null)
			 {
					PageService pg = new PageService();
					PageBean pb=  pg .Page(1, 30);
						 model.addAttribute("pageBean", pb);
					
			 }
			 else {
			String s=request.getParameter("page");
			page=Integer.parseInt(s);
		
			PageService pg = new PageService();
			PageBean pb=  pg .Page(page, 30);
				 model.addAttribute("pageBean", pb);
			 }
		}

		return "hlistnew";
	}

	//微信 的接口 
	 @RequestMapping(value="/wxselect")  
	    @ResponseBody  
	    public Object  wxselect(HttpSession session){  
		 Object a = "123123";
		 JSONObject  obj = null;
		 Jsonvo jvo= new Jsonvo();
		 JSONArray scoreArr = new JSONArray();
	// 此处for 循环  打包 result VO	 
		 SelectVx sd = new SelectVx();
		 List<newHvo> nv =  sd.selectCity();
		 for (int i = 0 ; i < 11 ; i ++)
		 {
			 scoreArr .add(nv.get(i)) ; 
		 }
		 jvo.setResult(scoreArr);
	      obj = JSONObject.fromObject(jvo);
	     System.out.println(obj.toString());
	     try {
			a=   obj.toString().getBytes("UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			System.out.println("遗憾  异常了");
			e.printStackTrace();
		}
	        return a;  
	    }  
	 
	 @RequestMapping("/wxselect1")  
	    @ResponseBody  
	    public Object gogo(){  
	            Object a = "aadfsdf";
	        return a;  
	    }  
	
	 
	
	
}
