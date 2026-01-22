package ricksciascia.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;

import java.time.LocalDate;
@Entity
@Table(name = "concerti")
public class Concerto extends Event{
    @Enumerated(EnumType.STRING)
    private Genere genere;
    private boolean inStreaming;

    public Concerto(){
    }

    public Concerto(String nomeConcerto, LocalDate data, String descr, TipoEvento tipoEvento,
                    int nMaxPart, Location locationConcerto, Genere genere, boolean inStreaming) {
        super(nomeConcerto ,data ,descr ,tipoEvento ,nMaxPart ,locationConcerto);
        this.genere = genere;
        this.inStreaming = inStreaming;
    }

//    getter e setter

    public Genere getGenere() {
        return genere;
    }

    public void setGenere(Genere genere) {
        this.genere = genere;
    }

    public boolean isInStreaming() {
        return inStreaming;
    }

    public void setInStreaming(boolean inStreaming) {
        this.inStreaming = inStreaming;
    }

    @Override
    public String toString() {
        return "Concerto{" +
                "genere=" + genere +
                ", inStreaming=" + inStreaming +
                '}';
    }
}
