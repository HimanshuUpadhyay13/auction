package providers;

import entity.Player;
import exceptions.PlayerNotFoundException;

public interface PlayerStorage {

     void loadPool();
     Player getPlayerById(String playerId) throws PlayerNotFoundException;
     void currentPool();
}
