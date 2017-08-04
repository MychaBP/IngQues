package pl.ing.zadanko.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pl.ing.zadanko.Services.ClientService;
import pl.ing.zadanko.api.dto.ClientFullDto;
import pl.ing.zadanko.api.dto.ClientsTableDto;

@RestController
@RequestMapping("/clients")
public class ClientsApi {

    ClientService clientService;

    @Autowired
    public ClientsApi(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping(path = "/Clients")
    public ClientsTableDto getClients() {
        return clientService.getClients();
    }

    @GetMapping(path = "/client")
    public ClientFullDto GetClient(@RequestParam("clientNr") Integer clientNr) {
        return clientService.getFullClientByKey(clientNr);
    }

}
