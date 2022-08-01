import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.List;

public class Json {

    class Result{
        Integer length;
        List<List<String>> data;

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

        public List<List<String>> getData() {
            return data;
        }

        public void setData(List<List<String>> data) {
            this.data = data;
        }
    }

    public static void main(String[] args) throws Exception {

        BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\keti\\IdeaProjects\\jsonpassing\\bt_test.json"));

        String str = "";
        String strResult = "";

        while ((str = reader.readLine()) != null) {
            strResult += str;
        }

        reader.close();

//        System.out.println(strResult);
//        System.out.println("------------------------------------------------------------------------------------------------------------------------");

        Gson gson = new Gson();

        Result result = gson.fromJson(strResult, Result.class);
//        System.out.println(result.toString());

        List<List<String>> list = result.getData();
        System.out.println("LAST DATA : "+list.get(0).toString());
        long cont = 0;
//        list << 이건 제이슨배열이들어있는 리스트
//        list.get(0) << 이것도 list지만 실질적인 제이슨 데이터가 들어있음.
//        key value로 던졌으면 list가아니라 vo or map이 들어갈수있는 부분임.

        for(List<String> items : list){
            cont++;
            for(String item : items){
                System.out.print(item.toString() + ", ");
            }
            System.out.println();
            System.out.println("-------------------------");
            System.out.println("카운트 : " + cont);

        }

    }
}

