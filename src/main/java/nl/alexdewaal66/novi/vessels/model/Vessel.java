package nl.alexdewaal66.novi.vessels.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.NoArgsConstructor;
import lombok.ToString;
import nl.alexdewaal66.novi.vessels.infrastructure.BaseEntity;
import nl.alexdewaal66.novi.vessels.utils.ItemIdSerializer;
import nl.alexdewaal66.novi.vessels.utils.ItemIdSetSerializer;

import javax.persistence.*;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Entity @ToString @NoArgsConstructor
public class Vessel extends BaseEntity<Vessel> {

    @Override @JsonIgnore @Transient
    public List<String> getTextProperties() {
        return Arrays.asList("hullNumber", "builder");
    }


    @JsonSerialize(using = ItemIdSerializer.class)
    @ManyToOne
    @JoinColumn(name = "hull_id")
    private Hull hull;

    @Column(name = "item_name")
    private String name;

    @Size(max = 5000)
    private String description;

    @OneToOne
    private Image image;

    @Size(max = 10)
    private String mmsi;

    @Size(max = 10)
    private String callSign;

    @JsonSerialize(using = ItemIdSerializer.class)
    @ManyToOne
    @JoinColumn(name = "vessel_type_id")
    private VesselType vesselType;

    @JsonSerialize(using = ItemIdSerializer.class)
    @ManyToOne
    @JoinColumn(name = "un_locode_id")
    private UNLocode homePort;

    @Column(name = "length_oa")
    @Positive(message = "Length must be larger than zero")
    private Double lengthOA; //LWL or LOA ?

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

    @JsonSerialize(using = ItemIdSerializer.class)
    @ManyToOne
    @JoinColumn(name = "propulsion_type_id")
    private PropulsionType propulsionType;

    @JsonSerialize(using = ItemIdSetSerializer.class)
    @OneToMany(mappedBy = "vessel")
    Set<Operation> operations;


    public Hull getHull() { return hull; }
    public void setHull(Hull hull) { this.hull = hull; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getDescription() {return description;}
    public void setDescription(String description) {this.description = description;}

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

    public Double getLengthOA() { return lengthOA; }
    public void setLengthOA(Double length) { this.lengthOA = length; }

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

    public Set<Operation> getOperations() {return operations;}
    public void setOperations(Set<Operation> operations) {this.operations = operations;}

}

    /*
    Potential Fields:

    Management
        Manager
        Owner
        Classification Society
        Insurer

    Length:
        Length overall
        Length between perpendiculars
        Length at the waterline
    Breadth:
        Beam
    Depth:
        Draft
        Moulded depth
        Freeboard
        Waterline (Plimsoll Line)
    Height:
        Air draft
    Volume:
        Worldwide:
            Tonnage
            Gross tonnage
            Compensated gross tonnage
            Net tonnage
        Specialized:
            Panama Canal/Universal Measurement System
            Thames measurement tonnage
        Archaic:
            Gross register tonnage
            Net register tonnage
    Capacity:
        Current:
            Deadweight tonnage
            Twenty-foot equivalent unit (Intermodal containers)
        Archaic:
            Builder's Old Measurement
            Moorsom System
    Weight:
        Displacement
        Loaded displacement
        Standard displacement
        Light displacement
        Normal displacement
    Stability:
        Inclining test
        List
        Angle of loll
        Metacentric height (GM)

    Air draft
    Beam Midl
    Complement
    Cube
        Bale Cube
        Grain Cube
    Draft
        Summer Load
        Winter Load
    DWT
        Summer
        Winter
    DWAT
    Gross Tonnage
    Length BP
    Length WL
    Length OS
    Net Tonnage
     */
