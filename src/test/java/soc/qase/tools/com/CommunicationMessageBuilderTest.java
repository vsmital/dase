package soc.qase.tools.com;

import junit.framework.TestCase;
import org.junit.Test;
import org.junit.internal.runners.JUnit38ClassRunner;
import org.junit.runner.RunWith;
import soc.qase.info.User;

/**
 * Created by Vojtech.Smital on 16.2.2016.
 */
@RunWith(JUnit38ClassRunner.class)
public class CommunicationMessageBuilderTest extends TestCase {

    @Test
    public void testBuildConnectMessage() {
        final String expectedResult
                = "connect 32 105 1247302201 \"\\version\\Daikatana v1.3 for x86. Built Dec 30 2014 at 02:52:40\\chat\\3\\dm_taunts\\1\\ctf_team\\0\\chatmsg\\1\\cl_cinematics\\1\\fov\\90\\msg\\1\\cl_autowweaponswitch\\1\\dt_team\\0\\rate\\30000\\team\\4\\name\\VojtBot\\modelname\\models/global/m_hiro.dkm\\skinname\\skins/hiro_bod_1.wal\\skincolor\\0\\character\\0\"";

        final int clientID = 105;
        final String challengeNumber = "1247302201";


        final String result = CommunicationMessageBuilder.buildConnectMessage(clientID, challengeNumber, new User("VojtBot"));
        assertEquals(expectedResult, result);
    }
}
