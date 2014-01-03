package dimpl;
import java.util.List;

public interface IController extends IPlayer {

  void connect(IPlayer player);
  void disconnect(IPlayer player);
  List<IPlayer> players();

}
