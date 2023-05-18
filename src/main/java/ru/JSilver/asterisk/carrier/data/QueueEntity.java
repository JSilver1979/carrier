package ru.JSilver.asterisk.carrier.data;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "queues")
@NoArgsConstructor
@Getter
@Setter
public class QueueEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "number")
    private String number;

    @Column(name = "description")
    private String description;

    @Column(name = "delay")
    private Integer delay;

    public QueueEntity(String number, String description, Integer delay) {
        this.number = number;
        this.description = description;
        this.delay = delay;
    }
}
