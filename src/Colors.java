/**
 * Classe Colors utile per stampare dei testi colorati
 * su console che interpretano gli ANSI escape codes.
 *
 * @author Davide Branchi
 */
public class Colors {
    //Costanti contenenti gli escape codes per ogni colore
    public static final String RESET = "\u001B[0m";
    public static final String BLACK = "\u001B[30m";
    public static final String RED = "\u001B[31m";
    public static final String GREEN = "\u001B[32m";
    public static final String YELLOW = "\u001B[33m";
    public static final String BLUE = "\u001B[34m";
    public static final String PURPLE = "\u001B[35m";
    public static final String CYAN = "\u001B[36m";
    public static final String WHITE = "\u001B[37m";

    public static final String BLACK_BG = "\u001B[40m";
    public static final String RED_BG = "\u001B[41m";
    public static final String GREEN_BG = "\u001B[42m";
    public static final String YELLOW_BG = "\u001B[43m";
    public static final String BLUE_BG = "\u001B[44m";
    public static final String PURPLE_BG = "\u001B[45m";
    public static final String CYAN_BG = "\u001B[46m";
    public static final String WHITE_BG = "\u001B[47m";

    /**
     * Metodo che restituisce uns stringa con ANSI escape code
     * per il colore nero
     *
     * @param text testo da colorare
     * @return stringa con il testo nero
     */
    public static String black(String text) {
        return BLACK + text + RESET;
    }

    /**
     * Metodo che restituisce uns stringa con ANSI escape code
     * per il colore rosso
     *
     * @param text testo da colorare
     * @return stringa con il testo rosso
     */
    public static String red(String text) {
        return RED + text + RESET;
    }

    /**
     * Metodo che restituisce uns stringa con ANSI escape code
     * per il colore verde
     *
     * @param text testo da colorare
     * @return stringa con il testo verde
     */
    public static String green(String text) {
        return GREEN + text + RESET;
    }

    /**
     * Metodo che restituisce uns stringa con ANSI escape code
     * per il colore giallo
     *
     * @param text testo da colorare
     * @return stringa con il testo giallo
     */
    public static String yellow(String text) {
        return YELLOW + text + RESET;
    }

    /**
     * Metodo che restituisce uns stringa con ANSI escape code
     * per il colore blu
     *
     * @param text testo da colorare
     * @return stringa con il testo blu
     */
    public static String blue(String text) {
        return BLUE + text + RESET;
    }

    /**
     * Metodo che restituisce uns stringa con ANSI escape code
     * per il colore viola
     *
     * @param text testo da colorare
     * @return stringa con il testo viola
     */
    public static String purple(String text) {
        return PURPLE + text + RESET;
    }

    /**
     * Metodo che restituisce uns stringa con ANSI escape code
     * per il colore ciano
     *
     * @param text testo da colorare
     * @return stringa con il testo ciano
     */
    public static String cyan(String text) {
        return CYAN + text + RESET;
    }

    /**
     * Metodo che restituisce uns stringa con ANSI escape code
     * per il colore bianco
     *
     * @param text testo da colorare
     * @return stringa con il testo bianco
     */
    public static String white(String text) {
        return WHITE + text + RESET;
    }

    /**
     * Metodo che restituisce uns stringa con ANSI escape code
     * per lo sfondo nero di un testo
     *
     * @param text testo da colorare
     * @return stringa con lo sfondo nero
     */
    public static String blackBg(String text) {
        return BLACK_BG + text + RESET;
    }

    /**
     * Metodo che restituisce uns stringa con ANSI escape code
     * per lo sfondo rosso di un testo
     *
     * @param text testo da colorare
     * @return stringa con lo sfondo rosso
     */
    public static String redBg(String text) {
        return RED_BG + text + RESET;
    }

    /**
     * Metodo che restituisce uns stringa con ANSI escape code
     * per lo sfondo verde di un testo
     *
     * @param text testo da colorare
     * @return stringa con lo sfondo verde
     */
    public static String greenBg(String text) {
        return GREEN_BG + text + RESET;
    }

    /**
     * Metodo che restituisce uns stringa con ANSI escape code
     * per lo sfondo giallo di un testo
     *
     * @param text testo da colorare
     * @return stringa con lo sfondo giallo
     */
    public static String yellowBg(String text) {
        return YELLOW_BG + text + RESET;
    }

    /**
     * Metodo che restituisce uns stringa con ANSI escape code
     * per lo sfondo blu di un testo
     *
     * @param text testo da colorare
     * @return stringa con lo sfondo blu
     */
    public static String blueBg(String text) {
        return BLUE_BG + text + RESET;
    }

    /**
     * Metodo che restituisce uns stringa con ANSI escape code
     * per lo sfondo viola di un testo
     *
     * @param text testo da colorare
     * @return stringa con lo sfondo viola
     */
    public static String purpleBg(String text) {
        return PURPLE_BG + text + RESET;
    }

    /**
     * Metodo che restituisce uns stringa con ANSI escape code
     * per lo sfondo ciano di un testo
     *
     * @param text testo da colorare
     * @return stringa con lo sfondo ciano
     */
    public static String cyanBg(String text) {
        return CYAN_BG + text + RESET;
    }

    /**
     * Metodo che restituisce uns stringa con ANSI escape code
     * per lo sfondo bianco di un testo
     *
     * @param text testo da colorare
     * @return stringa con lo sfondo bianco
     */
    public static String whiteBg(String text) {
        return WHITE_BG + text + RESET;
    }
}