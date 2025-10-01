class Solution {
    long answer=0;
    int maxIdx;
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        move(cap,n,deliveries,pickups);
        return answer;
    }
    void move(int cap,int n,int[] deliveries,int[] pickups){
        maxIdx=n-1;
        while(true){
            int flag=0;
            //뒤에서 부터 일 할거 있는지 확인
            for(int i=maxIdx;i>=0;i--){
                if(deliveries[i]!=0 || pickups[i]!=0){
                    maxIdx=i;
                    answer+=(i+1)*2;
                    flag=1;
                    break;
                }
            }
            //택배 배달하기
            int curD=cap;
            for(int i=maxIdx;i>=0;i--){
                if(deliveries[i]!=0){
                    if(deliveries[i]<=curD){
                        curD-=deliveries[i];
                        deliveries[i]=0;
                    }
                    else{
                        deliveries[i]-=curD;
                        curD=0;
                    }
                    if(curD==0){
                        break;
                    }
                }
            }
            //수거하기
            curD=cap;
            for(int i=maxIdx;i>=0;i--){
                if(pickups[i]!=0){
                    if(pickups[i]<=curD){
                        curD-=pickups[i];
                        pickups[i]=0;
                    }
                    else{
                        pickups[i]-=curD;
                        curD=0;
                    }
                    if(curD==0){
                        break;
                    }
                }
            }
            if(flag==0) break;
        }
        
    }
}