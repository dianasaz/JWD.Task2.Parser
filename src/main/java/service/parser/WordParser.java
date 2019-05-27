package service.parser;

import entity.CompositeWord;
import entity.LeafWord;
import entity.Word;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WordParser extends AbstractParser{
    public static final String WORD_VALIDATION = "[\\w-]+";

    @Override
    public LeafWord parseLine(String string) {
        String stringWord = find(WORD_VALIDATION, string);

        LeafWord word = new Word(stringWord);
        return word;
    }

    private String find(String regex, String line) {
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(line);
        String stringWord = "";
        while (m.find()) {
            int start = m.start();
            int end = m.end();
            stringWord = line.substring(start, end);
        }
        return stringWord;
    }


}
