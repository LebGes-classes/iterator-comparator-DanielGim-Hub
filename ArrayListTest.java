package itisTest.unit.unit;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.*;

public class ArrayListTest {
    private ArrayList<Integer> intList;
    private ArrayList<String> stringList;

    @BeforeEach
    void setUp() {
        intList = new ArrayList<>();
        stringList = new ArrayList<>();
    }

    @Test
    void testAdd() {
        intList.add(5);
        assertEquals(1, intList.size());
        assertEquals(Integer.valueOf(5), intList.findElement(5));
    }

    @Test
    void testAddAtIndex() {
        intList.add(0, 1);
        intList.add(1, 2);
        intList.add(1, 3);

        assertEquals(Integer.valueOf(1), intList.findElement(1));
        assertEquals(Integer.valueOf(3), intList.findElement(3));
        assertEquals(Integer.valueOf(2), intList.findElement(2));
        assertEquals(3, intList.size());
    }

    @Test
    void testRemoveElement() {
        stringList.add("a");
        stringList.add("b");
        assertTrue(stringList.removeElement("a"));
        assertEquals(-1, stringList.findIndex("a"));
        assertEquals(1, stringList.size());
    }

    @Test
    void testClear() {
        intList.add(1);
        intList.add(2);
        intList.clear();
        assertEquals(0, intList.size());
    }

    @Test
    void testFindElement() {
        intList.add(1);
        intList.add(2);
        assertNotNull(intList.findElement(1));
        assertNull(intList.findElement(3));
    }

    @Test
    void testFindIndex() {
        intList.add(1);
        intList.add(2);
        assertEquals(0, intList.findIndex(1));
        assertEquals(1, intList.findIndex(2));
        assertEquals(-1, intList.findIndex(3));
    }

    @Test
    void testRemoveIndex() {
        intList.add(1);
        intList.add(2);
        assertTrue(intList.removeIndex(0));
        assertEquals(-1, intList.findIndex(1));
        assertEquals(1, intList.size());
    }
    @Test
    void testIteratorHasNextAndNext() {
        intList.add(1);
        intList.add(2);
        Iterator<Integer> iterator = intList.iterator();
        assertTrue(iterator.hasNext());
        assertEquals(Integer.valueOf(1), iterator.next());
        assertTrue(iterator.hasNext());
        assertEquals(Integer.valueOf(2), iterator.next());
        assertFalse(iterator.hasNext());
    }
    @Test
    void testIteratorRemove() {
        intList.add(1);
        intList.add(2);
        intList.add(3);

        Iterator<Integer> iterator = intList.iterator();
        assertTrue(iterator.hasNext());
        assertEquals(Integer.valueOf(1), iterator.next());
        // Удаление первого элемента
        iterator.remove();
        assertEquals(2, intList.size());
        assertTrue(intList.findIndex(1) == -1);

        assertEquals(Integer.valueOf(2), iterator.next());
        assertEquals(Integer.valueOf(3), iterator.next());
        assertFalse(iterator.hasNext());
        // Удаление последнего элемента
        iterator.remove();
        assertEquals(1, intList.size());
        assertTrue(intList.findIndex(3) == -1);
    }
}
