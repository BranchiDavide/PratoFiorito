/**
 * Classe SoundPlayer che permette di riprodurre dei suoni
 *
 * @author Davide Branchi
 */

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.File;

public class SoundPlayer {
    private static String soundPath;
    private Clip clip;

    /**
     * Metodo costruttore che permette di istanziare un oggetto
     * SoundPlayer per far riprodurre dei suoni
     * @param soundPath percorso dove si trova il file audio (solo file .wav)
     */
    public SoundPlayer(String soundPath) {
        this.soundPath = soundPath;
        try{
            clip = AudioSystem.getClip();
        }catch(Exception e){
            System.out.println(Colors.redBg("Errore nel caricamento dell'audio"));
            System.out.println(Colors.redBg(e.getMessage()));
        }
    }

    /**
     * Metodo che fa partire la riproduzione del file audio
     */
    public synchronized void play() {
        try{
            AudioInputStream input = AudioSystem.getAudioInputStream(new File(soundPath));
            clip.open(input);
            clip.start();
            clip.loop(Clip.LOOP_CONTINUOUSLY);
        }catch(Exception e){
            System.out.println(Colors.redBg("Errore nel caricamento dell'audio"));
            System.out.println(Colors.redBg(e.getMessage()));
        }
    }

    /**
     * Metodo che interrompe la riproduzione del file audio
     */
    public void stop(){
        clip.stop();
        clip.close();
    }

    /**
     * Metodo getter che ritorna il percorso del file audio
     * @return percorso del file audio
     */
    public String getSoundPath() {
        return soundPath;
    }

    /**
     * Metodo setter che imposta il percorso del file audio
     * @param soundPath percorso del file audio (solo file .wav)
     */
    public void setSoundPath(String soundPath) {
        SoundPlayer.soundPath = soundPath;
    }
}
