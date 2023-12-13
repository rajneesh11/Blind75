public class RemoveAlmostEqualCharacters {
    static int removeAlmostEqualCharacters(String w) {
        char[] word = w.toCharArray();
        int ans = 0;
        for (int i = 1; i < word.length; i++) {

            if (word[i] >= word[i - 1] && word[i] - word[i - 1] <= 1) {
                ans++;
                i++;
            } else if (word[i] < word[i - 1] && word[i - 1] - word[i] <= 1) {
                ans++;
                i++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        String word = "aaaaa"; // acaca
        System.out.println(removeAlmostEqualCharacters(word));
    }
}
