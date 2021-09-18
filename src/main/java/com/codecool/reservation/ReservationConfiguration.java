package com.codecool.reservation;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EntityScan
@EnableJpaRepositories
public class ReservationConfiguration {

  @Bean
  ReservationService reservationService(ReservationRepository reservationRepository) {
    return new ReservationService(reservationRepository);
  }
}
