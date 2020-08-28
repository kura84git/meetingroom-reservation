package com.kura.example.domain.service.reservation;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kura.example.domain.model.ReservableRoom;
import com.kura.example.domain.model.ReservableRoomId;
import com.kura.example.domain.model.Reservation;
import com.kura.example.domain.model.RoleName;
import com.kura.example.domain.model.User;
import com.kura.example.domain.repository.reservation.ReservationRepository;
import com.kura.example.domain.repository.room.ReservableRoomRepository;

@Service
@Transactional
public class ReservationService {

	@Autowired
	ReservationRepository reservationRepository;
	@Autowired
	ReservableRoomRepository reservableRoomRepository;
	
	public Reservation reserve(Reservation reservation) {
		ReservableRoomId reservableRoomId = reservation.getReservableRoom().getReservableRoomId();
		ReservableRoom reservable = reservableRoomRepository.findOneForUpdateByReservableRoomId(reservableRoomId);
		if (reservable == null) {
			throw new UnavaliableReservationException("入力の日付・部屋の組み合わせは予約できません!!");
		}
		
		boolean overlap = reservationRepository.findByReservableRoom_ReservableRoomIdOrderByStartTimeAsc(reservableRoomId).stream().anyMatch(x -> x.overlap(reservation));
		
		if (overlap) {
			throw new AlreadyReservedException("入力の時間帯は既に予約済みです!!");
		}
		
		reservationRepository.save(reservation);
		return reservation;
		
	}
	
	public List<Reservation> findReservations(ReservableRoomId reservableRoomId) {
		return reservationRepository.findByReservableRoom_ReservableRoomIdOrderByStartTimeAsc(reservableRoomId);
	}
	
	public void cancel(Integer reservationId, User requestUser) {
		Optional<Reservation> reservation = reservationRepository.findById(reservationId);
		if (RoleName.ADMIN != requestUser.getRoleName() && !Objects.equals(reservation.get().getUser(), requestUser.getUserId())) {
			throw new AccessDeniedException("要求されたキャンセルは許可できません!!");
		}
		reservationRepository.deleteById(reservation.get().getReservationId());
	}
	
}
