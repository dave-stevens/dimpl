package dimpl;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;


public class Library {

  private List<Media> mediaList = new ArrayList<Media>();

  public void add(Media media) {
    mediaList.add(media);
  }

public List<Media> all() {
    ArrayList<Media> sorted = new ArrayList<Media>(mediaList);
    return sorted;
  }

public List<Media> sort(IMediaComparator comparator) {
    ArrayList<Media> sorted = new ArrayList<Media>(mediaList);
    Collections.sort(sorted, comparator);
    return sorted;
  }

public Library filter(IMediaPredicate predicate) {
    Library filtered = new Library();
    for (Media media : mediaList) {
      if (predicate.match(media)) {
        filtered.add(media);
      }
    }
    return filtered;
  }

}
