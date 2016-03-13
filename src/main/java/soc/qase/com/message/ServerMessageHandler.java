//---------------------------------------------------------------------
// Name:			ServerMessageHandler.java
// Author:			Bernard.Gorman@computing.dcu.ie
// Author:			Martin.Fredriksson@bth.se
//---------------------------------------------------------------------

package soc.qase.com.message;

import java.util.Observable;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import soc.qase.com.packet.ClientPacket;
import soc.qase.com.packet.ServerPacket;
import soc.qase.file.dem.DemParser;
import soc.qase.info.Server;
import soc.qase.state.World;

/*-------------------------------------------------------------------*/

/**    Abstract class used as base for all classes which read and process
 *	server messages (ie Proxy and DM2Parser).
 *    @see soc.qase.com.Proxy
 *	@see DemParser */
/*-------------------------------------------------------------------*/
public abstract class ServerMessageHandler extends Observable {

    protected final Logger LOGGER = LoggerFactory.getLogger(getClass());

    protected World world = null;
    protected Server server = null;

    protected boolean trackInventory = false;

/*-------------------------------------------------------------------*/

    /**    Process an incoming ServerPacket, identifying the type of message
     *	it contains and reacting accordingly. See the following methods
     *	for a list of all valid message types. */
/*-------------------------------------------------------------------*/
    protected void processServerPacket(ServerPacket packet) {
        ClientPacket clientPacket = null;
        Message message = null;

        message = packet.getMessage();

        try {
            if (message instanceof ServerBad) LOGGER.debug("Received: ServerBad");
            else if (message instanceof ServerPlayerMuzzleFlash) processServerPlayerMuzzleFlash((ServerPlayerMuzzleFlash) message);
            else if (message instanceof ServerMonsterMuzzleFlash) processServerMonsterMuzzleFlash((ServerMonsterMuzzleFlash) message);
            else if (message instanceof ServerTemporaryEntity) processServerTemporaryEntity((ServerTemporaryEntity) message);
            else if (message instanceof ServerLayout) processServerLayout((ServerLayout) message);
            else if (message instanceof ServerInventory) processServerInventory((ServerInventory) message);
            else if (message instanceof ServerNop) LOGGER.debug("Received: ServerNop");
            else if (message instanceof ServerDisconnect) processServerDisconnect((ServerDisconnect) message);
            else if (message instanceof ServerReconnect) processServerReconnect((ServerReconnect) message);
            else if (message instanceof ServerSound) processServerSound((ServerSound) message);
            else if (message instanceof ServerPrint) processServerPrint((ServerPrint) message);
            else if (message instanceof ServerStuffText) processServerStuffText((ServerStuffText) message);
            else if (message instanceof ServerData) processServerData((ServerData) message);
            else if (message instanceof ServerConfigString) processServerConfigString((ServerConfigString) message);
            else if (message instanceof ServerSpawnBaseline) processServerSpawnBaseline((ServerSpawnBaseline) message);
            else if (message instanceof ServerCenterPrint) LOGGER.debug("Received: ServerCenterPrint");
            else if (message instanceof ServerDownload) LOGGER.debug("Received: ServerDownload");
            else if (message instanceof ServerPlayerInfo) processServerPlayerInfo((ServerPlayerInfo) message);
            else if (message instanceof ServerPacketEntities) processServerPacketEntities((ServerPacketEntities) message);
            else if (message instanceof ServerDeltaPacketEntities) LOGGER.debug("Received: ServerDeltaPacketEntities");
            else if (message instanceof ServerFrame) processServerFrame((ServerFrame) message);
            else if (message instanceof ServerMessagePrefix) LOGGER.debug("Received: ServerMessagePrefix");
        } catch (Exception e) {
            LOGGER.error("Error occured", e);
        }
    }

    /*-------------------------------------------------------------------*/
/*-------------------------------------------------------------------*/
    protected void processServerPlayerMuzzleFlash(ServerPlayerMuzzleFlash message) {
        LOGGER.debug("Processing: ServerPlayerMuzzleFlash");
    }

    /*-------------------------------------------------------------------*/
/*-------------------------------------------------------------------*/
    protected void processServerMonsterMuzzleFlash(ServerMonsterMuzzleFlash message) {
        LOGGER.debug("Processing: ServerMonsterMuzzleFlash");
    }

    /*-------------------------------------------------------------------*/
/*-------------------------------------------------------------------*/
    protected void processServerTemporaryEntity(ServerTemporaryEntity message) {
        LOGGER.debug("Processing: ServerTemporaryEntity");

        world.setTemporaryEntity(message.getTemporaryEntity());
    }

    /*-------------------------------------------------------------------*/
/*-------------------------------------------------------------------*/
    protected void processServerLayout(ServerLayout message) {
        LOGGER.debug("Processing: ServerLayout");

        world.setLayout(message.getLayout());
    }

    /*-------------------------------------------------------------------*/
/*-------------------------------------------------------------------*/
    protected void processServerInventory(ServerInventory message) {
        LOGGER.debug("Processing: ServerInventory");

        world.setInventory(message.getInventory());
    }

    /*-------------------------------------------------------------------*/
/*-------------------------------------------------------------------*/
    protected void processServerDisconnect(ServerDisconnect message) {
        LOGGER.debug("Processing: ServerDisconnect");
    }

    /*-------------------------------------------------------------------*/
/*-------------------------------------------------------------------*/
    protected void processServerReconnect(ServerReconnect message) {
        LOGGER.debug("Processing: ServerReconnect");
    }

    /*-------------------------------------------------------------------*/
/*-------------------------------------------------------------------*/
    protected void processServerSound(ServerSound message) {
        LOGGER.debug("Processing: ServerSound");

        world.processSound(message.getSound());
    }

    /*-------------------------------------------------------------------*/
/*-------------------------------------------------------------------*/
    protected void processServerPrint(ServerPrint message) {
        LOGGER.debug("Processing: ServerPrint");

        world.setMessage(message.getPrintString());
    }

    /*-------------------------------------------------------------------*/
/*-------------------------------------------------------------------*/
    protected void processServerStuffText(ServerStuffText message) {
        LOGGER.debug("Processing: ServerStuffText");
    }

    /*-------------------------------------------------------------------*/
/*-------------------------------------------------------------------*/
    protected void processServerData(ServerData message) {
        LOGGER.debug("Processing: ServerData");

        server = new Server(message);

        if (world != null)
            world.setServerData(server);
    }

    /*-------------------------------------------------------------------*/
/*-------------------------------------------------------------------*/
    protected void processServerConfigString(ServerConfigString message) {
        LOGGER.debug("Processing: ServerConfigString - [" + message.getIndex() + " " + message.getConfigString() + "]");

        world.getConfig().setConfigString(message.getIndex(), message.getConfigString());
    }

    /*-------------------------------------------------------------------*/
/*-------------------------------------------------------------------*/
    protected void processServerSpawnBaseline(ServerSpawnBaseline message) {
        LOGGER.debug("Processing: ServerSpawnBaseline");
    }

    /*-------------------------------------------------------------------*/
/*-------------------------------------------------------------------*/
    protected void processServerPlayerInfo(ServerPlayerInfo message) {
        LOGGER.debug("Processing: ServerPlayerInfo");

        world.setPlayer(message.getPlayer());
    }

    /*-------------------------------------------------------------------*/
/*-------------------------------------------------------------------*/
    protected void processServerPacketEntities(ServerPacketEntities message) {
        LOGGER.debug("Processing: ServerPacketEntities");

        world.setEntities(message.getEntities());
    }

    /*-------------------------------------------------------------------*/
/*-------------------------------------------------------------------*/
    protected void processServerFrame(ServerFrame message) {
        LOGGER.debug("Processing: ServerFrame");

        world.setFrame(message);
    }

    //Probably only for mocking purposes...
    void setWorld(final World world) {
        this.world = world;
    }
}
