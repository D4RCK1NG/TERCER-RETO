package co.usa.ciclo3.ciclo3.repository;

import co.usa.ciclo3.ciclo3.model.Client;
import co.usa.ciclo3.ciclo3.model.ContClients;
import co.usa.ciclo3.ciclo3.model.Reservation;
import co.usa.ciclo3.ciclo3.repository.crud.ReservationCrudRepository;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ReservationRepository {
    
    @Autowired
    private ReservationCrudRepository reservationCrudRepository;
    
    public List<Reservation> getAll() {
        return (List<Reservation>) reservationCrudRepository.findAll();
    }
    
    public Optional<Reservation> getReservation(int id) {
        return reservationCrudRepository.findById(id);
    }
    
    public Reservation save(Reservation reservation) {
        return reservationCrudRepository.save(reservation);
    }
    
    public void delete(Reservation reservation) {
        reservationCrudRepository.delete(reservation);
    }
    
    public List<Reservation> StatusReservations(String status) {
        return reservationCrudRepository.findAllByStatus(status);
    }
    
    public List<Reservation> ReservationTime(Date a, Date b) {
        return reservationCrudRepository.findAllByStartDateAfterAndStartDateBefore(a, b);
    }
    
    public List<ContClients> getTopClientses() {
        List<ContClients> r = new ArrayList<>();
        List<Object[]> report = reservationCrudRepository.countTotReservationsByClient();
        for (int i = 0; i < report.size(); i++) {
            r.add(new ContClients((Long) report.get(i)[1], (Client) report.get(i)[0]));
        }
        return r;
    }
}
