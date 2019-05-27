package service.parser;

import entity.CompositeWord;
import entity.LeafWord;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class InvalidLineParser extends AbstractParser {

    private final Logger logger = LogManager.getLogger(InvalidLineParser.class);

    @Override
    public CompositeWord parseLine(String line) {
        logger.warn("Invalid line\n" + line);
        return (CompositeWord) nextParse(line);
    }
}
