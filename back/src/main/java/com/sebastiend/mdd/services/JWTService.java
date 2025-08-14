package com.sebastiend.mdd.services;


import com.sebastiend.mdd.models.entities.UserEntity;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import org.springframework.security.oauth2.jose.jws.MacAlgorithm;
import org.springframework.security.oauth2.jwt.*;
import org.springframework.stereotype.Service;


@Service
public class JWTService {
	private JwtEncoder jwtEncoder;
	
    
	public JWTService(JwtEncoder jwtEncoder) {
		this.jwtEncoder = jwtEncoder;
	}


    public String generateToken(UserEntity user) {
        Instant now = Instant.now();
     	JwtClaimsSet claims = JwtClaimsSet.builder()
            .claim("email", user.getEmailAddress())
            .issuer("self")
            .issuedAt(now)
            .expiresAt(now.plus(1, ChronoUnit.HOURS))
            .subject(user.getEmailAddress())
            .build();
		JwtEncoderParameters jwtEncoderParameters = JwtEncoderParameters.from(JwsHeader.with(MacAlgorithm.HS256).build(), claims);
		String JWTtoken =  this.jwtEncoder.encode(jwtEncoderParameters).getTokenValue();
        return JWTtoken;
    }
}
