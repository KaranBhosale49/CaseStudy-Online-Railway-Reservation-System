package com.CaseStudy.UserSecurity.model;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="UserSecurity")
public class UserModel {
@Id
private String Id;
private String username;
private String password;
public String getId() {
	return this.Id;
}
public void setId(String id) {
	this.Id = id;
}
public String getUsername() {
	return username;
}
public void setUsername(String username) {
	this.username = username;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public UserModel(String id, String username, String password) {
	super();
	this.Id = id;
	this.username = username;
	this.password = password;
}
public UserModel() {
	super();
}

}
