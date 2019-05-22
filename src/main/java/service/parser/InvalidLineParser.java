package service.parser;

import entity.SmartText;
import entity.Word;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class InvalidLineParser extends TextParser {

    private final Logger logger = LogManager.getLogger(InvalidLineParser.class);

    @Override
    public SmartText parseLine(String line) {
        logger.warn("Invalid line\n" + line);
        return nextParse(line);
    }
}
