package observer;

/**
 * this class contains a shallow copy of UndoableStringBuilder Member from our observer class
 */
public class ConcreteMember implements Member {
    private UndoableStringBuilder usbDB;
    private final String name;

    public ConcreteMember(String name) {
        this.name = name;
    }

    public UndoableStringBuilder getUsbDB() {
        return usbDB;
    }

    /**
     * if the observer see a change this method will update it
     * so the UndoableStringBuilder will change accordingly.
     *
     * @param usb
     */
    @Override
    public void update(UndoableStringBuilder usb) {
        usbDB = usb;
        System.out.println("Member " + name + ": " + usb);
    }

}
