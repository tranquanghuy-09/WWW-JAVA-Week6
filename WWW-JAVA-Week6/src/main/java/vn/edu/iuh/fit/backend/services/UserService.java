package vn.edu.iuh.fit.backend.services;

import lombok.extern.slf4j.Slf4j;
import vn.edu.iuh.fit.backend.models.User;
import vn.edu.iuh.fit.backend.repositories.UserRepository;

import java.util.List;
import java.util.Optional;

@Slf4j
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    public boolean save(User user){
        try{
            userRepository.save(user);
            return true;
        }catch (Exception e){
            log.error(e.getMessage());
        }
        return false;
    }
    public Optional<User> findById(long id){
        return userRepository.findById(id);
    }
    public List<User> findAll(){
        return userRepository.findAll();
    }
}
