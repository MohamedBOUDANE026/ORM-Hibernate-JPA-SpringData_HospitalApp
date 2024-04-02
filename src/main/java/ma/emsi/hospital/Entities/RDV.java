package ma.emsi.hospital.Entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jdk.jshell.Snippet;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RDV {
    @Id

     private String id;
     private Date date;
     @Enumerated(EnumType.STRING)
     private StatusRDV status;
     @ManyToOne
     @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
     private Patient p;
    @ManyToOne
     private Medecin m;
    @OneToOne(mappedBy = "rendezvous")
     private Consultation cons;
}
