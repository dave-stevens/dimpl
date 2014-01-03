package dimpl.jws.service;

import java.net.URL;

public class JWSMedia {

	private int id;
	public int getId() {
		return id;
	}
	
	public void setId(int value) {
		id = value;
	}
	
	private double duration;
	public double getDuration() {
		return duration;
	}
	public void setDuration(double value) {
		duration = value;
	}
	
	private String name;
	public String getName() {
		return name;
	}
	public void setName(String value) {
		name = value;
	}
	
	private URL url;
	public URL getUrl() {
		return url;
	}
	public void setUrl(URL value) {
		url = value;
	}

}
