import java.util.*;

class Anagrams {
    public List<List<String>>groupAnagrams(String[] strs){
        Map<String, List<String>>map = new HashMap<>();

        for(String word :strs){
            char[] chars = word.toCharArray();
            Arrays.sort(chars);
            String sortedKey = new String(chars);

            if(!map.containsKey(sortedKey)){
                map.put(sortedKey, new ArrayList<>());
            }
            map.get(sortedKey).add(word);
        }
        return new ArrayList<>(map.values());
    }
}
public class Question2{
    public static void main(String[] args) {
        Anagrams A = new Anagrams();

        String[] words = {"eat", "tea","tan","ate","nat","bat"};

        List<List<String>> result = A.groupAnagrams(words);
        System.out.println("Grouped Anagrams:");
        for(List<String>group:result){
            System.out.println(group);
        }
    }
}
