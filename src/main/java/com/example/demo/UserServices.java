package com.example.demo;
 
import java.util.List;
 
import javax.transaction.Transactional;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
 
@Service
@Transactional
public class UserServices {
     
    @Autowired
    private UserRepository repo;
     
    public List<User> listAll() {
        return repo.findAll(Sort.by("email").ascending());
    }

	public static User listUsers() {
		// TODO Auto-generated method stub
		return null;
	}



     
}