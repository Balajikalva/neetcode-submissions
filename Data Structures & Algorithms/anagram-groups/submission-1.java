class Solution {

  public List<List<String>> groupAnagrams(String[] strs) {

    Map<String, List<String>> map = new HashMap<>();

    for (String str : strs) {

      String sortedString = getSortedForm(str);
      List<String> list = map.getOrDefault(sortedString, new ArrayList<>());

      list.add(str);
      map.put(sortedString, list);

    }

    return new ArrayList<>(map.values());
  }

  public String getSortedForm(String str) {

    int[] freq = new int[256];

    for (int i = 0; i < str.length(); i++) {

      int ind = str.charAt(i);
      freq[ind]++;
    }

    StringBuilder builder = new StringBuilder();

    for (int i = 0; i < freq.length; i++) {

      char ch = (char) i;
      int count = freq[i];

      while (count-- > 0) {
        builder.append(ch);
      }
    }

    return builder.toString();
  }
}