import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer  st = new StringTokenizer(br.readLine());
        HashMap<Integer, Integer> hm = new HashMap<>();

        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());
            if (hm.containsKey(num)) 
                hm.replace(num, (hm.get(num) + 1));
            else hm.put(num, 1);
        }
        
        N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        br.close();

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int i = 0; i < N; i++) {   
            int num = Integer.parseInt(st.nextToken());
            if (hm.containsKey(num)) 
                bw.write(hm.get(num) + " ");
            else bw.write("0 ");
        }
        bw.flush();
        bw.close();
    }
}