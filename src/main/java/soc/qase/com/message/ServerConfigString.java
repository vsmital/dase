//---------------------------------------------------------------------
// Name:			ServerConfigString.java
// Author:			Bernard.Gorman@computing.dcu.ie
// Author:			Martin.Fredriksson@bth.se
//---------------------------------------------------------------------

package soc.qase.com.message;

import soc.qase.tools.Utils;

/**    Message wrapper used when signalling config string from host
 *	to client. */
/*-------------------------------------------------------------------*/
public class ServerConfigString extends Message {
    private static final int TYPE = 21;

    private static final byte[] SERVER_STUFF_TEXT_PREFIX = new byte[]{ 19, 99, 109, 100 };

    private int index = 0;
    private String configString = null;




/*-------------------------------------------------------------------*/

    /**    Constructor. Parses the data and extracts message details.
     *    @param data message source. */
/*-------------------------------------------------------------------*/
    public ServerConfigString(byte[] data, int off) {
        super(TYPE);

        //ServerConfigString is currently not parsable - we'll only set length..
        setLength(Utils.byteArraySearch(data, SERVER_STUFF_TEXT_PREFIX) - off);
    }

/*-------------------------------------------------------------------*/

    /**    Get config string index.
     *    @return string index. */
/*-------------------------------------------------------------------*/
    public int getIndex() {
        return index;
    }

/*-------------------------------------------------------------------*/

    /**    Get config string.
     *    @return config string. */
/*-------------------------------------------------------------------*/
    public String getConfigString() {
        return configString;
    }

/*-------------------------------------------------------------------*/

    /**    Get String representation of this object.
     *    @return String representation of this object. */
/*-------------------------------------------------------------------*/
    public String toString() {
        return configString;
    }
}

