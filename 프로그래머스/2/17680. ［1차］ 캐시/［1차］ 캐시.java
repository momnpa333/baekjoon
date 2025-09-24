import java.util.*;

class Solution {
    ArrayList<String> cache;
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        
        cache=new ArrayList<String>();
        
        for(int i=0;i<cities.length;i++){
            String city=cities[i].toLowerCase();
            if(cache.contains(city)){
                answer+=1;
                cache.remove(city);
                cache.add(city);
            }
            else{
                answer+=5;
                cache.add(city);
                if(cache.size()>cacheSize){
                    cache.remove(0);
                }
            }
        }
        return answer;
    }
}