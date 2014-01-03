import dimpl.Media;
import dimpl.IMediaPredicate;

public class TruePredicate implements IMediaPredicate {

  public boolean match(Media media) {
    return true;
  }

}
