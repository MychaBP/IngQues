package pl.ing.zadanko.Services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.ing.zadanko.dao.Clients;
import pl.ing.zadanko.repositiories.ClientsRepository;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FilenameFilter;
import java.io.IOException;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Service
public class CsvParser {

    ClientsRepository clientsRepository;

    @Autowired
    public CsvParser(ClientsRepository clientsRepository) {
        this.clientsRepository = clientsRepository;
    }

    public void parse() {
        File file  = new File("C:\\Users\\Mycha\\Desktop\\zadanie");

        File[] csvFiles = file.listFiles(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                return name.startsWith("klienci") && name.endsWith(".csv");
            }
        });

        BufferedReader br = null;
        String line = "";
        String csvSplitBy = ",";
        for(File fil : csvFiles) {
            try {
                String fName = fil.getPath();
                br = new BufferedReader(new FileReader(fName));
                while((line = br.readLine()) != null) {
                    String[] parties = line.split(csvSplitBy);

                    if(tryParseInt(parties[0])) {
                        Clients client = clientsRepository.findOneByClientNr(new Integer(parties[0]));
                        if(client == null) {
                           clientsRepository.save(prepareClient(parties));
                        } else {
                            updateClient(client, parties);
                            clientsRepository.save(client);
                        }
                    }
                    System.out.println(line+" : "+parties.length);
                }

            } catch (IOException e) {

            }
        }
    }

    private Clients prepareClient(String[] data) {
        Clients clients = new Clients();

        clients.setClientNr(new Integer(data[0]));
        clients.setName(data[1]);
        clients.setRegion(data[2]);
        clients.setPhoneNumber(data[3]);
        clients.setBranza(data[4]);
        clients.setEmail(data[5]);
        clients.setActivityFrom(Timestamp.valueOf(LocalDate.parse(data[6]).atStartOfDay()));
        clients.setCreateAt(Timestamp.valueOf(LocalDateTime.now()));

        return clients;
    }

    private void updateClient(Clients client, String[] data){
        client.setClientNr(new Integer(data[0]));
        client.setName(data[1]);
        client.setRegion(data[2]);
        client.setBranza(data[3]);
        client.setPhoneNumber(data[4]);
        client.setEmail(data[5]);
        client.setActivityFrom(Timestamp.valueOf(LocalDate.parse(data[6]).atStartOfDay()));
        client.setLastModify(Timestamp.valueOf(LocalDateTime.now()));
    }

    private boolean tryParseInt(String toParse) {
        try {
            Integer.parseInt(toParse);
            return true;
        } catch(NumberFormatException e) {
            return false;
        }
    }


}
