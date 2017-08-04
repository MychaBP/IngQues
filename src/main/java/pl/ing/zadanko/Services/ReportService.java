package pl.ing.zadanko.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.ing.zadanko.repositiories.ClientsRepository;

import java.io.FileWriter;
import java.io.IOException;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReportService {

    ClientsRepository clientsRepository;

    @Autowired
    ReportService(ClientsRepository clientsRepository) {
        this.clientsRepository = clientsRepository;
    }

    public void makeDayliReport(){
        List<String> verses = prepareVerses(getDataForDayliReport());
        saveReport(verses);
    }

    private List<String> prepareVerses(List<Object[]> data) {
        List<String> result = new ArrayList<>();
        addHederLine(result);
        prepareDaylyReport(result, data);

        return result;
    }

    private List<Object[]> getDataForDayliReport(){
        Timestamp dateTo = Timestamp.valueOf(LocalDateTime.now());
        Timestamp dateFrom = Timestamp.valueOf(LocalDateTime.now().minusDays(1));
        return clientsRepository.findNoteCountToDaylyReport(dateFrom, dateTo);
    }

    private void addHederLine(List<String> list) {
        StringBuilder sb = new StringBuilder();
        sb.append("branza, ")
                .append("ilosc_notatek");
        list.add(sb.toString());
    }

    private void prepareDaylyReport(List<String> report, List<Object[]> data) {
       List<String> result = data.stream().map(p -> prepareObject(p)).collect(Collectors.toCollection(ArrayList::new));
       report.addAll(result);
    }

    private String prepareObject(Object[] objectTable) {
        StringBuilder stringBuilder = new StringBuilder();
        boolean first = true;

        stringBuilder.append("\r\n");
        for(Object obj : objectTable) {
            if(!first) {
                stringBuilder.append(", ");
            }
            stringBuilder.append(obj.toString());

            first = false;
        }
        return stringBuilder.toString();
    }

    private void saveReport(List<String> report) {
        try {
            FileWriter fileWriter = new FileWriter("C:\\Users\\Mycha\\Desktop\\zadanie\\" + prepareDaylyReportFileName());

            for(String vers : report) {
                fileWriter.append(vers);
            }
            fileWriter.flush();
            fileWriter.close();
        } catch (IOException e) {

        }

    }

    private String prepareDaylyReportFileName() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("report_")
                .append(LocalDate.now().toString())
                .append(".csv");
        return stringBuilder.toString();
    }
}
