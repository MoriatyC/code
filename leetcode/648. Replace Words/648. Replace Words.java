public class Solution {
    class trie {
        trie[] children;
        char value;
        boolean flag;
        String word;
        public trie(char value) {
            this.value = value;
            children = new trie[26];
            flag = false;
        }
        public trie() {
            children = new trie[26];
            flag = false;
        }
    }
    public String replaceWords(List<String> dict, String sentence) {
        trie root = new trie();
        trie cur;
        for (String word: dict) {
            cur = root;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                if (cur.children[c - 'a'] == null) {
                    cur.children[c - 'a'] = new trie(c);
                }
                cur = cur.children[c - 'a'];
            }
            cur.flag = true;   
            cur.word = word;
        }
        String[] words = sentence.split("\\s");
        StringBuilder sb = new StringBuilder();
        for (String word: words) {
            cur = root;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                if (cur.children[c - 'a'] == null) {
                    sb.append(word + " ");
                    break;
                } else {
                    cur = cur.children[c - 'a'];
                    if (cur.flag == true) {
                        sb.append(cur.word + " ");
                        break;
                    }
                    if (i == word.length() - 1) {
                        sb.append(word + " ");
                        break;
                    }
                }
            }
        }
        return sb.substring(0, sb.length() - 1);
    }
}