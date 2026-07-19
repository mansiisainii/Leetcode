class Solution {
    public String smallestSubsequence(String s) {
        int[] freq= new int[26];
        boolean[] seen = new boolean[26];
        Stack<Character> stack= new Stack<>();
        for(char ch: s.toCharArray()){
            freq[ch-'a']++;
        }
        for(char ch: s.toCharArray()){
            freq[ch-'a']--;
            if(seen[ch-'a']){
                continue;
            }
            while(!stack.isEmpty() && stack.peek()>ch && freq[(stack.peek()-'a')]>0){
                seen[stack.pop()-'a']=false;
            }
            stack.push(ch);
            seen[ch-'a']=true;
        }
        StringBuilder ans = new StringBuilder();
        while(!stack.isEmpty()){
            ans.append(stack.pop());

        }
        return ans.reverse().toString();
    }
}