package ru.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.spring.entity.Referrer;

@Repository
public interface ReferrerRepository extends JpaRepository<Referrer, Integer> {
}
