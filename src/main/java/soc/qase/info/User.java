//---------------------------------------------------------------------
// Name:			User.java
// Author:			Martin.Fredriksson@bth.se
// Author:			Bernard.Gorman@computing.dcu.ie
//---------------------------------------------------------------------

package soc.qase.info;

/*-------------------------------------------------------------------*/

import org.apache.commons.lang.StringUtils;

/**    User information wrapper. The User class is employed when an agent
 *	connects to the simulator environment using a Proxy object, supplying
 *	the environment with basic information required by a Quake2 server. */
/*-------------------------------------------------------------------*/
public class User {
    private String name = "DASE_bot";
    private String model = "models/global/m_hiro.dkm";
    private String skin = "skins/hiro_bod_1.wal";
    private int rate = 30000;
    private int message = 1;
    private int fov = 90;
    private int hand = HAND_RIGHT;
    private String password = null;

    public static final int HAND_RIGHT = 0, HAND_LEFT = 1, HAND_CENTER = 2;

    // indicates the default number button on the keyboard associated with each weapon
    public static final int KEY_BLASTER = 1, KEY_SHOTGUN = 2, KEY_SUPER_SHOTGUN = 3, KEY_MACHINEGUN = 4,
            KEY_CHAINGUN = 5, KEY_GRENADE_LAUNCHER = 6, KEY_ROCKET_LAUNCHER = 7,
            KEY_HYPERBLASTER = 8, KEY_RAILGUN = 9, KEY_BFG = 0;

    /**
     * Default constructor
     */
/*-------------------------------------------------------------------*/
    public User() {
        //nothing to do
    }


    /**    Constructor. Records the user's specified options.
     *    @param name the name by which the agent will be known by other
     *	agents interacting with the environment.
     */
/*-------------------------------------------------------------------*/
    public User(final String name) {
        setName(name);
    }


    /**    Constructor. Records the user's specified options.
     *    @param name the name by which the agent will be known by other
     *	agents interacting with the environment.
     *  @param model the WAL model to be used by an agent
     *	@param skin the rendering skin to be used by an agent; it defines
     *	in what way another agent, making use of environment visualization,
     *	will perceive the agent.
     *	@param rate defines the data receive rate of a Quake2 client and is
     *	expressed in terms of possible number of bytes per second; the value
     *	can range between 0 and 65535 bps
     *	@param message user message level; defines the type of messages in
     *	which the agent registers an interest
     *	@param fov describes the current size of a Quake2 client's view space,
     *	in degrees; as with all angles in the QASE API, this value can range
     *	between 0 and 360
     *	@param hand agents interacting with the physical environment simulated
     *	by a Quake2 server are able to hold certain weapons in their hands;
     *	this hand parameter defines the default hand in which to hold a weapon,
     *	and should be one of the HAND constants listed above
     *	@param password the Quake2 server component features a limited support
     *	for security, and as such may optionally define a password to be used
     *	by connecting parties */
/*-------------------------------------------------------------------*/
    public User(String name, String model, String skin, Integer rate, Integer message, Integer fov, Integer hand, String password) {
        setName(name);
        setModel(model);
        setSkin(skin);
        setRate(rate);
        setMessage(message);
        setFov(fov);
        //TODO vsmital 16.2.2016 find out if hand position is even supported by Daikatana??s
        setHand(hand);
        setPassword(password);
    }
/*-------------------------------------------------------------------*/

    /**    Set user name.
     *    @param name user name. */
/*-------------------------------------------------------------------*/
    public void setName(final String name) {
        if (StringUtils.isNotEmpty(name)) {
            this.name = name;
        }
        this.name = name;
    }

    /**   Sets user model.
     *   @param model users model. */
/*-------------------------------------------------------------------*/
    public void setModel(final String model) {
        if (StringUtils.isNotEmpty(model)) {
            this.model = model;
        }
    }

    /**    Set user skin.
     *    @param skin user skin. */
/*-------------------------------------------------------------------*/
    public void setSkin(final String skin) {
        if (StringUtils.isNotEmpty(skin)) {
            this.skin = skin;
        }
    }


/*-------------------------------------------------------------------*/

    /**    Set data receive rate.
     *    @param rate data receive rate. */
/*-------------------------------------------------------------------*/
    public void setRate(final Integer rate) {
        if (rate != null && rate > 0) {
            this.rate = rate;
        }
    }

/*-------------------------------------------------------------------*/

    /**    Set user message level. Defines what kind of messages the client
     *	is interested in.
     *    @param message user message level. */
/*-------------------------------------------------------------------*/
    public void setMessage(final Integer message) {
        if (message != null) {
            this.message = message;
        }
    }

/*-------------------------------------------------------------------*/

    /**    Set user field of view.
     *    @param fov user field of view. */
/*-------------------------------------------------------------------*/
    public void setFov(final Integer fov) {
        if (fov != null && fov > 0) {
            this.fov = fov;
        }
    }

/*-------------------------------------------------------------------*/

    /**    Set user hand. 0 for right, 1 for left, 2 for centre (invisible)
     *    @param hand user hand. */
/*-------------------------------------------------------------------*/
    public void setHand(final Integer hand) {
        if (hand != null && hand >= 0 && hand <= 2) {
            this.hand = hand;
        }
    }

/*-------------------------------------------------------------------*/

    /**    Set host password.
     *    @param password host password. */
/*-------------------------------------------------------------------*/
    public void setPassword(String password) {
        this.password = password;
    }

/*-------------------------------------------------------------------*/

    /**    Get user name.
     *    @return user name. */
/*-------------------------------------------------------------------*/
    public String getName() {
        return name;
    }

    /**    Returns model name
     *     @return model name */
/*-------------------------------------------------------------------*/
    public String getModel() {
        return model;
    }

    /**    Get user skin.
     *    @return user skin. */
/*-------------------------------------------------------------------*/
    public String getSkin() {
        return skin;
    }

/*-------------------------------------------------------------------*/

    /**    Get data receive rate.
     *    @return data receive rate. */
/*-------------------------------------------------------------------*/
    public int getRate() {
        return rate;
    }

/*-------------------------------------------------------------------*/

    /**    Get user message level.
     *    @return user message level. */
/*-------------------------------------------------------------------*/
    public int getMessage() {
        return message;
    }

/*-------------------------------------------------------------------*/

    /**    Get user field of view.
     *    @return user field of view. */
/*-------------------------------------------------------------------*/
    public int getFov() {
        return fov;
    }

/*-------------------------------------------------------------------*/

    /**    Get user hand.
     *    @return user hand. */
/*-------------------------------------------------------------------*/
    public int getHand() {
        return hand;
    }

/*-------------------------------------------------------------------*/

    /**    Get host password.
     *    @return host password. */
/*-------------------------------------------------------------------*/
    public String getPassword() {
        return password;
    }

/*-------------------------------------------------------------------*/

    /**    Get String representation of this object.
     *    @return String representation of this object. */
/*-------------------------------------------------------------------*/
    public String toString() {
        String result = null;

        result = new String("\\");
        result += "rate" + "\\" + rate + "\\";
        result += "msg" + "\\" + message + "\\";
        result += "fov" + "\\" + fov + "\\";
        result += "modelName" + "\\" + model + "\\";
        result += "skinName" + "\\" + skin + "\\";
        result += "name" + "\\" + name + "\\";
        result += "hand" + "\\" + hand;
        return result;
    }
}
