package com.unir.orders.model.db;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "requests")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class AddRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ElementCollection
    @Column(name = "players")
    private List<Long> players;
}
