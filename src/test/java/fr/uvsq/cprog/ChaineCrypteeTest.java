package fr.uvsq.cprog;

import org.junit.Test;
import static org.junit.Assert.*;

public class ChaineCrypteeTest {

    @Test
    public void testCryptageSimple() {
        ChaineCryptee c = ChaineCryptee.deEnClair("ABC", 3);
        assertEquals("DEF", c.crypte());
    }

    @Test
    public void testDecryptageSimple() {
        ChaineCryptee c = ChaineCryptee.deCryptee("DEF", 3);
        assertEquals("ABC", c.decrypte());
    }

    @Test
    public void testEspaceNonModifie() {
        ChaineCryptee c = ChaineCryptee.deEnClair("A B", 1);
        assertEquals("B C", c.crypte());
    }
}
