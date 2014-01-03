package dimpl;

import java.net.URL;


public class Media {

  private double duration;
  private String name;
  private URL url;

  public Media(double duration, String name, URL url) {
    this.duration = duration;
    this.name = name;
    this.url = url;
  }

  public double duration() { return this.duration; }
  public String name()     { return this.name; }
  public URL url()         { return this.url; }
}
