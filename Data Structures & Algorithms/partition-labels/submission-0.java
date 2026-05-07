class Solution {
    public List<Integer> partitionLabels(String s) {

        List<Integer> sol = new ArrayList<>();
        
        int[] first = new int[26];
        int[] last = new int[26];

        Arrays.fill(first, -1);
        Arrays.fill(last, -1);

        for (int i = 0;i < s.length(); i++) {

            int num = s.charAt(i) - 'a';

            if (first[num] == -1) {

                first[num] = i;
            }

            last[num] = i;
        }

        List<int[]> intervals = new ArrayList<>();

        for (int i = 0;i < s.length(); i++) {

            int num = s.charAt(i) - 'a';
            intervals.add(new int[] {first[num], last[num]});
        }

        int[] max = intervals.get(0);

        for (int i = 1;i < intervals.size();i++) {

            int[] pres = intervals.get(i);

            if (max[1] > pres[0]) {

                max[1] = Math.max(max[1], pres[1]);
            }else {
                sol.add(max[1] - max[0] + 1);
                max = pres;
            }
        }

        sol.add(max[1] - max[0] + 1);
        return sol;
    }
}
