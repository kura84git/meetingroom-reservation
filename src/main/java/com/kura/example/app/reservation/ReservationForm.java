package com.kura.example.app.reservation;

import java.io.Serializable;
import java.time.LocalTime;

import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

@EndTimeMustBeAfterStartTime(message = "終了時刻は開始時刻より後にしてください!!")
public class ReservationForm implements Serializable {

	private static final long serialVersionUID = 1L;
	
	/*
	 @NotNullを付ける場合
	<dependency>
	    <groupId>javax.validation</groupId>
	    <artifactId>validation-api</artifactId>
	    <version>1.1.0.Final</version>
	</dependency>
	<dependency>
	    <groupId>org.hibernate</groupId>
	    <artifactId>hibernate-validator</artifactId>
	    <version>5.2.4.Final</version>
	</dependency>	
	*/

	@NotNull(message = "必須です!!")
	@ThirtyMinutesUnit(message = "30分単位で入力してください!!")
	@DateTimeFormat(pattern = "HH:mm")
	private LocalTime startTime;
	
	@NotNull(message = "必須です!!")
	@ThirtyMinutesUnit(message = "30分単位で入力してください!!")
	@DateTimeFormat(pattern = "HH:mm")
	private LocalTime endTime;

	public LocalTime getStartTime() {
		return startTime;
	}

	public void setStartTime(LocalTime startTime) {
		this.startTime = startTime;
	}

	public LocalTime getEndTime() {
		return endTime;
	}

	public void setEndTime(LocalTime endTime) {
		this.endTime = endTime;
	}
	
	
	
}
