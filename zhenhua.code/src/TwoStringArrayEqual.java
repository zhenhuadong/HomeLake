import java.util.Objects;

public class TwoStringArrayEqual {
    public static void main(String[] args){
        String[] word1 = {"ab", "c"};
        String[] word2 = {"a", "bc"};
        System.out.println(arrayStringsAreEqual(word1, word2));
    }

    public static boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        String str1=String.join("", word1);
        String str2=String.join("",word2);
        return Objects.equals(str1, str2);
    }
}
