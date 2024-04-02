package ma.emsi.hospital.service;

import jakarta.transaction.Transactional;
import ma.emsi.hospital.Entities.Consultation;
import ma.emsi.hospital.Entities.Medecin;
import ma.emsi.hospital.Entities.Patient;
import ma.emsi.hospital.Entities.RDV;
import ma.emsi.hospital.Repositories.ConsultationRepository;
import ma.emsi.hospital.Repositories.MedecinRepository;
import ma.emsi.hospital.Repositories.PatientRepository;
import ma.emsi.hospital.Repositories.RdvRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@Transactional

public class HospitalServerImpl implements IhospitalService{
    private PatientRepository patientRepository;
    private MedecinRepository medecinRepository;
    private RdvRepository rdvRepository;
    private ConsultationRepository consultationRepository;

    public HospitalServerImpl(PatientRepository patientRepository,MedecinRepository medecinRepository,
                              RdvRepository rdvRepository,ConsultationRepository consultationRepository) {
        this.patientRepository = patientRepository;
        this.medecinRepository = medecinRepository;
        this.rdvRepository = rdvRepository;
        this.consultationRepository = consultationRepository;
    }

    @Override
    public Patient savePatient(Patient p) {
        return patientRepository.save(p);
    }

    @Override
    public Medecin saveMedecin(Medecin m) {
        return medecinRepository.save(m);
    }

    @Override
    public RDV saveRDV(RDV r) {
        r.setId(UUID.randomUUID().toString());
        return rdvRepository.save(r);
    }

    @Override
    public Consultation saveCons(Consultation c) {
        return consultationRepository.save(c);
    }
}
