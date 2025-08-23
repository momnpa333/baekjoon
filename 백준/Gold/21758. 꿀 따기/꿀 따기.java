import java.io.*;
import java.util.*;

public class Main {

  public static void main(String[] args) throws IOException {
    //입력값 처리하는 BufferedReader
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    //결과값 출력하는 BufferedWriter
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    int n = Integer.parseInt(br.readLine());
    //각 칸의 대한 꿀 정보 저장
    int[] honey = new int[n+1];
    StringTokenizer st = new StringTokenizer(br.readLine()," ");
    for(int i=1;i<=n;i++){
      honey[i] = Integer.parseInt(st.nextToken());
    }
    //누적합 구하기
    int[][] sum = new int[2][n+2];
    for(int i=1;i<=n;i++){
      sum[0][i] = sum[0][i-1] + honey[i]; // →
      sum[1][n-i+1] = sum[1][n-i+2] + honey[n-i+1]; //←
    }
    int max = Integer.MIN_VALUE;
    //1. 벌통이 오른쪽 끝
    for(int i=2;i<=n-1;i++){
      int cur = (sum[0][n] - sum[0][1] - honey[i] ) + (sum[0][n] - sum[0][i]);
      max = Math.max(max, cur);
    }
    //2. 벌통이 왼쪽 끝
    for(int i=n-1;i>=2;i--){
      int cur = (sum[1][1] - sum[1][n] - honey[i] ) + (sum[1][1] - sum[1][i]);
      max = Math.max(max, cur);
    }
    //3. 벌통이 중간일 때
    for(int i=2;i<=n-1;i++){
      max = Math.max(max, (sum[0][i] - sum[0][1]) + (sum[1][i] - sum[1][n]));
    }
    //탐색을 통해 얻은 꿀의 최대양 BufferedWriter 저장
    bw.write(String.valueOf(max));
    bw.flush();		//결과 출력
    bw.close();
    br.close();
  }
}