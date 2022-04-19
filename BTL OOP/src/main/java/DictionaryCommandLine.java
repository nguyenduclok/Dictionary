public class DictionaryCommandLine {
    public void dictionaryBasic() {
        DictionaryManagement insertDictionary = new DictionaryManagement();
        DictionaryCommandLineTest showDictionary = new DictionaryCommandLineTest();
        insertDictionary.insertFromCommandline();
        showDictionary.showAllWords();
    }

    public void dictionaryAdvanced() {
        DictionaryCommandLineTest dictionary1 = new DictionaryCommandLineTest();
        DictionaryManagement dictionary2 = new DictionaryManagement();
        dictionary2.insertFromFile();
        dictionary1.showAllWords();
        dictionary2.dictionaryLookup();
    }
}