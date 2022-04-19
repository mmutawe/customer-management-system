package com.mmutawe.explore.microservice.auth.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class CustomerAuthHistory {

    @Id
    @SequenceGenerator(
            name = "auth_id_seq_generator",
            sequenceName = "auth_id_seq_generator"
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "auth_id_seq_generator"
    )
    private Long id;

    private Long customerId;
    private Boolean isAuthorized;
    private LocalDateTime createdAt;
}
