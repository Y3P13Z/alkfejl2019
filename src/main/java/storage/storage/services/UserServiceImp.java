package storage.storage.services;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import storage.storage.inputModels.User.LoginInputModel;
import storage.storage.inputModels.User.RegisterInputModel;
import storage.storage.inputModels.User.RoleInputModel;
import storage.storage.models.Role;
import storage.storage.models.User;
import storage.storage.repositories.UserRepository;
import storage.storage.security.MyUserDetailsService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImp implements UserService {

    private final UserRepository userRepository;

    private final MyUserDetailsService userDetailsService;

    private final BCryptPasswordEncoder passwordEncoder;

    public UserServiceImp(UserRepository userRepository, MyUserDetailsService userDetailsService, BCryptPasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.userDetailsService = userDetailsService;
        this.passwordEncoder = passwordEncoder;
    }

    // later will be needed for form based authentication
    @Override
    public User loginUser(LoginInputModel loginInputModel) {
        User user = userRepository.findByUsername(loginInputModel.getUsername()).get();
        if(passwordEncoder.matches(loginInputModel.getPassword(), user.getPassword())) {
            return user;
        }
        return null;
    }

    public User register(RegisterInputModel registerInputModel) {
        Optional<User> oUser = userRepository.findByUsername(registerInputModel.getUsername());
        if (oUser.isPresent()) {
            return null;
        }
        if(registerInputModel.getPassword().equals(registerInputModel.getConfirmPassword())) {
            User user = new User();
            user.setUsername(registerInputModel.getUsername());
            user.setPassword(passwordEncoder.encode(registerInputModel.getPassword()));
            user.setRole(Role.ROLE_STOREMAN);
            return userRepository.save(user);
        }
        return null;
    }

    @Override
    public User changeRole(RoleInputModel roleInputModel) {
        Optional<User> oUser = userRepository.findById(roleInputModel.getUserId());
        if(oUser.isPresent()) {
            User user = oUser.get();
            user.setRole(Role.valueOf(roleInputModel.getRole()));
            userRepository.save(user);
            return user;
        }
        return null;
    }

    @Override
    public List<User> getAllUsers() {
        Iterable<User> users =  userRepository.findAll();
        if(users == null){
            return null;
        }
        List<User> userList = new ArrayList<>();
        users.forEach(product -> userList.add(product));
        return userList;
    }
}
