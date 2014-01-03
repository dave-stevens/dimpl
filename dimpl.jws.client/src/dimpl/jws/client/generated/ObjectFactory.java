
package dimpl.jws.client.generated;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the dimpl.jws.client.generated package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _PlayingWSResponse_QNAME = new QName("http://service.jws.dimpl/", "playingWSResponse");
    private final static QName _StopWS_QNAME = new QName("http://service.jws.dimpl/", "stopWS");
    private final static QName _StartWS_QNAME = new QName("http://service.jws.dimpl/", "startWS");
    private final static QName _RewindWSResponse_QNAME = new QName("http://service.jws.dimpl/", "rewindWSResponse");
    private final static QName _PlayingWS_QNAME = new QName("http://service.jws.dimpl/", "playingWS");
    private final static QName _ElapsedWSResponse_QNAME = new QName("http://service.jws.dimpl/", "elapsedWSResponse");
    private final static QName _StartWSResponse_QNAME = new QName("http://service.jws.dimpl/", "startWSResponse");
    private final static QName _SkipWSResponse_QNAME = new QName("http://service.jws.dimpl/", "skipWSResponse");
    private final static QName _PauseWSResponse_QNAME = new QName("http://service.jws.dimpl/", "pauseWSResponse");
    private final static QName _PrepareWSResponse_QNAME = new QName("http://service.jws.dimpl/", "prepareWSResponse");
    private final static QName _PreparedWS_QNAME = new QName("http://service.jws.dimpl/", "preparedWS");
    private final static QName _RewindWS_QNAME = new QName("http://service.jws.dimpl/", "rewindWS");
    private final static QName _SkipWS_QNAME = new QName("http://service.jws.dimpl/", "skipWS");
    private final static QName _StopWSResponse_QNAME = new QName("http://service.jws.dimpl/", "stopWSResponse");
    private final static QName _PrepareWS_QNAME = new QName("http://service.jws.dimpl/", "prepareWS");
    private final static QName _PauseWS_QNAME = new QName("http://service.jws.dimpl/", "pauseWS");
    private final static QName _PreparedWSResponse_QNAME = new QName("http://service.jws.dimpl/", "preparedWSResponse");
    private final static QName _ElapsedWS_QNAME = new QName("http://service.jws.dimpl/", "elapsedWS");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: dimpl.jws.client.generated
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link SkipWSResponse }
     * 
     */
    public SkipWSResponse createSkipWSResponse() {
        return new SkipWSResponse();
    }

    /**
     * Create an instance of {@link StartWS }
     * 
     */
    public StartWS createStartWS() {
        return new StartWS();
    }

    /**
     * Create an instance of {@link StartWSResponse }
     * 
     */
    public StartWSResponse createStartWSResponse() {
        return new StartWSResponse();
    }

    /**
     * Create an instance of {@link ElapsedWSResponse }
     * 
     */
    public ElapsedWSResponse createElapsedWSResponse() {
        return new ElapsedWSResponse();
    }

    /**
     * Create an instance of {@link StopWS }
     * 
     */
    public StopWS createStopWS() {
        return new StopWS();
    }

    /**
     * Create an instance of {@link PreparedWSResponse }
     * 
     */
    public PreparedWSResponse createPreparedWSResponse() {
        return new PreparedWSResponse();
    }

    /**
     * Create an instance of {@link StopWSResponse }
     * 
     */
    public StopWSResponse createStopWSResponse() {
        return new StopWSResponse();
    }

    /**
     * Create an instance of {@link PreparedWS }
     * 
     */
    public PreparedWS createPreparedWS() {
        return new PreparedWS();
    }

    /**
     * Create an instance of {@link PlayingWSResponse }
     * 
     */
    public PlayingWSResponse createPlayingWSResponse() {
        return new PlayingWSResponse();
    }

    /**
     * Create an instance of {@link JwsMedia }
     * 
     */
    public JwsMedia createJwsMedia() {
        return new JwsMedia();
    }

    /**
     * Create an instance of {@link RewindWSResponse }
     * 
     */
    public RewindWSResponse createRewindWSResponse() {
        return new RewindWSResponse();
    }

    /**
     * Create an instance of {@link PrepareWS }
     * 
     */
    public PrepareWS createPrepareWS() {
        return new PrepareWS();
    }

    /**
     * Create an instance of {@link PrepareWSResponse }
     * 
     */
    public PrepareWSResponse createPrepareWSResponse() {
        return new PrepareWSResponse();
    }

    /**
     * Create an instance of {@link PlayingWS }
     * 
     */
    public PlayingWS createPlayingWS() {
        return new PlayingWS();
    }

    /**
     * Create an instance of {@link ElapsedWS }
     * 
     */
    public ElapsedWS createElapsedWS() {
        return new ElapsedWS();
    }

    /**
     * Create an instance of {@link PauseWSResponse }
     * 
     */
    public PauseWSResponse createPauseWSResponse() {
        return new PauseWSResponse();
    }

    /**
     * Create an instance of {@link PauseWS }
     * 
     */
    public PauseWS createPauseWS() {
        return new PauseWS();
    }

    /**
     * Create an instance of {@link RewindWS }
     * 
     */
    public RewindWS createRewindWS() {
        return new RewindWS();
    }

    /**
     * Create an instance of {@link SkipWS }
     * 
     */
    public SkipWS createSkipWS() {
        return new SkipWS();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PlayingWSResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.jws.dimpl/", name = "playingWSResponse")
    public JAXBElement<PlayingWSResponse> createPlayingWSResponse(PlayingWSResponse value) {
        return new JAXBElement<PlayingWSResponse>(_PlayingWSResponse_QNAME, PlayingWSResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link StopWS }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.jws.dimpl/", name = "stopWS")
    public JAXBElement<StopWS> createStopWS(StopWS value) {
        return new JAXBElement<StopWS>(_StopWS_QNAME, StopWS.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link StartWS }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.jws.dimpl/", name = "startWS")
    public JAXBElement<StartWS> createStartWS(StartWS value) {
        return new JAXBElement<StartWS>(_StartWS_QNAME, StartWS.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RewindWSResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.jws.dimpl/", name = "rewindWSResponse")
    public JAXBElement<RewindWSResponse> createRewindWSResponse(RewindWSResponse value) {
        return new JAXBElement<RewindWSResponse>(_RewindWSResponse_QNAME, RewindWSResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PlayingWS }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.jws.dimpl/", name = "playingWS")
    public JAXBElement<PlayingWS> createPlayingWS(PlayingWS value) {
        return new JAXBElement<PlayingWS>(_PlayingWS_QNAME, PlayingWS.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ElapsedWSResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.jws.dimpl/", name = "elapsedWSResponse")
    public JAXBElement<ElapsedWSResponse> createElapsedWSResponse(ElapsedWSResponse value) {
        return new JAXBElement<ElapsedWSResponse>(_ElapsedWSResponse_QNAME, ElapsedWSResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link StartWSResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.jws.dimpl/", name = "startWSResponse")
    public JAXBElement<StartWSResponse> createStartWSResponse(StartWSResponse value) {
        return new JAXBElement<StartWSResponse>(_StartWSResponse_QNAME, StartWSResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SkipWSResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.jws.dimpl/", name = "skipWSResponse")
    public JAXBElement<SkipWSResponse> createSkipWSResponse(SkipWSResponse value) {
        return new JAXBElement<SkipWSResponse>(_SkipWSResponse_QNAME, SkipWSResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PauseWSResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.jws.dimpl/", name = "pauseWSResponse")
    public JAXBElement<PauseWSResponse> createPauseWSResponse(PauseWSResponse value) {
        return new JAXBElement<PauseWSResponse>(_PauseWSResponse_QNAME, PauseWSResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PrepareWSResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.jws.dimpl/", name = "prepareWSResponse")
    public JAXBElement<PrepareWSResponse> createPrepareWSResponse(PrepareWSResponse value) {
        return new JAXBElement<PrepareWSResponse>(_PrepareWSResponse_QNAME, PrepareWSResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PreparedWS }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.jws.dimpl/", name = "preparedWS")
    public JAXBElement<PreparedWS> createPreparedWS(PreparedWS value) {
        return new JAXBElement<PreparedWS>(_PreparedWS_QNAME, PreparedWS.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RewindWS }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.jws.dimpl/", name = "rewindWS")
    public JAXBElement<RewindWS> createRewindWS(RewindWS value) {
        return new JAXBElement<RewindWS>(_RewindWS_QNAME, RewindWS.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SkipWS }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.jws.dimpl/", name = "skipWS")
    public JAXBElement<SkipWS> createSkipWS(SkipWS value) {
        return new JAXBElement<SkipWS>(_SkipWS_QNAME, SkipWS.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link StopWSResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.jws.dimpl/", name = "stopWSResponse")
    public JAXBElement<StopWSResponse> createStopWSResponse(StopWSResponse value) {
        return new JAXBElement<StopWSResponse>(_StopWSResponse_QNAME, StopWSResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PrepareWS }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.jws.dimpl/", name = "prepareWS")
    public JAXBElement<PrepareWS> createPrepareWS(PrepareWS value) {
        return new JAXBElement<PrepareWS>(_PrepareWS_QNAME, PrepareWS.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PauseWS }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.jws.dimpl/", name = "pauseWS")
    public JAXBElement<PauseWS> createPauseWS(PauseWS value) {
        return new JAXBElement<PauseWS>(_PauseWS_QNAME, PauseWS.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PreparedWSResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.jws.dimpl/", name = "preparedWSResponse")
    public JAXBElement<PreparedWSResponse> createPreparedWSResponse(PreparedWSResponse value) {
        return new JAXBElement<PreparedWSResponse>(_PreparedWSResponse_QNAME, PreparedWSResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ElapsedWS }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.jws.dimpl/", name = "elapsedWS")
    public JAXBElement<ElapsedWS> createElapsedWS(ElapsedWS value) {
        return new JAXBElement<ElapsedWS>(_ElapsedWS_QNAME, ElapsedWS.class, null, value);
    }

}
