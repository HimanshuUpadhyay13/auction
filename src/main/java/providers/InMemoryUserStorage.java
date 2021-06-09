package providers;

import entity.User;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class InMemoryUserStorage implements UserStorage {

    public static final Map<String, User> allItems = new ConcurrentHashMap<>();

    @Override
    public int checkPoints(String userId) {
        return 0;
    }
}
