package ru.JSilver.asterisk.carrier.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.JSilver.asterisk.carrier.data.CallEntity;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface CallRepository extends JpaRepository<CallEntity, Long> {

    List<CallEntity> findAllByDateAndQueueNumber(LocalDate date, String queue);

    CallEntity findByCallIdAndDate(String callId, LocalDate date);
}
