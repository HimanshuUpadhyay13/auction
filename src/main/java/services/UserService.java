package services;

import providers.UserStorage;
import requests.BuildTeamResponseDTO;

public class UserService {

    private UserStorage storage;

    public UserService(UserStorage storage) {
        this.storage = storage;
    }

    public BuildTeamResponseDTO checkPoints(String userId) {


        return null;
    }
}
