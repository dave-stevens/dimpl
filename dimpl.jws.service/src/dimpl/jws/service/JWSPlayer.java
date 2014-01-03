package dimpl.jws.service;

import java.util.Hashtable;

import javax.jws.WebMethod;
import javax.jws.WebService;
import dimpl.Library;
import dimpl.Media;
import dimpl.MediaQueue;
import dimpl.IPlayer;

@WebService
public class JWSPlayer {

	private IPlayer player;
	private Hashtable<Integer, Media> idMediaIndex = new Hashtable<Integer, Media>();
	private Hashtable<Media, JWSMedia> mediaJWSMediaIndex = new Hashtable<Media, JWSMedia>();
	
	public JWSPlayer(IPlayer player) {
		this.player = player;
	}

	private Media lookupMedia(int id) {
		return idMediaIndex.get(id);
	}
	
	private JWSMedia getJWSMedia(Media media) {
		JWSMedia jwsMedia = mediaJWSMediaIndex.get(media);
		if (jwsMedia == null) {
			jwsMedia = new JWSMedia();
			jwsMedia.setDuration(media.duration());
			jwsMedia.setId(idMediaIndex.size()+1);
			jwsMedia.setName(media.name());
			jwsMedia.setUrl(media.url());
			mediaJWSMediaIndex.put(media, jwsMedia);
			idMediaIndex.put(jwsMedia.getId(), media);
		}
		return jwsMedia;
	}
	
	@WebMethod(operationName = "elapsedWS")
	public double elapsed() {
		return player.elapsed();
	}

	@WebMethod(operationName = "playingWS")
	public JWSMedia playing() {
		return getJWSMedia(player.playing());
	}

	@WebMethod(operationName = "prepareWS")
	public void prepare(JWSMedia jwsMedia) {
		Media media = lookupMedia(jwsMedia.getId());
		if (media != null) {
			player.prepare(media);
		}
	}

	@WebMethod(operationName = "preparedWS")
	public boolean prepared() {
		return player.prepared();
	}
	
	@WebMethod(operationName = "startWS")
	public void start() {
		System.out.println("start()");
		player.start();
	}

	@WebMethod(operationName = "stopWS")
	public void stop() {
		System.out.println("stop()");
		player.stop();
	}

	@WebMethod(operationName = "pauseWS")
	public void pause() {
		System.out.println("pause()");
		player.pause();
	}

	@WebMethod(operationName = "rewindWS")
	public void rewind() {
		System.out.println("rewind()");
		player.rewind();
	}

	@WebMethod(operationName = "skipWS")
	public void skip() {
		System.out.println("skip()");
		player.skip();
	}

}
