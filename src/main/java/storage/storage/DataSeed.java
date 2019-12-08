package storage.storage;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import storage.storage.models.Role;
import storage.storage.models.User;
import storage.storage.repositories.UserRepository;

import java.util.Arrays;

@Component
public class DataSeed implements ApplicationListener<ContextRefreshedEvent> {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    public DataSeed(UserRepository userRepository, BCryptPasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        userRepository.saveAll(Arrays.asList(
            new User("admin", passwordEncoder.encode("Almafa1"), Role.ROLE_ADMIN),
            new User( "storekeeper", passwordEncoder.encode("Almafa1"), Role.ROLE_STOREKEEPER),
            new User( "storeman", passwordEncoder.encode("Almafa1"), Role.ROLE_STOREMAN)
        ));
    }
}
