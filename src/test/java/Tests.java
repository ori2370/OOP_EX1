import observer.ConcreteMember;
import observer.GroupAdmin;
import observer.UndoableStringBuilder;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.platform.commons.logging.Logger;
import org.junit.platform.commons.logging.LoggerFactory;

public class Tests {
    public static final Logger logger = LoggerFactory.getLogger(Tests.class);

    //GroupAdmin tests
    @Test
    void register() {
        GroupAdmin Elon_Musk = new GroupAdmin();
        ConcreteMember SpaceX = new ConcreteMember("SpaceX");
        ConcreteMember Tesla = new ConcreteMember("Tesla");
        assertTrue(Elon_Musk.getClients().isEmpty()); //True
        Elon_Musk.register(Tesla);
        Elon_Musk.register(SpaceX);
        assertTrue(Elon_Musk.getClients().contains(Tesla));
        assertTrue(Elon_Musk.getClients().contains(SpaceX));
    }

    @Test
    void unregister() {
        GroupAdmin Elon_Musk = new GroupAdmin();
        ConcreteMember SpaceX = new ConcreteMember("SpaceX");
        ConcreteMember Tesla = new ConcreteMember("Tesla");
        Elon_Musk.register(Tesla);
        Elon_Musk.register(SpaceX);
        Elon_Musk.unregister(SpaceX);
        assertFalse(Elon_Musk.getClients().contains(SpaceX));
        assertFalse(!(Elon_Musk.getClients().contains(Tesla))); // false*false ==true we didnt unregister Tesla
    }

    @Test
    void insert() {
        GroupAdmin Elon_Musk = new GroupAdmin();
        ConcreteMember SpaceX = new ConcreteMember("SpaceX");
        ConcreteMember Tesla = new ConcreteMember("Tesla");
        Elon_Musk.register(Tesla);
        Elon_Musk.register(SpaceX);
        Elon_Musk.insert(0, "Everyone will get Tesla model plaid for Xmas");
        //check each element and then the whole container
        assertEquals("Everyone will get Tesla model plaid for Xmas", Tesla.getUsbDB().toString());
        assertEquals("Everyone will get Tesla model plaid for Xmas", SpaceX.getUsbDB().toString());
        assertEquals("Everyone will get Tesla model plaid for Xmas", Elon_Musk.getUsb().toString());
    }

    @Test
    void append() {
        GroupAdmin Elon_Musk = new GroupAdmin();
        ConcreteMember SpaceX = new ConcreteMember("SpaceX");
        ConcreteMember Tesla = new ConcreteMember("Tesla");
        Elon_Musk.register(Tesla);
        Elon_Musk.register(SpaceX);
        Elon_Musk.insert(0, "Everyone will get Tesla model plaid for Xmas");
        Elon_Musk.append(" only if he Sent OOP_EX1 for Natan and ELizabeth");
        //check each element and then the whole container
        assertEquals("Everyone will get Tesla model plaid for Xmas only if he Sent OOP_EX1 for Natan and ELizabeth", Tesla.getUsbDB().toString());
        assertEquals("Everyone will get Tesla model plaid for Xmas only if he Sent OOP_EX1 for Natan and ELizabeth", SpaceX.getUsbDB().toString());
        assertEquals("Everyone will get Tesla model plaid for Xmas only if he Sent OOP_EX1 for Natan and ELizabeth", Elon_Musk.getUsb().toString());
    }

    @Test
    void delete() {
        GroupAdmin Elon_Musk = new GroupAdmin();
        ConcreteMember SpaceX = new ConcreteMember("SpaceX");
        ConcreteMember Tesla = new ConcreteMember("Tesla");
        Elon_Musk.register(Tesla);
        Elon_Musk.register(SpaceX);
        Elon_Musk.insert(0, "Everyone will get Tesla model plaid for Xmas");
        Elon_Musk.delete(0, 5);
        //check each element and then the whole container
        assertEquals("one will get Tesla model plaid for Xmas", Tesla.getUsbDB().toString());
        assertEquals("one will get Tesla model plaid for Xmas", SpaceX.getUsbDB().toString());
        assertEquals("one will get Tesla model plaid for Xmas", Elon_Musk.getUsb().toString());
    }

    @Test
    void undo() {
        GroupAdmin Elon_Musk = new GroupAdmin();
        ConcreteMember SpaceX = new ConcreteMember("SpaceX");
        ConcreteMember Tesla = new ConcreteMember("Tesla");
        Elon_Musk.register(Tesla);
        Elon_Musk.register(SpaceX);
        Elon_Musk.insert(0, "Everyone will get Tesla model plaid for Xmas");
        Elon_Musk.append(" only if he Sent OOP_EX1 for Natan and ELizabeth");
        Elon_Musk.undo();
        //check each element and then the whole container
        assertEquals("Everyone will get Tesla model plaid for Xmas", Tesla.getUsbDB().toString());
        assertEquals("Everyone will get Tesla model plaid for Xmas", SpaceX.getUsbDB().toString());
        assertEquals("Everyone will get Tesla model plaid for Xmas", Elon_Musk.getUsb().toString());
        Elon_Musk.delete(0, 5);
        Elon_Musk.undo();
        //check each element and then the whole container
        assertEquals("Everyone will get Tesla model plaid for Xmas", Tesla.getUsbDB().toString());
        assertEquals("Everyone will get Tesla model plaid for Xmas", SpaceX.getUsbDB().toString());
        assertEquals("Everyone will get Tesla model plaid for Xmas", Elon_Musk.getUsb().toString());
    }

    //ConcreteMember tests
    @Test
    void update() {
        UndoableStringBuilder msg = new UndoableStringBuilder();
        GroupAdmin Elon_Musk = new GroupAdmin();
        ConcreteMember Tesla = new ConcreteMember("Tesla");
        Elon_Musk.register(Tesla);
        msg.insert(0, "Everyone will get Tesla model plaid for Xmas");
        Tesla.update(msg);
        assertEquals("Everyone will get Tesla model plaid for Xmas", Tesla.getUsbDB().toString());
    }

    // stub method to check external dependencies compatibility
    @Test
    public void test() {
        GroupAdmin Elon_Musk = new GroupAdmin();
        ConcreteMember SpaceX = new ConcreteMember("SpaceX");
        ConcreteMember Tesla = new ConcreteMember("Tesla");
        Elon_Musk.register(Tesla);
        Elon_Musk.register(SpaceX);
        logger.info(() -> JvmUtilities.objectFootprint(Elon_Musk));
        logger.info(() -> JvmUtilities.objectFootprint(Tesla, SpaceX));
        logger.info(() -> JvmUtilities.objectTotalSize(Elon_Musk));
        logger.info(() -> JvmUtilities.jvmInfo());
    }
}
