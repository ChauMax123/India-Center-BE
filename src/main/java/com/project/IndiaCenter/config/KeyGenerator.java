//package com.project.IC_L.config;
//import io.jsonwebtoken.security.Keys;
//import javax.crypto.SecretKey;
//import java.util.Base64;
//
//public class KeyGenerator {
//
//    public static void main(String[] args) {
//        // Generate a secure key
//        SecretKey key = Keys.secretKeyFor(io.jsonwebtoken.SignatureAlgorithm.HS256);
//        // Print the key as a base64-encoded string
//        String base64Key = Base64.getEncoder().encodeToString(key.getEncoded());
//        System.out.println("Generated Key (base64 encoded): " + base64Key);
//    }
//}