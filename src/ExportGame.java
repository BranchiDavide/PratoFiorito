/**
 * Classe che permette di esportare un testo in un pdf
 * la classe utilizza una libreria esterna (itextpdf)
 * che è contenuta in un file jar dentro al package com.itextpdf
 *
 * @author Davide Branchi
 */

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.Font.FontFamily;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Scanner;

public class ExportGame {
    private String path;
    private String pdfContent;
    Font red = new Font(FontFamily.COURIER, 11, Font.BOLD, BaseColor.RED);
    Font black = new Font(FontFamily.COURIER, 11, Font.BOLD, BaseColor.BLACK);
    Font cyan = new Font(FontFamily.COURIER, 11, Font.BOLD, BaseColor.BLUE);
    Font yellow = new Font(FontFamily.COURIER, 11, Font.BOLD, BaseColor.ORANGE);
    Font green = new Font(FontFamily.COURIER, 11, Font.BOLD, BaseColor.GREEN);
    Font white = new Font(FontFamily.COURIER, 11, Font.BOLD, BaseColor.WHITE);

    /**
     * Metodo costruttore della classe che permette di istanziare un oggetto
     * ExportGame a cui deve essere passato come parametro il percorso del pdf
     * da creare e il contenuto di esso
     * @param path percorso del pdf
     * @param pdfContent contenuto del pdf
     */
    public ExportGame(String path, String pdfContent) {
        this.path = path;
        this.pdfContent = pdfContent;
    }

    /**
     * Metodo che esporta il contenuto in un pdf interpretando anche gli
     * ANSI escape codes per scrivere il testo colorato
     * @throws FileNotFoundException
     * @throws DocumentException
     */
    public void startExport() throws FileNotFoundException, DocumentException {
        Scanner content = new Scanner(pdfContent);
        Document document = new Document();
        PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(path));
        document.open();
        while (content.hasNextLine()) {
            String line = content.nextLine();
            Paragraph p = new Paragraph();
            String ansiColor = "";
            for (int i = 0; i < line.length(); i++) {
                if (line.charAt(i) == '\u001B') { //Trovato escape code
                    ansiColor = "";
                    i++;
                    while (line.charAt(i) != 'm') {
                        ansiColor += line.charAt(i);
                        i++;
                    }
                    i++;
                }
                if (i < line.length()) {
                    if (line.charAt(i) != '\u001B') {
                        switch (ansiColor) { //Switch per colorare il testo in base all'escape code trovato
                            case "[31":
                                Chunk redText = new Chunk(line.charAt(i), red);
                                p.add(redText);
                                break;
                            case "[32":
                                Chunk greenText = new Chunk(line.charAt(i), green);
                                p.add(greenText);
                                break;
                            case "[33":
                                Chunk yellowText = new Chunk(line.charAt(i), yellow);
                                p.add(yellowText);
                                break;
                            case "[36":
                                Chunk cyanText = new Chunk(line.charAt(i), cyan);
                                p.add(cyanText);
                                break;
                            case "[41":
                                Chunk redBgText = new Chunk(line.charAt(i), white);
                                redBgText.setBackground(BaseColor.RED);
                                p.add(redBgText);
                                break;
                            case "[43":
                                Chunk yellowBgText = new Chunk(line.charAt(i), white);
                                yellowBgText.setBackground(BaseColor.ORANGE);
                                p.add(yellowBgText);
                                break;
                            default:
                                Chunk blackText = new Chunk(line.charAt(i), black);
                                p.add(blackText);
                                break;
                        }
                    } else {
                        i--;
                    }
                }
            }
            p.setAlignment(1);
            document.add(p);
        }
        document.close();
    }
}
