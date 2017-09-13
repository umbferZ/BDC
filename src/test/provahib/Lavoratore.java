/*
 * 
 * Created by Umberto Ferracci, Francesco Ottaviano and Federica Zelli
 * Project: BdC - Osservatorio Astronomico Virtuale
 * Package: test.provahib
 * Type: Lavoratore
 * Last update: 13-set-2017 14.06.21
 * 
 */

package test.provahib;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Lavoratore {

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Azienda azienda;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int     id;

    private String  name;

    private String  other;

    public Lavoratore() {}

    public Azienda getAzienda() {
        return azienda;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getOther() {
        return other;
    }

    public void setAzienda(Azienda azienda) {
        this.azienda = azienda;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setOther(String other) {
        this.other = other;
    }

}
