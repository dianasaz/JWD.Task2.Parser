package entity;

import java.util.Objects;

public class Word implements LeafWord{
    private String previousElement;
    private String word;
    private String nextElement;

    public Word(String word){
        this.word = word;
    }

    @Override
    public String getData() {
        return word + " ";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Word word1 = (Word) o;
        return Objects.equals(previousElement, word1.previousElement) &&
                Objects.equals(word, word1.word) &&
                Objects.equals(nextElement, word1.nextElement);
    }

    @Override
    public int hashCode() {
        return Objects.hash(previousElement, word, nextElement);
    }

    @Override
    public String toString() {
        return  word + "";
    }
}
