package dimpl.impl;

import dimpl.Event;
import dimpl.IPlayer;
import dimpl.Media;

public abstract class PlayerBase implements IPlayer {

    /* State machine
     * 
     * Events
     * 
     *  PREPARE_START
     *  PREPARE_OK
     *  PREPARE_ERROR
     *  PREPARE_RESET
     *  START
     *  PAUSE
     *  REWIND
     *  STOP
     *  SKIP
     * 
     *           +-------+
     *           | READY |<------+
     *           +-------+       |
     *             |   ^         |
     *     PREPARE |   | ERROR   |
     *             v   |         |
     *          +-----------+    |
     *          | PREPARING |    | PREPARE_RESET
     *          +-----------+    |
     *                |          |
     *                | OK       |
     *                v          |
     *         +-----------+     |
     *         | PREPARED  |-----+
     *         +-----------+
     *
     *       +---------+
     *       | STOPPED |<----+
     *       +---------+     |
     *            |          |
     *            | START    | STOP
     *            v          |
     *       +---------+     |
     *       | STARTED |-----+
     *       +---------+
     *          |   ^
     *    PAUSE |   | START
     *          v   |
     *        +--------+
     *        | PAUSED |
     *        +--------+
     * 
     * 
     */
    
    protected enum PrepareState {
        READY,
        PREPARING,
        PREPARED
    }
    
    protected enum PlayState {
        STOPPED,
        STARTED,
        PAUSED
    }
    
    protected PrepareState prepareState = PrepareState.READY;
    private Media prepareMedia;
    protected PlayState playState = PlayState.STOPPED;
    private Media playMedia;
    
    @Override
    public void prepare(Media media) {
        switch (prepareState) {
        case READY:
            prepareMedia = media;
            prepareState = PrepareState.PREPARING;
            doPrepare(media);
            break;
        case PREPARING:
            System.err.println("prepare() called but already preparing");
            break;
        case PREPARED:
            System.err.println("prepare() called but already prepared");
            break;
        }
    }

    // Low-level methods to implement
    protected abstract void doPrepare(Media media);
    protected abstract void doStart();
    protected abstract void doRestartFromPause();
    protected abstract void doStop();
    protected abstract void doPause();
    protected abstract void doRewindAndStart();
    protected abstract void doRewindAndPause();
    protected abstract double elapsedSeconds();

    protected void prepareOK() {
        switch (prepareState) {
        case READY:
            System.err.println("prepareOK() called but not preparing");
            break;
        case PREPARING:
            prepareState = PrepareState.PREPARED;
            prepared().raise(this);
            break;
        case PREPARED:
            System.err.println("prepareOK() called but already prepared");
            break;
        }
    }
    
    protected void prepareError() {
        switch (prepareState) {
        case READY:
            System.err.println("prepareError() called but not preparing");
            break;
        case PREPARING:
            prepareState = PrepareState.READY;
            prepareMedia = null;
            break;
        case PREPARED:
            System.err.println("prepareError() called but already prepared");
            break;
        }
    }
    
    @Override
    public boolean isPrepared() {
        return prepareState == PrepareState.PREPARED;
    }

    private Event preparedEvent = new Event();
    @Override
    public Event prepared() {
        return preparedEvent;
    }
    
    @Override
    public void start() {
        switch (playState) {
        case STOPPED:
            switch (prepareState) {
            case READY:
                System.err.println("start() called but not prepared");
                break;
            case PREPARING:
                System.err.println("start() called but preparing");
                break;
            case PREPARED:
                playMedia = prepareMedia;
                prepareMedia = null;
                prepareState = PrepareState.READY;
                playState = PlayState.STARTED;
                doStart();
                break;
            }
            break;
        case STARTED:
            break;
        case PAUSED:
            playState = PlayState.STARTED;
            doRestartFromPause();
            break;
        }
    }
    
    @Override
    public void stop() {
        switch (playState) {
        case STOPPED:
            break;
        case STARTED:
            playState = PlayState.STOPPED;
            playMedia = null;
            doStop();
            break;
        case PAUSED:
            playState = PlayState.STOPPED;
            playMedia = null;
            doStop();
            break;
        }
    }
    
    private Event completedEvent = new Event();
    @Override
    public Event completed() {
        return completedEvent;
    }
    
    protected void completedOK() {
        switch (playState) {
        case STOPPED:
            System.err.println("completeOK() but stopped");
            break;
        case STARTED:
            playMedia = null;
            break;
        case PAUSED:
            playMedia = null;
            System.err.println("completeOK() but paused");
            break;
        }
        playState = PlayState.STOPPED;
        completed().raise();
    }

    protected void completedError() {
        switch (playState) {
        case STOPPED:
            System.err.println("completeError() called when stopped");
            break;
        case STARTED:
            playMedia = null;
            System.err.println("completeError() called when started");
            break;
        case PAUSED:
            playMedia = null;
            System.err.println("completeError() called when paused");
            break;
        }
        playState = PlayState.STOPPED;
        completed().raise();
    }

    @Override
    public void pause() {
        switch (playState) {
        case STOPPED:
            break;
        case STARTED:
            playState = PlayState.PAUSED;
            doPause();
            break;
        case PAUSED:
            break;
        }
    }
    
    @Override
    public void rewind() {
        switch (playState) {
        case STOPPED:
            break;
        case STARTED:
            doRewindAndStart();
            break;
        case PAUSED:
            doRewindAndPause();
            break;
        }
    }

    @Override
    public void skip() {
        stop();
        start();
    }

    @Override
    public double elapsed() {
        return elapsedSeconds();
    }

    @Override
    public Media playing() {
        return playMedia;
    }

}
