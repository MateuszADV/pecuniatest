package pl.mateusz.pecuniatest.models;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
@Entity
@Table(name = "country")
public class Country {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "country_sequence")
    private Long id;
    private String continent;
    @Column(name = "country_en")
    private String countryEn;
    @Column(name = "country_pl")
    private String countryPl;
    @Column(name = "capital_city")
    private String capitalCity;
    @Column(name = "alfa_2")
    private String alfa2;
    @Column(name = "alfa_3")
    private String alfa3;
    @Column(name = "numeric_code")
    private String numericCode;
    @Column(name = "iso_code")
    private String isoCode;

    @OneToMany(mappedBy = "country", cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    private List<Currency> currencies;
}
