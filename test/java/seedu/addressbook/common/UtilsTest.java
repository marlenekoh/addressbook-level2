package seedu.addressbook.common;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class UtilsTest {


    @Test
    public void elementsAreUnique() throws Exception {
        // empty list
        assertAreUnique();

        // only one object
        assertAreUnique((Object) null);
        assertAreUnique(1);
        assertAreUnique("");
        assertAreUnique("abc");

        // all objects unique
        assertAreUnique("abc", "ab", "a");
        assertAreUnique(1, 2);

        // some identical objects
        assertNotUnique("abc", "abc");
        assertNotUnique("abc", "", "abc", "ABC");
        assertNotUnique("", "abc", "a", "abc");
        assertNotUnique(1, new Integer(1));
        assertNotUnique(null, 1, new Integer(1));
        assertNotUnique(null, null);
        assertNotUnique(null, "a", "b", null);
    }

    private void assertAreUnique(Object... objects) {
        assertTrue(Utils.elementsAreUnique(Arrays.asList(objects)));
    }

    private void assertNotUnique(Object... objects) {
        assertFalse(Utils.elementsAreUnique(Arrays.asList(objects)));
    }


    @Test
    public void isAnyNull() throws Exception {
        isAnyNull_EmptyList_returnsFalse();
        isAnyNull_SomeNull__returnsTrue();
        isAnyNull_AllNull_returnsTrue();
        isAnyNull_NoNull_returnsFalse();
    }

    private void isAnyNull_EmptyList_returnsFalse() {
        assertNoNull();
    }

    private void isAnyNull_NoNull_returnsFalse() {
        assertNoNull(new Integer(1), 1);
        assertNoNull("a", "b", "c");
    }

    private void isAnyNull_SomeNull__returnsTrue() {
        assertHasNull(null, "abc");
        assertHasNull("abc", null, 1);
        assertHasNull(null, new Integer(1), null, "abc");
    }

    private void isAnyNull_AllNull_returnsTrue() {
        assertHasNull(null, null);
        assertHasNull(null, null, null);
    }

    private void assertNoNull(Object... objects) {
        assertFalse(Utils.isAnyNull(objects));
    }

    private void assertHasNull(Object... objects) {
        assertTrue(Utils.isAnyNull(objects));
    }
}
