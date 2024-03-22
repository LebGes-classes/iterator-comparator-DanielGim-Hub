package itisTest.unit.unit;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedList<E> implements Collection<E> {
    private Node<E> head;
    private int size = 0;

    private static class Node<E> {
        E data;
        Node<E> next;

        Node(E data) {
            this.data = data;
            this.next = null;
        }
    }

    // Метод добавления элемента в конец списка
    @Override
    public void add(E element) {

        add(size, element);
    }

    // Метод добавления элемента на указанную позицию
    @Override
    public void add(int index, E element) {
        // Проверка на корректность индекса
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }

        Node<E> newNode = new Node<>(element);
        // Вставка в начало, если индекс равен 0
        if (index == 0) {
            newNode.next = head;
            head = newNode;
        } else {
            // Находим предыдущий узел и вставляем новый узел после него
            Node<E> prev = getNode(index - 1);
            newNode.next = prev.next;
            prev.next = newNode;
        }
        size++;
    }

    // Метод удаления элемента по значению
    @Override
    public boolean removeElement(E element) {
        Node<E> prev = null;
        Node<E> current = head;

        // Перебор всех узлов в поисках элемента
        while (current != null) {
            if (current.data.equals(element)) {
                // Удаление узла, если элемент найден
                if (prev == null) {
                    head = current.next;
                } else {
                    prev.next = current.next;
                }
                size--;
                return true;
            }
            // Переход к следующему узлу
            prev = current;
            current = current.next;
        }
        return false;
    }

    // Метод очистки списка
    @Override
    public void clear() {
        head = null;
        size = 0;
    }

    // Метод поиска элемента и возвращения его значения
    @Override
    public E findElement(E element) {
        Node<E> current = head;
        while (current != null) {
            if (current.data.equals(element)) {
                return current.data;
            }
            current = current.next;
        }
        return null;
    }

    // Метод поиска индекса элемента в списке
    @Override
    public int findIndex(E element) {
        Node<E> current = head;
        int index = 0;
        while (current != null) {
            if (current.data.equals(element)) {
                return index;
            }
            current = current.next;
            index++;
        }
        return -1;
    }

    // Метод удаления элемента по индексу
    @Override
    public boolean removeIndex(int index) {
        // Проверка на корректность индекса
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        // Удаление первого узла, если индекс равен 0
        if (index == 0) {
            head = head.next;
        } else {
            // Находим предыдущий узел и удаляем следующий за ним узел
            Node<E> prev = getNode(index - 1);
            prev.next = prev.next.next;
        }
        // Уменьшаем размер списка
        size--;
        return true;
    }

    // Метод возвращения размера списка. Должен возвращать значение size.
    @Override
    public int size() {
        return 0;
    }

    // Вспомогательный метод для получения узла по индексу
    private Node<E> getNode(int index) {
        Node<E> current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current;
    }
    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            private Node<E> current = head;
            private Node<E> prev = null;
            private Node<E> prevPrev = null;

            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public E next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                E data = current.data;
                prevPrev = prev;
                prev = current;
                current = current.next;
                return data;
            }
        };
    }
}