package nl.alexdewaal66.novi.vessels.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.ToString;
import nl.alexdewaal66.novi.vessels.generics.BaseEntity;
import nl.alexdewaal66.novi.vessels.generics.GenericEntity;
import nl.alexdewaal66.novi.vessels.utils.Property;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import java.sql.Timestamp;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Entity @ToString
public class Vessel extends BaseEntity implements GenericEntity<Vessel> {

    @Override @JsonIgnore @Transient
    public List<String> getTextProperties() {
        return Arrays.asList("hullNumber", "builder");
    }


    @ManyToOne
    @JoinColumn(name = "hull_id")
    private Hull hull;

    @Column(name = "item_name")
    private String name;

    @OneToOne
    private Image image;

    @Size(max = 10)
    private String mmsi;

    @Size(max = 10)
    private String callSign;

    @ManyToOne
    @JoinColumn(name = "vessel_type_id")
    private VesselType vesselType;

    @ManyToOne
    @JoinColumn(name = "un_locode_id")
    private UNLocode homePort;

    @Positive(message = "Length must be larger than zero")
    private Double length; //LWL or LOA ?

    @Positive(message = "Beam must be larger than zero")
    private Double beam;

    @Positive(message = "Draft must be larger than zero")
    private Double draft;

    @Positive(message = "Displacement must be larger than zero")
    private Double displacement;

    @Temporal(value = TemporalType.DATE)
    private Date startDate;

    @Temporal(value = TemporalType.DATE)
    private Date endDate;


    public Hull getHull() { return hull; }
    public void setHull(Hull hull) { this.hull = hull; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public Image getImage() { return image; }
    public void setImage(Image image) { this.image = image; }

    public String getMmsi() { return mmsi; }
    public void setMmsi(String mmsi) { this.mmsi = mmsi; }

    public String getCallSign() { return callSign; }
    public void setCallSign(String callsign) { this.callSign = callsign; }

    public VesselType getVesselType() { return vesselType; }
    public void setVesselType(VesselType vesselType) { this.vesselType = vesselType; }

    public UNLocode getHomePort() { return homePort; }
    public void setHomePort(UNLocode homePort) { this.homePort = homePort; }

    public Double getLength() { return length; }
    public void setLength(Double length) { this.length = length; }

    public Double getBeam() { return beam; }
    public void setBeam(Double beam) { this.beam = beam; }

    public Double getDraft() { return draft; }
    public void setDraft(Double draft) { this.draft = draft; }

    public Double getDisplacement() { return displacement; }
    public void setDisplacement(Double displacement) { this.displacement = displacement; }

    public Date getStartDate() { return startDate; }
    public void setStartDate(Date startDate) { this.startDate = startDate; }

    public Date getEndDate() { return endDate; }
    public void setEndDate(Date endDate) { this.endDate = endDate; }

}
