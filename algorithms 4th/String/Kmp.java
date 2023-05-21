package String;

public class Kmp {

    public static void main(String[] args) {
        Kmp kmp = new Kmp();
        System.out.println(kmp.KMP("aabaabaaf", "baa"));
    }

    public static void getNext(int[] next, String s){ // 子串的前缀表
        int j = 0;
        next[0] = 0;
        for (int i = 1; i < s.length(); i++) {
            while (j > 0 && s.charAt(i) != s.charAt(j)){
                j = next[j - 1];
            }
            if (s.charAt(i) == s.charAt(j)){
                j++;
            }
            next[i] = j;
        }
    }

    public int KMP(String haystack, String needle){
        if (needle.length() == 0){
            return 0;
        }
        int[] next = new int[needle.length()];
        getNext(next,needle); // 获得子串的前缀表
        int j = 0;

        for (int i = 1; i < haystack.length(); i++) {
            while (j > 0 && haystack.charAt(i) != needle.charAt(j)){
                j = next[j - 1];
            }
            if (haystack.charAt(i) == needle.charAt(j)){
                j++;
            }
            if (j == needle.length()){
                return (i - needle.length() + 1);
            }
        }
        return -1;
    }

}
