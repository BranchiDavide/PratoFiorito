/**
 * Classe principale del prato fiorito, questa è la classe da cui
 * parte il programma.
 * Nella classe Main vengono chiesti tutti gli input che devono
 * essere inseriti dall'utente, e viene fatto anche un controllo su eventuali
 * valori non validi inseriti da parte dell'utente
 *
 * @author Davide Branchi
 */

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        SoundPlayer sound = new SoundPlayer("Assets/game.wav");
        sound.play();
        Scanner in = new Scanner(System.in);
        String output = "";
        String currentOutput;
        System.out.println(currentOutput = Colors.cyan("PRATO FIORITO GAME"));
        output += currentOutput + "\n";
        System.out.print(currentOutput = Colors.yellow("Enter your name: "));
        output += currentOutput + "\n";
        String name;
        do{
            name = in.nextLine();
            if(name.equals("")){
                System.out.println(currentOutput = Colors.redBg("Inserire un nome!"));
                output += currentOutput + "\n";
                System.out.print(currentOutput = Colors.yellow("Enter your name: "));
                output += currentOutput + "\n";
            }
        }while(name.equals(""));
        output += name + "\n";
        System.out.print(currentOutput = Colors.yellow("Enter dimension (2-50): "));
        output += currentOutput + "\n";
        int dimension;
        try{
            dimension = Integer.parseInt(in.nextLine());
            output += dimension + "\n";
        }catch(NumberFormatException e){
            dimension = 10;
            System.out.println(currentOutput = Colors.redBg("Valore non valido! Inserito dimensione 10 (default)"));
            output += currentOutput + "\n";
        }
        if(dimension < 2 || dimension > 50){
            System.out.println(currentOutput = Colors.redBg("Valore non valido! Inserito dimensione 10 (default)"));
            output += currentOutput + "\n";
        }
        PratoFiorito pratoFiorito = new PratoFiorito(dimension);
        Player player = new Player(name);
        System.out.println(currentOutput = Colors.yellow("Game started"));
        output += currentOutput + "\n";
        pratoFiorito.inizializzaPrato();
        pratoFiorito.printPrato();
        output += pratoFiorito.getPrato();
        boolean match = true;
        int moves = 0;
        while(match){
            boolean validCell = false;
            int row = 0;
            int colum = 0;
            while(!validCell){
                boolean validRow = false;
                while(!validRow){
                    System.out.println(currentOutput = Colors.yellow("Enter row:"));
                    output += currentOutput + "\n";
                    try{
                        row = Integer.parseInt(in.nextLine().trim());
                        output += row + "\n";
                        if(row > 0 && row <= pratoFiorito.getDimension()){
                            validRow = true;
                        }else{
                            System.out.println(currentOutput = Colors.redBg("Valore inserito non valido, riprovare"));
                            output += currentOutput + "\n";
                        }
                    }catch(NumberFormatException e){
                        System.out.println(currentOutput = Colors.redBg("Valore inserito non valido, riprovare"));
                        output += currentOutput + "\n";
                    }
                }
                boolean validColum = false;
                while(!validColum){
                    try{
                        System.out.println(currentOutput = Colors.yellow("Enter Colum:"));
                        output += currentOutput + "\n";
                        colum = Integer.parseInt(in.nextLine().trim());
                        output += colum + "\n";
                        if(colum > 0 && colum <= pratoFiorito.getDimension()){
                            validColum = true;
                        }else{
                            System.out.println(currentOutput = Colors.redBg("Valore inserito non valido, riprovare"));
                            output += currentOutput + "\n";
                        }
                    }catch(NumberFormatException e){
                        System.out.println(currentOutput = Colors.redBg("Valore inserito non valido, riprovare"));
                        output += currentOutput + "\n";
                    }
                }
                if(pratoFiorito.isAValidCell(row,colum)){
                    validCell = true;
                }else{
                    System.out.println(currentOutput = Colors.redBg("Cella selezionata già scoperta"));
                    output += currentOutput + "\n";
                }
            }
            if(pratoFiorito.isFlowerCell(row,colum)){
                sound.stop();
                sound.setSoundPath("Assets/gameover.wav");
                sound.play();
                match = false;
                pratoFiorito.printPrato();
                output += pratoFiorito.getPrato();
                System.out.println(currentOutput = Colors.red("GAME OVER"));
                output += currentOutput + "\n";
                System.out.println(currentOutput = Colors.cyan("Player: " + player.getName()));
                output += currentOutput + "\n";
                System.out.println(currentOutput = Colors.cyan("Score: " + player.getScore()));
                output += currentOutput + "\n";
                System.out.print(currentOutput = Colors.yellow("Visualizzare la posizione di tutti i fiori? (S/N): "));
                output += currentOutput + "\n";
                String choice = in.nextLine().toLowerCase().trim();
                output += choice + "\n";
                if(choice.equals("s")){
                    pratoFiorito.printFiori();
                    output += pratoFiorito.getFiori();
                }
            }else{
                pratoFiorito.mineCell(row, colum);
                player.addScore();
                pratoFiorito.printPrato();
                output += pratoFiorito.getPrato();
                moves++;
            }
            if(moves == (Math.pow(pratoFiorito.getDimension(), 2) - pratoFiorito.getDimension())){
                sound.stop();
                sound.setSoundPath("Assets/gamewin.wav");
                sound.play();
                match = false;
                System.out.println(currentOutput = Colors.yellowBg("YOU WON!"));
                output += currentOutput + "\n";
                System.out.println(currentOutput = Colors.cyan("Player: " + player.getName()));
                output += currentOutput + "\n";
                System.out.println(currentOutput = Colors.cyan("Score: " + player.getScore()));
                output += currentOutput + "\n";
            }
        }
        System.out.print(currentOutput = Colors.yellow("Esportare la partita in un file pdf? (S/N): "));
        output += currentOutput + "\n";
        String choice = in.nextLine().toLowerCase().trim();
        output += choice + "\n";
        if(choice.equals("s")){
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy_HH.mm.ss");
            LocalDateTime now = LocalDateTime.now();
            String pdfName = "prato_fiorito_" + dtf.format(now) + ".pdf";
            ExportGame export = new ExportGame(pdfName, output);
            try{
                export.startExport();
                System.out.println(Colors.green("Partita esportata nel file " + pdfName));
            }catch (Exception e){
                System.out.println(Colors.redBg("Errore nell'esportazione della partita in un file pdf"));
                System.out.println(Colors.redBg(e.getMessage()));
            }
        }
    }
}
