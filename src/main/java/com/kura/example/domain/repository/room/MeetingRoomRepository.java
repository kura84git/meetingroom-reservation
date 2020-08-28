package com.kura.example.domain.repository.room;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kura.example.domain.model.MeetingRoom;

public interface MeetingRoomRepository extends JpaRepository<MeetingRoom, Integer> {

}
