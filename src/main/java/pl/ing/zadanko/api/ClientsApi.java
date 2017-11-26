package pl.ing.zadanko.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pl.ing.zadanko.services.ClientService;
import pl.ing.zadanko.api.dto.ClientFullDto;
import pl.ing.zadanko.api.dto.ClientsTableDto;
import pl.ing.zadanko.api.dto.ClientsFilterDto;

@RestController
@RequestMapping("/clients")
public class ClientsApi {

    ClientService clientService;

    @Autowired
    public ClientsApi(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping(path = "/clients")
    public ClientsTableDto getClients() {
        return clientService.getClients();
    }

    @GetMapping(path = "/client/{clientId}")
    public ClientFullDto getClient(@PathVariable("clientId") Integer clientId) {
        return clientService.getFullClientById(clientId);
    }

    @PostMapping(path = "/filter")
    public ClientsTableDto doFilter(@RequestBody ClientsFilterDto clientsFilterDto){
        return clientService.getFilteredClients(clientsFilterDto);
    }

}
