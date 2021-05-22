package com.hardik.plutocracy.security.utility;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.function.Function;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import com.hardik.plutocracy.entity.User;
import com.hardik.plutocracy.security.configuration.properties.JwtConfiguration;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.AllArgsConstructor;

@Component
@EnableConfigurationProperties(JwtConfiguration.class)
@AllArgsConstructor
public class JwtUtils {

	private final JwtConfiguration jwtConfiguration;

	public String extractEmail(String token) {
		return extractClaim(token, Claims::getSubject);
	}

	public UUID extractUserId(String token) {
		return UUID.fromString((String) extractAllClaims(token).get("user_id"));
	}

	public UUID extractTotalBalanceId(String token) {
		return UUID.fromString((String) extractAllClaims(token).get("total_balance_id"));
	}

	public Date extractExpiration(String token) {
		return extractClaim(token, Claims::getExpiration);
	}

	public <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
		final Claims claims = extractAllClaims(token);
		return claimsResolver.apply(claims);
	}

	private Claims extractAllClaims(String token) {
		return Jwts.parser().setSigningKey(jwtConfiguration.getJwt().getSecretKey()).parseClaimsJws(token).getBody();
	}

	private Boolean isTokenExpired(String token) {
		return extractExpiration(token).before(new Date());
	}

	public String generateToken(User user, UUID totalBalanceId) {
		Map<String, Object> claims = new HashMap<>();
		claims.put("account_creation_timestamp", user.getCreatedAt().toString());
		claims.put("user_id", user.getId());
		claims.put("total_balance_id", totalBalanceId);
		claims.put("name", user.getFirstName() + " " + user.getLastName());
		claims.put("scope", "user");
		return createToken(claims, user.getEmailId());
	}

	private String createToken(Map<String, Object> claims, String subject) {

		return Jwts.builder().setClaims(claims).setSubject(subject).setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 10))
				.signWith(SignatureAlgorithm.HS256, jwtConfiguration.getJwt().getSecretKey()).compact();
	}

	public Boolean validateToken(String token, UserDetails userDetails) {
		final String username = extractEmail(token);
		return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
	}

}