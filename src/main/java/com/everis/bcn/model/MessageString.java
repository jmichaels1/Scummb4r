package com.everis.bcn.model;

import java.text.SimpleDateFormat;

import org.springframework.stereotype.Component;

/***
 * 
 * @author J Michael
 *
 */
@Component
public class MessageString {
	
	private static final SimpleDateFormat FORMAT = new SimpleDateFormat("dd-MM-yyyy");

	private StringBuilder success_booking = new StringBuilder("ENHORABUENA, su reserva ha sido registrada : ");
	private static final String FAILED_MESAS = "LO SIENTO, todas las mesas se encuentran reservadas";
	private static final String FAILED_CAPACITY = "LO SIENTO, no hay mesas disponibles para la cantidad de personas";

	private StringBuilder success_cancelBooking = new StringBuilder("Su reserva ha sido Cancelada : ");
	private static final String FAILED_CANCEL = "LO SIENTO, los datos de la reserva no son correctos";

	/***
	 * Método Constructor without parameters
	 */
	public MessageString() {
		super();
	}

	/**** Getters And Setters ****/

	public StringBuilder getSuccess_booking() {
		return success_booking;
	}

	public void setSuccess_booking(StringBuilder success_booking) {
		this.success_booking = success_booking;
	}

	public StringBuilder getSuccess_cancelBooking() {
		return success_cancelBooking;
	}

	public void setSuccess_cancelBooking(StringBuilder success_cancelBooking) {
		this.success_cancelBooking = success_cancelBooking;
	}

	public static String getFailedMesas() {
		return FAILED_MESAS;
	}

	public static String getFailedCapacity() {
		return FAILED_CAPACITY;
	}

	public static String getFailedCancel() {
		return FAILED_CANCEL;
	}

	public static SimpleDateFormat getFormat() {
		return FORMAT;
	}

}
