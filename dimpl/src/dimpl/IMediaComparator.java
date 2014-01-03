package dimpl;
import java.util.Comparator;

public interface IMediaComparator extends Comparator<Media> {

  int compare(Media left, Media right);

}
