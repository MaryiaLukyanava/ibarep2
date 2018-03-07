package iba.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "buoy")
public class Buoy implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idbuoy")
    private Long idbuoy;

    @Column(name = "longitude")
    private double longitude;

    @Column(name = "latitude")
    private double latitude;

    @Column(name = "owner")
    private String owner;


    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public Long getIdbuoy() {
        return idbuoy;
    }

    public void setIdbuoy(Long idbuoy) {
        this.idbuoy = idbuoy;
    }
}
