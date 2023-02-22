package com.workman.capstone;

import static org.junit.Assert.assertEquals;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.workman.blueridgechapel.model.Property;
import com.workman.blueridgechapel.model.Reservation;
import com.workman.blueridgechapel.service.ReservationService;

@SpringBootTest
public class ReservationServiceTest {
	
	@Autowired
	private ReservationService reservationService;
	
	@Test
	public void testGetAllReservations() throws ParseException {
		LocalDate checkInDate = LocalDate.of(2023, 2, 19);
		LocalDate checkOutDate = LocalDate.of(2023, 2, 25);
		
		Reservation reservation = new Reservation();
		reservation.setId(1L);
		reservation.setName("Becky Workman");
		reservation.setEmail("blworkman03@gmail.com");
		reservation.setCheckInDate(checkInDate);
		reservation.setCheckOutDate(checkOutDate);
		reservation.setNumberOfGuests(6);
		reservation.setPetStatus("no");
		reservation.setPropertyLocation(1L);
		
		
		List<Reservation> expectedList = new ArrayList<>();
		expectedList.add(reservation);
		
		List<Reservation> actualList = reservationService.getAllReservations();
		assertEquals(expectedList, actualList);
		
		
	}

}
