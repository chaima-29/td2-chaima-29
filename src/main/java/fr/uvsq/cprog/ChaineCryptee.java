package fr.uvsq.cprog;

/**
 * Classe permettant de chiffrer et déchiffrer une chaîne de caractères
 * (lettres majuscules et espaces) par décalage.
 *
 * Version modifiée : seule la chaîne cryptée est stockée.
 */
public class ChaineCryptee {

    private String cryptee;
    private int decalage;

    /**
     * Constructeur privé (utilisation du modèle de fabrique).
     */
    private ChaineCryptee(String cryptee, int decalage) {
        this.cryptee = cryptee;
        this.decalage = decalage;
    }

    /**
     * Méthode de fabrique à partir d'une chaîne en clair.
     * Chiffre immédiatement la chaîne avant de la stocker.
     */
    public static ChaineCryptee deEnClair(String clair, int decalage) {
        String cryptee = crypteStatic(clair, decalage);
        return new ChaineCryptee(cryptee, decalage);
    }

    /**
     * Méthode de fabrique à partir d'une chaîne déjà cryptée.
     */
    public static ChaineCryptee deCryptee(String cryptee, int decalage) {
        return new ChaineCryptee(cryptee, decalage);
    }

    /**
     * Retourne la chaîne cryptée stockée.
     */
    public String crypte() {
        return cryptee;
    }

    /**
     * Retourne la chaîne décryptée.
     */
    public String decrypte() {
        return decrypteStatic(cryptee, decalage);
    }

    /**
     * Méthode statique pour chiffrer une chaîne.
     */
    private static String crypteStatic(String s, int decalage) {
        if (s == null) return null;
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            sb.append(decaleCaractere(c, decalage));
        }
        return sb.toString();
    }

    /**
     * Méthode statique pour déchiffrer une chaîne.
     */
    private static String decrypteStatic(String s, int decalage) {
        if (s == null) return null;
        return crypteStatic(s, 26 - decalage % 26);
    }

    /**
     * Décale un caractère majuscule selon la clé donnée.
     * Les espaces sont conservés.
     */
    private static char decaleCaractere(char c, int decalage) {
        if (c == ' ') return ' ';
        return (char) ('A' + (c - 'A' + decalage + 26) % 26);
    }

    /**
     * Méthode main de démonstration.
     * Montre le chiffrement et le déchiffrement d'une chaîne.
     */
    public static void main(String[] args) {
        ChaineCryptee c1 = ChaineCryptee.deEnClair("BONJOUR TOUT LE MONDE", 3);
        System.out.println("Chaîne en clair   : BONJOUR TOUT LE MONDE");
        System.out.println("Chaîne cryptée    : " + c1.crypte());
        System.out.println("Chaîne décryptée  : " + c1.decrypte());

        ChaineCryptee c2 = ChaineCryptee.deCryptee("DEF", 3);
        System.out.println("Décryptage de DEF avec clé 3 : " + c2.decrypte());
    }
}
