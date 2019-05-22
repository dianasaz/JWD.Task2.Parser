package service.parser;

import entity.Paragraph;
import entity.SmartText;
import entity.Word;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import service.validation.Validation;

public class ParagraphParser extends TextParser {
    private static final String PARAGRAPH_SPLIT_REGEX = "\\s{4}";

    @Override
    public SmartText parseLine(String text) {
        for (int i = 0; i < text.length(); i++) {
            String[] paragraphs = text.split(PARAGRAPH_SPLIT_REGEX);
            for (String paragraph: paragraphs){
                Paragraph paragraph1 = new Paragraph();
            }
        }



    /*
    InvalidLineParser
        validation
        ParagraphParser
        validation
        SentenseParser
        validation
        WordParser



}
     */

        return null;
    }
}