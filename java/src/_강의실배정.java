import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class _강의실배정 {
    static int N;
    static int[][] classes;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N=Integer.parseInt(st.nextToken());


        classes=new int[N][2];

        for(int i=0;i<N;i++){
            st=new StringTokenizer(br.readLine());
            int S=Integer.parseInt(st.nextToken()); int F=Integer.parseInt(st.nextToken());
            classes[i][0]=S; classes[i][1]=F;
        }

        Arrays.sort(classes,((o1, o2) -> o1[1]==o2[1]?o1[0]-o2[0]:o1[1]-o2[1]));

        int prev=0; int answer=0;
        for(int i=0;i<N;i++){
            if(classes[i][0]>=prev){
                prev=classes[i][1];
                answer+=1;
            }
        }
        System.out.println(answer);
    }
}
