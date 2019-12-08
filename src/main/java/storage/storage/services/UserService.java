package storage.storage.services;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import storage.storage.inputModels.User.LoginInputModel;
import storage.storage.inputModels.User.RegisterInputModel;
import storage.storage.inputModels.User.RoleInputModel;
import storage.storage.models.User;

import java.util.List;

@Service
public interface UserService {

    User loginUser(LoginInputModel loginInputModel);
    User register(RegisterInputModel registerInputModel);
    User changeRole(RoleInputModel roleInputModel);
    List<User> getAllUsers();

}
