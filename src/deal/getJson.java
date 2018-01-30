package deal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ConnectException;
import java.net.HttpURLConnection;
import java.net.URL;

import net.sf.json.JSONObject;

public class getJson {

	 public static void main(String[] args) {
		 getJson gt =new getJson();
		String url = "http://localhost:8080/Lagou/wxselect";
		JSONObject Json=	 gt.httpRequest(url, "POST", "asda");
	System.out.println(Json .toString());
	 }

	    /**  
	     * ����http���󲢻�ȡ���  
	     *   
	     * @param requestUrl �����ַ  
	     * @param requestMethod ����ʽ��GET��POST��  
	     * @param outputStr �ύ������  
	     * @return JSONObject(ͨ��JSONObject.get(key)�ķ�ʽ��ȡjson���������ֵ)  
	     */    
	    public JSONObject httpRequest(String requestUrl, String requestMethod, String outputStr) {    
	        JSONObject jsonObject = null;    
	        StringBuffer buffer = new StringBuffer();  
	        InputStream inputStream=null;  
	        try {  
	            URL url = new URL(requestUrl);  
	            HttpURLConnection httpUrlConn = (HttpURLConnection) url.openConnection();    
	            httpUrlConn.setDoOutput(true);    
	            httpUrlConn.setDoInput(true);    
	            httpUrlConn.setUseCaches(false);  
	            // ��������ʽ��GET/POST��    
	            httpUrlConn.setRequestMethod(requestMethod);    
	            if ("GET".equalsIgnoreCase(requestMethod))    
	                httpUrlConn.connect();    
	    
	            // ����������Ҫ�ύʱ    
	            if (null != outputStr) {    
	                OutputStream outputStream = httpUrlConn.getOutputStream();    
	                // ע������ʽ����ֹ��������    
	                outputStream.write(outputStr.getBytes("UTF-8"));    
	                outputStream.close();    
	            }  
	            //�����ص�������ת�����ַ���    
	            inputStream = httpUrlConn.getInputStream();    
	            InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "utf-8");    
	            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);    
	    
	            String str = null;    
	            while ((str = bufferedReader.readLine()) != null) {    
	                buffer.append(str);    
	            }    
	            bufferedReader.close();    
	            inputStreamReader.close();    
	            // �ͷ���Դ    
	            inputStream.close();    
	            inputStream = null;    
	            httpUrlConn.disconnect();    
	          jsonObject = JSONObject.fromObject(buffer.toString());  
	        } catch (ConnectException ce) {    
	              ce.printStackTrace();  
	              System.out.println("Weixin server connection timed out");  
	        } catch (Exception e) {    
	               e.printStackTrace();  
	               System.out.println("http request error:{}");  
	        }finally{  
	            try {  
	                if(inputStream!=null){  
	                    inputStream.close();  
	                }  
	            } catch (IOException e) {  
	                // TODO Auto-generated catch block  
	                e.printStackTrace();  
	            }  
	        }   
	        return jsonObject;    
	    }    
	
}
