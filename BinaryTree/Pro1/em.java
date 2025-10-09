public int solution(String s, int k) {
    int n = s.length();
    int count = 0;
    for (int len = k + 1; len <= n; len++) {
        for (int i = 0; i + len <= n; i++) {
            for (int j = 0; j + len <= n; j++) {
                if (i == j) continue;
                int di = 0;
                boolean valid = true;
                for (int x = 0; x < len; x++) {
                    if (s.charAt(i + x) != s.charAt(j + x)) {
                        di++;
                        if (di > 1 || x != k) {
                            valid = false;
                            break;
                        }
                    }
                }
                if (valid && di == 1) {
                    count++;
                }
            }
        }
    }
    return count;
}

////////////////////////////////////////////////////////

public int[] solution(int a, int b, int[] c) {
    int n = c.length;
    long tot = 0;
    for (int x : c) {
        tot += x;
    }
    long free = a - tot;
    long lim = (long) (n + 1) * Math.max(0, b - 1);
    if (free > lim) return new int[]{-1};
    int[] res = new int[a];
    int idx = 0;
    long left = free;
    int gap = Math.max(0, b - 1);
    for (int i = 0; i < n; i++) {
        int skip = (int) Math.min(gap, left);
        idx += skip;
        left -= skip;

        for (int j = 0; j < c[i]; j++) {
            res[idx++] = i + 1;
        }
    }
    return res;
}

//////////////////////////////////////////

