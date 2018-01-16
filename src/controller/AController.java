package controller;



import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import Dao.HDao;
import Vo.HVo;
import deal.DealStr;
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
	        String name = "ÕÅÐ¡ËÄ";
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
	public String gohnew(Model model ) throws Exception{
         HDao hd =new HDao();
   		List <HVo> list= hd.Hselect();
		 model.addAttribute("list", list);//hasmaplist {columnnum=1, label13=1, label12=2, label11=3}
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
