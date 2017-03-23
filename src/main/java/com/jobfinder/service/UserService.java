package com.jobfinder.service;

import com.jobfinder.model.User; 

public interface UserService extends GenericService<User,Integer>{
    public void save(User user); 

    public User findByUsername(String username);
    
    public String getLoggedInUserName();
    
    public User getUserById(int userId);
    
    public User getUserFromSession();
    
}
