package controller;



import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.omg.CORBA.Request;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import Bean.PageBean;
import Dao.HDao;
import Dao.HnewDao;
import Service.PageService;
import Vo.HVo;
import Vo.newHvo;
import deal.Lagoujsondeal;

@Controller
public class AController {
//	@RequestMapping("/ago")
//	public ModelAndView ad(Avo b) throws Exception{
//		ModelAndView mv = new ModelAndView("b");
//		//mv.addObject("a", "name");
//		//mv.setViewName("b");
//		System.out.println(b.getName());
//		return mv;
//	}

//	@RequestMapping("/toweb_inf")
//	public ModelAndView toweb_inf( ) throws Exception{
//		System.out.println("111");
//		ModelAndView mv = new ModelAndView("addmessage");
//		//mv.addObject("a", "name");
//		//mv.setViewName("b");
//		return mv;
//	}

//	@RequestMapping("/gomain")
//	public String gomain(Model model ) throws Exception{
//		DealStr stt= new DealStr();
//		HashMap hashmap;
//		hashmap= stt .done();
////		System.out.println(hashmap);
//		 model.addAttribute("hs", hashmap);
//		return "tables";
//	}
	
	@RequestMapping("/chuanzhi")
	    public String chuanzhi(Model model){
	        String name = "张小四";
	        model.addAttribute("name", name);
	        return "s1";
	        
	    }
	
		@RequestMapping("/go1p")
		public ModelAndView go1p() throws Exception{
			System.out.println("111");
			ModelAndView mv = new ModelAndView("s1");
			//mv.addObject("a", "name");
			return mv;
		}
	
	@RequestMapping("/goh")
	public String goh(Model model ) throws Exception{
         HDao hd =new HDao();
   		List <HVo> list= hd.Hselect();
		 model.addAttribute("list", list);//hasmaplist {columnnum=1, label13=1, label12=2, label11=3}
//		 model.addAttribute("json", stt.getjson());//json wenjian """"str"""""
		return "hold";
	}
	@RequestMapping("/gohnew")
	public String gohnew(Model model,HttpServletRequest request ) throws Exception{
		//解析点的是第几页
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
					System.out.print("page=");
					System.out.println(1);
					PageService pg = new PageService();
					PageBean pb=  pg .Page(1, 30);
					System.out.println(pb);
					System.out.println(pb.getList().get(1).getCompanyFullName());
						 model.addAttribute("pageBean", pb);
					
			 }
			 else {
			String s=request.getParameter("page");
			page=Integer.parseInt(s);
			System.out.print("page=");
			System.out.println(page);
			PageService pg = new PageService();
			PageBean pb=  pg .Page(page, 30);
			
			System.out.println(pb.getList().get(3).getCompanshortname());
				 model.addAttribute("pageBean", pb);
			 }
		}
       //hasmaplist {columnnum=1, label13=1, label12=2, label11=3}
//		 model.addAttribute("json", stt.getjson());//json wenjian """"str"""""
		return "hlistnew";
	}
	
	
		@RequestMapping("/gomain1")
		public String gomain1(Model model ) throws Exception{
			Lagoujsondeal stt= new Lagoujsondeal();
			HashMap hashmap;
			hashmap= stt .gethslist();
			System.out.println(hashmap);
			 model.addAttribute("hs", hashmap);//hasmaplist {columnnum=1, label13=1, label12=2, label11=3}
			 model.addAttribute("json", stt.getjson());//json wenjian """"str"""""
			return "maintables";
		}
}
