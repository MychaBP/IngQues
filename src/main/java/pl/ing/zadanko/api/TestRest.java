package pl.ing.zadanko.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.ing.zadanko.services.ReportService;
import pl.ing.zadanko.services.CsvParser;
import pl.ing.zadanko.repositiories.ClientsRepository;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;

@RestController
public class TestRest {

    CsvParser csvParser;
    ClientsRepository clientsRepository;
    ReportService reportService;

    @Autowired
    TestRest(CsvParser csvParser, ClientsRepository clientsRepository, ReportService reportService) {
        this.csvParser = csvParser;
        this.clientsRepository = clientsRepository;
        this.reportService = reportService;
    }

    @RequestMapping(path = "test")
    public boolean testa() {
        Timestamp ts =Timestamp.valueOf(LocalDate.now().atStartOfDay());
        Timestamp ts2 = Timestamp.valueOf(LocalDateTime.now());

        csvParser.parse();
        return true;
    }

    @RequestMapping(path = "asap")
    public String asap() {
        reportService.makeDayliReport();
        return "OK";
    }
}
