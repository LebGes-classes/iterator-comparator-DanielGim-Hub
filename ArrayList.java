package itisTest.unit.unit;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class ArrayList<E> implements Collection<E> {
    private Object[] elements;
    private int size = 0;

    public ArrayList() {

        elements = new Object[20];
    }

    @Override
    public void add(E element) {
        //Проверка места
        ensureCapacity();
        elements[size++] = element;
    }

    @Override
    public void add(int index, E element) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }
        //Проверка места
        ensureCapacity();
        // Сдвиг вправо
        System.arraycopy(elements, index, elements, index + 1, size - index);
        elements[index] = element;
        size++;
    }

    @Override
    public boolean removeElement(E element) {
        for (int i = 0; i < size; i++) {
            if (element.equals(elements[i])) {
                removeIndex(i);
                return true;
            }
        }
        return false;
    }

    @Override
    public void clear() {
        for (int i = 0; i < size; i++) {
            elements[i] = null;
        }
        size = 0;
    }

    @Override
    public E findElement(E element) {
        for (int i = 0; i < size; i++) {
            if (element.equals(elements[i])) {
                return (E) elements[i];
            }
        }
        return null;
    }

    @Override
    public int findIndex(E element) {
        for (int i = 0; i < size; i++) {
            if (element.equals(elements[i])) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public boolean removeIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        //Количество элементов для сдвига
        int numMoved = size - index - 1;
        if (numMoved > 0) {
            // Сдвиг влево
            System.arraycopy(elements, index + 1, elements, index, numMoved);
        }
        elements[--size] = null;
        return true;
    }

    @Override
    public int size() {

        return size;
    }

    private void ensureCapacity() {
        //Массив заполнен
        if (size == elements.length) {
            Object[] newElements = new Object[2 * size];
            System.arraycopy(elements, 0, newElements, 0, size);
            elements = newElements;
        }
    }

    // Метод iterator
    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            private int currentIndex = 0;

            @Override
            public boolean hasNext() {
                return currentIndex < size;
            }

            @Override
            public E next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return (E) elements[currentIndex++];
            }

            @Override
            public void remove() {
                if (currentIndex <= 0) {
                    throw new IllegalStateException();
                }
                ArrayList.this.removeIndex(--currentIndex);
            }
        };
    }
}

