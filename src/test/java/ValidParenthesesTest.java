import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class ValidParenthesesTest {
    @Test
    public void testIsValid() {
        ValidParentheses vp = new ValidParentheses();
        assertTrue(vp.isValid("()"));
        for (String s : Arrays.asList("()[]{}", "{[]}", "{[()()]}", "{{[[(())]]}}")) {
            assertTrue(vp.isValid(s));
        }

        assertFalse(vp.isValid("(]"));
        assertFalse(vp.isValid("([)]"));
        assertFalse(vp.isValid("{[(])}"));
        assertFalse(vp.isValid("(("));
        assertFalse(vp.isValid("(()"));
        assertFalse(vp.isValid(")}"));
        assertFalse(vp.isValid("{[()]})"));
        assertFalse(vp.isValid("({[]})[)]"));
        assertFalse(vp.isValid("{[("));

        assertTrue(vp.isValid(""));
    }
}
