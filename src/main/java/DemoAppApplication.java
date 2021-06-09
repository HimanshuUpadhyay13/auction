import enums.PlayerType;
import exceptions.InvalidTeamException;
import exceptions.PlayerNotFoundException;
import mappers.TeamRequestMapper;
import providers.*;
import requests.BuildTeamRequestDTO;
import requests.PlayerDetails;
import services.TeamService;
import validators.BuildTeamValidator;
import validators.Validator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DemoAppApplication {


    public static void main(String[] args) throws PlayerNotFoundException, InvalidTeamException {
        PlayerStorage pool = new InMemoryPlayerStorage();
        pool.loadPool();
        pool.currentPool();
       // PlayerStorage playerStorage = new InMemoryPlayerStorage();
        UserStorage userStorage = new InMemoryUserStorage();
        TeamStorage teamStorage = new InMemoryTeamStorage();

        //requirement 1
        //create a team service bean
        Validator<BuildTeamRequestDTO> validator = new BuildTeamValidator();
        TeamRequestMapper teamRequestMapper = new TeamRequestMapper(pool);
        TeamService teamService = new TeamService(validator, teamRequestMapper,teamStorage);
        teamService.buildTeam(getTeamRequestDTO());
        teamStorage.print();


    }

    /*
    Player bat_01 = new Player("bt_01", PlayerType.BATSMAN.name(), 30);
        Player bat_02 = new Player("bt_02", PlayerType.BATSMAN.name(), 40);
        Player bat_03 = new Player("bt_03", PlayerType.BATSMAN.name(), 50);

        Player bow_01 = new Player("bw_01", PlayerType.BOWLER.name(), 30);
        Player bow_02 = new Player("bw_02", PlayerType.BOWLER.name(), 40);
        Player bow_03 = new Player("bw_03", PlayerType.BOWLER.name(), 50);

        Player kep_01 = new Player("kp_01", PlayerType.KEEPER.name(), 60);

        Player bat_04 = new Player("bw_04", PlayerType.BATSMAN.name(), 40);
        Player bat_05 = new Player("bw_05", PlayerType.BATSMAN.name(), 50);
        Player bat_06 = new Player("bw_06", PlayerType.BATSMAN.name(), 30);
        Player bat_07 = new Player("bw_07", PlayerType.BATSMAN.name(), 30);
        //7 batsman
        pool.put(bat_01.getPlayerId(), bat_01);
        pool.put(bat_02.getPlayerId(), bat_02);
        pool.put(bat_03.getPlayerId(), bat_03);
        pool.put(bat_04.getPlayerId(), bat_04);
        pool.put(bat_05.getPlayerId(), bat_05);
        pool.put(bat_06.getPlayerId(), bat_06);
        pool.put(bat_07.getPlayerId(), bat_07);

        pool.put(bow_01.getPlayerId(), bow_01);
        pool.put(bow_02.getPlayerId(), bow_02);
        pool.put(bow_03.getPlayerId(), bow_03);
        pool.put(kep_01.getPlayerId(), kep_01);

     */
    private static BuildTeamRequestDTO getTeamRequestDTO() {
        List<PlayerDetails> playerDetails = new ArrayList<>();
        BuildTeamRequestDTO teamRequestDTO = new BuildTeamRequestDTO();
        teamRequestDTO.setUserId("u_01");
        teamRequestDTO.setBudget(100);
        playerDetails.add(createPlayerDetails("bt_01", 10, PlayerType.BATSMAN));
        playerDetails.add(createPlayerDetails("bt_02", 10, PlayerType.BATSMAN));
        playerDetails.add(createPlayerDetails("bt_03", 10, PlayerType.BATSMAN));
        playerDetails.add(createPlayerDetails("bw_04", 10, PlayerType.BOWLER));
        playerDetails.add(createPlayerDetails("bw_05", 10, PlayerType.BOWLER));
        playerDetails.add(createPlayerDetails("bw_06", 10, PlayerType.BOWLER));
        playerDetails.add(createPlayerDetails("bw_07", 10, PlayerType.BOWLER));

        playerDetails.add(createPlayerDetails("bw_01", 10, PlayerType.BOWLER));
        playerDetails.add(createPlayerDetails("bw_02", 10, PlayerType.BOWLER));
        playerDetails.add(createPlayerDetails("bw_03", 10, PlayerType.BOWLER));

        playerDetails.add(createPlayerDetails("kp_01", 10, PlayerType.KEEPER));
        teamRequestDTO.setListOfPlayers(playerDetails);
        return teamRequestDTO;
    }


    public static PlayerDetails createPlayerDetails(String playerId, int credit, PlayerType playerType) {
        PlayerDetails playerDetails = new PlayerDetails();
        playerDetails.setPlayerID(playerId);
        playerDetails.setCredit(credit);
        playerDetails.setType(playerType);
        return playerDetails;
    }
}
