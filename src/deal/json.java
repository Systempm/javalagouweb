package deal;

import java.io.FileNotFoundException;
import java.io.FileReader;
 
import com.google.gson.JsonArray;
import com.google.gson.JsonIOException;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;
 
public class json {
    public static void main(String args[]){
        JsonParser parse =new JsonParser();  //创建json解析器
        try {
            JsonObject json=(JsonObject) parse.parse(new FileReader("D:\\jsonn.json"));  //创建jsonObject对象
            System.out.println("resultcode:"+json.get("resultcode").getAsInt());  //将json数据转为为int型的数据
            System.out.println("reason:"+json.get("reason").getAsString());     //将json数据转为为String型的数据
             
            JsonObject result=json.get("result").getAsJsonObject();
            JsonObject today=result.get("today").getAsJsonObject();
            System.out.println("temperature:"+today.get("temperature").getAsString());
            System.out.println("weather:"+today.get("weather").getAsString());
             
        } catch (JsonIOException e) {
            e.printStackTrace();
        } catch (JsonSyntaxException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}