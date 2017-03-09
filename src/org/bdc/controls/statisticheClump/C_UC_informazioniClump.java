/*
 * 
 * Created by Umberto Ferracci from urania's PC
 * email: umberto.ferracci@gmail.com
 * Project: BdC
 * Package: org.bdc.controls.statisticheClump
 * Type: C_UC_informazioniClump
 * Last update: 9-mar-2017 18.32.20
 * 
 */
package org.bdc.controls.statisticheClump;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.bdc.model.DaoFactory;
import org.bdc.model.entity.Clump;

public class C_UC_informazioniClump {
    public List<BeanResponseMassaClump> getMasseClump() {
        List<Clump> clumps = DaoFactory.getInstance().getClumpDao().getAll();
        List<BeanResponseMassaClump> list = new ArrayList<>();
        for (Clump c : clumps) {
            BeanResponseMassaClump b = new BeanResponseMassaClump();
            b.setMassa(c.getMassa());
            b.setIdClump(c.getId());
            list.add(b);
        }
        return list;

    }

    public BeanResponseStatistiche getStatistiche() {
        List<Clump> clumps = DaoFactory.getInstance().getClumpDao().getAll();
        BeanResponseStatistiche bean = new BeanResponseStatistiche();
        double massSum = 0;
        double mediana = 0;
        double deviazioneMediaAssoluta = 0;
        double media = 0;
        double[] massSort = null; // TODO replace null with somethings
        double[] massDev = null;
        int i = 0;
        for (Clump c : clumps) {

            massSum += c.getMassa();
            massSort[i] = c.getMassa();
            i++;
        }
        Arrays.sort(massSort);
        media = massSum / clumps.size();
        mediana = (massSort.length % 2) == 0 ? (massSort[massSort.length / 2] + massSort[(massSort.length / 2) - 1]) / 2 : (double) massSort[massSort.length / 2];
        double devAss = 0;
        i = 0;
        for (Clump c : clumps) {
            massDev[i] = c.getMassa() - mediana;
            devAss += Math.pow((c.getMassa() - media), 2);
            massSum += c.getMassa();
            i++;
        }

        deviazioneMediaAssoluta = (massDev.length % 2) == 0 ? (massDev[massDev.length / 2] + massDev[(massDev.length / 2) - 1]) / 2 : (double) massDev[massDev.length / 2];
        bean.setMedia(media);
        bean.setDeviazioneMediaAssoluta(deviazioneMediaAssoluta);
        bean.setDeviazioneStandard(Math.sqrt((devAss / clumps.size())));
        bean.setMediana(mediana);
        return bean;
    }
}
