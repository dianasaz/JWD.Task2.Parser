package service.parser;

import entity.CompositeWord;
import entity.LeafWord;
import entity.Paragraph;
import entity.Sentense;
import entity.Text;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class ParagraphParser extends AbstractParser {


    private static final String SENTENSE_SPLIT_REGEX = "[\\.][\\s]";


    @Override
    public LeafWord parseLine(String string) {
        List<String> stringSentences = new LinkedList<>(Arrays.asList(string.split(SENTENSE_SPLIT_REGEX)));
        CompositeWord paragraph = new Paragraph();
        for (String stringSentence : stringSentences) {
            CompositeWord sentence = (CompositeWord) nextParse(stringSentence);
            paragraph.add(sentence);
        }
        return paragraph;
    }
}
