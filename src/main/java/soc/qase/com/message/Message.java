//---------------------------------------------------------------------
// Name:			Message.java
// Author:			Bernard.Gorman@computing.dcu.ie
// Author:			Martin.Fredriksson@bth.se
//---------------------------------------------------------------------

package soc.qase.com.message;

import com.google.common.io.BaseEncoding;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import soc.qase.tools.Utils;

/*-------------------------------------------------------------------*/

/**    The message class implements all general functionality of
 *	messages sent between client/host and host/client. */
/*-------------------------------------------------------------------*/
public class Message {
    // this weird delimiter is primarily used in server spawn baseline message where it delimits messages in block from each other
    protected static final byte[] MESSAGES_INNER_DELIMITER = new byte[]{ 0, 0, -128, 63 };

    private int type = -1;
    private int clientID = -1;
    private byte[] data = null;
    private int length = 0;

    protected final Logger LOGGER = LoggerFactory.getLogger(getClass());

/*-------------------------------------------------------------------*/

    /**    Default constructor. */
/*-------------------------------------------------------------------*/
    public Message() {
    }

    public Message(int type) {
        this.type = type;
    }

/*-------------------------------------------------------------------*/

    /**    Get message type.
     *    @return message type. */
/*-------------------------------------------------------------------*/
    public int getType() {
        return type;
    }

/*-------------------------------------------------------------------*/

    /**    Set message type.
     *    @param type message type. */
/*-------------------------------------------------------------------*/
    public void setType(int type) {
        this.type = type;
    }

/*-------------------------------------------------------------------*/

    /**    Get client identifier.
     *    @return client identifier. */
/*-------------------------------------------------------------------*/
    public int getClientID() {
        return clientID;
    }

/*-------------------------------------------------------------------*/

    /**    Set client identifier.
     *    @param clientID client identifier. */
/*-------------------------------------------------------------------*/
    public void setClientID(int clientID) {
        this.clientID = clientID;
    }

/*-------------------------------------------------------------------*/

    /**    Get message data as a byte array.
     *    @return message data. */
/*-------------------------------------------------------------------*/
    public byte[] getData() {
        return data;
    }

/*-------------------------------------------------------------------*/

    /**    Set message data.
     *    @param data message data. */
/*-------------------------------------------------------------------*/
    public void setData(byte[] data) {
        this.data = data;
    }

/*-------------------------------------------------------------------*/

    /**    Get message length.
     *    @return message length. */
/*-------------------------------------------------------------------*/
    public int getLength() {
        return length;
    }

/*-------------------------------------------------------------------*/

    /**    Set message length.
     *    @param length message length. */
/*-------------------------------------------------------------------*/
    public void setLength(int length) {
        this.length = length;
    }

/*-------------------------------------------------------------------*/

    /**    Get message bytes.
     *    @return byte array. */
/*-------------------------------------------------------------------*/
    public byte[] getBytes() {
        if (getType() == -1)
            return getData();

        byte[] result = new byte[(getData() == null ? 0 : getData().length) + 3];

        if (getClientID() != -1)
            Utils.shortToByteArray((short) getClientID(), result, 0);

        if (getType() != -1)
            result[2] = (byte) getType();

        if (getData() != null)
            Utils.copyArray(getData(), result, 0, 3, getData().length);

        return result;
    }

/*-------------------------------------------------------------------*/

    /**    Get String representation of message.
     *    @return String representation of message. */
/*-------------------------------------------------------------------*/
    public String toString() {
        String result = null;

        if (getType() == -1) // Connectionless
        {
            if (getData() != null)
                result = new String(getData(), 4, getData().length - 4);
        } else {
            result = new String("" + getType());

            if (getClientID() != -1)
                result += " " + getClientID();

            if (getData() != null)
                result += " " + new String(getData());
        }

        return result;
    }

    protected void logHexStringInterpretation(byte[] data, int offset) {
        String characterInterpretation = String.format("%02X", getType()) + BaseEncoding.base16().encode(Utils.extractBytes(data, offset, getLength()));
        characterInterpretation = characterInterpretation.replaceAll("..", "$0 ").toLowerCase();
        LOGGER.debug(characterInterpretation);
    }
}

