package dimpl.console;

import dimpl.Media;
import dimpl.impl.PlayerBase;

public class ConsolePlayer extends PlayerBase {

    private static class ConsoleMediaPlayer implements Runnable {
        private Media media = null;
        private double elapsed = 0;
        private boolean playing = false;

        public ConsoleMediaPlayer() {
        }

        public void run() {
            System.out.println("Running");
            try {
                while (true) {
                    Thread.sleep(100);
                    if (playing()) {
                        shift(0.1);
                    }
                }
            } catch (InterruptedException e) {
                System.out.println("Interrupted");
            }
        }

        public synchronized double elapsed() {
            return elapsed;
        }

        private synchronized boolean playing() {
            return playing;
        }

        private synchronized void shift(double delta) {
            if (media != null) {
                elapsed = elapsed + delta;
                if (elapsed < 0) {
                    rewind();
                } else if (elapsed > media.duration()) {
                    stop();
                } else {
                    System.out.println(media.name() + " "
                            + String.format("%f", elapsed));
                }
            }
        }

        public synchronized void play() {
            System.out.println("ConsoleMediaPlayer.play");
            playing = true;
        }

        public synchronized void stop() {
            System.out.println("ConsoleMediaPlayer.stop");
            select(null);
        }

        public synchronized void pause() {
            this.playing = false;
        }

        public synchronized void rewind() {
            System.out.println("ConsoleMediaPlayer.rewind");
            this.elapsed = 0;
        }

        public synchronized void select(Media media) {
            this.elapsed = 0;
            this.media = media;
            if (this.media == null) {
                this.playing = false;
            }
        }
    }

    private ConsoleMediaPlayer mediaPlayer = new ConsoleMediaPlayer();
    private Thread thread;

    public ConsolePlayer() {
        thread = new Thread(mediaPlayer);
        thread.start();
    }

    @Override
    protected void doPrepare(Media media) {
        mediaPlayer.select(media);
        prepareOK();
    }

    @Override
    protected void doStart() {
        mediaPlayer.play();
    }

    @Override
    protected void doRestartFromPause() {
        mediaPlayer.play();
    }

    @Override
    protected void doStop() {
        mediaPlayer.stop();
    }

    @Override
    protected void doPause() {
        mediaPlayer.pause();
    }

    @Override
    protected void doRewindAndStart() {
        mediaPlayer.rewind();
        mediaPlayer.play();
    }

    @Override
    protected void doRewindAndPause() {
        mediaPlayer.rewind();
    }

    @Override
    protected double elapsedSeconds() {
        return mediaPlayer.elapsed();
    }

}
