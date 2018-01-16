package deal;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

import com.google.gson.JsonArray;
import com.google.gson.JsonIOException;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;

public class Lagoujsondeal {
//old
	public HashMap gethslist() {
		JsonParser parse = new JsonParser();
		HashMap has= new HashMap();
	
		JsonObject json;
		try {
			json = (JsonObject)parse.parse(new FileReader("D:\\lagou.json"));
		int colnum = json.get("columnnum").getAsInt();
			has.put("columnnum", colnum);
			for (int i=1;i<colnum+1 ;i ++)
			{
				 for (int j =1 ;j<4;j++)
			         {
//				System.out.println("label"+i+j);
				int num = json.get("label"+i+j).getAsJsonObject().get("num").getAsInt();
				has .put("label"+i+j, num);
				
			            }
			} 
		} catch (JsonIOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonSyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	return has;	
	}
	public String getjson()
	{
	     String path ="D:\\";   // ����ļ�Ŀ¼��ĳ����·��  
	        File file = new File(path,"lagou.json");              //Ӳ��
	        FileReader fr = null;
			try {
				fr = new FileReader(file);
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}  //�ַ�������  
	        BufferedReader br = new BufferedReader(fr);  //ʹ�ļ��ɰ��ж�ȡ�����л��幦��  
	        StringBuffer strB = new StringBuffer();   //strB�����洢jsp.txt�ļ��������  
	        String str = null;
			try {
				str = br.readLine();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}  
	        while(str!=null){  
	            strB.append(str);   //����ȡ�����ݷ���strB  
	            try {
					str = br.readLine();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}  
	        }  
	        
	     
	       // System.out.println(a);
	        try {
				br.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
		
		return strB.toString();
	}
	
	public static void main(String[] args) {
		Lagoujsondeal l=new Lagoujsondeal();
HashMap h=l.gethslist();
System.out.println(h);
System.out.println(l .getjson()); 	
	}
}
		
		
		
		//		JsonParser parse = new JsonParser();
//		HashMap has= new HashMap();
//	
//		try {
//			JsonObject json = (JsonObject)parse.parse(new FileReader("D:\\lagou.json"));
//		System.out.println("label11num=  "+json.get("label11").getAsJsonObject().get("num").getAsString());
//		JsonArray jsa=json.get("label11").getAsJsonObject().get("everyone").getAsJsonArray();
//		
//		System.out.println(jsa.size());
//		for  (int i =0 ;i <jsa.size();i++)
//		{
//			
//			   JsonObject sub=jsa.get(i).getAsJsonObject();
//			System.out.println("labename+"+ sub.get("labename").getAsString());
//			System.out.println("conpnicname+"+ sub.get("conpnicname").getAsString());
//			System.out.println("todo+"+ sub.get("todo").getAsString());
//			System.out.println("id+"+ sub.get("id").getAsString());
//		}
//		
//		
//		} catch (JsonIOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (JsonSyntaxException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (FileNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}

