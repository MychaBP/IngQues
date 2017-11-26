package pl.ing.zadanko.api.dto;

import java.util.List;

public class ClientsTableDto {

    private List<ClientTableDto> clients;

    public List<ClientTableDto> getClients() {
        return clients;
    }

    public void setClients(List<ClientTableDto> clients) {
        this.clients = clients;
    }
}
