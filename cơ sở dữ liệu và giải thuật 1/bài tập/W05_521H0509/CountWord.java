import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class CountWord {
    public static void WordCount(File file) throws Exception {

        BufferedReader br = new BufferedReader(new FileReader(file));

        String str;

        str = br.readLine();
        Map<String, Integer> hashMap = new HashMap<>();

        String[] words = str.split(" ");

        for (String word : words) {
            Integer integer = hashMap.get(word);
            if (integer == null)

                hashMap.put(word, 1);

            else {

                hashMap.put(word, integer + 1);
            }
        }
        System.out.println(hashMap);
    }

    public static void main(String[] args) throws Exception {
        File file = new File("test.txt");
        WordCount(file);

    }
}