import dimpl.Media;
import dimpl.IMediaPredicate;

public class MediaNameStartsWithPredicate implements IMediaPredicate {

  private String prefix;

  public MediaNameStartsWithPredicate(String prefix) {
    this.prefix = prefix;
  }

  public boolean match(Media media) {
    return media.name().startsWith(prefix);
  }

}
