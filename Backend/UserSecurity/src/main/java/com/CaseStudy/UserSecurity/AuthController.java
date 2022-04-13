package com.CaseStudy.UserSecurity;

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

import com.CaseStudy.UserSecurity.model.AuthenticationRequest;
import com.CaseStudy.UserSecurity.model.AuthenticationResponse;
import com.CaseStudy.UserSecurity.model.UserModel;
import com.CaseStudy.UserSecurity.model.UserRepository;
import com.CaseStudy.UserSecurity.service.UserService;
import com.CaseStudy.UserSecurity.utils.JwtUtils;

@CrossOrigin(origins="http://localhost:4200")
@RestController
@RequestMapping("/Secure")
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
		usermodel.setId(authreq.getId());
		
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
	private ResponseEntity<?> authenticateClient(@RequestBody AuthenticationRequest authreq) throws Exception{
		String username=authreq.getUsername();
		String password= authreq.getPassword();
		UserModel passengerobj = null;
		if(username != null && password != null ) {
		passengerobj = userservice.fetchUserByUsernameAndPassword(username,password);
		authenticates.authenticate(new UsernamePasswordAuthenticationToken(username, password));
		}
		if(passengerobj ==null) {
		throw new Exception("invalid credentials");
		}
		String jwt = jwtutil.generateToken(passengerobj);
		return ResponseEntity.ok(new AuthenticationResponse(jwt));
		}
	}