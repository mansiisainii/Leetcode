class Solution {
    public int numberOfSpecialChars(String word) {
        int count=0;
        for(char ch='a';ch<='z';ch++){
            int lastLower = word.lastIndexOf(ch);
            int firstUpper = word.indexOf(Character.toUpperCase(ch));
            if(lastLower!=-1 && firstUpper!=-1 && lastLower < firstUpper){
                count++;
            }
        }
        return count;
    }
}