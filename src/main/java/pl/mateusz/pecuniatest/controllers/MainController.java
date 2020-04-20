package pl.mateusz.pecuniatest.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import pl.mateusz.pecuniatest.models.*;
import pl.mateusz.pecuniatest.models.dtos.CoinDto;
import pl.mateusz.pecuniatest.models.dtos.NoteDto;
import pl.mateusz.pecuniatest.repository.CoinRepository;
import pl.mateusz.pecuniatest.repository.CountryRepository;
import pl.mateusz.pecuniatest.repository.CurrencyRepository;
import pl.mateusz.pecuniatest.repository.NoteRepository;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Controller
public class MainController {

    private NoteRepository noteRepository;
    private CoinRepository coinRepository;
    private CountryRepository countryRepository;
    private CurrencyRepository currencyRepository;

    public MainController(NoteRepository noteRepository, CoinRepository coinRepository, CountryRepository countryRepository, CurrencyRepository currencyRepository) {
        this.noteRepository = noteRepository;
        this.coinRepository = coinRepository;
        this.countryRepository = countryRepository;
        this.currencyRepository = currencyRepository;
    }

    @GetMapping("/")
    public String getMain() {


        return "index";
    }

    @GetMapping("/dane")
    public String getDane(ModelMap modelMap) {

        List<Note> noteList = noteRepository.findAll();
        List<NoteDto> noteDtoList = new ArrayList<>();

        for (Note note : noteList) {
            noteDtoList.add(new ModelMapper().map(note, NoteDto.class));
        }

//        noteList.forEach(System.out::println);
        System.out.println(noteList.get(0));
        System.out.println(noteDtoList.get(0));

//           modelMap.addAttribute("banknoty",manyList);
        modelMap.addAttribute("note", noteDtoList.get(0));
        return "index";
    }
    @GetMapping("/addcoins")
    public String getAddCoin(ModelMap modelMap) {
        Country country = countryRepository.getOne(172l);
        Currency currency = currencyRepository.getOne(226l);

        Coin coin = new Coin();
        coin.setDateBuyNote(Date.valueOf("2020-04-16"));
        coin.setBought("LOC");
        coin.setDenomination(100d);
        coin.setPriceBuy(2.5);
        coin.setPriceSell(7d);
        coin.setCoinDate("2000");
        coin.setSeries("1990-2000");
        coin.setStatus("KOLECTION");
        coin.setComposition("Al - 20%\nFe - 80%");
        coin.setDescription("Opis monety ");
        coin.setNameCurrency("Złotówka");
        coin.setQuality("bdb");
        coin.setImgType("foto");
        coin.setSignatureCode(101);
        coin.setAversPath("Avers");
        coin.setReversePath("Revers");
        coin.setCurrency(currency);

        coinRepository.save(coin);
        CoinDto coinDto = new ModelMapper().map(coin, CoinDto.class);

        System.out.println(coinDto);

        modelMap.addAttribute("coin", coinDto);
    return "index";
    }
}
