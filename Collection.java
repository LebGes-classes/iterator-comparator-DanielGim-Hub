package itisTest.unit.unit;
import java.util.Iterator;


public interface Collection<E> {
    void add(E element);
    void add(int index, E element);
    boolean removeElement(E element);
    void clear();
    E findElement(E element);
    int findIndex(E element);
    boolean removeIndex(int index);
    int size();
    Iterator<E> iterator();
}
