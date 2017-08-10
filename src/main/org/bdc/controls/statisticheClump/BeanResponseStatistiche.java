/*
 * 
 * Created by Umberto Ferracci from urania's PC
 * email: umberto.ferracci@gmail.com
 * Project: BdC
 * Package: main.org.bdc.controls.statisticheClump
 * Type: BeanResponseStatistiche
 * Last update: 11-mar-2017 19.20.51
 * 
 */

package main.org.bdc.controls.statisticheClump;

public class BeanResponseStatistiche {

    private double deviazioneMediaAssoluta;

    private double deviazioneStandard;

    private double media;

    private double mediana;

    public double getDeviazioneMediaAssoluta() {

        return deviazioneMediaAssoluta;
    }

    public double getDeviazioneStandard() {

        return deviazioneStandard;
    }

    public double getMedia() {

        return media;
    }

    public double getMediana() {

        return mediana;
    }

    public void setDeviazioneMediaAssoluta(double deviazioneMediaAssoluta) {

        this.deviazioneMediaAssoluta = deviazioneMediaAssoluta;
    }

    public void setDeviazioneStandard(double deviazioneStandard) {

        this.deviazioneStandard = deviazioneStandard;
    }

    public void setMedia(double media) {

        this.media = media;
    }

    public void setMediana(double mediana) {

        this.mediana = mediana;
    }
}
