import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        DictionaryCommandLine dictonary = new DictionaryCommandLine();
        DictionaryManagement newDictionary = new DictionaryManagement();
        newDictionary.insertFromFile();
        dictonary.showAllWords();
        try {
            newDictionary.dictionaryExportToFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
