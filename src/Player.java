/**
 * Classe Player che viene utilizzata per memorizzare il nome
 * del giocatore e gestire il suo punteggio
 *
 * @author Davide Branchi
 */
public class Player {
    private String name;
    private int score;

    /**
     * Costruttore Player
     * @param name nome del giocatore
     */
    public Player(String name){
        this.name = name;
        this.score = 0;
    }

    /**
     * Metodo getter che ritorna il nome del giocatore
     * @return nome del giocatore
     */
    public String getName() {
        return name;
    }

    /**
     * Metodo setter che imposta il nome del giocatore
     * @param name nome del giocatore
     */
    private void setName(String name) {
        this.name = name;
    }

    /**
     * Metodo getter che ritorna lo score del giocatore
     * @return score del giocatore
     */
    public int getScore() {
        return score;
    }

    /**
     * Metodo setter che imposta lo score del giocatore
     * @param score score del giocatore
     */
    private void setScore(int score) {
        this.score = score;
    }

    /**
     * Metodo che incrementa lo score del giocatore di 1
     */
    public void addScore(){
        this.score++;
    }
}
