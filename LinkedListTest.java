package itisTest.unit.unit;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Iterator;

public class LinkedListTest {
    private LinkedList<Integer> intList;
    private LinkedList<String> stringList;

    @BeforeEach
    void setUp() {
        intList = new LinkedList<>();
        stringList = new LinkedList<>();
    }

    @Test
    void testAdd() {
        intList.add(5);
        assertEquals(0, intList.findIndex(5));
    }

    @Test
    void testAddAtIndex() {
        intList.add(0, 1);
        intList.add(1, 2);
        intList.add(2, 3);
        assertEquals(2, intList.findIndex(3));
    }

    @Test
    void testRemoveElement() {
        stringList.add("a");
        stringList.add("b");
        assertTrue(stringList.removeElement("b"));
        assertEquals(-1, stringList.findIndex("b"));
    }

    @Test
    void testClear() {
        intList.add(1);
        intList.add(2);
        intList.clear();
        assertEquals(-1, intList.findIndex(1));
        assertEquals(-1, intList.findIndex(2));
    }

    @Test
    void testFindElement() {
        intList.add(1);
        intList.add(2);
        assertEquals(Integer.valueOf(2), intList.findElement(2));
    }

    @Test
    void testFindIndex() {
        intList.add(1);
        intList.add(2);
        assertEquals(1, intList.findIndex(2));
    }

    @Test
    void testRemoveIndex() {
        intList.add(1);
        intList.add(2);
        assertTrue(intList.removeIndex(1));
        assertEquals(-1, intList.findIndex(2));
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
}