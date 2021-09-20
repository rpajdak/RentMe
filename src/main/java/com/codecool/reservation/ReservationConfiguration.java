package com.codecool.reservation;

import com.codecool.item.ItemService;
import com.codecool.user.UserService;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EntityScan
@EnableJpaRepositories
public class ReservationConfiguration {
    @Bean
    ReservationService reservationService(ReservationRepository reservationRepository,
                                          ReservationConverter reservationConverter,
                                          ItemService itemService,
                                          UserService userService) {
        return new ReservationService(reservationRepository, reservationConverter, itemService, userService);
    }
}
