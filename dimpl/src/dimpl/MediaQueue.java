package dimpl;
import java.util.Queue;
import java.util.LinkedList;


public class MediaQueue {

  Queue<Media> queue = new LinkedList<Media>();

  public Media peek() {
    return queue.peek();
  }

  public Media pop() {
    return queue.poll();
  }

  public void push(Media media) {
    queue.add(media);
  }

}
