package service.parser;

import entity.CompositeWord;
import entity.LeafWord;
import entity.Paragraph;
import entity.Text;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class TextParser extends AbstractParser {
    private static final String PARAGRAPH_SPLIT_REGEX = "\t";


    @Override
    public LeafWord parseLine(String string) {
        List<String> stringSentences = new LinkedList<>(Arrays.asList(string.split(PARAGRAPH_SPLIT_REGEX)));
        CompositeWord text = new Text();
        for (String stringSentence : stringSentences) {
            CompositeWord paragraph = (CompositeWord) nextParse(stringSentence);
            text.add(paragraph);
        }
        return text;
    }
}