package com.CaseStudy.AdminSecurity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.CaseStudy.AdminSecurity.model.AuthenticationRequest;
import com.CaseStudy.AdminSecurity.model.AuthenticationResponse;
import com.CaseStudy.AdminSecurity.model.UserModel;
import com.CaseStudy.AdminSecurity.model.UserRepository;
import com.CaseStudy.AdminSecurity.service.UserService;
import com.CaseStudy.AdminSecurity.utils.JwtUtils;
@CrossOrigin(origins="http://localhost:4200")
@RestController
@RequestMapping("/Adlog")
public class AuthController {

	@Autowired
	UserRepository userrepo;
	
	@Autowired
	AuthenticationManager authenticates;
	
	@Autowired
	UserService userservice;
	
	@Autowired
	JwtUtils jwtutil;
	
	@PostMapping("/subs")
	private ResponseEntity<AuthenticationResponse>subscribeClient(@RequestBody UserModel authreq){
		
		UserModel usermodel =new UserModel();
		usermodel.setUsername(authreq.getUsername());
		usermodel.setPassword(authreq.getPassword());
		
		
		try {
			userrepo.save(usermodel);
		}
		catch(Exception e){
			return new ResponseEntity<AuthenticationResponse>(new AuthenticationResponse
					("Error during subscription ") , HttpStatus.OK);
		}
		
		return new ResponseEntity<AuthenticationResponse>(new AuthenticationResponse
				("Successful subs for client " +authreq.getUsername()), HttpStatus.OK);
	}
	
	
	@PostMapping("/auth")
	private ResponseEntity<?> authenticateClient(@RequestBody AuthenticationRequest authreq){
		String username=authreq.getUsername();
		String password= authreq.getPassword();
		try {
			authenticates.authenticate(new UsernamePasswordAuthenticationToken(username, password));
				
		}
		catch(Exception e) {
			return ResponseEntity.ok(new AuthenticationResponse("error during authentication" + username));
		}
		
		UserDetails userdetails= userservice.loadUserByUsername(username);
		
		String generatedToken = jwtutil.generateToken(userdetails);
		return ResponseEntity.ok(new AuthenticationResponse(generatedToken));
	}
	
}
