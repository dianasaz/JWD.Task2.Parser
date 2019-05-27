package service;

import entity.CompositeWord;
import entity.Text;
import org.junit.Assert;
import org.junit.Test;
import service.reader.TextReader;

import java.io.IOException;

import static org.junit.Assert.*;

public class TextServiceTest {

    @Test
    public void test() throws IOException {
        TextReader textReader = new TextReader();
        String expected = textReader.read("src\\main\\resources\\File.txt");

        TextService textService = new TextService();

        Text text = (Text) textService.read();
        for (int i = 0; i < text.getWords().size()-1; i++){
            textService.sort((CompositeWord) text.getWords().get(i));
        }


        Assert.assertEquals(expected, textService.print());
    }

}