package observer;

import java.util.ArrayList;

/**
 *
 */
public class GroupAdmin implements Sender {
    private ArrayList<Member> clients = new ArrayList<>();
    private UndoableStringBuilder usb;

    /**
     * @param obj
     */
    @Override
    public void register(Member obj) {
        this.clients.add(obj);
    }

    /**
     * @param obj
     */
    @Override
    public void unregister(Member obj) {
        this.clients.remove(obj);
    }

    /**
     * @param offset
     * @param obj
     */
    @Override
    public void insert(int offset, String obj) {
        this.usb = usb.insert(offset, obj);
        notifyObservers();
    }

    /**
     * Appends the specified string to this character sequence and updates it to
     * our clients database (Observer)
     *
     * @param obj the {@code StringBuffer} to append.
     */
    @Override
    public void append(String obj) {
        this.usb = usb.append(obj);
        notifyObservers();
    }

    /**
     * @param start
     * @param end
     */
    @Override
    public void delete(int start, int end) {
        this.usb = usb.delete(start, end);
        notifyObservers();
    }

    /**
     *
     */
    @Override
    public void undo() {
        this.usb.undo();
        notifyObservers();
    }

    /**
     *
     */
    public void notifyObservers() {
        for (Member member : clients) {
            member.update(usb);
        }
    }

}
