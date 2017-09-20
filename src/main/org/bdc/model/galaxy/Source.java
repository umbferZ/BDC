/*
 * 
 * Created by Umberto Ferracci, Francesco Ottaviano and Federica Zelli
 * Project: BdC - Osservatorio Astronomico Virtuale
 * Package: main.org.bdc.model.galaxy
 * Type: Source
 * Last update: 20-set-2017 13.23.24
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
import javax.persistence.Transient;

/**
 * The Class Source.
 */
@Entity
public class Source implements Serializable {

    @Transient
    private double     distance;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Flow> flows;

    @Id
    private String     id;

    @ManyToOne(fetch = FetchType.LAZY)
    private Map        map;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "source")
    private Position   position;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Source     sourceToLowerResolution;

    /**
     * Instantiates a new source.
     */
    public Source() {
        flows = new ArrayList<>();
    }

    /**
     * Adds the flow.
     *
     * @param flow the flow
     */
    public void addFlow(Flow flow) {
        flows.add(flow);
    }

    /**
     * Gets the distance.
     *
     * @return the distance
     */
    public double getDistance() {
        return distance;
    }

    /**
     * Gets the flow.
     *
     * @return the flow
     */
    public List<Flow> getFlow() {
        return flows;
    }

    /**
     * Gets the flows.
     *
     * @return the flows
     */
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

    /**
     * Gets the map.
     *
     * @return the map
     */
    public Map getMap() {
        return map;
    }

    /**
     * Gets the position.
     *
     * @return the position
     */
    public Position getPosition() {
        return position;
    }

    /**
     * Gets the source to lower resolution.
     *
     * @return the source to lower resolution
     */
    public Source getSourceToLowerResolution() {
        return sourceToLowerResolution;
    }

    /**
     * Sets the distance.
     *
     * @param distance the new distance
     */
    public void setDistance(double distance) {
        this.distance = distance;
    }

    /**
     * Sets the flow.
     *
     * @param flows the new flow
     */
    public void setFlow(List<Flow> flows) {
        this.flows = flows;
    }

    /**
     * Sets the flows.
     *
     * @param flows the new flows
     */
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

    /**
     * Sets the map.
     *
     * @param map the new map
     */
    public void setMap(Map map) {
        this.map = map;
    }

    /**
     * Sets the position.
     *
     * @param position the new position
     */
    public void setPosition(Position position) {
        this.position = position;
    }

    /**
     * Sets the source to lower resolution.
     *
     * @param sourceToLowerResolution the new source to lower resolution
     */
    public void setSourceToLowerResolution(Source sourceToLowerResolution) {
        this.sourceToLowerResolution = sourceToLowerResolution;
    }
}