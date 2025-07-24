import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Objects;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class _21939 {
    static int N;
    static int M;
    static TreeSet<Problem> problems;
    static Problem[] problemAry;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        problems=new TreeSet<>();
        problemAry=new Problem[10_000_001];

        N=Integer.parseInt(st.nextToken());

        for(int i=0;i<N;i++){
            st=new StringTokenizer(br.readLine()," ");
            int num,l;
            num=Integer.parseInt(st.nextToken());
            l=Integer.parseInt(st.nextToken());
            Problem p=new Problem(num,l);
            problems.add(p);
            problemAry[num]=p;
        }
        M=Integer.parseInt(br.readLine());
        for(int i=0;i<M;i++){
            String op=br.readLine();
            solve(op);
        }


    }
    static void solve(String op){
        String[] oper=new String[3];
        int cnt=0;
        for(String s:op.split(" ")){
            oper[cnt++]=s;
        }
        if(Objects.equals(oper[0], "recommend")){
            if(Objects.equals(oper[1], "1")){
                System.out.println(problems.last());
            }
            else{
                System.out.println(problems.first());
            }
        }
        if(Objects.equals(oper[0], "solved")){
            problems.remove(problemAry[Integer.parseInt(oper[1])]);
            problemAry[Integer.parseInt(oper[1])]=null;
        }
        if(Objects.equals(oper[0], "add")){
            int num=Integer.parseInt(oper[1]);
            int l=Integer.parseInt(oper[2]);
            if(problemAry[num]!=null){
                problemAry[num].lev=l;
            }
            else{
                Problem p=new Problem(num,l);
                problems.add(p);
                problemAry[num]=p;
            }
        }

    }

    static class Problem implements Comparable<Problem>{
        int num;
        int lev;
        Problem(int num,int lev){
            this.num=num;
            this.lev=lev;
        }
        public int compareTo(Problem o){
            if(this.lev>o.lev){
                return 1;
            }
            else{
                if(this.lev==o.lev){
                    return this.num-o.num;
                }
                return -1;
            }

        }
        public String toString(){
            return Integer.toString(this.num);
        }
    }

}
