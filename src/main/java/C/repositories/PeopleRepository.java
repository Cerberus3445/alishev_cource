package C.repositories;

import C.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PeopleRepository extends JpaRepository<Person, Integer> { //1 параметр: класс, который является сущностью, а 2 - тип первичного ключа(id)
}
