import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        DictionaryCommandLine dictionaryCommandLine = new DictionaryCommandLine();
        DictionaryCommandLineTest dictionaryCommandline = new DictionaryCommandLineTest();
        dictionaryCommandLine.dictionaryBasic();
        dictionaryCommandline.showAllWords();
        try {
            DictionaryManagement.dictionaryExportToFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}