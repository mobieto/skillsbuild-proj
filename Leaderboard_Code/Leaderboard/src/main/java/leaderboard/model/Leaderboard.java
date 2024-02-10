package leaderboard.model;

import java.util.ArrayList;
import java.util.List;

public class Leaderboard {
    private List<Players> players;

    public List<Players> getPlayers() {
        if (players == null){
            players = new ArrayList<>();
        }
        return players;
    }
    public void setPlayers(List<Players> players) {
        this.players = players;
    }
}
