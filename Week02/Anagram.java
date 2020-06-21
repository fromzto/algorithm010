public class Anagram {

    /*
     * 判断两个字符串是否是异味字符串
     *
    */
    public boolean isAnagram(String s, String t) {
        
        if (s.length() != t.length()) {
            return false;
        } 

        int arr[] = new int[26];
        for (int i = 0;i < s.length(); i++) {
            int index = (int) s.charAt(i) - (int) 'a';
            arr[index] = arr[index] + 1;
        }

        for (int i = 0;i < t.length();i++) {
            int index = (int) t.charAt(i) - (int) 'a';
            arr[index] = arr[index] - 1;
            if (arr[index] < 0) {
                return false;
            }
        }

        for (int i = 0;i < arr.length;i++) {
            if (arr[i] != 0) {
                return false;
            }
        }

        return true;
    }
}
