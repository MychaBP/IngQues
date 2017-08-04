package pl.ing.zadanko.repositiories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import pl.ing.zadanko.dao.Clients;

import java.sql.Timestamp;
import java.util.List;

public interface ClientsRepository extends CrudRepository<Clients, Integer> {

    static final String query = "select c.BRANZA, count(n.ID) from zadanko.clients c " +
            "left join zadanko.notes n on c.id = n.client_id " +
            "where n.CREATE_AT between :from and :to " +
            "group by c.BRANZA";

    Clients findOneByClientNr(Integer clientNr);

    @Override
    List<Clients> findAll();

    @Query(value = query, nativeQuery = true)
    public List<Object[]> findNoteCountToDaylyReport(@Param("from") Timestamp dateFrom, @Param("to") Timestamp dateTo);
}
