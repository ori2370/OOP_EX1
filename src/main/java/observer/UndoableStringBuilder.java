import org.jetbrains.annotations.NotNull;

import java.util.Stack;

public class UndoableStringBuilder {

    private Stack<StringBuilder> last;


    public UndoableStringBuilder() {
        last = new Stack<>();
        last.push(new StringBuilder());
    }

    public UndoableStringBuilder(String str) {
        last = new Stack<>();
        last.push(new StringBuilder(str));
    }

    /***
     * Appends the specified string to this character sequence.
     * @param   str   the {@code StringBuffer} to append.
     * @return a reference to this object.
     */
    public UndoableStringBuilder append(String str) {
        StringBuilder current = new StringBuilder(last.peek());
        current = current.append(str);
        last.push(current);
        return this;
    }

    /***
     * Removes the characters in a substring of this sequence. The substring begins
     * at the specified start and extends to the character at index
     * end - 1 or to the end of the sequence if no such character exists.
     * If start is equal to end, no changes are made.
     * @param start
     * @param end
     * @return a reference to this object.
     */
    public UndoableStringBuilder delete(int start, int end) {
        StringBuilder current = new StringBuilder(last.peek());
        if (last.peek() == null) {
            return this;
        }
        try {
            current = current.delete(start, end);
            last.push(current);
        } catch (StringIndexOutOfBoundsException e) {
            System.err.println("start/end are out of bound");
        }
        //to make sure we catch all the exceptions
        catch (Exception e) {
            System.err.println("unknown exception: ");
            e.printStackTrace();

        }
        last.push(current);
        return this;
    }

    /***
     * Inserts the string into this character sequence.
     * @param      offset   the offset.
     * @param      str      a string.
     * @return a reference to this object.
     */
    public UndoableStringBuilder insert(int offset, String str) {
        StringBuilder current = new StringBuilder(last.peek());
        if (last.peek() == null) {
            return this;
        }
        try {
            current = current.insert(offset, str);
            last.push(current);

        } catch (StringIndexOutOfBoundsException e) {
            System.err.println("start/end are out of bound");
        }//to make sure we catch all the exceptions
        catch (Exception e) {
            System.err.println("unknown exception: ");
            e.printStackTrace();

        }
        return this;
    }

    /***
     * Replaces the characters in a substring of this sequence with characters in
     * the specified String. The substring begins at the specified start and
     * extends to the character at index end - 1 or to the end of the sequence if
     * no such character exists. First the characters in the substring are removed
     * and then the specified String is inserted at start. (This sequence will be
     * lengthened to accommodate the specified String if necessary).
     * @param      start    The beginning index, inclusive.
     * @param      end      The ending index, exclusive.
     * @param      str   String that will replace previous contents.
     * @return a reference to this object.
     */
    public UndoableStringBuilder replace(int start, int end, String str) {
        StringBuilder current = new StringBuilder(last.peek());
        if (last.peek() == null) {
            return this;
        }
        try {
            current = current.replace(start, end, str);
            last.push(current);
        } catch (StringIndexOutOfBoundsException e) {
            System.err.println("start/end are out of bound");
        }//to make sure we catch all the exceptions
        catch (Exception e) {
            System.err.println("unknown exception: ");
            e.printStackTrace();
        }
        return this;
    }

    /***
     * Causes this character sequence to be replaced by the reverse of the
     * sequence.
     * @return a reference to this object.
     */
    public UndoableStringBuilder reverse() {
        StringBuilder current = new StringBuilder(last.peek());
        current = current.reverse();
        last.push(current);
        return this;
    }

    /***
     * reverts the last operation done on the StringBuilder object
     */
    public void undo() {
        last.pop();
    }

    @Override
    public String toString() {
        return last.peek().toString();
    }
}
