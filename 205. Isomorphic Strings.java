public class Solution {
    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) return false;
        
        HashMap<Character, Character> sToT = new HashMap<>();
        HashMap<Character, Character> tToS = new HashMap<>();
        
        for (int i = 0; i < s.length(); i++) {
            char from = s.charAt(i), to = t.charAt(i);
            
            if ((sToT.containsKey(from) && sToT.get(from) != to) ||
                (tToS.containsKey(to) && tToS.get(to) != from)) {
                return false;
            }
            
            sToT.put(from, to);
            tToS.put(to, from);
        }
        
        return true;
    }
}
