public class CountOccAnagrams {
    int search(String pat, String txt) {
        int txtl = txt.length();
        int patl = pat.length();
        int[] org_hash = new int[26];
        int[] mod_hash = new int[26];

        for (int i = 0; i < patl; i++) {
            char ch = pat.charAt(i);
            int id = ch - 'a';
            org_hash[id]++;
        }

        int i = 0;
        int j = 0;
        int res = 0;

        while (j < txtl) {
            int ind = txt.charAt(j) - 'a';
            mod_hash[ind]++;

            if (j - i + 1 < patl) {
                j++;
            } else if (j - i + 1 == patl) {
                // check anagram present
                boolean ispresent = true;
                for (int p = 0; p < patl; p++) {
                    int id = pat.charAt(p) - 'a';
                    if (org_hash[id] != mod_hash[id]) {
                        ispresent = false;
                        break;
                    }
                }
                if (ispresent) {
                    res++;
                }
                ind = txt.charAt(i) - 'a';
                mod_hash[ind]--;
                i++;
                j++;
            }

        }

        return res;
    }
}
