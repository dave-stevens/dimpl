package dimpl.jws.client;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Hashtable;

import dimpl.IPlayer;
import dimpl.Media;
import dimpl.jws.client.generated.JWSPlayer;
import dimpl.jws.client.generated.JWSPlayerService;
import dimpl.jws.client.generated.JwsMedia;

public class JWSPlayerClient implements IPlayer {

	private JWSPlayer player;
	private Hashtable<Integer, Media> idMediaIndex = new Hashtable<Integer, Media>();
	private Hashtable<Media, Integer> mediaIdIndex = new Hashtable<Media, Integer>();
	
	public JWSPlayerClient() {
		try {
			player = new JWSPlayerService().getJWSPlayerPort();
		}
		catch (Exception e) {
			e.printStackTrace();
			player = null;
		}
	}

	private JwsMedia lookupJwsMedia(Media media) {
		Integer id = mediaIdIndex.get(media);
		if (id != null) {
			JwsMedia jwsMedia = new JwsMedia();
			jwsMedia.setDuration(media.duration());
			jwsMedia.setId(id);
			jwsMedia.setName(media.name());
			jwsMedia.setUrl(media.url().toString());
			return jwsMedia;
		}
		// Unknown Media
		return null;
	}
	
	private Media getMedia(JwsMedia jwsMedia) {
		Media media = idMediaIndex.get(jwsMedia.getId());
		if (media == null) {
			try {
				media = new Media(jwsMedia.getDuration(), jwsMedia.getName(), new URL(jwsMedia.getUrl()));
			} catch (MalformedURLException e) {
				// Trace and return null
				e.printStackTrace();
				return null;
			}
			idMediaIndex.put(jwsMedia.getId(), media);
			idMediaIndex.put(jwsMedia.getId(), media);
		}
		return media;
	}
	
	@Override
	public void start() {
		if (player != null) {
			player.startWS();
		}
	}

	@Override
	public void stop() {
		if (player != null) {
			player.stopWS();
		}
	}

	@Override
	public void pause() {
		if (player != null) {
			player.pauseWS();
		}
	}

	@Override
	public void rewind() {
		if (player != null) {
			player.rewindWS();
		}
	}

	@Override
	public void skip() {
		if (player != null) {
			player.skipWS();
		}
	}

	@Override
	public void prepare(Media media) {
		if (player != null) {
			JwsMedia jwsMedia = lookupJwsMedia(media);
			if (jwsMedia != null) {
				player.prepareWS(jwsMedia);
			}
		}
	}

	@Override
	public boolean prepared() {
		if (player != null) {
			return player.preparedWS();
		}
		return false;
	}

	@Override
	public double elapsed() {
		if (player != null) {
			return player.elapsedWS();
		}
		return 0;
	}

	@Override
	public Media playing() {
		if (player != null) {
			return getMedia(player.playingWS());
		}
		return null;
	}

}
