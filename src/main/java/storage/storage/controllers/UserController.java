package storage.storage.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;
import storage.storage.inputModels.User.LoginInputModel;
import storage.storage.inputModels.User.RegisterInputModel;
import storage.storage.inputModels.User.RoleInputModel;
import storage.storage.models.User;
import storage.storage.security.AuthenticatedUser;
import storage.storage.services.UserService;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class UserController {

    private final UserService userService;

    @Autowired
    private AuthenticatedUser authenticatedUser;


    public UserController(UserService userService) {
        this.userService = userService;
    }

    //Later will be needed for form based authentication
    @PostMapping("/login")
    public ResponseEntity<User> login(@RequestBody LoginInputModel loginInputModel) {

        User user = userService.loginUser(loginInputModel);
        if(user != null) {
            return new ResponseEntity(user, HttpStatus.OK);
        }
        return new ResponseEntity(HttpStatus.BAD_REQUEST);

    }

    /*
    @PostMapping("login")
    public ResponseEntity login(@RequestBody LoginInputModel loginInputModel) {
        return ResponseEntity.ok().build();
    }
    */

    @Secured({"ROLE_STOREKEEPER", "ROLE_ADMIN"})
    @PostMapping("/register")
    public ResponseEntity<User> register(@RequestBody RegisterInputModel registerInputModel) {
        User user = userService.register(registerInputModel);
        if(user == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @Secured({"ROLE_ADMIN"})
    @PostMapping("changeRole")
    public ResponseEntity<User> changeRole(@RequestBody RoleInputModel roleInputModel) {
        User user = userService.changeRole(roleInputModel);
        if(user == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @GetMapping("/test")
    public ResponseEntity<String> test(){
        return new ResponseEntity<>(authenticatedUser.getUser().getUsername(), HttpStatus.OK);
    }


    @GetMapping("/user/getAll")
    public ResponseEntity<List<User>> getAll() {
        List<User> users = userService.getAllUsers();
        if(users == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(users, HttpStatus.OK);
    }
}
