package ru.JSilver.asterisk.carrier.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.JSilver.asterisk.carrier.data.CallEntity;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface CallRepository extends JpaRepository<CallEntity, Integer> {

    List<CallEntity> findAllByDate(LocalDate date);

    CallEntity findByCallIdAndDateAndQueueNumber(String callId, LocalDate date, String queueNumber);
}
