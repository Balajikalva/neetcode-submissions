class Solution {

    List<String> sol;

    public List<String> generateParenthesis(int n) {

        sol = new ArrayList<>();
        
        helper(0, 0, 2* n, new StringBuilder());
        return sol;

    }

    public void helper(int open, int close, int len, StringBuilder builder) {

        if (open + close == len) {

           if (open == close) {

             sol.add(builder.toString());
           }

           return;
        }

        // choosing open

        if (open < len - close) {

            builder.append('(');
            helper(open + 1, close, len, builder);
            builder.deleteCharAt(open + close);

        }

        // choosing close

        if (close < open) {

            builder.append(')');
            helper(open, close + 1, len, builder);
            builder.deleteCharAt(open + close);
        }

        return;


    }
}
