package org.example;

import org.junit.jupiter.api.Test;
import java.util.NoSuchElementException;
import static org.junit.jupiter.api.Assertions.*;

public class ArrayIteratorTest {

  @Test
  public void testHasNextAndNext() {
    Integer[] numbers = {1, 2, 3};
    ArrayIterator<Integer> iterator = new ArrayIterator<>(numbers);

    assertTrue(iterator.hasNext());
    assertEquals(1, iterator.next().intValue());
    assertTrue(iterator.hasNext());
    assertEquals(2, iterator.next().intValue());
    assertTrue(iterator.hasNext());
    assertEquals(3, iterator.next().intValue());
    assertFalse(iterator.hasNext());
  }

  @Test
  public void testNoSuchElementException() {
    Integer[] numbers = {1};
    ArrayIterator<Integer> iterator = new ArrayIterator<>(numbers);

    iterator.next();
    assertThrows(NoSuchElementException.class, iterator::next);
  }
}
