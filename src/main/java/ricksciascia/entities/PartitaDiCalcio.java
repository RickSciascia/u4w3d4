package ricksciascia.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.time.LocalDate;

@Entity
@Table(name = "parite_di_calcio")
public class PartitaDiCalcio extends Event {
    private String home;
    private String away;
    private String winningTeam;
    private int golHomeTeam;
    private int golAwayTeam;

//    costruttore vuoto
    public PartitaDiCalcio(){
    }
//    costruttore custom
    public PartitaDiCalcio(LocalDate dataEvento, String descrizione,TipoEvento tipoEvento,int numeroMaxPart, Location locationPartita,
                           String homeTeam, String awayTeam, String winningTeam, int golHomeTeam, int golAwayTeam)
    {
        super(homeTeam + " - " + awayTeam,dataEvento,descrizione,tipoEvento,numeroMaxPart,locationPartita);
        this.home = homeTeam;
        this.away = awayTeam;
        this.winningTeam = winningTeam;
        this.golHomeTeam = golHomeTeam;
        this.golAwayTeam = golAwayTeam;
    }
//    getter e setter


    public String getHome() {
        return home;
    }

    public void setHome(String home) {
        this.home = home;
    }

    public String getAway() {
        return away;
    }

    public void setAway(String away) {
        this.away = away;
    }

    public String getWinningTeam() {
        return winningTeam;
    }

    public void setWinningTeam(String winningTeam) {
        this.winningTeam = winningTeam;
    }

    public int getGolHomeTeam() {
        return golHomeTeam;
    }

    public void setGolHomeTeam(int golHomeTeam) {
        this.golHomeTeam = golHomeTeam;
    }

    public int getGolAwayTeam() {
        return golAwayTeam;
    }

    public void setGolAwayTeam(int golAwayTeam) {
        this.golAwayTeam = golAwayTeam;
    }

    @Override
    public String toString() {
        return "PartitaDiCalcio{" +
                "home='" + home + '\'' +
                ", away='" + away + '\'' +
                ", winningTeam='" + winningTeam + '\'' +
                ", golHomeTeam=" + golHomeTeam +
                ", golAwayTeam=" + golAwayTeam +
                '}';
    }
}

