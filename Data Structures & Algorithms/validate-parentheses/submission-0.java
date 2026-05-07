class Solution {
    public boolean isValid(String s) {
        
        Stack<Character> stk = new Stack<>();

        Map<Character, Character> map = Map.of('}','{', ')', '(', ']', '[');

        for (int i = 0; i < s.length(); i++) {

            char ch = s.charAt(i);

            if (map.containsKey(ch)) {
                
                if (stk.isEmpty() || stk.pop() != map.get(ch)) return false;
            }else{
                stk.push(ch);
            }
        }

        return stk.isEmpty();
    }
}
