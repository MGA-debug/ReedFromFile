package ru.appline.logic.reader;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class MyReader {
    private List<String> words = new ArrayList<>();
    private String path;
    private Scanner scanner;

    public MyReader(String path) {
        this.path = path;
    }

    public MyReader read() {
        try {
            scanner = new Scanner(new File(this.path));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        words = Arrays.asList(scanner.nextLine().split(" "));
        Collections.sort(words);
        return this;
    }

    public void getInformation() {
        String moreTimeFindWord = "";
        int count = 0;
        Map<String, Integer> wordsRepeat = findCuntRepeat();

        for (Map.Entry<String, Integer> e : wordsRepeat.entrySet()) {
            int value = e.getValue();
            String word = e.getKey();
            if (value > count) {
                count = value;
                moreTimeFindWord = word;
            }
            System.out.println("Слово \""+word +"\" количество повторений " + value);
        }
        System.out.println("Слово \""+moreTimeFindWord+"\", встречается чаще всего, "+count+" раз/раза");

    }


    private Map<String, Integer> findCuntRepeat() {
        Map<String, Integer> wordsRepeat = new HashMap<>();
        for (String word : words) {
            if (wordsRepeat.containsKey(word)) {
                wordsRepeat.put(word, wordsRepeat.get(word) + 1);
            } else {
                wordsRepeat.put(word, 1);
            }
        }
        return wordsRepeat;
    }
}
