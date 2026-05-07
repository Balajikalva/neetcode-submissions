class Solution {
    public int leastInterval(char[] tasks, int n) {
        
        int[] counter = new int[26];
        int[] lastPicked = new int[26];

        Arrays.fill(lastPicked, -1);

        int total = tasks.length;
        int days = 0;

        for (char ch : tasks) {

            counter[ch - 'A']++;
        }

        while(total > 0) {

            int pickedIndex = -1;
            int max = 0;

            for (int i = 0;i < 26;i++) {

                if (lastPicked[i] == -1 || lastPicked[i] < days + 1 - n) {

                    if (max < counter[i]) {
                        max = counter[i];
                        pickedIndex = i;
                    }
                }
            }

            if (max != 0) {
                total--;
                counter[pickedIndex]--;
                lastPicked[pickedIndex] = days + 1;
            }

            days++;
        }


        return days;
    }
}
