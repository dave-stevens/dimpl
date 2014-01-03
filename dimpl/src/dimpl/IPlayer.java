package dimpl;

public interface IPlayer {

  // Prepare a Media for playing
  void prepare(Media media);

  // Determine if the player is ready to start
  boolean isPrepared();

  // prepared event is raised when the media is ready to be played
  Event prepared();

  // Start the player
  void start();

  // Stop the player, the player drops the media being played
  void stop();

  // stopped event is raised when the media has finished being played
  Event completed();
  
  // Pause the player at its current position
  void pause();

  // Move to the start of the current media
  void rewind();

  // Move to the next media or stop if none
  void skip();

  // The elapsed time in seconds of the current media
  double elapsed();

  // Retrieve the media that is currently playing
  Media playing();
}
