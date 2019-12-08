package storage.storage.security;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;
import storage.storage.models.User;

@RequestScope
@Component
public class AuthenticatedUser {

    private User user;

    public AuthenticatedUser(User user) {
        this.user = user;
    }

    public AuthenticatedUser() {
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}

