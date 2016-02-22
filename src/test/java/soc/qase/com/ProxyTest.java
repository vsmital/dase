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

    @Test
    public void testProcessIncomingDataPacket_cmdConfigString() {
        final String hexString = "010000800100008014200000002448000000000000636173746c650013636d6420636f6e666967737472696e677320313834363820300a00";
        proxy.processIncomingDataPacket(hexStringToByteArray(hexString));
    }

    @Ignore
    @Test
    public void testProcessIncomingDataPacket_precacheString() {
        final String hexString
                = "170000801700000016838b82793d016b00602ee0d36002602ee0d3600202000000803f0000803f0000803f0f0f200b0f040000803f05200002000116838b82793e016a00602e00da4001602e00da400102000000803f0000803f0000803f151f20141e010000803f05200002000116878b82793f016c00002840e1400600008743002840e1400602000000803f0000803f0000803f03341f03112a0000803f25200041003b0116878b827940016c000028c0d240060000b4420028c0d2400602000000803f0000803f0000803f03111f03342a0000803f25200041003b0116878b827941016c00402f00da400600003443402f00da400602000000803f0000803f0000803f34031f11032a0000803f25200041003b0116838b827942017100000900dd800e000900dd800e02000000803f0000803f0000803f19181019192d0000803f05200002000116839b885143017500002028080900dde010080900dde0100000803f0000803f0000803f0000803f16879b885144017500002028080900dde0100000b442080900dde0100000803f0000803f0000803f0000803f16838b827945017100000900d7800e000900d7800e02000000803f0000803f0000803f19181019192d0000803f05200002000116839b885146017500002028080900d7e010080900d7e0100000803f0000803f0000803f0000803f16879b885147017500002028080900d7e0100000b442080900d7e0100000803f0000803f0000803f0000803f16838b82794801710000090006800e00090006800e02000000803f0000803f0000803f19181019192d0000803f05200002000116839b88514901750000202808090006e01008090006e0100000803f0000803f0000803f0000803f16879b88514a01750000202808090006e0100000b44208090006e0100000803f0000803f0000803f0000803f16838b82794b0171000009000c800e0009000c800e02000000803f0000803f0000803f19181019192d0000803f05200002000116839b88514c0175000020280809000ce0100809000ce0100000803f0000803f0000803f0000803f16879b88514d0175000020280809000ce0100000b4420809000ce0100000803f0000803f0000803f0000803f137072656361636865203b20636d6420626567696e2031383436380a00";
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
