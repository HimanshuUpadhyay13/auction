package providers;

import entity.Team;
import exceptions.InvalidTeamException;

public interface TeamStorage {

    Team save(Team team) throws InvalidTeamException;
    void print();
}
