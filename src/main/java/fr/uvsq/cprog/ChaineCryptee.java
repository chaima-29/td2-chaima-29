package fr.uvsq.cprog;

/**
 * Classe permettant de chiffrer et déchiffrer une chaîne de caractères
 * (lettres majuscules et espaces) par décalage.
 */
public class ChaineCryptee {

    private String clair;
    private int decalage;

    /**
     * Constructeur privé pour forcer l'utilisation des méthodes de fabrique.
     */
    private ChaineCryptee(String clair, int decalage) {
        this.clair = clair;
        this.decalage = decalage;
    }

    /**
     * Méthode de fabrique pour créer une ChaineCryptee à partir d'une chaîne en clair.
     */
    public static ChaineCryptee deEnClair(String clair, int decalage) {
        return new ChaineCryptee(clair, decalage);
    }

    /**
     * Méthode de fabrique pour créer une ChaineCryptee à partir d'une chaîne déjà cryptée.
     */
    public static ChaineCryptee deCryptee(String cryptee, int decalage) {
        String clair = decrypteStatic(cryptee, decalage);
        return new ChaineCryptee(clair, decalage);
    }

    /**
     * Retourne la chaîne cryptée.
     */
    public String crypte() {
        return crypteStatic(clair, decalage);
    }

    /**
     * Retourne la chaîne en clair.
     */
    public String decrypte() {
        return clair;
    }

    /**
     * Méthode statique pour chiffrer une chaîne.
     */
    private static String crypteStatic(String s, int decalage) {
        if (s == null) return null; // ✅ Empêche les NullPointerException
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
}
