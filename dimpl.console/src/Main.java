import java.net.MalformedURLException;

import dimpl.IController;
import dimpl.IMediaPredicate;
import dimpl.IPlayer;
import dimpl.console.ConsolePlayer;
import dimpl.impl.Controller;

class Main {

  public static void main(String[] args) throws MalformedURLException {

    IController controller;

    {
      // Inject dependencies
      ConsolePlayer     consolePlayer1    = new ConsolePlayer();

//      consolePlayer1.library().add(new Media(1.2, "The Planet Suite", new URL("")));
//      consolePlayer1.library().add(new Media( .9, "The Trout", new URL("")));
//      consolePlayer1.library().add(new Media(0.3, "Madness", new URL("")));

      ConsolePlayer     consolePlayer2    = new ConsolePlayer();
      Controller consoleController = new Controller();

      consoleController.connect(consolePlayer1);
      consoleController.connect(consolePlayer2);

      controller = consoleController;
    }

    // Manipulate the players of the controller
    for (IPlayer player : controller.players()) {

//      Library library =  player.library();

      IMediaPredicate predicate;

      // Queue everything
      predicate = new TruePredicate();
//      for (Media media : library.filter(predicate).all()) {
//        player.mediaQueue().push(media);
//      }

      // Queue everything that begins with "The"
      predicate = new MediaNameStartsWithPredicate("The");
//      for (Media media : library.filter(predicate).all()) {
//          player.mediaQueue().push(media);
//      }

      // Queue everything that contains "ne"
      predicate = new MediaNameContainsPredicate("ne");
//      for (Media media : library.filter(predicate).all()) {
//          player.mediaQueue().push(media);
//      }

      player.start();
    }
  }
}
