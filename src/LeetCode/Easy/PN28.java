package LeetCode.Easy;

public class PN28 {

    public static void main(String[] args) {
        System.out.println(strStr2("a", "a"));
        // System.out.println(strStr2("mississippi", "issip"));
    }

    public static int strStr2(String haystack, String needle) {

        int hLen = haystack.length();
        int nLen = needle.length();

        if (nLen == 0)
            return 0;
        if (hLen < nLen)
            return -1;

        for (int i = 0; i <= hLen - nLen; i++) {
            int j = 0;

            while (j < nLen && haystack.charAt(i + j) == needle.charAt(j)) {
                j++;
            }

            if (j == nLen) {
                return i;
            }
        }

        return -1;
    }

    public static int strStr(String haystack, String needle) {

        if (haystack.isEmpty() || needle.isEmpty())
            return -1;
        if (haystack.length() < needle.length())
            return -1;

        int haystackPointer = 0;
        int needlePointer = 0;

        int size = haystack.length();

        while (haystackPointer < size) {

            if (haystack.charAt(haystackPointer) == needle.charAt(0)) {
                needlePointer = 0;
                while (needlePointer < needle.length()) {
                    if (haystackPointer + needlePointer >= haystack.length()) {
                        return -1;
                    }

                    if (haystack.charAt(haystackPointer + needlePointer) == needle.charAt(needlePointer)) {
                        needlePointer++;
                    } else {
                        break;
                    }
                }

                if (needlePointer >= needle.length()) {
                    return haystackPointer;
                }
            }

            haystackPointer++;

            System.out.println("haystackPointer: " + haystackPointer + " needlePointer: " + needlePointer);
        }

        System.out.println("Not found");
        return -1;
    }
}
