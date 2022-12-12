package tn.esprit.salemzacharia.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.salemzacharia.entities.Parking;
import tn.esprit.salemzacharia.entities.Personnel;
import tn.esprit.salemzacharia.entities.Zone;
import tn.esprit.salemzacharia.repositories.ParkingRepository;
import tn.esprit.salemzacharia.repositories.PersonnelRepository;
import tn.esprit.salemzacharia.repositories.ZoneRepository;

import java.time.LocalDate;
import java.util.List;

@RestController
public class ExamenBlancController {
@Autowired
    PersonnelRepository pr;
@Autowired
    ParkingRepository parkingRepository;
@Autowired
    ZoneRepository zoneRepository;

@PostMapping("/addPersonnel")
    public Personnel ajouterPersonnel(@RequestBody Personnel personnel){
return pr.save(personnel);}
@PostMapping("/ajoutParkingetZone")
    public void ajoutParkingetZone(@RequestBody Parking parking){
       parkingRepository.save(parking);



}
    @PostMapping("/affecterPersonnelZone/{idZone}/{idGarde}")
    public void affecterPersonnelZone( @PathVariable  int idZone, @PathVariable int idGarde) {
        Zone zone = zoneRepository.findById(idZone).orElse(null);
        Personnel personnel = pr.findById(idGarde).orElse(null);
        if(zone != null && personnel != null){
            zone.setPersonnel(personnel);
            zoneRepository.save(zone);
        }
    }

@GetMapping("/getAllpersonnelByParking/{id}")
   public List <Personnel> getAllPersonnelByParking(@PathVariable int id){
    return pr.getAllPersonnelByParking(id);
}
@GetMapping("/nombreGardeJour/{adresse}")
  public  Integer nombreGardeJour( @PathVariable String adresse ){
 return pr.nombreGardeJour(adresse);

}
@GetMapping("/getPbyD/{date1}/{date2}")
    public List<Personnel>getPersonalByDate(@PathVariable LocalDate date1,@PathVariable LocalDate date2)
{
    return pr.getPersonelByDate(date1,date2);
}

@GetMapping("/getNbrGardeByZone")
    public void getNbrGardesByZone(){

}
}


