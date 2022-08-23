package Recursion;

public class DIString {
    public static void main(String[] args) {
        String str = "IIIDIDDD";
        boolean[] vis = new boolean[10];
        StringBuilder myStr = new StringBuilder();
        int[] len = {8};
        smallestNumber(str, vis, myStr, len);
        System.out.println(myStr);
    }

    static void smallestNumber(String str, boolean[] vis, StringBuilder myStr, int[] len) {

        if (len[0] < 0) return;

        for (int x=1; x<=9; x++) {
            if (myStr.isEmpty()) {
                myStr.append(x);
                vis[x] = true;
                len[0]--;
                smallestNumber(str, vis, myStr, len);
                return;
            }

            if (str.charAt(len[0]) == 'D') {
                //greater than the last guy and not visited
                if (x > Integer.parseInt(String.valueOf(myStr.charAt(myStr.length()-1))) && !vis[x]) {
                    myStr.append(x);
                    vis[x] = true;
                    len[0]--;
                    smallestNumber(str, vis, myStr, len);
                    return;
                }
            }

            if (str.charAt(len[0]) == 'I') {
                //smaller than the last guy and not visited
                if (x < Integer.parseInt(String.valueOf(myStr.charAt(myStr.length()-1))) && !vis[x]) {
                    myStr.append(x);
                    vis[x] = true;
                    len[0]--;
                    smallestNumber(str, vis, myStr, len);
                    return;
                }
            }
        }

    }
}
