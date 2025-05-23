import java.util.ArrayList;

public class _4673 {
    public static void main(String[] args){
        ArrayList<Integer> selfNumbers= new ArrayList<>();
        for(int i=1;i<10000;i++){
            if(checkSelf(i)){
                System.out.println(i);
            }
        }

    }
    private static boolean checkSelf(int num){
        for(int i=1;i<num;i++){
            if (func(i)==num) {
                return false;
            }
        }
        return true;
    }
    private static int func(int num){
        int ret=num;
        for(char value:Integer.valueOf(num).toString().toCharArray()){
            ret+=Character.getNumericValue(value);
        }
        return ret;
    }

}
