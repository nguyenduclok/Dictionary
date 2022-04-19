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
                int index = line.indexOf("\t");
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
        System.out.println("Enter a word you want to look up:");
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

    public void addWordToDictionary() {
        System.out.println("Enter word target and word explain you want to add: ");
        Scanner scanner = new Scanner(System.in);
        String wordTarget = scanner.nextLine();
        String wordExplain = scanner.nextLine();
        wordInDictionary.add(new Word(wordTarget, wordExplain));
    }

    public void editWordInDictionary() {
        System.out.println("Enter word target or word explain you want to edit:");
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        boolean isExist = false;
        for (Word word : wordInDictionary) {
            if (str.equals(word.getWord_explain())) {
                System.out.println("Enter a new word target:");
                String newWordTarget = scanner.nextLine();
                word.setWord_target(newWordTarget);
                isExist = true;
                break;
            } else if (str.equals(word.getWord_target())) {
                System.out.println("Enter a new word explain:");
                String newWordExplain = scanner.nextLine();
                word.setWord_explain(newWordExplain);
                isExist = true;
                break;
            }
        }
        if (!isExist) {
            System.out.println("The word you enter is invalid.");
        }
    }

    public void deleteDictionary() {
        System.out.println("Enter a word you want to delete:");
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        for (Word word : wordInDictionary) {
            if (str.equals(word.getWord_target())) {
                wordInDictionary.remove(word);
                break;
            }
        }
    }

    public void dictionarySearcher() {
        System.out.println("Enter a word you want to search:");
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        List<Word> wordsList = new ArrayList<Word>();
        for (Word word : wordInDictionary) {
            if (word.getWord_target().startsWith(str)) {
                wordsList.add(new Word(word.getWord_target(), word.getWord_explain()));
            }
        }
        System.out.println("No\t| English\t|Vietnamese");
        for (int i = 0; i < wordsList.size(); i++) {
            System.out.println((i + 1) + "\t" + wordsList.get(i).toString());
        }
    }

    public static void dictionaryExportToFile() throws IOException {
        FileWriter writer = new FileWriter("src\\main\\assets\\dictionaries.txt");
        for (Word word : wordInDictionary) {
            writer.write(String.format("%s\t%s\n", word.getWord_target(), word.getWord_explain()));
        }
        writer.close();
    }
}
