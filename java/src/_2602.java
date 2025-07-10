import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class _2602 {
    static char[] magic;
    static char[] devil;
    static char[] angel;
    static int[][] devilDp;
    static int[][] angelDp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        magic=br.readLine().toCharArray();
        devil=(" "+br.readLine()).toCharArray();
        angel=(" "+br.readLine()).toCharArray();
        devilDp=new int[magic.length][devil.length];
        angelDp=new int[magic.length][angel.length];

        for(int i=1;i<devil.length;i++){
            if(magic[0]==devil[i]){
                devilDp[0][i]=devilDp[0][i-1]+1;
            }
            else{
                devilDp[0][i]=devilDp[0][i-1];
            }
            if(magic[0]==angel[i]){
                angelDp[0][i]=angelDp[0][i-1]+1;
            }
            else{
                angelDp[0][i]=angelDp[0][i-1];
            }
        }

        for(int i=1;i< magic.length;i++) {
            for (int j = 1; j < devil.length; j++) {
                if (magic[i] == devil[j]) {
                    devilDp[i][j] = angelDp[i - 1][j - 1] + devilDp[i][j - 1];
                } else {
                    devilDp[i][j] = devilDp[i][j - 1];
                }
                if (magic[i] == angel[j]) {
                    angelDp[i][j] = devilDp[i - 1][j - 1] + angelDp[i][j - 1];
                } else {
                    angelDp[i][j] = angelDp[i][j - 1];
                }
            }
        }
        System.out.println(devilDp[magic.length-1][devil.length-1]+angelDp[magic.length-1][angel.length-1]);

    }

}
