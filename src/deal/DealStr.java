package deal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.ResourceBundle;
public class DealStr {
   
	ResourceBundle res = ResourceBundle.getBundle("a");
	public String[]  splitstr(String  node )
	{
	
		
		
		String allstr=res.getString(node);
		
		String[] a= allstr.split("#");
	
		return  a;
	}
	
	public HashMap done()
	{
		 HashMap<String,String[]> mp = new HashMap<String,String[]>();
		 DealStr a  = new DealStr();
	 for (int i =1 ; i <8;i++) {
		 for (int j =0;j <3;j++)
		 {
		String	spstr[]= a.splitstr("label"+i+j);
		
			  mp.put("label"+i+j, a.splitstr("label"+i+j));

		 } 
	 }
	 return mp;
	 }
		
		
	
	
	 public static void main(String[] args) {
		 HashMap<String,String[]> mp = new HashMap<String,String[]>();
		 DealStr a  = new DealStr();
	 for (int i =1 ; i <8;i++) {
		 for (int j =0;j <3;j++)
		 {
		String	spstr[]= a.splitstr("label"+i+j);
		
			  mp.put("label"+i+j, a.splitstr("label"+i+j));

		 } 
	 
	 }
		 System.out.println(mp);
		
		
	 }
	
		 

}
