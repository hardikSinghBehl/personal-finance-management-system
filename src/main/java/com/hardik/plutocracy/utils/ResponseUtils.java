package com.hardik.plutocracy.utils;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.UUID;
import java.util.stream.Collectors;

import org.json.JSONObject;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.hardik.plutocracy.constant.BalanceModeType;
import com.hardik.plutocracy.constant.ContextType;
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

	public ResponseEntity<?> userCreationSuccessResponse() {
		final var response = new JSONObject();
		response.put("status", "success");
		response.put("message", "Account Created Successfully, Now you can login with your credentials");
		response.put("timestamp", LocalDateTime.now().toString());
		return ResponseEntity.ok(response.toString());
	}

	public ResponseEntity<?> duplicateEmailIdResponse() {
		final var response = new JSONObject();
		response.put("status", "Failure");
		response.put("message", "Account Already Exists with the provided email-id");
		response.put("timestamp", LocalDateTime.now().toString());
		return ResponseEntity.ok(response.toString());
	}

	public ResponseEntity<?> invalidEmailIdResponse() {
		final var response = new JSONObject();
		response.put("message", "Invalid Email-id Provided, No Account Exists with the provided email-id");
		response.put("timestamp", LocalDateTime.now().toString());
		return ResponseEntity.ok(response.toString());
	}

	public ResponseEntity<?> loginSuccessResponse(final String jwtToken) {
		final var response = new JSONObject();
		response.put("message",
				"Login Successfull, Please use this provided JWT for authentication by using Authentication Bearer mechanism");
		response.put("JWT", jwtToken);
		response.put("timestamp", LocalDateTime.now().toString());
		return ResponseEntity.ok(response.toString());
	}

	public ResponseEntity<?> invalidPasswordResponse() {
		final var response = new JSONObject();
		response.put("message", "Incorrect Password Provided");
		response.put("timestamp", LocalDateTime.now().toString());
		return ResponseEntity.ok(response.toString());
	}

	public ResponseEntity<?> passwordUpdationSuccessResponse() {
		final var response = new JSONObject();
		response.put("message", "Password Changed Successfully");
		response.put("timestamp", LocalDateTime.now().toString());
		return ResponseEntity.ok(response.toString());
	}

	public ResponseEntity<?> balanceModeSuccessResponse(final UUID balanceModeId) {
		final var response = new JSONObject();
		response.put("message", "Balance Mode Saved Successfully!");
		response.put("balance_mode_id", balanceModeId);
		response.put("timestamp", LocalDateTime.now().toString());
		return ResponseEntity.ok(response.toString());
	}

	public ResponseEntity<?> unauthorizedResponse() {
		final var response = new JSONObject();
		response.put("message", "You Are Unauthorized to perform this task");
		response.put("timestamp", LocalDateTime.now().toString());
		return ResponseEntity.ok(response.toString());
	}

	public ResponseEntity<?> completedTicketSuccessResponse(final UUID completedTicketId) {
		final var response = new JSONObject();
		response.put("message", "Ticket Saved Successfully!");
		response.put("completed_ticket_id", completedTicketId);
		response.put("timestamp", LocalDateTime.now().toString());
		return ResponseEntity.ok(response.toString());
	}

	public ResponseEntity<?> completedTicketDeletionResponse() {
		final var response = new JSONObject();
		response.put("message", "Ticket Deleted Successfully");
		response.put("timestamp", LocalDateTime.now().toString());
		return ResponseEntity.ok(response.toString());
	}

	public ResponseEntity<?> futureTicketDeletionResponse() {
		final var response = new JSONObject();
		response.put("message", "Ticket Deleted Successfully");
		response.put("timestamp", LocalDateTime.now().toString());
		return ResponseEntity.ok(response.toString());
	}

	public ResponseEntity<?> futureTicketSuccessResponse(final UUID futureTicketId) {
		final var response = new JSONObject();
		response.put("message", "Ticket Saved Successfully!");
		response.put("future_ticket_id", futureTicketId);
		response.put("timestamp", LocalDateTime.now().toString());
		return ResponseEntity.ok(response.toString());
	}

	public ResponseEntity<?> contextTypeListResponse() {
		return ResponseEntity.ok(Arrays.stream(ContextType.values()).map(contextType -> contextType.getName())
				.collect(Collectors.toList()));
	}

	public ResponseEntity<?> goalSuccessResponse(final UUID goalId) {
		final var response = new JSONObject();
		response.put("message", "Goal Saved Successfully!");
		response.put("goal_id", goalId);
		response.put("timestamp", LocalDateTime.now().toString());
		return ResponseEntity.ok(response.toString());
	}

	public ResponseEntity<?> noteSuccessResponse(final UUID noteId) {
		final var response = new JSONObject();
		response.put("message", "Note Saved Successfully!");
		response.put("note_id", noteId);
		response.put("timestamp", LocalDateTime.now().toString());
		return ResponseEntity.ok(response.toString());
	}

	public ResponseEntity<?> monthlySpendingUpdationSuccessResponse() {
		final var response = new JSONObject();
		response.put("message", "Current Month's Spending Threshold Saved Successfully!");
		response.put("timestamp", LocalDateTime.now().toString());
		return ResponseEntity.ok(response.toString());
	}

	public ResponseEntity<?> profileDetailUpdationSuccessResponse() {
		final var response = new JSONObject();
		response.put("message", "Profile details updated Successfully!");
		response.put("timestamp", LocalDateTime.now().toString());
		return ResponseEntity.ok(response.toString());
	}

}
