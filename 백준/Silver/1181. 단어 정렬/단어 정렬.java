import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {
   public static void main(String[] args) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
      int T = Integer.parseInt(br.readLine());
      String[] strs = new String[T];
      for (int i = 0; i < T; i++) strs[i] = br.readLine();
      br.close();

	  for (int i = 0; i < T; i++) { //길이 순 정렬
          for (int j = i + 1; j < T; j++) {
              if (strs[i].length() > strs[j].length()) {
                  String temp = strs[i];
                  strs[i] = strs[j];
                  strs[j] = temp;
              }
          }
      }
      
      for (int i = 0; i < T; i++) { //사전 순 정렬렬
          for (int j = i + 1; j < T; j++) {
              if ((strs[i].length() == strs[j].length()) && (strs[i].compareTo(strs[j]) > 0)) {
                  String temp = strs[i];
                  strs[i] = strs[j];
                  strs[j] = temp;
              }
          }
      }
      
      for (int i = 0; i < T; i++) {
          if (i > 0 && strs[i].equals(strs[i - 1]) ) continue; //중복된 값 거르기기
          bw.write(strs[i] + "\n");
		  bw.flush();
      }
      bw.close();
   }
}