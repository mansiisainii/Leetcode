class Solution {
    public int numberOfSpecialChars(String word) {
        int count=0;
        for(char ch='a';ch<='z';ch++){
            int smallIdx = word.indexOf(ch);
            int upperIdx = word.indexOf(Character.toUpperCase(ch));
            if(smallIdx!=-1 && upperIdx!=-1){
                count++;
            }
        }
        return count;
    }
}