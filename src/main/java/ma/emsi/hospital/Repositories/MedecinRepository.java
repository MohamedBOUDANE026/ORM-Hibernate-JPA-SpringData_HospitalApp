package ma.emsi.hospital.Repositories;

import ma.emsi.hospital.Entities.Medecin;
import ma.emsi.hospital.Entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedecinRepository extends JpaRepository<Medecin,Long> {
    Medecin findByNom(String m);
}
