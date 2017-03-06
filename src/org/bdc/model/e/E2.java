/*
 * 
 * Created by Umberto Ferracci from urania's PC
 * email: umberto.ferracci@gmail.com
 * Project: BdC
 * Package: org.bdc.model
 * Type: E2
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

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.Fetch;

@Entity
public class E2 {
    @Id
    @GeneratedValue
    private int id;

    private String nome;

    @ManyToMany(mappedBy="listE2", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<E1> e1;

    public E2() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<E1> getE1() {
        return e1;
    }

    public void setE1(List<E1> e1) {
        this.e1 = e1;
    }

}
