package petshealthcontrolsystem.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import petshealthcontrolsystem.Repository.UserRepository;
import petshealthcontrolsystem.model.User;

import java.util.List;
@Service
public class UserService {

    private UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getAllUses(){
        return userRepository.findAll();

    }
    public User getUser(User user){
        return userRepository.save(user);
    }
    public void deleteUser(Long id){
        userRepository.deleteById(id);
    }

    public User updateUser(User user){
        User user1=this.userRepository.findById(user.getId()).orElse(null);
        user1.setFirst_name(user.getFirst_name());
        user1.setLast_name(user.getLast_name());
        user1.setUsername(user.getUsername());
        user1.setPassword(user.getPassword());
        user1.setEmail(user.getEmail());
        user1.setStatus(user.getStatus());
        user1.setPhone_number(user.getPhone_number());
        user1.setGender(user.getGender());
        user1.setAddress(user.getAddress());

        return this.userRepository.save(user1);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }


    public User saveUser(User user) {
        return userRepository.save(user);

        }

}


