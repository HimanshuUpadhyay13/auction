package entity;

import enums.PlayerType;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Player {
    private String playerId;
    private String playerType;
    private int worth;
}
