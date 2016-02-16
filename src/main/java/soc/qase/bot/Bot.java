//--------------------------------------------------
// Name:			Bot.java
// Author:			Bernard.Gorman@computing.dcu.ie
//--------------------------------------------------

package soc.qase.bot;

import soc.qase.state.World;

/*-------------------------------------------------------------------*/

/**    An interface which specifies the minimal structure to which Bots must
 *	conform. */
/*-------------------------------------------------------------------*/
public interface Bot {
/*-------------------------------------------------------------------*/

    /**    Disconnect from the server. */
/*-------------------------------------------------------------------*/
    void disconnect();
/*-------------------------------------------------------------------*/

    /**    Connect to a game server .
     *    @param host a String representation of the host's ip
     *	@param port the port on which the game is running */
/*-------------------------------------------------------------------*/
    boolean connect(String host, int port);

/*-------------------------------------------------------------------*/

    /**    The agent's main AI loop should reside in this method.
     *    @param world a World object representing the current gamestate */
/*-------------------------------------------------------------------*/
    void runAI(World world);
}
