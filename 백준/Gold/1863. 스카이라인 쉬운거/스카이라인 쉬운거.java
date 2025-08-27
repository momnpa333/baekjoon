import java.io.*;
import java.sql.Array;
import java.util.*;

public class Main {
    static int N;
    static City[] cities;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Set<Integer> cur=new HashSet<>();
        ArrayDeque<Integer> stack=new ArrayDeque<>();
        int answer=0;
        N=Integer.parseInt(st.nextToken());
        cities=new City[N];
        for(int i=0;i<N;i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int A = Integer.parseInt(st.nextToken());
            int H = Integer.parseInt(st.nextToken());
            cities[i]=new City(A,H);
        }
        Arrays.sort(cities);

        for(int i=0;i<N;i++){
            int H=cities[i].h;
            if(H==0){
                cur=new HashSet<>();
                stack=new ArrayDeque<>();
                continue;
            }

//            System.out.println(cur);
//            System.out.println(H);

            if(!cur.contains(H)){
                while(!stack.isEmpty()){
                    int item=stack.pollLast();
                    cur.remove(item);
                    if(item<H){
                        stack.add(item);
                        cur.add(item);
                        break;
                    }
                }
                stack.add(H);
                cur.add(H);
                answer++;
//                System.out.println(answer);
            }
            else if(cur.contains(H)){
                while(!stack.isEmpty()){
                    int item=stack.pollLast();
                    cur.remove(item);
                    if(item==H){
                        stack.add(H);
                        cur.add(H);
                        break;
                    }
                }
            }
        }
        System.out.println(answer);
    }
    static class City implements Comparable<City>{
        int x;
        int h;
        City(int x,int h){
            this.x=x;
            this.h=h;
        }
        public int compareTo(City o){
            return this.x-o.x;
        }

    }
}
