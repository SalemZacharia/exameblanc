package tn.esprit.salemzacharia.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import tn.esprit.salemzacharia.entities.Personnel;

import java.time.LocalDate;
import java.util.List;

public interface PersonnelRepository extends JpaRepository<Personnel,Integer> {
;
    @Query("SELECT p FROM Personnel p JOIN p.zoneP.parking pp WHERE pp.id= :id")
            List<Personnel>getAllPersonnelByParking(@Param("id") int id);

    @Query("select COUNT(p) from Personnel p WHERE p.zoneP.parking.adresse=:adresse")
        Integer nombreGardeJour(@Param("adresse") String adresse);

    @Query("select  p from Personnel  p where p.dateDeRecrutement BETWEEN :date1 AND :date2 ")
    List<Personnel>getPersonelByDate(@Param("date1")LocalDate date1,@Param("date2") LocalDate date2);


}

