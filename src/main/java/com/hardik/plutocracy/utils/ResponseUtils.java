package com.hardik.plutocracy.utils;

import java.time.LocalDateTime;

import org.json.JSONObject;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.hardik.plutocracy.constant.BalanceModeType;
import com.hardik.plutocracy.constant.TicketType;

@Component
public class ResponseUtils {

	public ResponseEntity<?> pingResponse() {
		final var response = new JSONObject();
		response.put("message", "ping");
		response.put("timestamp", LocalDateTime.now().toString());
		return ResponseEntity.ok(response.toString());
	}

	public ResponseEntity<?> ticketTypeListResponse() {
		return ResponseEntity.ok(TicketType.values());
	}

	public ResponseEntity<?> balanceModeTypeListResponse() {
		return ResponseEntity.ok(BalanceModeType.values());
	}

}
