/*
 * 
 * Created by Umberto Ferracci, Francesco Ottaviano and Federica Zelli
 * Project: BdC - Osservatorio Astronomico Virtuale
 * Package: test.provahib
 * Type: Azienda
 * Last update: 13-set-2017 14.06.33
 * 
 */

package test.provahib;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Azienda {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int    id;

    private String name;

    private String qualcosa;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getQualcosa() {
        return qualcosa;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setQualcosa(String qualcosa) {
        this.qualcosa = qualcosa;
    }

}
