package soc.qase.com.message;

/**
 * Created by Vojtech.Smital on 9.3.2016.
 */
public class ServerMessagePrefix extends Message {

    private static final int MESSAGE_LENGTH = 5;
    private static final int TYPE = 44;

    /**
     * Constructor
     * @param data message source
     * @param off offset within data array.
     */
    public ServerMessagePrefix(byte[] data, int off) {
        super(TYPE);
        //nothing more to do, as this is a new structure within protocol version 33 a we know nothing about it :(
        setLength(MESSAGE_LENGTH);
        logHexStringInterpretation(data, off);
    }
}
