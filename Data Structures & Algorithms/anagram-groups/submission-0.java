class Solution {
      public List<List<String>> groupAnagrams(String[] strs) {

        Map<String, List<String>> map = new HashMap<>();

        for (String str : strs) {

          String sorted = getSortedString(str);
          List<String> list = map.getOrDefault(sorted, new ArrayList<>());
          list.add(str);
          map.put(sorted,list);
        }

        List<List<String>> sols = new ArrayList<>();

        for (List<String> list : map.values()) {

          sols.add(list);
        }

        return sols;
      }

      public String getSortedString(String str) {

        int[] counter = new int[26];

        for(int i = 0; i < str.length(); i++) {

          int num = (int) (str.charAt(i) - 'a');
          counter[num]++;
        }

        StringBuilder builder = new StringBuilder();


        for (int i = 0;i < 26; i++) {

          while(counter[i]-- > 0) {

            char ch = (char) (i + 'a');
            builder.append(ch);
          }
        }

        return builder.toString();
      }
    }