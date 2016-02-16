package soc.qase.tools.com;

import soc.qase.com.message.ServerTemporaryEntity;
import soc.qase.info.User;

/**
 * Created by Vojtech.Smital on 16.2.2016.
 */
public class CommunicationMessageBuilder {

    private static final String KEY_VALUE_DELIMITER = "\\";
    private static final String KEY_VALUE_ENTRY_DELIMITER = "\\";

    private static final String CONNECT_MESSAGE_PREFIX = "connect ";
    private static final String DAIKATANA_VERSION_MESSAGE_SNIPPET = "version" + KEY_VALUE_DELIMITER + "Daikatana v1.3 for x86. Built Dec 30 2014 at 02:52:40";
    private static final String CHAT_MESSAGE_SNIPPET = "chat" + KEY_VALUE_DELIMITER + "3";
    private static final String DM_TAUNTS_MESSAGE_SNIPPET = "dm_taunts" + KEY_VALUE_DELIMITER + "1";
    private static final String CTF_TEAM_MESSAGE_SNIPPET = "ctf_team" + KEY_VALUE_DELIMITER + "0";
    private static final String CHATMSG_MESSAGE_SNIPPET = "chatmsg" + KEY_VALUE_DELIMITER + "1";
    private static final String CL_CINEMATICS_MESSAGE_SNIPPET = "cl_cinematics" + KEY_VALUE_DELIMITER + "1";
    private static final String FOV_MESSAGE_SNIPPET = "fov" + KEY_VALUE_DELIMITER + "$FOV_VALUE";
    private static final String MSG_MESSAGE_SNIPPET = "msg" + KEY_VALUE_DELIMITER + "$MSG_VALUE";
    private static final String CL_AUTOWEAPONSWITCH_MESSAGE_SNIPPET = "cl_autowweaponswitch" + KEY_VALUE_DELIMITER + "1";
    private static final String DT_TEAM_MESSAGE_SNIPPET = "dt_team" + KEY_VALUE_DELIMITER + "0";
    private static final String RATE_MESSAGE_SNIPPET = "rate" + KEY_VALUE_DELIMITER + "$RATE_VALUE";
    private static final String TEAM_MESSAGE_SNIPPET = "team" + KEY_VALUE_DELIMITER + "4";
    private static final String NAME_MESSAGE_SNIPPET = "name" + KEY_VALUE_DELIMITER + "$NAME_VALUE";
    private static final String MODELNAME_MESSAGE_SNIPPET = "modelname" + KEY_VALUE_DELIMITER + "$MODELNAME_VALUE";
    private static final String SKINNAME_MESSAGE_SNIPPET = "skinname" + KEY_VALUE_DELIMITER + "$SKINNAME_VALUE";
    private static final String SKINCOLOR_MESSAGE_SNIPPET = "skincolor" + KEY_VALUE_DELIMITER + "0";
    private static final String CHARACTER_MESSAGE_SNIPPET = "character" + KEY_VALUE_DELIMITER + "0";


    private CommunicationMessageBuilder() {

    }

    public static String buildConnectMessage(final int clientID, final String challengeNumber, final User user) {
        //TODO Assertion that 2-nd parameter is not null.

        String result = CONNECT_MESSAGE_PREFIX + ServerTemporaryEntity.getServerVersion() + " " + clientID + " " + challengeNumber;
        result = result + " \"" + KEY_VALUE_ENTRY_DELIMITER + DAIKATANA_VERSION_MESSAGE_SNIPPET;
        result = result + KEY_VALUE_ENTRY_DELIMITER + CHAT_MESSAGE_SNIPPET;
        result = result + KEY_VALUE_ENTRY_DELIMITER + DM_TAUNTS_MESSAGE_SNIPPET;
        result = result + KEY_VALUE_ENTRY_DELIMITER + CTF_TEAM_MESSAGE_SNIPPET;
        result = result + KEY_VALUE_ENTRY_DELIMITER + CHATMSG_MESSAGE_SNIPPET;
        result = result + KEY_VALUE_ENTRY_DELIMITER + CL_CINEMATICS_MESSAGE_SNIPPET;
        result = result + KEY_VALUE_ENTRY_DELIMITER + FOV_MESSAGE_SNIPPET.replaceAll("\\$FOV_VALUE", String.valueOf(user.getFov()));
        result = result + KEY_VALUE_ENTRY_DELIMITER + MSG_MESSAGE_SNIPPET.replaceAll("\\$MSG_VALUE", String.valueOf(user.getMessage()));
        result = result + KEY_VALUE_ENTRY_DELIMITER + CL_AUTOWEAPONSWITCH_MESSAGE_SNIPPET;
        result = result + KEY_VALUE_ENTRY_DELIMITER + DT_TEAM_MESSAGE_SNIPPET;
        result = result + KEY_VALUE_ENTRY_DELIMITER + RATE_MESSAGE_SNIPPET.replaceAll("\\$RATE_VALUE", String.valueOf(user.getRate()));
        result = result + KEY_VALUE_ENTRY_DELIMITER + TEAM_MESSAGE_SNIPPET;
        result = result + KEY_VALUE_ENTRY_DELIMITER + NAME_MESSAGE_SNIPPET.replaceAll("\\$NAME_VALUE", user.getName());
        result = result + KEY_VALUE_ENTRY_DELIMITER + MODELNAME_MESSAGE_SNIPPET.replaceAll("\\$MODELNAME_VALUE", user.getModel());
        result = result + KEY_VALUE_ENTRY_DELIMITER + SKINNAME_MESSAGE_SNIPPET.replaceAll("\\$SKINNAME_VALUE", user.getSkin());
        result = result + KEY_VALUE_ENTRY_DELIMITER + SKINCOLOR_MESSAGE_SNIPPET;
        result = result + KEY_VALUE_ENTRY_DELIMITER + CHARACTER_MESSAGE_SNIPPET + "\"";

        return result;
    }
}
