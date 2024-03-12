import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int rlt = Integer.parseInt(st.nextToken()) + Integer.parseInt(st.nextToken());
            if (rlt == 0) break;
            bw.write(rlt + "\n");
            bw.flush();
        }
        br.close();
        bw.close();
    }
}