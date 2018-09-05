package note.designPattern.strategy;

import java.util.Collection;

public interface Sort {
    <E> Collection  sort(Collection<E> collection);
}
