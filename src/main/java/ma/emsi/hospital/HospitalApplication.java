package ma.emsi.hospital;

import ma.emsi.hospital.Entities.*;
import ma.emsi.hospital.Repositories.ConsultationRepository;
import ma.emsi.hospital.Repositories.MedecinRepository;
import ma.emsi.hospital.Repositories.PatientRepository;
import ma.emsi.hospital.Repositories.RdvRepository;
import ma.emsi.hospital.service.IhospitalService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.lang.constant.Constable;
import java.util.Date;
import java.util.stream.Stream;

@SpringBootApplication
public class HospitalApplication  {

    public static void main(String[] args) {
        SpringApplication.run(HospitalApplication.class, args);
    }

  @Bean
    CommandLineRunner start(IhospitalService hospitalService,
                            PatientRepository patientRepository,
                            MedecinRepository medecinRepository,
                            RdvRepository rdvRepository,
                            ConsultationRepository consultationRepository){
        return args -> {
            Stream.of("Mohamed","Hassan","Hafsa").forEach(n->{
                Patient p = new Patient();
                p.setNom(n);
                p.setDateNaissance(new Date());
                p.setMalade(false);
                hospitalService.savePatient(p);
            });
            Stream.of("Abdo","Rachid","Yasmine").forEach(n->{
                Medecin m = new Medecin();
                m.setNom(n);
                m.setEmail(n+"@gmail.com");
                m.setSpec(Math.random()>0.5?"Cardio":"Dentiste");
                hospitalService.saveMedecin(m);
            });

            Patient p=patientRepository.findById(1L).get();
            Patient p1=patientRepository.findByNom("Mohamed");

            Medecin m=medecinRepository.findByNom("Yasmine");

            RDV Rendez_vous=new RDV();
            Rendez_vous.setDate(new Date());
            Rendez_vous.setStatus(StatusRDV.PENDING);
            Rendez_vous.setM(m);
            Rendez_vous.setP(p1);
            RDV savedRDV = hospitalService.saveRDV(Rendez_vous);
            System.out.println(savedRDV.getId());

            RDV rdv1=rdvRepository.findAll().get(0);
            Consultation cons = new Consultation();
            cons.setDateConsultation(new Date());
            cons.setRendezvous(rdv1);
            cons.setRapport("Rapport de consultation");
            hospitalService.saveCons(cons);


        };
  }
}
