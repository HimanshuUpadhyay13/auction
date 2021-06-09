package providers;

import entity.Player;
import enums.PlayerType;
import exceptions.PlayerNotFoundException;
import lombok.Data;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class InMemoryPlayerStorage implements PlayerStorage {

    @Getter
    public final Map<String, Player> pool = new ConcurrentHashMap<>();

    //at present kept it as public so that it can be loaded form mainn method..
    public void loadPool() {
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

    }


    public Player getPlayerById(String playerId) throws PlayerNotFoundException {
        if (pool.containsKey(playerId))
            return pool.get(playerId);
        throw new PlayerNotFoundException("player not found...");
    }

    @Override
    public void currentPool() {
        System.out.println(pool);
    }


}
