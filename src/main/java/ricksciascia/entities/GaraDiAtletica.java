package ricksciascia.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "gara_di_atletica")
public class GaraDiAtletica extends Event{
    private List<Person> listaAtleti;
    private Person winner;

    public GaraDiAtletica(){}
    public GaraDiAtletica(String titoloGara, LocalDate dataEvento, String descrizione, TipoEvento tipoEvento,
                          int nMaxPart, Location locationGara,List<Person> listaAtleti,Person winner) {
        super(titoloGara,dataEvento,descrizione,tipoEvento,nMaxPart,locationGara);
        this.listaAtleti = listaAtleti;
        this.winner = winner;
    }
//    setter e getter

    public List<Person> getListaAtleti() {
        return listaAtleti;
    }

    public void setListaAtleti(List<Person> listaAtleti) {
        this.listaAtleti = listaAtleti;
    }

    public Person getWinner() {
        return winner;
    }

    public void setWinner(Person winner) {
        this.winner = winner;
    }

    @Override
    public String toString() {
        return "GaraDiAtletica{" +
                "listaAtleti=" + listaAtleti +
                ", winner=" + winner +
                '}';
    }
}
