//---------------------------------------------------------------------
// Name:			ServerStuffText.java
// Author:			Bernard.Gorman@computing.dcu.ie
// Author:			Martin.Fredriksson@bth.se
//---------------------------------------------------------------------

package soc.qase.com.message;

import soc.qase.tools.Utils;

/*-------------------------------------------------------------------*/

/**    Message wrapper used when signalling stuff text information from
 *	host to client. */
/*-------------------------------------------------------------------*/
public class ServerStuffText extends Message {
    private static final int TYPE = 19;

    private String stuffString = null;

/*-------------------------------------------------------------------*/

    /**    Constructor. Parses the data and extracts message details.
     *    @param data message source
     *    @param off offset regarding input data byte array
     */
/*-------------------------------------------------------------------*/
    public ServerStuffText(byte[] data, int off) {
        super(TYPE);

        int stringLength = Utils.stringLength(data, off);
        stuffString = new String(Utils.stringValue(data, off, stringLength - 1));
        setLength(data.length - off);

        logHexStringInterpretation(data, off);
    }

/*-------------------------------------------------------------------*/

    /**    Get stuff string.
     *    @return stuff string. */
/*-------------------------------------------------------------------*/
    public String getStuffString() {
        return stuffString;
    }

/*-------------------------------------------------------------------*/

    /**    Get String representation of this object.
     *    @return String representation of this object. */
/*-------------------------------------------------------------------*/
    public String toString() {
        return stuffString;
    }
}

