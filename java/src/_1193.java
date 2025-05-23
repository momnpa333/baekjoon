import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class _1193 {
    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw= new BufferedWriter(new OutputStreamWriter(System.out));

        int N=Integer.parseInt(br.readLine());

        bw.write(findDividedNum(N));
        bw.flush();
        bw.close();

    }
    private static int[] makeDividedNum(){
        int[] dividedNum=new int[10000];
        dividedNum[0]=0;

        for(int i=1;i<dividedNum.length;i++){
            dividedNum[i]=i+dividedNum[i-1];
        }

        return dividedNum;

    }

    private static String findDividedNum(int n){
        int[] rank= makeDividedNum();
        int phase=0; int sq=0; int up=0; int down=0;

//        for(int i=0;i<rank.length;i++){
//            System.out.println(rank[i]);
//        }

        for(int i=0;i<rank.length;i++){
            if(n<=rank[i]){
                phase=i; sq=n-rank[i-1]-1;
                break;
            }
        }
//        System.out.printf("%d %d\n",phase,sq);
        if(phase%2==0){
            up=1; down=phase;
            for(int i=0;i<sq;i++){
                up+=1; down-=1;
            }
        }
        else{
            up=phase; down=1;
            for(int i=0;i<sq;i++){
                up-=1; down+=1;
            }
        }

        return up+"/"+down;
    }
}
