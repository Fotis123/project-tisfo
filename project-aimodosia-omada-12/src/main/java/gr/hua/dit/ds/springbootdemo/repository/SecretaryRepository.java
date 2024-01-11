package gr.hua.dit.ds.springbootdemo.repository;

import gr.hua.dit.ds.springbootdemo.entity.Secretary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SecretaryRepository extends JpaRepository<Secretary, Integer> {
    Optional<Secretary> findById(int id); //επιστροφή ενός Secretary με βάση το καθορισμένο id

    List<Secretary> findByFirstNameAndLastName(String firstName, String lastName); //επιστροφή μίας λίστας με βάση το συγκεκριμένο firstName και LastName
}
