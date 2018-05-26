package com.udemy.helpdesk.api.security.jwt;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JwtTokerUtil  implements Serializable{

	private static final long serialVersionUID = 1L;

	static final String CLAIM_KEY_USERNAME="sub";
	static final String CLAIM_KEY_CREATED="created";
	static final String CLAIM_KEY_EXPIRED="exp";
	
	
	@Value("${jwt.secret}")
	private String secret;
	 
	@Value("${jwt.expiration}")
	private Long expiration;
	
	//Obter email que ta dentro do Token
	public String getUsernameFromToken(String token){
		String username;
		
		try {
		final Claims  claims = getClaimsFromToken(token);
		username=claims.getSubject();
		} catch (Exception e) {
			username = null;
		}
		return username;
	}
	
	
	//Retorna a data de expiração de um token jwt
	
	public Date getExpirationDateFromToken(String token){
		Date expiration;
		try {
			final Claims  claims = getClaimsFromToken(token);
			expiration = claims.getExpiration();
		} catch (Exception e) {
			expiration = null;
		}
		return expiration;
	}
	
	
	//Passe o toker jwt para extrir informaçoes no corpo dele
	private Claims getClaimsFromToken( String token){
		Claims claims;
		try {
			claims= Jwts.parser()
					.setSigningKey(secret)
					.parseClaimsJws(token)
					.getBody();
					
					
		} catch (Exception e) {
			claims = null;
		}
		
		return claims;
	}
	
	
	//Verificar se token esta expirado:
	
	private Boolean isTokenExpired(String token){
		final Date expiration =  getExpirationDateFromToken(token);
		return expiration.before(new Date());
	}
	
	//Gerar o Token
	
	public String generateToken(UserDetails userDetails){
		Map<String , Object> claims = new HashMap<>();
		
		claims.put(CLAIM_KEY_USERNAME, userDetails.getUsername());
		
		final Date createDate= new Date();
		
		claims.put(CLAIM_KEY_CREATED, createDate);
		
		return doGenerateToken(claims);
	}
	
	//Metodo auxilar para criar token
	
	private String doGenerateToken(Map<String, Object> claims) {
		final Date createdDate= (Date) claims.get(CLAIM_KEY_CREATED);
		final Date expirationDate = new Date(createdDate.getTime()+expiration*100);
		return Jwts.builder()
				.setClaims(claims)
				.setExpiration(expirationDate)
				.signWith(SignatureAlgorithm.HS512, secret)
				.compact();
		
	}
	
	
	//Verificar se token pode ser atualizado
	
	public Boolean canTokenBeRefreshed(String token){
		return (!isTokenExpired(token));
	}
	
	
	
	//Atualiza o Token
	
	public String refreshToken(String token){
		String refreshedToken;
		try {
			final Claims claims = getClaimsFromToken(token);
			claims.put(CLAIM_KEY_CREATED, new Date());
			refreshedToken = doGenerateToken(claims);
			
		} catch (Exception e) {
			refreshedToken= null;
		}
		return refreshedToken;
	}
	
	
	//Verificar de token esta valido
	
	public Boolean validateToken(String token, UserDetails userDatails){
		JwtUser user = (JwtUser) userDatails;
		
		final String username=  getUsernameFromToken(token);
		return(username.equals(user.getUsername()) && !isTokenExpired(token)); 
	}

}
