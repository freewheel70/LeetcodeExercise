package leetcode;

import java.util.HashMap;

/**
 * Created by Administrator on 2016/8/16.
 */
public class RansomNote {
    public boolean canConstruct(String ransomNote, String magazine) {
        HashMap<Character,Integer> map = new HashMap<>();
        for(int i=0;i<magazine.length();i++){
            Character c = magazine.charAt(i);
            if(map.containsKey(c)){
                map.put(c,map.get(c)+1);
            }else{
                map.put(c,1);
            }
        }

        for(int i =0 ;i < ransomNote.length();i++){
            Character c = ransomNote.charAt(i);
            if(map.containsKey(c)){
                int rest = map.get(c);
                if(rest<=0)
                    return false;
                else
                    map.put(c,rest-1);
            }else{
                return false;
            }
        }

        return true;
    }
}
