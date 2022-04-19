import java.util.ArrayList;
import java.util.List;

public class Dictionary {
    public static List<Word> wordInDictionary = new ArrayList<Word>();

    public void addWord(Word word) {
        wordInDictionary.add(word);
    }
}