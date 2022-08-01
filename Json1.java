import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.List;
import java.util.Map;

public class Json1 {

    public static void main(String[] args) throws Exception {

        BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\keti\\IdeaProjects\\jsonpassing\\bt_test1.json"));

        String str = "";
        String strResult = "";

        while ((str = reader.readLine()) != null) {
            strResult += str;
        }

        reader.close();

        System.out.println(strResult);

        System.out.println("------------------------------------------------------------------------------------------------------------------------");

        Gson gson = new Gson();

        Result1 result = gson.fromJson(strResult, Result1.class);

        System.out.println(result.toString());

        List<List<Map<String, Object>>> list = result.getData();
        for(List<Map<String, Object>> items : list){
            for(Map<String, Object> item : items){
                System.out.print(item.toString() + ", ");
            }
            System.out.println();
            System.out.println("-------------------------");
        }

    }
}

class Result1{
    Integer length;
    List<List<Map<String, Object>>> data;

    @Override
    public String toString() {
        return "Result{" +
                "length=" + length +
                ", data=" + data.size() +
                '}';
    }

    public Integer getLength() {
        return length;
    }

    public void setLength(Integer length) {
        this.length = length;
    }

    public List<List<Map<String, Object>>> getData() {
        return data;
    }

    public void setData(List<List<Map<String, Object>>> data) {
        this.data = data;
    }
}