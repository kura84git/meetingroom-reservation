package com.kura.example.domain.service.room;

import java.time.LocalDate;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kura.example.domain.model.MeetingRoom;
import com.kura.example.domain.model.ReservableRoom;
import com.kura.example.domain.repository.room.MeetingRoomRepository;
import com.kura.example.domain.repository.room.ReservableRoomRepository;

@Service
@Transactional
public class RoomService {

	@Autowired
	ReservableRoomRepository reservableRoomRepository;
	
	@Autowired
	MeetingRoomRepository meetingRoomRepository;
	
	public List<ReservableRoom> findReservableRooms(LocalDate date) {
		return reservableRoomRepository.findByReservableRoomId_reservedDateOrderByReservableRoomId_roomIdAsc(date);
	}
	
	public MeetingRoom findMeetingRoom(Integer roomId) {
		return meetingRoomRepository.findById(roomId).orElseGet(null);
	}
	
}
