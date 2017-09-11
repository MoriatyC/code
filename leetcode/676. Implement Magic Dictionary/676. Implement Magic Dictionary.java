class MagicDictionary {

    static class Trie {
        char letter;
        Trie[] children;
        boolean flag;
        public Trie(char letter) {
            flag = false;
            this.letter = letter;
            children = new Trie[26];
        }
        public Trie() {
            flag = false;
            children = new Trie[26];
        }
    }
    Trie root;
    /** Initialize your data structure here. */
    public MagicDictionary() {
        root = new Trie();
    }
    
    /** Build a dictionary through a list of words */
    public void buildDict(String[] dict) {
        Trie cur;
        for (String word: dict) {
            cur = root;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                if (cur.children[c - 'a'] == null) {
                    cur.children[c - 'a'] = new Trie(c);
                }
                cur = cur.children[c - 'a'];
            }
            cur.flag = true;
        }
    }
    
    /** Returns if there is any word in the trie that equals to the given word after modifying exactly one character */
    public boolean search(String word) {
        
        return relaxedSearch(root, word, 0, 0);
    }
    public boolean relaxedSearch(Trie root, String word, int count, int index) {
        boolean ret = false;
        if (index == word.length()) {//查询单词已完结，当前节点并不是一个单词，说明树中没这个单词
            if (root.flag == false || count == 0) {
                return false;
            }
            return true;
        }
        
        for (int i = 0; i < 26; i++) {
            int countcur = count;
            int indexcur = index;
            if (root.children[i] != null) {
                if (root.children[i].letter != word.charAt(indexcur)) {//当前字母和字典树节点字母不匹配
                    countcur++;
                    if (countcur > 1) {
                        continue;
                    }
                } 
                ret = ret || relaxedSearch(root.children[i], word, countcur, ++indexcur);
                if (ret) {
                    return true;
                }
            }
            
        }
       return ret;
    }

}

/**
 * Your MagicDictionary object will be instantiated and called as such:
 * MagicDictionary obj = new MagicDictionary();
 * obj.buildDict(dict);
 * boolean param_2 = obj.search(word);
 */