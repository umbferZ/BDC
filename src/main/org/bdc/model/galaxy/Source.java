/*
 * 
 * Created by Umberto Ferracci, Francesco Ottaviano and Federica Zelli
 * Project: BdC - Osservatorio Astronomico Virtuale
 * Package: main.org.bdc.model.galaxy
 * Type: Source
 * Last update: 13-set-2017 0.26.51
 * 
 */

package main.org.bdc.model.galaxy;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

/**
 * The Class Source.
 */
@Entity
public class Source implements Serializable {

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Flow> flows;

    @Id
    private String     id;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Map        map;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "source")
    private Position   position;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Source     sourceToLowerResolution;

    /**
     * Instantiates a new sorgente.
     */
    public Source() {
        this.flows = new ArrayList<>();
    }

    public void addFlow(Flow flow) {
        this.flows.add(flow);
    }

    /**
     * Gets the flows.
     *
     * @return the flows
     */
    public List<Flow> getFlow() {
        return this.flows;
    }

    public List<Flow> getFlows() {
        return this.flows;
    }

    /**
     * Gets the id.
     *
     * @return the id
     */
    public String getId() {
        return this.id;
    }

    public Map getMap() {
        return this.map;
    }

    public Position getPosition() {
        return this.position;
    }

    public Source getSourceToLowerResolution() {
        return this.sourceToLowerResolution;
    }

    /**
     * Sets the flusso.
     *
     * @param flows the new flusso
     */
    public void setFlow(List<Flow> flows) {
        this.flows = flows;
    }

    public void setFlows(List<Flow> flows) {
        this.flows = flows;
    }

    /**
     * Sets the id.
     *
     * @param id the new id
     */
    public void setId(String id) {
        this.id = id;
    }

    public void setMap(Map map) {
        this.map = map;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public void setSourceToLowerResolution(Source sourceToLowerResolution) {
        this.sourceToLowerResolution = sourceToLowerResolution;
    }
}