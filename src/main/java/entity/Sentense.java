package entity;

import java.util.List;

public class Sentense implements CompositeWord{
    private List<Word> words;

    @Override
    public void add(LeafWord leaf) {

    }

    @Override
    public List<LeafWord> getWords() {
        return null;
    }

    @Override
    public Object getData() {
        return null;
    }
}
