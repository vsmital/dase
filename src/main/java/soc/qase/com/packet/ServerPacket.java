//---------------------------------------------------------------------
// Name:			ServerPacket.java
// Author:			Bernard.Gorman@computing.dcu.ie
// Author:			Martin.Fredriksson@bth.se
//---------------------------------------------------------------------

package soc.qase.com.packet;

import org.apache.commons.lang.ArrayUtils;
import soc.qase.com.message.Message;
import soc.qase.com.message.ServerBad;
import soc.qase.com.message.ServerCenterPrint;
import soc.qase.com.message.ServerConfigString;
import soc.qase.com.message.ServerData;
import soc.qase.com.message.ServerDeltaPacketEntities;
import soc.qase.com.message.ServerDisconnect;
import soc.qase.com.message.ServerDownload;
import soc.qase.com.message.ServerFrame;
import soc.qase.com.message.ServerInventory;
import soc.qase.com.message.ServerLayout;
import soc.qase.com.message.ServerMonsterMuzzleFlash;
import soc.qase.com.message.ServerNop;
import soc.qase.com.message.ServerPacketEntities;
import soc.qase.com.message.ServerPlayerInfo;
import soc.qase.com.message.ServerPlayerMuzzleFlash;
import soc.qase.com.message.ServerPrint;
import soc.qase.com.message.ServerReconnect;
import soc.qase.com.message.ServerSound;
import soc.qase.com.message.ServerSpawnBaseline;
import soc.qase.com.message.ServerStuffText;
import soc.qase.com.message.ServerTemporaryEntity;

/*-------------------------------------------------------------------*/

/**    Packet wrapper used when receiving host messages. */
/*-------------------------------------------------------------------*/
public class ServerPacket extends Packet {
/*-------------------------------------------------------------------*/

    private boolean serverBaselineProcessing;
    private int offset;

    /**    Constructor. Detect data type and create appropriate Message object.
     *    @param data source message data
     *    @param off offset regarding input data byte array
     *    @param inServerBaselineProcessing determines if we're in the middle of server spawn baseline processing
     */
/*-------------------------------------------------------------------*/
    public ServerPacket(byte[] data, int off, boolean inServerBaselineProcessing) {
        offset = off;
        Message message = null;

        int messageType = getMessageType(data, inServerBaselineProcessing);

        if (messageType == 0) message = new ServerBad(data, offset + 1);
        else if (messageType == 9) message = new ServerPlayerMuzzleFlash(data, offset + 1);
        else if (messageType == 10) message = new ServerMonsterMuzzleFlash(data, offset + 1);
        else if (messageType == 11) message = new ServerTemporaryEntity(data, offset + 1);
        else if (messageType == 12) message = new ServerLayout(data, offset + 1);
        else if (messageType == 13) message = new ServerInventory(data, offset + 1);
        else if (messageType == 14) message = new ServerNop();
        else if (messageType == 15) message = new ServerDisconnect();
        else if (messageType == 16) message = new ServerReconnect();
        else if (messageType == 17) message = new ServerSound(data, offset + 1);
        else if (messageType == 18) message = new ServerPrint(data, offset + 1);
        else if (messageType == 19) message = new ServerStuffText(data, offset + 1); //originally messageType == 11
        else if (messageType == 20) message = new ServerData(data, offset + 1); //originally messageType == 12
        else if (messageType == 21) message = new ServerConfigString(data, offset + 1); // 13
        else if (messageType == 22) message = new ServerSpawnBaseline(data, offset + 1); // 14
        else if (messageType == 23) message = new ServerCenterPrint(data, offset + 1); //15
        else if (messageType == 24) message = new ServerDownload(data, offset + 1); //16
        else if (messageType == 25) message = new ServerPlayerInfo(data, offset + 1); //17
        else if (messageType == 26) message = new ServerPacketEntities(data, offset + 1); //18
        else if (messageType == 27) message = new ServerDeltaPacketEntities(data, offset + 1); //19
        else if (messageType == 28) message = new ServerFrame(data, offset + 1); //20
        else if (messageType > 28) {
            messageType = 0;
            message = new ServerBad(data, offset + 1);
        }

        setMessage(message);
        setLength(1 + message.getLength() + offset - off);
    }

    public boolean isInServerBaselineProcessing() {
        return serverBaselineProcessing;
    }

    private int getMessageType(byte[] data, boolean inServerBaselineProcessing) {
        int messageType = 0;

        if (inServerBaselineProcessing) {
            messageType = findMessageTypeAndUpdateOffset(data);
            serverBaselineProcessing = true;
        } else {
            messageType = (int) data[offset];
            if (messageType == 22) {
                serverBaselineProcessing = true;
            }
        }

        return messageType;
    }

    private int findMessageTypeAndUpdateOffset(byte[] data) {
        final int serverStuffTextIndex = ArrayUtils.indexOf(data, (byte) 19, offset);
        final int serverBaselineIndex = ArrayUtils.indexOf(data, (byte) 22, offset);

        if (serverBaselineIndex != -1) {
            offset = serverBaselineIndex;
            return 22;
        } else if (serverStuffTextIndex != -1 && (serverBaselineIndex == -1 || serverStuffTextIndex < serverBaselineIndex)) {
            offset = serverStuffTextIndex;
            return 19;
        } else {
            return 0;
        }
    }
}

