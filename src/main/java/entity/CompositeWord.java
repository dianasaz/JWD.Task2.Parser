package entity;

import java.util.List;

public interface CompositeWord<T> extends LeafWord<T>{
    void add(LeafWord<T> leaf);

    List<LeafWord<T>> getWords();
}
