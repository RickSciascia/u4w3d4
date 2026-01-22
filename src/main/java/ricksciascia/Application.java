package ricksciascia;

import com.github.javafaker.Faker;
import ricksciascia.dao.AttendancesDAO;
import ricksciascia.dao.EventsDAO;
import ricksciascia.dao.LocationsDAO;
import ricksciascia.dao.PeopleDAO;
import ricksciascia.entities.*;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import java.time.LocalDate;
import java.util.Locale;
import java.util.Random;

public class Application {
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("u4w3d4pu");

    public static void main(String[] args) {
        EntityManager em = emf.createEntityManager();
        Faker faker = new Faker(Locale.ITALY);
        EventsDAO eventsDAO = new EventsDAO(em);
        LocationsDAO locationsDAO = new LocationsDAO(em);
        PeopleDAO peopleDAO = new PeopleDAO(em);
        AttendancesDAO attendancesDAO = new AttendancesDAO(em);
        Random rndm = new Random();

        // ******************** SALVATAGGIO LOCATIONS, UTENTI E EVENTI ************************

//        Location location1 = new Location(faker.address().city(), faker.address().cityName());
        Location sanSiro = new Location("Stadio Giuseppe Meazza in San Siro", "Milano");
//        locationsDAO.save(sanSiro);
//        Location location2 = new Location(faker.address().city(), faker.address().cityName());
        Location palalottomatica = new Location("Pala Lottomatica", "Roma");
        Location olimpico = new Location("Stadio Olimpico di Roma", "Roma");
//        locationsDAO.save(palalottomatica);
//        locationsDAO.save(olimpico);

        Person person1 = new Person(faker.name().firstName(), faker.name().lastName(), faker.internet().emailAddress(), LocalDate.now(), rndm.nextInt(0, 2) == 0 ? 'M' : 'F');
        Person person2 = new Person(faker.name().firstName(), faker.name().lastName(), faker.internet().emailAddress(), LocalDate.now(), rndm.nextInt(0, 2) == 0 ? 'M' : 'F');
        Person person3 = new Person(faker.name().firstName(), faker.name().lastName(), faker.internet().emailAddress(), LocalDate.now(), rndm.nextInt(0, 2) == 0 ? 'M' : 'F');
//        peopleDAO.save(person1);
//        peopleDAO.save(person2);
//        peopleDAO.save(person3);
        Location sSiroFromDB = locationsDAO.findById(52);
        Location palalottomaticaFromDB = locationsDAO.findById(53);
        Location olimpicoFromDB = locationsDAO.findById(54);
        Concerto concerto1 = new Concerto("Pupo a S.Siro", LocalDate.of(2026,7,24),"incredibile",TipoEvento.PUBBLICO,40000,sSiroFromDB,Genere.POP,false);
        Concerto concerto2 = new Concerto("Vasco a S.Siro", LocalDate.of(2026,7,30),"Vasco a S.Siro",TipoEvento.PUBBLICO,40000,sSiroFromDB,Genere.POP,false);
        Concerto concerto3 = new Concerto("Pupo a Roma", LocalDate.of(2026,7,27),"incredibile anche in streaming",TipoEvento.PUBBLICO,30000,palalottomaticaFromDB,Genere.POP,true);
//        PartitaDiCalcio match1= new PartitaDiCalcio(LocalDate.of(2026,1,25),"Big match all Olimpico",TipoEvento.PUBBLICO,90000,olimpicoFromDB,);

//        for (int i = 0; i < 5; i++) {
//            eventsDAO.save(new Event(
//                    faker.chuckNorris().fact(),
//                    LocalDate.of(rndm.nextInt(2025, 2027),
//                            rndm.nextInt(1, 13),
//                            rndm.nextInt(1, 29)),
//                    faker.lorem().fixedString(50),
//                    rndm.nextInt(1, 3) == 1 ? TipoEvento.PRIVATO : TipoEvento.PUBBLICO,
//                    rndm.nextInt(1, 1000), rndm.nextInt(0, 2) == 0 ? location1 : location2));


            // ******************** PARTECIPAZIONE AD UN EVENTO ************************

//        Person person = peopleDAO.findById();
//        Event event = eventsDAO.findById();
        

//        Attendance partecipazione = new Attendance(person, event);
            // attendancesDAO.save(partecipazione);

            // Stampo eventi a cui partecipa la persona 23
//        person.getListaPartecipazioni().forEach(System.out::println);

            // Stampo elenco partecipanti evento 24
//        event.getListaPartecipazioni().forEach(System.out::println);

            // ******************** CASCADING ************************

            // Eliminando un evento dovrebbe eliminare anche le partecipazioni ad esso collegate
//        eventsDAO.findByIdAndDelete(24);

//
//            em.close();
//            emf.close();
//        }
    }
}