package entity;

import lombok.Data;

import java.util.List;

@Data
public class Team {
    private String team_id;
    //private String user_id;
    private List<Player> players;
}
