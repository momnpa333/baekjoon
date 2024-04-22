import java.util.Scanner;

public class _1110 {
    public static void main(String[] args) {
        // make a scanner
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        int cnt=0;
        int ans=num;
        do{
            int newNum=ans/10+ans%10;
            ans=newNum%10+(ans%10)*10;
            cnt+=1;
        }while (ans!=num);
        System.out.println(cnt);
    }
}