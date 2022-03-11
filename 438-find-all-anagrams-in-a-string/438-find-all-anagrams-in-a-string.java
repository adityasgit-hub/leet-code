class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        int plen = p.length();
        int slen = s.length();
        if(plen > slen) {
            return new ArrayList<>();
        }
        List<Integer> ans = new ArrayList<>();
        for(int i=0;i<slen-plen+1;i++) {
            if(isAnagram(s, i, i+plen, p)) {
                ans.add(i);
            } 
        }
        
        return ans;
    }
    
    public boolean isAnagram(String s, int start, int end, String t) {
        int[] arr = new int[26];

        for(int i=start; i<end;i++) {
            arr[s.charAt(i)-'a']++;
            arr[t.charAt(i-start)-'a']--;
        }

        for(int v: arr) {
            if(v != 0) return false;
        }

        return true;
    }
}