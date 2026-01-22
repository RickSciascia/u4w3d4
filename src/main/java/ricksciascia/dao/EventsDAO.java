package ricksciascia.dao;

import jakarta.persistence.TypedQuery;
import ricksciascia.entities.Concerto;
import ricksciascia.entities.Event;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import ricksciascia.entities.Genere;

import java.util.List;

public class EventsDAO {
    private EntityManager em;

    public EventsDAO(EntityManager em) {
        this.em = em;
    }


    public void save(Event evento) {
        try {
            EntityTransaction t = em.getTransaction();
            t.begin();
            em.persist(evento);
            t.commit();
            System.out.println("Evento - " + evento.getTitolo() + " - creato!");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public Event findById(long id) {
        return em.find(Event.class, id);
    }

    public void findByIdAndDelete(long id) {
        try {
            EntityTransaction t = em.getTransaction();
            Event found = em.find(Event.class, id);
            if (found != null) {
                t.begin();
                em.remove(found);
                t.commit();
                System.out.println("Evento eliminato");
            } else System.out.println("Evento non trovato");


        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    public List<Concerto> getConcertiInStreaming(boolean streaming) {
        TypedQuery<Concerto> query = em.createQuery("SELECT concerto FROM Concerto concerto WHERE concerto.inStreaming = :isStreaming", Concerto.class);
        query.setParameter("isStreaming", streaming);
        return query.getResultList();
    }

    public List<Concerto> getConcertiPerGenere(Genere genere) {
        TypedQuery<Concerto> query = em.createQuery("SELECT c From Concerto c WHERE c.genere = :genere", Concerto.class);
        query.setParameter("genere",genere);
        return query.getResultList();
    }
}
