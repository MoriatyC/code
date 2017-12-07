int[] tmp = new int[length];
        Arrays.fill(tmp, -1);
        for (int i = 0; i < length; i++) {
            int cur = numbers[i];
            if (tmp[cur] != -1) {
                duplication[0] = cur;
                return true;
            } else {
                tmp[cur] = cur;
            }
        }
        return false;