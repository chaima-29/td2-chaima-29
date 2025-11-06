package fr.uvsq.cprog;

/**
 * Classe permettant de chiffrer et déchiffrer une chaîne de caractères
 * (lettres majuscules et espaces) par décalage.
 */
public class ChaineCryptee {

    private String clair;
    private int decalage;

    // Constructeur privé
    private ChaineCryptee(String clair, int decalage) {
        this.clair = clair;
        this.decalage = decalage;
    }

    // Méthode de création depuis une chaîne en clair
    public static ChaineCryptee deEnClair(String clair, int decalage) {
        return new ChaineCryptee(clair, decalage);
    }

    // Méthode de création depuis une chaîne déjà cryptée
    public static ChaineCryptee deCryptee(String cryptee, int decalage) {
        String clair = decrypteStatic(cryptee, decalage);
        return new ChaineCryptee(clair, decalage);
    }

    // Méthode pour obtenir la chaîne chiffrée
    public String crypte() {
        return crypteStatic(clair, decalage);
    }

    // Méthode pour obtenir la chaîne en clair
    public String decrypte() {
        return clair;
    }

    // Méthodes statiques utilitaires
    private static String crypteStatic(String s, int decalage) {
        if (s == null) return null;
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            sb.append(decaleCaractere(c, decalage));
        }
        return sb.toString();
    }

    private static String decrypteStatic(String s, int decalage) {
        return crypteStatic(s, 26 - decalage % 26);
    }

    private static char decaleCaractere(char c, int decalage) {
        if (c == ' ') return ' ';
        return (char) ('A' + (c - 'A' + decalage + 26) % 26);
    }
}
