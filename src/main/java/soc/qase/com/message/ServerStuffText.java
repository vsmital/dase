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
    private String stuffString = null;

/*-------------------------------------------------------------------*/

    /**    Constructor. Parses the data and extracts message details.
     *    @param data message source
     *    @param off offset regarding input data byte array
     */
/*-------------------------------------------------------------------*/
    public ServerStuffText(byte[] data, int off) {
        int stringLength = Utils.stringLength(data, off + 1);
        stuffString = new String(Utils.stringValue(data, off + 1, stringLength - 1));
        setLength(stringLength + 1);
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

