//---------------------------------------------------------------------
// Name:			ServerCenterPrint.java
// Author:			Bernard.Gorman@computing.dcu.ie
// Author:			Martin.Fredriksson@bth.se
//---------------------------------------------------------------------

package soc.qase.com.message;

import soc.qase.tools.Utils;

/*-------------------------------------------------------------------*/

/**    A message containing text to be printed in the centre of the screen. */
/*-------------------------------------------------------------------*/
public class ServerCenterPrint extends Message {
    private static final int TYPE = 23;
    //this is probably related to size of displayed text or colour, it doesn't matter for us anyway
    private static final byte MESSAGE_POSTFIX_LENGTH = 3;

    private String text_message = null;

/*-------------------------------------------------------------------*/

    /**    Constructor. Parses the data and extracts message details.
     *    @param data message source */
/*-------------------------------------------------------------------*/
    public ServerCenterPrint(byte[] data, int off) {
        super(TYPE);

        int strLength = Utils.stringLength(data, off);
        text_message = Utils.stringValue(data, off, strLength);

        setLength(strLength + 1 + MESSAGE_POSTFIX_LENGTH);

        logHexStringInterpretation(data, off);
    }

/*-------------------------------------------------------------------*/

    /**    Get the text to be printed on screen.
     *    @return the text received from the server */
/*-------------------------------------------------------------------*/
    public String getText() {
        return text_message;
    }
}

