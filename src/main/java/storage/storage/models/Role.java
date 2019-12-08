package storage.storage.models;

import org.springframework.security.core.GrantedAuthority;


public enum Role implements GrantedAuthority {
    ROLE_STOREMAN, ROLE_STOREKEEPER, ROLE_ADMIN;

    public String getAuthority() {
        return name();
    }
}
