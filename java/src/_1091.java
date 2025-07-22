import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _1091 {
    static int N;
    static int[] target;
    static int[] suffle;
    static int[] deck;
    static int[] origin;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N=Integer.parseInt(br.readLine());
        target=new int[N];
        suffle=new int[N];
        deck=new int[N];

        st=new StringTokenizer(br.readLine()," ");
        for(int i=0;i<N;i++){
            target[i]=Integer.parseInt(st.nextToken());
        }
        st=new StringTokenizer(br.readLine()," ");
        for(int i=0;i<N;i++){
            suffle[i]=Integer.parseInt(st.nextToken());
        }
        for(int i=0;i<N;i++){
            deck[i]=i;
        }

        origin= Arrays.copyOf(deck,deck.length);

        boolean flag=false;
        int cnt=0;

        while(true){
            if(isAnswer()){
                System.out.println(cnt);
                flag=true;
                break;
            }
            suffling();
            if(!isChanged()){
                System.out.println(-1);
                break;
            }
            cnt++;
        }


    }
    static void suffling(){
        int[] tmp=Arrays.copyOf(deck,deck.length);
        for(int i=0;i<N;i++){
            deck[suffle[i]]=tmp[i];
        }
    }
    static boolean isChanged(){
        for(int i=0;i<N;i++){
            if(origin[i]!=deck[i]){
                return true;
            }
        }
        return false;
    }
    static boolean isAnswer(){
        for(int i=0;i<N;i++){
            boolean flag=false;
            for(int j=target[i];j<N;j+=3){
                if(i==deck[j]){
                    flag=true;
                }
            }
            if(!flag){
                return false;
            }
        }
        return true;
    }

}
