class Solution {
    public String addBinary(String a, String b) {
        StringBuilder result = new StringBuilder();
        
        int i = a.length() - 1; // pointer for a (right se)
        int j = b.length() - 1; // pointer for b (right se)
        int carry = 0;
        
        while (i >= 0 || j >= 0 || carry != 0) {
            int sum = carry;
            
            if (i >= 0) {
                sum += a.charAt(i) - '0'; // char ko int mein convert
                i--;
            }
            if (j >= 0) {
                sum += b.charAt(j) - '0';
                j--;
            }
            
            // current bit = sum % 2, carry = sum / 2
            result.append(sum % 2);
            carry = sum / 2;
        }
        
        // Humne result ko reverse order mein append kiya tha (right to left)
        // Isliye final answer reverse karna padega
        result.reverse();
        
        return result.toString();
    }
}