import java.util.HashSet;
import java.util.Set;

public class SmallQuestions {

    public static void main(String[] args){
       // System.out.println(isCanConstruct("abbaaaaa"));
        int[] arr = {1,2,3,4,14,20};
        System.out.println(numOfEquals(arr,-1,0));
    }

    /**
     * Given a word of length n, and n six-sided dice with a character in each side,
     * find out if this word is constructible by the set of given dice
     *
     * Solution: put dice letters in set. then add to set each word letter and see if size growth
     */
    public static boolean isCanConstruct(String word){
        Set<Character> diceSet = new HashSet<>();
        char dice[] = {'a','b','f','y','t','e'};
        for(int i = 0; i < 6; i ++){
            diceSet.add(dice[i]);
        }
        int diceSetLen = diceSet.size();
        for(int i = 0; i < word.length(); i++){
            diceSet.add(word.charAt(i));
            if(diceSet.size() > diceSetLen)
                return false;
        }
        return true;
    }

    public static int numOfEquals(int[] arr,int idx,int found){
        if(idx >= arr.length)
            return found;
        if(numOfEquals(arr,idx+1,found) + numOfEquals(arr,idx+2,found) + numOfEquals(arr,idx+3,found)
                + numOfEquals(arr,idx+4,found)
                == arr[idx + 4])
        found ++;
        return found;
    }
}
