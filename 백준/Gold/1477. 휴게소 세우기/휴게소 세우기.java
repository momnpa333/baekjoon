import java.io.*;
import java.util.*;

public class Main {
    static int N,M,L;
    static ArrayList<Integer> pos;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());
        L=Integer.parseInt(st.nextToken());

        pos=new ArrayList<>();
        pos.add(0); pos.add(L);
        st=new StringTokenizer(br.readLine()," ");
        for(int i=0;i<N;i++){
            pos.add(Integer.parseInt(st.nextToken()));
        }
        Collections.sort(pos);

//        System.out.println(pos);

        int left = 1;
        int right = L;
        while(left <= right) {
            int mid = (left + right) / 2; //휴게소의 간격
            if(can_make(mid)) left = mid + 1;
            else right = mid - 1;
        }
        System.out.println(left);
    }
    public static boolean can_make(int mid) {
        int count = 0;
        for(int i = 1; i < pos.size(); i++) {
            count += (pos.get(i) - pos.get(i - 1) - 1) / mid;
        }
        if(count > M) return true;
        return false;
    }

}
