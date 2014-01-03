import dimpl.Media;
import dimpl.IMediaPredicate;

public class MediaNameContainsPredicate implements IMediaPredicate {

  private String token;

  public MediaNameContainsPredicate(String token) {
    this.token = token;
  }

  public boolean match(Media media) {
    return media.name().contains(token);
  }

}
