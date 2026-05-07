class Solution {
  public int[] topKFrequent(int[] nums, int k) {

    Map<Integer,Integer> frequency = new HashMap<>();
    int[] sol = new int[k];

    for (int num : nums) {
      int count = frequency.getOrDefault(num, 0);
      frequency.put(num, count + 1);
    }

    List<int[]> list = new ArrayList<>();

    for (Map.Entry<Integer,Integer> entry : frequency.entrySet()) {

      int[] temp = new int[2];
      temp[0] = entry.getKey();
      temp[1] = entry.getValue();
      list.add(temp);
    }

    Collections.sort(list, (a,b) -> b[1] - a[1]);

    for (int i = 0;i < k; i++) {
      sol[i] = list.get(i)[0];
    }

    return sol;

  }
}