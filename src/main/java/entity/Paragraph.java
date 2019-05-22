package entity;

import java.util.List;

public class Paragraph implements CompositeWord{
    private List<Sentense> sentenses;

    @Override
    public void add(LeafWord leaf) {
        sentenses.add((Sentense) leaf);
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
