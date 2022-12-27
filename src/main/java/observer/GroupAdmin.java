package observer;
import java.util.ArrayList;
/** */
public class GroupAdmin implements Sender {
    private ArrayList<Member> clients= new ArrayList<>();
    private UndoableStringBuilder usb;

    @Override
    public void register(Member obj) {
    this.clients.add(obj);
    }

    @Override
    public void unregister(Member obj) {
        this.clients.remove(obj);
    }

    @Override
    public void insert(int offset, String obj) {
    this.usb= usb.insert(offset,obj);
        notifyObservers();
    }

    @Override
    public void append(String obj) {
    this.usb=usb.append(obj);
        notifyObservers();
    }

    @Override
    public void delete(int start, int end) {
    this.usb=usb.delete(start, end);
        notifyObservers();
    }

    @Override
    public void undo() {
    this.usb.undo();
        notifyObservers();
    }
    public void notifyObservers(){
        for(Member member: clients){
            member.update(usb);
        }
    }

}
