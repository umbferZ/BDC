/*
 * 
 * Created by Umberto Ferracci from urania's PC
 * email: umberto.ferracci@gmail.com
 * Project: BdC
 * Package: main.org.bdc.model.galaxy
 * Type: Source
 * Last update: 11-set-2017 20.29.35
 * 
 */

package main.org.bdc.model.galaxy;

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
public class Source {

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
        flows = new ArrayList<>();
    }

    public void addFlow(Flow flow) {
        flows.add(flow);
    }

    /**
     * Gets the flows.
     *
     * @return the flows
     */
    public List<Flow> getFlow() {
        return flows;
    }

    public List<Flow> getFlows() {
        return flows;
    }

    /**
     * Gets the id.
     *
     * @return the id
     */
    public String getId() {
        return id;
    }

    public Map getMap() {
        return map;
    }

    public Position getPosition() {
        return position;
    }

    public Source getSourceToLowerResolution() {
        return sourceToLowerResolution;
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