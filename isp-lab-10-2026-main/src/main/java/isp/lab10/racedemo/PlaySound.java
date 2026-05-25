package isp.lab10.raceapp;

import java.io.File;
import javax.sound.sampled.*;

public class PlaySound {
    private Clip sunetAuto;

    void playSound() {
        try {
            sunetAuto = AudioSystem.getClip();
            sunetAuto.open(AudioSystem.getAudioInputStream(new File(".\\shanghai-formula-1-grand-prix.wav")));
            sunetAuto.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    void stopSound(){
        if(sunetAuto != null)
            sunetAuto.stop();
    }
}