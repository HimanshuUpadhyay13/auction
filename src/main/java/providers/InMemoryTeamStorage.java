package providers;

import entity.Team;
import entity.User;
import exceptions.InvalidTeamException;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class InMemoryTeamStorage implements TeamStorage {

    public static final Map<String, Team> allTeams = new ConcurrentHashMap<>();

    @Override
    public Team save(Team team) throws InvalidTeamException {
        if (allTeams.containsKey(team.getTeam_id()))
            throw new InvalidTeamException("Invalid Team");
        return allTeams.put(team.getTeam_id(), team);
    }

    @Override
    public void print() {
        System.out.println(allTeams);
    }
}
