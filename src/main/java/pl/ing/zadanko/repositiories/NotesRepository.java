package pl.ing.zadanko.repositiories;

import org.springframework.data.repository.CrudRepository;
import pl.ing.zadanko.dao.Notes;

import java.util.List;

public interface NotesRepository extends CrudRepository<Notes, Integer> {

    List<Notes> findByClient_Id(Integer clientNr);

}
