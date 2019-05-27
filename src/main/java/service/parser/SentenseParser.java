package service.parser;

import entity.CompositeWord;
import entity.LeafWord;
import entity.Paragraph;
import entity.Sentense;
import entity.Word;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SentenseParser extends AbstractParser {

  /*  private static final String WORD_SPLIT_REGEX = "[\\W]";
    @Override
    public LeafWord parseLine(String string) {
        List<String> stringSentences = new LinkedList<>(Arrays.asList(string.split(WORD_SPLIT_REGEX)));
        CompositeWord sentense = new Sentense();
        for (String stringSentence : stringSentences) {
            LeafWord word = nextParse(stringSentence);
            sentense.add(word);
        }
        return sentense;
    }*/
  private static final String DELIMETER_SENTENCE_BY_WORDS = " ";
    private static final String END_SENTENCE_SYMBOLS = "[.!?]$";

    @Override
    public LeafWord parseLine(String line) {
        Pattern p = Pattern.compile(END_SENTENCE_SYMBOLS);
        Matcher m = p.matcher(line);
        String endChar = "";
        while (m.find()) {
            int end = m.end();
            
            endChar += line.charAt(end-1);
        }
        //String endChar = line.substring(m.start(), m.end());  //todo create parse exception
        List<String> stringWords = new LinkedList<>(Arrays.asList(line.split(DELIMETER_SENTENCE_BY_WORDS)));
        CompositeWord sentence = new Sentense(endChar);
        for (String stringWord : stringWords) {
            LeafWord word = nextParse(stringWord.trim());
            sentence.add(word);
            //LOGGER.log(Level.INFO, "Add new word to sentence");

        }
        return sentence;
    }
}
