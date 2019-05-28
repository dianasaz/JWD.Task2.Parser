package service.reader;

import controller.reader.TextReader;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

public class TextReaderTest {

    @Test
    public void testRead() throws IOException {
        TextReader textReader = new TextReader();
        String actual = textReader.read("src\\main\\resources\\fileMain.txt");

        String expected = "\tIt has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.\tIt is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout. The point of using Ipsum is that it has a more-or-less normal distribution of letters, as opposed to using 'Content here, content here', making it look like readable English.\tIt is a established fact that a reader will be of a page when looking at its layout.\tBye.";

        Assert.assertEquals(expected, actual);
    }

}