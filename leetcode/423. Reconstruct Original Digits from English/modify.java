public String originalDigits(String s) {
        int[] table = new int[26];
        for(char c : s.toCharArray())table[c - 'a']++;
        int[] res = new int[10];
        String[] num = {"zro","o","wo","h","fou","fi","six","sv","igh","i"};
        char[] identity = {'z','w','x','g','h','u','f','s','i','o'};
        int [] order = {0,2,6,8,3,4,5,7,9,1};
        for(int i = 0; i < 10; i++){
        	res[order[i]] = table[identity[i] - 'a'];
        	for(char n : num[order[i]].toCharArray()){
				table[n - 'a'] -= res[order[i]];
			}
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < 10; i++){
        	for(int j = 0; j < res[i]; j++) sb.append(i);
        }
        return sb.toString();
    }