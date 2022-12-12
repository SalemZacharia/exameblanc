package tn.esprit.salemzacharia.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.salemzacharia.entities.Parking;

public interface ParkingRepository extends JpaRepository<Parking,Integer> {
}
