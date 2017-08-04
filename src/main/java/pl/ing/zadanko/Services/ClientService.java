package pl.ing.zadanko.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.ing.zadanko.api.dto.ClientFullDto;
import pl.ing.zadanko.api.dto.ClientTableDto;
import pl.ing.zadanko.api.dto.ClientsTableDto;
import pl.ing.zadanko.dao.Clients;
import pl.ing.zadanko.repositiories.ClientsRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClientService {

    ClientsRepository clientsRepository;

    @Autowired
    public ClientService(ClientsRepository clientsRepository) {
        this.clientsRepository = clientsRepository;
    }

    public ClientsTableDto getClients() {
        return prepareDTO(clientsRepository.findAll());
    }

    public ClientFullDto getFullClientByKey(Integer clientNr) {
        return prepareFullClientDto(clientsRepository.findOneByClientNr(clientNr));
    }

    private ClientsTableDto prepareDTO(List<Clients> clients) {
        ClientsTableDto clientsTableDto = new ClientsTableDto();

       List<ClientTableDto> clientTableDtos = clients.stream().map(p -> clientToClientDto(p)).collect(Collectors.toList());

       clientsTableDto.setClients(clientTableDtos);

       return clientsTableDto;
    }

    private ClientFullDto prepareFullClientDto(Clients client) {
        return clientToFullClientDto(client);
    }

    private ClientTableDto clientToClientDto(Clients client) {
        ClientTableDto clientTableDto = new ClientTableDto();
        clientTableDto.setClientNr(client.getClientNr());
        clientTableDto.setName(client.getName());
        clientTableDto.setRegion(client.getRegion());
        clientTableDto.setBranza(client.getBranza());
        return clientTableDto;
    }

    private ClientFullDto clientToFullClientDto(Clients client) {
        ClientFullDto clientFullDto = new ClientFullDto();

        clientFullDto.setClientNr(client.getClientNr());
        clientFullDto.setName(client.getName());
        clientFullDto.setRegion(client.getRegion());
        clientFullDto.setPhoneNumber(client.getPhoneNumber());
        clientFullDto.setBranza(client.getBranza());
        clientFullDto.setEmail(client.getEmail());
        clientFullDto.setActivityFrom(client.getActivityFrom().toLocalDateTime().toLocalDate());

        return clientFullDto;
    }
}
