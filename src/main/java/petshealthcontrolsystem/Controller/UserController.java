package petshealthcontrolsystem.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import Exception.ResourceNotFoundException;
import petshealthcontrolsystem.Repository.UserRepository;
import petshealthcontrolsystem.model.User;
import petshealthcontrolsystem.service.UserService;

import java.util.List;


@CrossOrigin("*")
@RestController
@RequestMapping("/api/user")
public class UserController {
    @Autowired
    private UserRepository repository;
    private UserService userService;

    public UserController(UserRepository repository, UserService userService) {
        this.repository = repository;
        this.userService = userService;
    }

    @GetMapping("/all")
    public List<User> getAll(){
        return userService.getAllUsers();
    }
    @PostMapping("/add")
    public  User newUser(@RequestBody User user){
        return userService.saveUser(user);

    }

    @GetMapping("/user/{id}")
    public ResponseEntity<User>   getByIdUser(@PathVariable Long id){
        User user = repository.findById(id).
                orElseThrow(() ->new ResourceNotFoundException("user does not exist" +id));
        return ResponseEntity.ok(user);
    }
     @PutMapping("/update/{id}")
    public  User updateUser(@RequestBody User user){
        return  this.userService.updateUser(user);
    }
    @DeleteMapping("/user/{id}")
    public String deleteUser(@PathVariable Long id){
        repository.deleteById(id);
        return "user deleted!"+id;
    }

}
