//---------------------------------------------------------------------
// Name:			PlayerMove.java
// Author:			Martin.Fredriksson@bth.se
// Author:			Bernard.Gorman@computing.dcu.ie
//---------------------------------------------------------------------

package soc.qase.state;

import soc.qase.tools.vecmath.Vector2f;

/*-------------------------------------------------------------------*/
/**	Wrapper class for player move attributes. Contains two forms of
 *	information about the player's movement; the MOVE (normal, spectator,
 *	dead, gib, freeze) and the FLAGs (jump, duck, etc). Also includes
 *	the agent's current position in the environment (coordinates),
 *	its current angles (heading), and the agent's current velocity
 *	(speed along the X, Y, and Z axis). */
/*-------------------------------------------------------------------*/
public class PlayerMove
{
	private int type = -1;
	private int flags = -1;
	private int time = -1;
	private int gravity = -1;
	private Velocity velocity = null;
	private Origin origin = null;
	private Angles deltaAngles = null;
	private Vector2f directionalVelocity = null;

	public static final int MOVE_NORMAL = 0, MOVE_SPECTATOR = 1, MOVE_DEAD = 2, MOVE_GIB = 3, MOVE_FREEZE = 4;
	public static final int FLAG_DUCKED = 1, FLAG_JUMP = 2, FLAG_GROUND = 4, FLAG_TIME_WATER = 8, FLAG_TIME_LAND = 16, FLAG_TIME_TELEPORT = 32, FLAG_NO_PREDICTION = 64;

/*-------------------------------------------------------------------*/
/**	Default constructor. */
/*-------------------------------------------------------------------*/
	public PlayerMove()
	{
		directionalVelocity = new Vector2f();
	}
	
/*-------------------------------------------------------------------*/
/**	Get player move type, as defined by the TYPE constants listed above.
 *	@return player move type */
/*-------------------------------------------------------------------*/
	public int getType()
	{
		return type;
	}
	
/*-------------------------------------------------------------------*/
/**	Get player move type string.
 *	@return player move string. */
/*-------------------------------------------------------------------*/
	public String getTypeString()
	{
		String result = null;

		result = new String();
		if(type == 0) result += "normal";
		if(type == 1) result += "spectator";
		if(type == 2) result += "dead";
		if(type == 3) result += "gib";
		if(type == 4) result += "freeze";
		return result;
	}

/*-------------------------------------------------------------------*/
/**	Check the player move attributes. Typically, the argument is one of
 *	the MOVE constants defined above.
 *	@return player move type. */
/*-------------------------------------------------------------------*/
	public boolean checkType(int cType)
	{
		return type == cType;
	}

/*-------------------------------------------------------------------*/
/**	Set player move type, as defined by the MOVE constants listed above.
 *	@param type player move type */
/*-------------------------------------------------------------------*/
	public void setType(int type)
	{
		this.type = type;
	}
	
/*-------------------------------------------------------------------*/
/**	Get player move flags, as defined by the FLAG constants listed above.
 *	The result is a bitwise combination which may denote more than one
 *	move state.
 *	@return player move state */
/*-------------------------------------------------------------------*/
	public int getFlags()
	{
		return flags;
	}
	
/*-------------------------------------------------------------------*/
/**	Get concatenated string denoting current move flag settings.
 *	@return player move flags string. */
/*-------------------------------------------------------------------*/
	public String getFlagsString()
	{
		String result = "";

		if((flags & FLAG_DUCKED) != 0) result += "ducked:";
		if((flags & FLAG_JUMP) != 0) result += "jump:";
		if((flags & FLAG_GROUND) != 0) result += "ground:";
		if((flags & FLAG_TIME_WATER) != 0) result += "timeWater:";
		if((flags & FLAG_TIME_LAND) != 0) result += "timeLand:";
		if((flags & FLAG_TIME_TELEPORT) != 0) result += "timeTeleport:";
		if((flags & FLAG_NO_PREDICTION) != 0) result += "noPrediction:";

		return result;
	}

/*-------------------------------------------------------------------*/
/**	Set player move flags, as defined by the FLAG constants listed above.
 *	This my be a bitwise combination of two or more of the constants.
 *	@param flags player move flags */
/*-------------------------------------------------------------------*/
	public void setFlags(int flags)
	{
		this.flags = flags;
	}

/*-------------------------------------------------------------------*/
/**	Check whether certain movement flags are set. Typically the argument
 *	is a bitmask constructed by ORing a selection of the FLAG constants
 *	above, which is compared against the current flags state.
 *	@param flagMask flag mask to compare against current flag attributes
 *	@return true if the given sub-bitmask fits the flag bitmask */
/*-------------------------------------------------------------------*/
	public boolean checkFlags(int flagMask)
	{
		return (flags & flagMask) != 0;
	}

/*-------------------------------------------------------------------*/
/**	Get player move time.
 *	@return player move time. */
/*-------------------------------------------------------------------*/
	public int getTime()
	{
		return time;
	}
	
/*-------------------------------------------------------------------*/
/**	Set player move time.
 *	@param time player move time. */
/*-------------------------------------------------------------------*/
	public void setTime(int time)
	{
		this.time = time;
	}
	
/*-------------------------------------------------------------------*/
/**	Get player move gravity.
 *	@return player move gravity. */
/*-------------------------------------------------------------------*/
	public int getGravity()
	{
		return gravity;
	}
	
/*-------------------------------------------------------------------*/
/**	Set player move gravity.
 *	@param gravity player movement gravity */
/*-------------------------------------------------------------------*/
	public void setGravity(int gravity)
	{
		this.gravity = gravity;
	}
	
/*-------------------------------------------------------------------*/
/**	Get player move origin.
 *	@return player move origin. */
/*-------------------------------------------------------------------*/
	public Origin getOrigin()
	{
		if(origin == null) origin = new Origin();
		return origin;
	}
	
/*-------------------------------------------------------------------*/
/**	Set player move origin.
 *	@param origin player move origin. */
/*-------------------------------------------------------------------*/
	public void setOrigin(Origin origin)
	{
		this.origin = origin;
	}
	
/*-------------------------------------------------------------------*/
/**	Get player move velocity.
 *	@return player move velocity. */
/*-------------------------------------------------------------------*/
	public Velocity getVelocity()
	{
		if(velocity == null) velocity = new Velocity();
		return velocity;
	}

/*-------------------------------------------------------------------*/
/**	Set player move velocity.
 *	@param velocity player move velocity. */
/*-------------------------------------------------------------------*/
	public void setVelocity(Velocity velocity)
	{
		this.velocity = velocity;
		directionalVelocity.set(velocity.getForward(), velocity.getRight());
	}

/*-------------------------------------------------------------------*/
/**	Get player's directional velocity.
 *	@return a 2D vector indicating the player's veolcities along the
 *	X and Z axes */
/*-------------------------------------------------------------------*/
	public Vector2f getDirectionalVelocity()
	{
		return directionalVelocity;
	}

/*-------------------------------------------------------------------*/
/**	Get player move delta angles.
 *	@return player move delta angles. */
/*-------------------------------------------------------------------*/
	public Angles getDeltaAngles()
	{
		if(deltaAngles == null) deltaAngles = new Angles();
		return deltaAngles;
	}

/*-------------------------------------------------------------------*/
/**	Set player move delta angles.
 *	@param deltaAngles player move delta angles. */
/*-------------------------------------------------------------------*/
	public void setDeltaAngles(Angles deltaAngles)
	{
		this.deltaAngles = deltaAngles;
	}

/*-------------------------------------------------------------------*/
/**	Merge PlayerMove properties from an existing PlayerMove object into the
 *	current PlayerMove object. Used when assimilating cumulative updates
 *	from the Quake 2 server into the gamestate.
 *	@param playerMove source PlayerMove whose attributes should be merged
 *	into the current PlayerMove
 *	@see soc.qase.state.World#setEntity(Entity, boolean) */
/*-------------------------------------------------------------------*/
	public void merge(PlayerMove playerMove)
	{
		if(type == -1) type = playerMove.getType();
		if(flags == -1) flags = playerMove.getFlags();
		if(time == -1) time = playerMove.getTime();
		if(gravity == -1) gravity = playerMove.getGravity();
		if(origin == null) origin = new Origin();
		if(velocity == null) velocity = new Velocity();
		if(deltaAngles == null) deltaAngles = new Angles();

		if(playerMove != null)
		{
			origin.merge(playerMove.getOrigin());
			velocity.merge(playerMove.getVelocity());
			deltaAngles.merge(playerMove.getDeltaAngles());
		}
	}
}
