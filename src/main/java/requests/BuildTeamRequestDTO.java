package requests;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class BuildTeamRequestDTO {

    List<PlayerDetails> listOfPlayers=new ArrayList<>();
    private String userId;
    private int budget;

}

