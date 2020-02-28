package ru.test.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.test.entity.Referrer;

@Repository
public interface ReferrerRepository extends JpaRepository<Referrer, Integer> {
}
