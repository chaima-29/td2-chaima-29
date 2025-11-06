package fr.uvsq.cprog;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Classe de test pour ChaineCryptee.
 */
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

    @Test
    public void testBouclageAlphabet() {
        ChaineCryptee c = ChaineCryptee.deEnClair("XYZ", 3);
        assertEquals("ABC", c.crypte());
    }

    @Test
    public void testChaineVide() {
        ChaineCryptee c = ChaineCryptee.deEnClair("", 5);
        assertEquals("", c.crypte());
    }

    @Test
    public void testChaineNull() {
        ChaineCryptee c = ChaineCryptee.deEnClair(null, 5);
        assertNull(c.crypte());
    }

    @Test
    public void testDecalageNul() {
        ChaineCryptee c = ChaineCryptee.deEnClair("HELLO", 0);
        assertEquals("HELLO", c.crypte());
    }

    @Test
    public void testDecalageSuperieur26() {
        ChaineCryptee c = ChaineCryptee.deEnClair("ABC", 29);
        assertEquals("DEF", c.crypte());
    }
}
