package soc.qase.com;

import junit.framework.TestCase;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import soc.qase.info.User;

/**
 * Created by Vojtech.Smital on 18.2.2016.
 */
@RunWith(MockitoJUnitRunner.class)
public class ProxyTest extends TestCase {

    @Mock
    private CommunicationHandler communicationHandler;

    @InjectMocks
    private Proxy proxy;

    @Ignore
    @Test
    public void testProcessIncomingDataPacket_challangeProcessing() {
        proxy.setUser(createUser());
        //proxy.sentChallenge = true;

        final String hexString = "ffffffff6368616c6c656e67652031323437333032323031";
        proxy.processIncomingDataPacket(hexStringToByteArray(hexString));
    }

    @Ignore
    @Test
    public void testProcessIncomingDataPacket_clientConnectProcessing() {
        proxy.setUser(createUser());
        //proxy.sentConnect = true;

        final String hexString = "ffffffff636c69656e745f636f6e6e656374";
        proxy.processIncomingDataPacket(hexStringToByteArray(hexString));
    }

    @Ignore
    @Test
    public void testProcessIncomingDataPacket_cmdConfigString() {
        final String hexString = "010000800100008014200000002448000000000000636173746c650013636d6420636f6e666967737472696e677320313834363820300a00";
        proxy.processIncomingDataPacket(hexStringToByteArray(hexString));
    }

    private byte[] hexStringToByteArray(String s) {
        int len = s.length();
        byte[] data = new byte[len / 2];
        for (int i = 0; i < len; i += 2) {
            data[i / 2] = (byte) ((Character.digit(s.charAt(i), 16) << 4)
                    + Character.digit(s.charAt(i + 1), 16));
        }
        return data;
    }

    private User createUser() {
        User user = new User();
        user.setName("DASE_bot");
        user.setFov(90);

        return user;
    }
}
