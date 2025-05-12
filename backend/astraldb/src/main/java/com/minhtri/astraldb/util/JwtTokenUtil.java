package com.minhtri.astraldb.util;

import io.jsonwebtoken.*;
import java.math.BigInteger;
import java.security.KeyFactory;
import java.security.spec.RSAPublicKeySpec;
import java.security.interfaces.RSAPublicKey;
import java.util.Base64;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JwtTokenUtil {

    public static Claims validateToken(String token, Map<String, Object> jwkKeys) {
        try {
            // Decode the JWT header to get the key ID (kid)
            String[] tokenParts = token.split("\\.");
            String headerJson = new String(Base64.getDecoder().decode(tokenParts[0]));
            String kid = (String) new ObjectMapper().readValue(headerJson, Map.class).get("kid");

            @SuppressWarnings("unchecked")
            Map<String, Object> keyData = ((List<Map<String, Object>>) jwkKeys.get("keys"))
                    .stream()
                    .filter(key -> key.get("kid").equals(kid))
                    .findFirst()
                    .orElseThrow(() -> new RuntimeException("Key ID not found in JWKs"));
            // Decode the Base64 URL-encoded 'n' (modulus) and 'e' (exponent) fields
            String n = (String) keyData.get("n");
            String e = (String) keyData.get("e");
            byte[] modulusBytes = Base64.getUrlDecoder().decode(n);
            byte[] exponentBytes = Base64.getUrlDecoder().decode(e);

            // Build the RSA public key
            BigInteger modulus = new BigInteger(1, modulusBytes);
            BigInteger exponent = new BigInteger(1, exponentBytes);
            RSAPublicKey publicKey = (RSAPublicKey) KeyFactory.getInstance("RSA")
                    .generatePublic(new RSAPublicKeySpec(modulus, exponent));
            // Validate the token
            return Jwts.parserBuilder()
                    .setSigningKey(publicKey)
                    .build()
                    .parseClaimsJws(token)
                    .getBody();
        } catch (Exception e) {
            throw new RuntimeException("Invalid token", e);
        }
    }
}
