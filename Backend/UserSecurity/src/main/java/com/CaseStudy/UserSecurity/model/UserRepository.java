package com.CaseStudy.UserSecurity.model;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface UserRepository extends MongoRepository<UserModel,String > {
 
	UserModel findByusername(String username);

	UserModel findByUsernameAndPassword(String username, String password);
}
