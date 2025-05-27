import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class _2775 {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[][] hotel = new int[15][15];

        for(int i=0;i<15;i++){
            hotel[0][i]=i;
        }

        for(int r=1;r<15;r++){
            for(int c=1;c<15;c++){
                hotel[r][c]+=hotel[r][c-1]+hotel[r-1][c];
            }
        }

        int T=Integer.parseInt(br.readLine());

        while(T-->0){
            int k=Integer.parseInt(br.readLine());
            int n=Integer.parseInt(br.readLine());
            System.out.println(hotel[k][n]);
        }
    }
}
