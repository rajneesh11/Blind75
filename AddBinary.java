/* 
 * Given two binary strings a and b, return their sum as a binary string.

 

Example 1:

Input: a = "11", b = "1"
Output: "100"
Example 2:

Input: a = "1010", b = "1011"
Output: "10101"
 */

public class AddBinary {
    static String addBinary(String a, String b) {
        int carry = 0, sum = 0;
        StringBuilder sb = new StringBuilder();
        int ai = a.length() - 1, bi = b.length() - 1;
        while (ai >= 0 || bi >= 0) {
            int aa = 0, bb = 0;
            if (ai >= 0) {
                aa = a.charAt(ai) - '0';
            }
            if (bi >= 0) {
                bb = b.charAt(bi) - '0';
            }
            ai--;
            bi--;

            sum = (aa ^ bb) ^ carry;
            carry = (aa & bb) | (carry & (aa ^ bb));
            sb.append(sum);
        }
        if (carry == 1)
            sb.append(carry);

        return sb.reverse().toString();

    }

    public static void main(String[] args) {
        String a = "11", b = "1";
        // 101100
        // 110110
        // 10111
        // 1001101
        System.out.println(addBinary(a, b));
    }
}
