package observer;

public class ConcreteMember implements Member {
    private UndoableStringBuilder usb;
    private final String name;

    public ConcreteMember(UndoableStringBuilder usb, String name) {
        this.usb = usb;
        this.name = name;
    }

    @Override
    public void update(UndoableStringBuilder usb) {
        this.usb = usb;
        System.out.println("Member " + name + ": " + usb);
    }

}
