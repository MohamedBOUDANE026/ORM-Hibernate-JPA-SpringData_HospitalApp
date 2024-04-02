package ma.emsi.hospital.service;

import ma.emsi.hospital.Entities.Consultation;
import ma.emsi.hospital.Entities.Medecin;
import ma.emsi.hospital.Entities.Patient;
import ma.emsi.hospital.Entities.RDV;

public interface IhospitalService {
     Patient savePatient(Patient p);
     Medecin saveMedecin(Medecin m);
     RDV saveRDV(RDV r);
     Consultation saveCons(Consultation c);

}
