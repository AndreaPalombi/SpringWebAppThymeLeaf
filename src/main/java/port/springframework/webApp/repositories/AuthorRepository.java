package port.springframework.webApp.repositories;

import org.springframework.data.repository.CrudRepository;
import port.springframework.webApp.model.Author;

/**
 * Created by Andrea Palombi
 * on 19/10/2020
 */

public interface AuthorRepository extends CrudRepository<Author, Long> {

}
