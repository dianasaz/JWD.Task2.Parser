package entity;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Text implements CompositeWord{
    private List<LeafWord> paragraphs;

    @Override
    public void add(LeafWord leaf) {
        paragraphs.add( leaf);
    }

    public Text(){
        this.paragraphs = new ArrayList<>();
    }

    @Override
    public List<LeafWord> getWords() {
        return paragraphs;
    }

    @Override
    public String getData() {
/*
        String textString = paragraphs.stream()
                .map(LeafWord::getData)
                .map(n -> "\t" + n)
                .collect(Collectors.joining());

        return "" + textString;
               */
        String res = "";
        //res += "\t";
        for (int i = 0; i < paragraphs.size(); i++){
            if (i == 0) {
                res += "\t" + paragraphs.get(i).getData();
            } else res += "\n" + "\t" + paragraphs.get(i).getData();
        }
        return res;
    }
}
