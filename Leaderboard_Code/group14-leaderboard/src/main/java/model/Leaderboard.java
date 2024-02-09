package model;

import jakarta.persistence.*;

import java.util.List;

public class Leaderboard {
    @ManyToOne
    private List<Player> players;

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }
}
