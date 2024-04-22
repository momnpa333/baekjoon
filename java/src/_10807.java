import java.util.Scanner;

import java.util.Scanner;

public class _10807 {
    public static void main(String[] args) {
        // make a scanner
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        int ans=fivonacci(num);
        System.out.println(ans);

    }
    public static int fivonacci(int num){
        if(num==0){
            return 0;
        }else if(num==1){
            return 1;
        }else{
            return fivonacci(num-1)+fivonacci(num-2);
        }
    }
}
