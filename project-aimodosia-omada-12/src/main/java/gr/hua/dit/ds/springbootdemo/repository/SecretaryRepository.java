package gr.hua.dit.ds.springbootdemo.repository;

import gr.hua.dit.ds.springbootdemo.entity.Secretary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SecretaryRepository extends JpaRepository<Secretary, Integer> {
    // Εδώ μπορείτε να προσθέσετε πρόσθετες μεθόδους αναζήτησης αν χρειαστεί
}
