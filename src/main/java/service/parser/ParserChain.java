package service.parser;

public interface ParserChain < T > {
    T parseLine(String string);

    ParserChain < T > linkWith( ParserChain < T > next);
}
