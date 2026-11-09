package LeetCode.Hard;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

public class PN127 {

    public static void main(String[] args) {

        PN127 solution = new PN127();
        String beginWord = "hit";
        String endWord = "cog";
        List<String> wordList = new ArrayList<>(List.of("hot", "dot", "dog", "lot", "log", "cog"));
        int result = solution.ladderLength(beginWord, endWord, wordList);
        System.out.println(result);
    }

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {

        if (!wordList.contains(endWord))
            return 0;

        Map<String, List<String>> patterns = new HashMap<>();

        wordList.add(beginWord);
        for (String word : wordList) {
            char[] chars = word.toCharArray();

            for (int j = 0; j < chars.length; j++) {
                char originalChar = chars[j];

                chars[j] = '*';
                String pattern = new String(chars);

                patterns.computeIfAbsent(pattern, k -> new ArrayList<>()).add(word);

                chars[j] = originalChar;
            }
        }

        //

        Deque<String> deque = new ArrayDeque<>();
        HashSet<String> visited = new HashSet<>();

        deque.add(beginWord);
        visited.add(beginWord);
        int length = 0;

        while (!deque.isEmpty()) {

            int size = deque.size();

            for (int i = 0; i < size; i++) {
                String poll = deque.poll();

                if (poll.equals(endWord))
                    return length + 1;

                char[] chars = poll.toCharArray();

                for (int j = 0; j < chars.length; j++) {
                    char originalChar = chars[j];

                    chars[j] = '*';
                    String pattern = new String(chars);

                    for (String s : patterns.get(pattern))
                        if (!visited.contains(s)) {
                            deque.add(s);
                            visited.add(s);
                        }

                    chars[j] = originalChar;
                }
            }

            length++;
        }

        return 0;
    }
}
