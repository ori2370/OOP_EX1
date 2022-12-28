package observer;

import java.util.ArrayList;

/**
 * The GroupAdmin class maintains an Arraylist of Observers(clients) and provides methods
 * for adding and removing them, as well as for notifying them when
 * the state of the UndoableStringBuilder changes.
 */
public class GroupAdmin implements Sender {
    private ArrayList<Member> clients = new ArrayList<>();
    private UndoableStringBuilder usb = new UndoableStringBuilder();

    public UndoableStringBuilder getUsb() {
        return usb;
    }

    public ArrayList<Member> getClients() {
        return clients;
    }

    /**
     * this function adding an object(Member) that utilize as an observer into our ArrayList of clients
     *
     * @param obj this object will be an observer
     */
    @Override
    public void register(Member obj) {
        this.clients.add(obj);
    }

    /**
     * this function removing the object(Member) that utilize as an observer from our ArrayList of clients
     *
     * @param obj the observer that we want to remove
     */
    @Override
    public void unregister(Member obj) {
        this.clients.remove(obj);
    }

    /**
     * Inserts the string into this UndoableStringBuilder of our client(observer-Member)
     *
     * @param offset the offset.
     * @param obj    a string.
     * @return a reference to this object.
     */
    @Override
    public void insert(int offset, String obj) {
        this.usb = usb.insert(offset, obj);
        notifyObservers();
    }

    /**
     * Appends the specified string to this UndoableStringBuilder and updates it to
     * our clients database (Observers)
     *
     * @param obj the {@code StringBuffer} to append.
     */
    @Override
    public void append(String obj) {
        this.usb = usb.append(obj);
        notifyObservers();
    }

    /**
     * Removes the characters in a substring of this UndoableStringBuilder object. The substring begins
     * at the specified start and extends to the character at index
     * end - 1 or to the end of the sequence if no such character exists.
     * If start is equal to end, no changes are made.
     *
     * @param start
     * @param end
     * @return a reference to this object.
     */
    @Override
    public void delete(int start, int end) {
        this.usb = usb.delete(start, end);
        notifyObservers();
    }

    /**
     * reverts the last operation done on the UndoableStringBuilder Client(observer)
     */
    @Override
    public void undo() {
        this.usb.undo();
        notifyObservers();
    }

    /**
     * a for-each loop that goes through our database of clients and notify them of any changes happened.
     */
    public void notifyObservers() {
        for (Member member : clients) {
            member.update(usb);
        }
    }

}
