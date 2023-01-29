/**
 * Classe PratoFiorito che permette di gestire il prato
 * e la posizione de fiori
 *
 * @author Davide Branchi
 */
public class PratoFiorito {
    private int dimension;
    private String[][] prato;
    private String[][] fiori;

    /**
     * Metodo costruttore della classe che definisce la dimensione del prato
     * @param dimension dimensione del prato
     */
    public PratoFiorito(int dimension){
        setDimension(dimension);
    }

    /**
     * Metodo che ritorna il prato come stringa
     * @return stringa equivalente al prato
     */
    public String getPrato() {
        String output = "";
        for(int i = 0; i < prato.length; i++){
            for(int j = 0; j < prato[i].length; j++){
                if(prato[i][j].equals("*")){
                    output += Colors.red(prato[i][j]) + " ";
                }else{
                    output += Colors.green(prato[i][j]) + " ";
                }
            }
            output += "\n";
        }
        return output;
    }

    /**
     * Metodo setter che imposta una matrice stringa per il prato
     * @param prato matrice da utilizzare come prato
     */
    private void setPrato(String[][] prato) {
        this.prato = prato;
    }

    /**
     * Metodo che ritorna la matrice dei fiori come stringa
     * @return stringa equivalente alla matrice dei fiori
     */
    public String getFiori() {
        String output = "";
        for(int i = 0; i < fiori.length; i++){
            for(int j = 0; j < fiori[i].length; j++){
                if(fiori[i][j].equals("*")){
                    output += Colors.red(fiori[i][j]) + " ";
                }else{
                    output += Colors.green(fiori[i][j]) + " ";
                }
            }
            output += "\n";
        }
        return output;
    }

    /**
     * Metodo setter che imposta una matrice stringa come fiori
     * @param fiori matrice da utilizzare come fiori
     */
    public void setFiori(String[][] fiori) {
        this.fiori = fiori;
    }

    /**
     * Metodo getter che ritorna la dimensione del prato
     * @return dimensione del prato
     */
    public int getDimension() {
        return dimension;
    }

    /**
     * Metodo setter che imposta la dimensione del prato
     * @param dimension dimensione del prato
     */
    public void setDimension(int dimension) {
        if(dimension < 2 || dimension > 50){
            this.dimension = 10;
        }else{
            this.dimension = dimension;
        }
    }

    /**
     * Metodo che inizializza il prato e i fiori, la matrice del
     * prato vien riempita con il carattere "#"
     * la matrice dei fiori invece viene riempita casualmente con i fiori
     * rappresentati dal carattere "*"
     */
    public void inizializzaPrato(){
        prato = new String[dimension][dimension];
        fiori = new String[dimension][dimension];
        for(int i = 0; i < dimension; i++){
            for(int j = 0; j < dimension; j++){
                prato[i][j] = "#";
                fiori[i][j] = "#";
            }
        }
        for(int i = 0; i < dimension; i++){
            int r = random(0, dimension-1);
            int c = random(0, dimension-1);
            if(fiori[r][c].equals("#")){
                fiori[r][c] = "*";
            }else{
                i--;
            }
        }
    }

    /**
     * Metodo che stampa il prato utilizzando gli ANSI escape codes
     */
    public void printPrato(){
        for(int i = 0; i < prato.length; i++){
            for(int j = 0; j < prato[i].length; j++){
                if(prato[i][j].equals("*")){
                    System.out.print(Colors.red(prato[i][j]) + " ");
                }else{
                    System.out.print(Colors.green(prato[i][j]) + " ");
                }
            }
            System.out.println();
        }
    }

    /**
     * Metodo che stampa i fiori utilizzando gli ANSI escape codes
     */
    public void printFiori(){
        for(int i = 0; i < fiori.length; i++){
            for(int j = 0; j < fiori[i].length; j++){
                if(fiori[i][j].equals("*")){
                    System.out.print(Colors.red(fiori[i][j]) + " ");
                }else{
                    System.out.print(Colors.green(fiori[i][j]) + " ");
                }
            }
            System.out.println();
        }
    }

    /**
     * Metodo che genera un numero casuale
     * fra il minimo e il massimo (compresi)
     * @param min minimo
     * @param max massimo
     * @return numero casuale fra min e max
     */
    private int random(int min, int max){
        return (int)Math.floor(Math.random()*(max-min+1)+min);
    }

    /**
     * Metodo che controlla se la cella passata tramite row e colum
     * è valida (non è già stata scoperta)
     * @param row riga della cella
     * @param colum colonna della cella
     * @return true se la cella è valida, false altrimenti
     */
    public boolean isAValidCell(int row, int colum){
        if(prato[row-1][colum-1].equals("#")){
            return true;
        }else{
            return false;
        }
    }

    /**
     * Metodo che controlla se la cella passata contiene un fiore
     * @param row riga della cella
     * @param colum colonna della cella
     * @return true se la cella contiene un fiore, false altrimenti
     */
    public boolean isFlowerCell(int row, int colum){
        if(fiori[row-1][colum-1].equals("*")){
            prato[row-1][colum-1] = "*";
            return true;
        }else{
            return false;
        }
    }

    /**
     * Metodo che scopre la cella passata
     * @param row riga della cella
     * @param colum colonna della cella
     */
    public void mineCell(int row, int colum){
        prato[row-1][colum-1] = " ";
    }
}
