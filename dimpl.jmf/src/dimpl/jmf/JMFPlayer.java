package dimpl.jmf;

import java.io.IOException;

import javax.media.CannotRealizeException;
import javax.media.ControllerEvent;
import javax.media.ControllerListener;
import javax.media.Manager;
import javax.media.NoPlayerException;
import javax.media.Player;
import javax.media.Time;

import dimpl.IPlayer;
import dimpl.Library;
import dimpl.Media;
import dimpl.MediaQueue;
import dimpl.impl.PlayerBase;

public class JMFPlayer extends PlayerBase {

    Player preparing;
    Player playing;

    private class PlayerListener implements ControllerListener {

        int lastState = Player.Unrealized;
        
        @Override
        public void controllerUpdate(ControllerEvent event) {
            int state = event.getSourceController().getState();
            switch (state) {
            case Player.Prefetched:
                System.out.println("Prefetched");
                break;
            case Player.Prefetching:
                System.out.println("Prefetching");
                break;
            case Player.Realized:
                System.out.println("Realized");
                break;
            case Player.Realizing:
                System.out.println("Realizing");
                break;
            case Player.Started:
                System.out.println("Started");
                break;
            case Player.Unrealized:
                System.out.println("Unrealized");
                break;
            }
            if (playState == PlayState.STARTED) {
                if (lastState == Player.Started) {
                    // No more updates
                    event.getSourceController().removeControllerListener(this);
                    if (state == Player.Prefetched) {
                        completedOK();
                    } else {
                        completedError();
                    }
                }
            } else if (prepareState == PrepareState.PREPARING) {
                if (state == Player.Realized) {
                    prepareOK();
                }
            }
            lastState = state;
        }

    }

    @Override
    protected void doPrepare(Media media) {
        try {
            preparing = Manager.createPlayer(media.url());
            preparing.addControllerListener(new PlayerListener());
            preparing.realize();
        } catch (NoPlayerException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doStart() {
        playing = preparing;
        playing.start();
        preparing = null;
    }

    @Override
    protected void doRestartFromPause() {
        playing.start();
    }

    @Override
    protected void doStop() {
        playing.close();
        playing.deallocate();
        playing = null;
    }

    @Override
    protected void doPause() {
        playing.stop();
    }

    @Override
    protected void doRewindAndStart() {
        playing.stop();
        playing.setMediaTime(new Time(0.0));
        playing.start();
    }

    @Override
    protected void doRewindAndPause() {
        playing.stop();
        playing.setMediaTime(new Time(0.0));
    }

    @Override
    protected double elapsedSeconds() {
        long milliseconds = playing.getMediaNanoseconds() / 10000000;
        return ((double) milliseconds) / 1000;
    }

}
