import java.io.*;
import java.util.*;

public class Main {
    static int N,M,T;
    static Circle[] circles;
    static int[][] op;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());
        T=Integer.parseInt(st.nextToken());

        circles=new Circle[N+1];
        op=new int[T][3];
        for(int i=1;i<=N;i++){
            st=new StringTokenizer(br.readLine()," ");
            circles[i]=new Circle(M);
            for(int j=0;j<M;j++){
                circles[i].numbers[j]=Integer.parseInt(st.nextToken());
            }
        }
        for(int i=0;i<T;i++){
            st=new StringTokenizer(br.readLine()," ");
            op[i][0]=Integer.parseInt(st.nextToken());
            op[i][1]=Integer.parseInt(st.nextToken());
            op[i][2]=Integer.parseInt(st.nextToken());
        }

        for(int i=0;i<T;i++){
            play(op[i][0],op[i][1],op[i][2]);
//            for(int j=1;j<=N;j++){
//                System.out.println(circles[j]);
//            }
        }

        int answer=0;
        for(int i=1;i<=N;i++){
            for(int j=0;j<M;j++){
                if(circles[i].numbers[j]!=0){
                    answer+=circles[i].numbers[j];
                }
            }
        }
        System.out.println(answer);
    }
    static void play(int x,int d,int k){
        for(int i=x;i<=N;i+=x){
            for(int j=0;j<k;j++){
                circles[i].rotate(d);
            }
        }
        remove();
    }
    static void remove(){
        Set<String> removeSet=new HashSet<>();
        for(int i=1;i<=N;i++){
            if(i-1>0){
                for(int j=0;j<M;j++){
                    if(circles[i].numbers[j]!=0 && circles[i].numbers[j]==circles[i-1].numbers[j]){
                        removeSet.add(i+" "+j);
                        removeSet.add(i-1+" "+j);
                    }
                }
            }
        }
        for(int i=1;i<=N;i++){
            for(int j=0;j<M;j++){
                if(circles[i].numbers[j]!=0 && circles[i].numbers[j]==circles[i].numbers[(M+j-1)%M]){
                    removeSet.add(i+" "+j);
                    removeSet.add(i+" "+(M+j-1)%M);
                }
            }
        }
        if(removeSet.isEmpty()){
            changeNum();
        }
        for(String remove:removeSet){
            String[] tmp=remove.split(" ");
            int n=Integer.parseInt(tmp[0]);
            int m=Integer.parseInt(tmp[1]);
            circles[n].numbers[m]=0;
        }

    }
    static void changeNum(){
        int sum=0;
        int total=0;
        for(int i=1;i<=N;i++){
            for(int j=0;j<M;j++){
                if(circles[i].numbers[j]!=0){
                    sum+=circles[i].numbers[j];
                    total++;
                }
            }
        }
        float avg= (float) sum /total;
//        System.out.println(avg);

        for(int i=1;i<=N;i++){
            for(int j=0;j<M;j++){
                if(circles[i].numbers[j]!=0){
                    if(circles[i].numbers[j]>avg){
                        circles[i].numbers[j]-=1;
                    }
                    else if(circles[i].numbers[j]<avg){
                        circles[i].numbers[j]+=1;
                    }
                }
            }
        }
    }


    static class Circle{
        int[] numbers;
        Circle(int m){
            numbers=new int[m];
        }
        void rotate(int d){
            int tmp;
            if(d==0){
                tmp=numbers[numbers.length-1];
                for(int i=numbers.length-1;i>0;i--){
                    numbers[i]=numbers[i-1];
                }
                numbers[0]=tmp;
            }
            if(d==1){
                tmp=numbers[0];
                for(int i=0;i<numbers.length-1;i++){
                    numbers[i]=numbers[i+1];
                }
                numbers[numbers.length-1]=tmp;
            }
        }

        public String toString(){
            String ret="";
            for(int i=0;i<numbers.length;i++){
                ret+=numbers[i]+" ";
            }
            return ret;
        }
    }
}
