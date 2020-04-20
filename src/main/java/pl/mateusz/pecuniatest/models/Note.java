package pl.mateusz.pecuniatest.models;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "notes")
public class Note extends Many {


    public Note(Date dateBuyNote, String nameCurrency, Integer signatureCode, Double priceBuy, Double priceSell, Integer quantity, String status, String statusSell, String description, String imgType, String aversPath, String reversePath, Double denomination, String noteDate, String quality, String series, String making, String bought) {
        super(dateBuyNote, nameCurrency, signatureCode, priceBuy, priceSell, quantity, status, statusSell, description, imgType, aversPath, reversePath);
        this.denomination = denomination;
        this.noteDate = noteDate;
        this.quality = quality;
        this.series = series;
        this.making = making;
        this.bought = bought;
    }

    public Note() {
    }


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "notes_sequence")
    private Long id;
    private Double denomination;
    @Column(name = "note_date")
    private String noteDate;
    private String quality;
    private String series;
    private String making;
    private String bought;

    @ManyToOne
    @JoinColumn(name = "currency_id")
    private Currency currency;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getDenomination() {
        return denomination;
    }

    public void setDenomination(Double denomination) {
        this.denomination = denomination;
    }

    public String getNoteDate() {
        return noteDate;
    }

    public void setNoteDate(String noteDate) {
        this.noteDate = noteDate;
    }

    public String getQuality() {
        return quality;
    }

    public void setQuality(String quality) {
        this.quality = quality;
    }

    public String getSeries() {
        return series;
    }

    public void setSeries(String series) {
        this.series = series;
    }

    public String getMaking() {
        return making;
    }

    public void setMaking(String making) {
        this.making = making;
    }

    public String getBought() {
        return bought;
    }

    public void setBought(String bought) {
        this.bought = bought;
    }

//    @Override
//    public String toString() {
//        return "Note{" +
//                "id=" + id +
//                ", denomination=" + denomination +
//                ", noteDate='" + noteDate + '\'' +
//                ", quality='" + quality + '\'' +
//                ", series='" + series + '\'' +
//                ", making='" + making + '\'' +
//                ", bought='" + bought + '\'' +
//                '}';
//    }


}
