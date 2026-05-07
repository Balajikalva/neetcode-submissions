class Solution {

     Map<Character,String> phoneBook = Map.of(
            '1',"",
            '2',"abc",
            '3', "def",
            '4', "ghi",
            '5', "jkl",
            '6', "mno",
            '7',"pqrs",
            '8',"tuv",
            '9',"wxyz",
            '0',"+"

        );

    List<String> sol = new ArrayList<>();

    public List<String> letterCombinations(String digits) {

        if (digits == null || digits.isEmpty()) return sol;
        helper(digits, new StringBuilder(), 0);

        return sol;
    }

    public void helper(String digits, StringBuilder builder, int ind) {

        if (ind == digits.length()) {

            sol.add(builder.toString());
            return;
        }

        for (char ch : phoneBook.get(digits.charAt(ind)).toCharArray()) {

            builder.append(ch);
            helper(digits, builder, ind + 1);
            builder.deleteCharAt(builder.length() - 1);
        }
    }
}
