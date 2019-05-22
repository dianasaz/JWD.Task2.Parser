package service.parser;

import entity.SmartText;
import entity.Word;

public abstract class TextParser implements ParserChain<SmartText> {
    private TextParser next;

    @Override
    public ParserChain<SmartText> linkWith(ParserChain<SmartText> next) {
        ((TextParser) next).next = this;
        return next;
    }

    protected SmartText nextParse(String line){
        if (next != null){
            return next.parseLine(line);
        } else {
            return null;
        }
    }
}
