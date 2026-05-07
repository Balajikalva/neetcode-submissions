class Solution {

    public String encode(List<String> strs) {

        StringBuilder builder = new StringBuilder();

        for (String s : strs) {

            int len = s.length();
            builder.append(len);
            builder.append("#");
            builder.append(s);
            
        }

        System.out.println(String.format("decoded string : %s", builder));

        return builder.toString();
    }

    public List<String> decode(String str) {

        List<String> list = new ArrayList<>();

        int ind = 0;

        StringBuilder builder = new StringBuilder();

        while(ind < str.length()) {

            int len = 0;

            while(ind < str.length() && str.charAt(ind) != '#') {

                int num = (int) (str.charAt(ind) - '0');
                len *= 10;
                len += num;

                ind++;
            }

            ind++;

            while(len-- > 0) {

                builder.append(str.charAt(ind));
                ind++;
            }

            
            list.add(builder.toString());
            builder.setLength(0);
        }

        return list;
    }
}