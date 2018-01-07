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
        JsonParser parse =new JsonParser();  //����json������
        try {
            JsonObject json=(JsonObject) parse.parse(new FileReader("D:\\jsonn.json"));  //����jsonObject����
            System.out.println("resultcode:"+json.get("resultcode").getAsInt());  //��json����תΪΪint�͵�����
            System.out.println("reason:"+json.get("reason").getAsString());     //��json����תΪΪString�͵�����
             
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