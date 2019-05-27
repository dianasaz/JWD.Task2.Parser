package entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Sentense implements CompositeWord{
    private List<LeafWord> words;
    private String endOfSentence;

    @Override
    public void add(LeafWord leaf) {
        words.add( leaf);
    }

    public Sentense(String end){
        this.words = new ArrayList<>();
        this.endOfSentence = end;
    }

    @Override
    public List<LeafWord> getWords() {
        return words;
    }

    @Override
    public String getData() {/*
        String sentenceWords = words.stream()
                .map(LeafWord::getData)
                .collect(Collectors.joining());

        return "" + sentenceWords.trim();
    }*/
        String res = "";
        //res += "\t";
        for (LeafWord word : words) {
            res += word.getData();
        }
        return res + endOfSentence;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Sentense sentense = (Sentense) o;
        return Objects.equals(words, sentense.words);
    }

    @Override
    public int hashCode() {
        return Objects.hash(words);
    }

    @Override
    public String toString() {
        return  words + "";
    }
}
