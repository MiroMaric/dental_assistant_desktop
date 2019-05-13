package storage;

import domain.User;

public class StorageUser {

    private static StorageUser instance;
    private User user;
    
    private StorageUser() {
    }
    
    public static StorageUser getInstance(){
        if(instance==null)
            instance = new StorageUser();
        return instance;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
