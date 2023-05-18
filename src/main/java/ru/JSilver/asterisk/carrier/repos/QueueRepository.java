package ru.JSilver.asterisk.carrier.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.JSilver.asterisk.carrier.data.QueueEntity;

@Repository
public interface QueueRepository extends JpaRepository<QueueEntity, Integer> {
}
