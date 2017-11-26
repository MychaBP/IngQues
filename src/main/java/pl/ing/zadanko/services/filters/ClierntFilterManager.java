package pl.ing.zadanko.services.filters;

import pl.ing.zadanko.api.dto.ClientsFilterDto;

public class ClierntFilterManager {

    private String prepareSql(ClientsFilterDto clientsFilterDto) {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append("Test");

        return stringBuilder.toString();
    }
}
