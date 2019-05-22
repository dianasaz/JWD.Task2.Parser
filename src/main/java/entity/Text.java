package entity;

import java.util.List;

public class Text implements CompositeWord{
    private List<Paragraph> paragraphs;

    @Override
    public void add(LeafWord leaf) {
        paragraphs.add((Paragraph) leaf);
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
