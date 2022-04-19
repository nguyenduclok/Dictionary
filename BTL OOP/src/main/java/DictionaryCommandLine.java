public class DictionaryCommandLine {
    public void dictionaryBasic() {
        DictionaryManagement insertDictionary = new DictionaryManagement();
        DictionaryCommandline showDictionary = new DictionaryCommandline();
        insertDictionary.insertFromCommandline();
        showDictionary.showAllWords();
    }

    public void dictionaryAdvanced() {
        DictionaryCommandline dictionary1 = new DictionaryCommandline();
        DictionaryManagement dictionary2 = new DictionaryManagement();
        dictionary2.insertFromFile();
        dictionary1.showAllWords();
        dictionary2.dictionaryLookup();
    }
}
