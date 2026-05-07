class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        

        int[] sol = new int[temperatures.length];

        Stack<Integer> stk = new Stack<>();

        for (int i = 0;i < temperatures.length; i++) {

            int temp = temperatures[i];

            while(stk.isEmpty() == false && temp > temperatures[stk.peek()]) {

                int ind = stk.pop();
                sol[ind] = i - ind;
            }

            stk.push(i);
        }

        return sol;

        
    }
}
