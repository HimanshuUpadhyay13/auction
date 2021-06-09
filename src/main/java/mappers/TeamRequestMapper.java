package mappers;

import entity.Player;
import entity.Team;
import exceptions.PlayerNotFoundException;
import providers.PlayerStorage;
import requests.BuildTeamRequestDTO;
import requests.BuildTeamResponseDTO;
import services.TeamService;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class TeamRequestMapper {

    private PlayerStorage playerStorage;

    public TeamRequestMapper(PlayerStorage playerStorage) {
        this.playerStorage = playerStorage;
    }

    public Team mapFromDTO(BuildTeamRequestDTO request) {
        Team team = new Team();
        team.setTeam_id(UUID.randomUUID().toString());
        team.setPlayers(getAllPlayers(request));
        return team;
    }

    public static BuildTeamResponseDTO mapToDTO(Team team) {
        return null;
    }

    //TODO can be moved to helpers..
    private List<Player> getAllPlayers(BuildTeamRequestDTO request) {
        List<Player> players = new ArrayList<>();
        request.getListOfPlayers().forEach((player) -> {
            try {
                players.add(playerStorage.getPlayerById(player.getPlayerID()));
            } catch (PlayerNotFoundException e) {
                e.printStackTrace();
            }
        });
        return players;
    }
}
