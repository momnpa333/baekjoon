import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _17611 {
    static int N;
    static Dot[] dots;
    static ArrayList<Line> row;
    static int[] cnt;
    static ArrayList<Line> col;
    static int rowAns,colAns;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N=Integer.parseInt(st.nextToken());
        row=new ArrayList<>();  col=new ArrayList<>();
        dots=new Dot[N];
        for(int i=0;i<N;i++){
            st=new StringTokenizer(br.readLine()," ");
            int c=Integer.parseInt(st.nextToken()); int r=Integer.parseInt(st.nextToken());
            dots[i]=new Dot(r,c);
        }

        for(int i=0;i<N;i++){
            if(dots[i].row==dots[(i+N-1)%N].row){
                int ma=Math.max(dots[i].col,dots[(i-1+N)%N].col);
                int mi=Math.min(dots[i].col,dots[(i-1+N)%N].col);
                col.add(new Line(mi,ma));
            }
            else{
                int ma=Math.max(dots[i].row,dots[(i-1+N)%N].row);
                int mi=Math.min(dots[i].row,dots[(i-1+N)%N].row);
                row.add(new Line(mi,ma));
            }
        }
        cnt=new int[1000002];

        for(Line l:row){
            cnt[l.start+500001]+=1;
            cnt[l.end+500001]-=1;
        }
        for(int i=1;i<=1000001;i++){
            cnt[i]+=cnt[i-1];
            rowAns=Math.max(rowAns,cnt[i]);
        }
        Arrays.fill(cnt,0);
        for(Line l:col){
            cnt[l.start+500001]+=1;
            cnt[l.end+500001]-=1;
        }
        for(int i=1;i<=1000001;i++){
            cnt[i]+=cnt[i-1];
            colAns=Math.max(colAns,cnt[i]);
        }

        System.out.println(Math.max(rowAns,colAns));
    }

    static class Line implements Comparable<Line>{
        int start;
        int end;
        Line(int s,int e){
            start=s;
            end=e;
        }
        public String toString(){
            return start+" "+end;
        }
        public int compareTo(Line o){
            if(this.start<o.start){
                return -1;
            }
            if(this.start==o.start){
                if(this.end<o.end){
                    return -1;
                }
            }
            return 1;
        }
    }
    static class Dot{
        int row;
        int col;
        Dot(int r,int c){
            row=r;
            col=c;
        }
    }


}
