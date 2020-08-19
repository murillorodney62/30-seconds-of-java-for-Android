/*
 * MIT License
 *
 * Copyright (c) 2017-2019 Ilkka Seppälä
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.lang.reflect.InvocationTargetException;
import org.junit.jupiter.api.Test;

/*
 * Tests for 30 Seconds of Java code library
 *
 */
class ClassLibraryTest {
  /**
   * Tests for {@link ClassLibrary#getAllMethods(Class)}.
   */
  @Test
  void testGetAllMethods() {
    var list = ClassLibrary.getAllMethods(ClassLibrary.class);
    assertTrue(list.contains("getAllMethods"));
    assertTrue(list.contains("getAllFieldNames"));
    assertTrue(list.contains("createObject"));
  }

  /**
   * Tests for {@link ClassLibrary#getAllFieldNames(Class)}.
   */
  @Test
  void testGetAllFieldNames() {
    class TestClass {
      public int fieldOne;
      public int fieldTwo;
    }

    var list = ClassLibrary.getAllFieldNames(TestClass.class);
    assertEquals(2, list.size());
    assertTrue(list.contains("fieldOne"));
    assertTrue(list.contains("fieldTwo"));
  }

  /**
   * Tests for {@link ClassLibrary#createObject(String)}.
   */
  @Test
  void testCreateObject()
          throws InvocationTargetException,
          NoSuchMethodException,
          InstantiationException,
          IllegalAccessException,
          ClassNotFoundException {
    assertEquals(String.class, ClassLibrary.createObject("java.lang.String").getClass());
    assertNotEquals(Integer.class, ClassLibrary.createObject("java.lang.String").getClass());
  }
}