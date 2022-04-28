package ma.emsi.patientsmvc;

import ma.emsi.patientsmvc.entities.Patient;
import ma.emsi.patientsmvc.repositories.PatientRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;

@SpringBootApplication
public class PatientsMvcApplication {

    public static void main(String[] args) {

        SpringApplication.run(PatientsMvcApplication.class, args);
    }
        @Bean
        CommandLineRunner commandLineRunner(PatientRepository patientRepository) {
            return args -> {
                patientRepository.save(
                        new Patient(null, "Hassan", new Date(), true, 12));
                patientRepository.save(
                        new Patient(null, "Chaimae", new Date(), false, 10));
                patientRepository.save(
                        new Patient(null, "Zineb", new Date(), false, 100));
                patientRepository.save(
                        new Patient(null, "Fatimazahra", new Date(), false, 321));
                patientRepository.findAll().forEach(p->{
                    System.out.println(p.getNom());
                });
            };
        }

}
