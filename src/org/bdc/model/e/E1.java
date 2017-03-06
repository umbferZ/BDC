/*
 * 
 * Created by Umberto Ferracci from urania's PC
 * email: umberto.ferracci@gmail.com
 * Project: BdC
 * Package: org.bdc.model
 * Type: E1
 * Last update: 6-mar-2017 12.45.21
 * 
 */
package org.bdc.model.e;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
public class E1 {

    @Id
    @GeneratedValue
    private int id;

    private String nome;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "e2_id")
    private List<E2> listE2;

    @OneToMany(mappedBy = "e1", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<E3> listE3;

    public E1() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String string) {
        this.nome = string;
    }

    public List<E2> getListE2() {
        return listE2;
    }

    public void setListE2(List<E2> listE2) {
        this.listE2 = listE2;
    }

    public List<E3> getListE3() {
        return listE3;
    }

    public void setListE3(List<E3> listE3) {
        this.listE3 = listE3;
    }

}
