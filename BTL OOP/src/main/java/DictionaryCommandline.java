public class DictionaryCommandline extends Dictionary {
    public void showAllWords() {
        System.out.println("No\t| English\t|Vietnamese");
        for (int i = 0; i < wordInDictionary.size(); i++) {
            System.out.println((i + 1) + "\t" + wordInDictionary.get(i).toString());
        }
    }
}