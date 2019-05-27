package service;

import entity.CompositeWord;
import entity.LeafWord;
import entity.Text;
import org.junit.Assert;
import service.parser.ParagraphParser;
import service.parser.ParserChain;
import service.parser.SentenseParser;
import service.parser.TextParser;
import service.parser.WordParser;
import service.reader.TextReader;

import java.io.IOException;

public class TextService {
    private CompositeWord text;

    public void sort(CompositeWord paragraph){
        for (int i = 0; i < paragraph.getWords().size(); i++)
            for (int j = 0; j < paragraph.getWords().size() - 1; j++)
                if (paragraph.getWords().get(j).getData().length() > paragraph.getWords().get(j + 1).getData().length()) {
                    LeafWord temp;
                    temp = paragraph.getWords().get(j);
                    paragraph.getWords().set(j,  paragraph.getWords().get(j + 1));
                    paragraph.getWords().set(j + 1, temp);
                }
    }

    public CompositeWord read() throws IOException {

        TextReader textReader = new TextReader();
        String stringText = textReader.read("src\\main\\resources\\File.txt");

        ParserChain componentParser = new WordParser()
                .linkWith(new SentenseParser())
                .linkWith(new ParagraphParser())
                .linkWith(new TextParser());

        text = (Text) componentParser.parseLine(stringText);

        return text;
    }

    public String print() {
        String stringText = text.getData();
        /*
        char search = ' ';
        char search2 = ',';
        char search3 = '.';
        String parsedStr = null;
        for (int i = 75; i < 80; i++) {
            if (stringText.charAt(i) == search | stringText.charAt(i) == search2 | stringText.charAt(i) == search3) {
                String regex = "(.{" + i + "})";
                parsedStr = stringText.replaceAll(regex, "$1\n");
                //break;
            }
        }*/
        String parsedStr = stringText.replaceAll("(.{76})", "$1\n");
        return parsedStr;
    }
}
