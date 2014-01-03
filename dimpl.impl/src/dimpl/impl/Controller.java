package dimpl.impl;

import java.util.ArrayList;
import java.util.List;

import dimpl.IController;
import dimpl.IPlayer;
import dimpl.Media;

public class Controller extends PlayerBase implements IController {

    private List<IPlayer> players = new ArrayList<IPlayer>();

    public void connect(IPlayer player) {
        players.add(player);
    }

    public void disconnect(IPlayer player) {
        players.remove(player);
    }

    public List<IPlayer> players() {
        return players;
    }

    @Override
    protected void doPrepare(Media media) {
        for (IPlayer player : players) {
            player.prepare(media);
        }
    }

    @Override
    protected void doStart() {
        for (IPlayer player : players) {
            player.start();
        }
    }

    @Override
    protected void doRestartFromPause() {
        for (IPlayer player : players) {
            player.start();
        }
    }

    @Override
    protected void doStop() {
        for (IPlayer player : players) {
            player.stop();
        }
    }

    @Override
    protected void doPause() {
        for (IPlayer player : players) {
            player.pause();
        }
    }

    @Override
    protected void doRewindAndStart() {
        for (IPlayer player : players) {
            player.rewind();
        }
    }

    @Override
    protected void doRewindAndPause() {
        for (IPlayer player : players) {
            player.rewind();
        }
    }

    @Override
    protected double elapsedSeconds() {
        double seconds = 0;
        for (IPlayer player : players) {
            double playerElapsed = player.elapsed();
            if (seconds > playerElapsed) {
                seconds = playerElapsed;
            }
        }
        return seconds;
    }
}
