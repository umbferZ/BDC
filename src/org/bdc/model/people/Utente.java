/*
 * 
 * Created by Umberto Ferracci from urania's PC
 * email: umberto.ferracci@gmail.com
 * Project: BdC
 * Package: org.bdc.model.people
 * Type: Utente
 * Last update: 12-mar-2017 16.23.01
 * 
 */

package org.bdc.model.people;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.IdClass;

/**
 * The Class Utente.
 */
@Entity
@IdClass(Utente_PK.class)
public class Utente {

    private String cognome;

    @Id
    private String email;

    private String nome;

    private String password;

    @Enumerated(EnumType.STRING)
    private TipoUtente tipoUtente;

    @Id
    private String username;

    /**
     * Instantiates a new utente.
     */
    public Utente() {
        super();
    }

    /**
     * Gets the cognome.
     *
     * @return the cognome
     */
    public String getCognome() {
        return cognome;
    }

    /**
     * Gets the email.
     *
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * Gets the nome.
     *
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * Gets the password.
     *
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Gets the tipo utente.
     *
     * @return the tipo utente
     */
    public TipoUtente getTipoUtente() {
        return tipoUtente;
    }

    /**
     * Gets the username.
     *
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * Sets the cognome.
     *
     * @param cognome the new cognome
     */
    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    /**
     * Sets the email.
     *
     * @param email the new email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Sets the nome.
     *
     * @param nome the new nome
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Sets the password.
     *
     * @param password the new password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Sets the tipo utente.
     *
     * @param tipoUtente the new tipo utente
     */
    public void setTipoUtente(TipoUtente tipoUtente) {
        this.tipoUtente = tipoUtente;
    }

    /**
     * Sets the username.
     *
     * @param username the new username
     */
    public void setUsername(String username) {
        this.username = username;
    }
}
