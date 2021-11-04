package co.usa.ciclo3.ciclo3.service;

import co.usa.ciclo3.ciclo3.model.ContClients;
import co.usa.ciclo3.ciclo3.model.Reservation;
import co.usa.ciclo3.ciclo3.model.StatusReservations;
import co.usa.ciclo3.ciclo3.repository.ReservationRepository;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author jose david amaya
 */
@Service
public class ReservationService {

    /**
     * creación de variable de tipo Repositorio con la anotación
     */
    @Autowired
    private ReservationRepository reservationRepository;
    
/**
     * metodo para obtener todos los datos de la tabla reservaciones
     * @return List de clase Reservacion
     */
    public List<Reservation> getAll() {
        return reservationRepository.getAll();
    }

    /**
     * metodo para obtener dato de la tabla reservaciones por Id
     * @param reservationId
     * @return Optional de clase Reservacion
     */
    public Optional<Reservation> getReservation(int reservationId) {
        return reservationRepository.getReservation(reservationId);
    }

    /**
     * metodo para registrar valores en la tabla reservaciones
     * @param reservation
     * @return valor de calse Reservacion
     */
    public Reservation save(Reservation reservation) {
        if (reservation.getIdReservation() == null) {
            return reservationRepository.save(reservation);
        } else {
            Optional<Reservation> res = reservationRepository.getReservation(reservation.getIdReservation());
            if (res.isEmpty()) {
                return reservationRepository.save(reservation);
            } else {
                return reservation;
            }
        }
    }

     /**
     * metodo para actualizar un dato de la tabla Reservaciones
     * @param reservation
     * @return valor de calse Reservacion
     */
    public Reservation update(Reservation reservation) {
        if (reservation.getIdReservation() != null) {
            Optional<Reservation> e = reservationRepository.getReservation(reservation.getIdReservation());
            if (!e.isEmpty()) {

                if (reservation.getStartDate() != null) {
                    e.get().setStartDate(reservation.getStartDate());
                }
                if (reservation.getDevolutionDate() != null) {
                    e.get().setDevolutionDate(reservation.getDevolutionDate());
                }
                if (reservation.getStatus() != null) {
                    e.get().setStatus(reservation.getStatus());
                }
                reservationRepository.save(e.get());
                return e.get();
            } else {
                return reservation;
            }
        } else {
            return reservation;
        }
    }

     /**
     * metodo para borrar un dato de la tabla Reservaciones por Id
     * @param reservationId
     * @return boolean
     */
    public boolean deleteReservation(int reservationId) {
        Boolean aBoolean = getReservation(reservationId).map(reservation -> {
            reservationRepository.delete(reservation);
            return true;
        }).orElse(false);
        return aBoolean;
    }

     /**
     * Metodo para adquirir status
     * @return StatusReservaciones
     */
    public StatusReservations getReportStatusReservations() {

        List<Reservation> completed = reservationRepository.StatusReservations("completed");
        List<Reservation> cancelled = reservationRepository.StatusReservations("cancelled");
        return new StatusReservations(completed.size(), cancelled.size());
    }

    /**
     * Metodo para el reporte de tiempo
     * @param datoA
     * @param datoB
     * @return ListaReservaciones
     */
    public List<Reservation> getReportsTimeReservations(String datoA, String datoB) {
        SimpleDateFormat parser = new SimpleDateFormat("yyyy-MM-dd");
        Date datoUno = new Date();
        Date datoDos = new Date();

        try {
            datoUno = parser.parse(datoA);
            datoDos = parser.parse(datoB);
        } catch (ParseException ev) {
            ev.printStackTrace();
        }
        if (datoUno.before(datoDos)) {
            return reservationRepository.ReservationTime(datoUno, datoDos);
        } else {
            return new ArrayList<>();
        }
    }

     /**
     * metodo para reporte de clientes
     * @return listaClientes
     */
    public List<ContClients> serviceTopClientses() {
        return reservationRepository.getTopClientses();
    }

}
