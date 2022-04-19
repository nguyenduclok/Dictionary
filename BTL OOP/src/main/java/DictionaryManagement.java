import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DictionaryManagement extends Dictionary {
    public void insertFromCommandline() {
        String word_target, word_explain;
        Scanner ip = new Scanner(System.in);
        int numLine = ip.nextInt();
        ip.nextLine();
        System.out.println(numLine);
        for (int i = 0; i < numLine; i++) {
            word_target = ip.nextLine();
            word_explain = ip.nextLine();
            Word word = new Word(word_target, word_explain);
            addWord(word);
        }
    }

    public void insertFromFile() {
        try {
            File myFile = new File("src\\main\\assets\\dictionary.txt");
            FileReader fr = new FileReader(myFile);
            BufferedReader br = new BufferedReader(fr);
            String line;
            while ((line = br.readLine()) != null) {
                int index = line.lastIndexOf("\t");
                String word_target = line.substring(0, index);
                String word_explain = line.substring(index + 1);
                addWord(new Word(word_target, word_explain));
            }
            fr.close();
            br.close();
        } catch (Exception ex) {
            System.out.println("Loi doc file: " + ex);
        }
    }

    public void dictionaryLookup() {
        Scanner scanner = new Scanner(System.in);
        String answer = "There's no such word";
        String wordLookUp = scanner.nextLine();
        for (Word word : wordInDictionary) {
            if (wordLookUp.equals(word.getWord_target())
                    || wordLookUp.equals(word.getWord_explain())) {
                answer = word.toString();
            }
        }
        System.out.println(answer);
    }

    public void editDictionary(String str) {
        Scanner scanner = new Scanner(System.in);
        for (Word word : wordInDictionary) {
            if (str.equals(word.getWord_explain())) {
                System.out.println("Insert word edit:");
                String newWordExplain = scanner.nextLine();
                word.setWord_explain(newWordExplain);
            } else if (str.equals(word.getWord_target())) {
                System.out.println("Insert word edit:");
                String newWordTarget = scanner.nextLine();
                word.setWord_target(newWordTarget);
            }
        }
    }

    public void deleteDictionary(String str) {
        for (Word word : wordInDictionary) {
            if (str.equals(word.getWord_explain())) {
                word.setWord_explain("");
            } else if (str.equals(word.getWord_target())) {
                word.setWord_target("");
            }
        }
    }

    public List<String> dictionarySearcher(String str) {
        List<String> wordsList = new ArrayList<String>();
        for (Word word : wordInDictionary) {
            if (word.getWord_target().startsWith(str)) {
                wordsList.add(word.getWord_target());
            }
        }
        return wordsList;
    }

    public static void dictionaryExportToFile() throws IOException {
        FileWriter writer = new FileWriter("src\\main\\assets\\dictionaries.txt");
        for (Word word : wordInDictionary) {
            writer.write(String.format("%s\t%s\n", word.getWord_target(), word.getWord_explain()));
        }
        writer.close();
    }
}
