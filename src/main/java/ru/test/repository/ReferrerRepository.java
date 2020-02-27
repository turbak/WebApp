package ru.test.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.test.entity.Referrer;

public interface ReferrerRepository extends JpaRepository<Referrer, Integer> {
}
