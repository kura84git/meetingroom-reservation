package com.kura.example.domain.repository.reservation;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kura.example.domain.model.ReservableRoomId;
import com.kura.example.domain.model.Reservation;

public interface ReservationRepository extends JpaRepository<Reservation, Integer> {

	List<Reservation> findByReservableRoom_ReservableRoomIdOrderByStartTimeAsc(ReservableRoomId reservableRoomId);
}
