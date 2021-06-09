package requests;

import enums.PlayerType;
import lombok.Data;

@Data
public class PlayerDetails {

    private String playerID;
    private PlayerType type;
    private float credit;

}
