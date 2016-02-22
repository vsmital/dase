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

    @Ignore
    @Test
    public void testProcessIncomingDataPacket_serverConfig() {
        final String hexString = "0200008002000000150000636173746c650015020065326d310015040065326d310015060065326d3174696c6500151f002d383634373439373837001521006d6170732f636173746c652e627370001522002a31001523002a32001524002a33001525002a34001526002a35001527002a36001528002a37001529002a3800152a002a3900152b002a313000152c002a313100152d002a313200152e002a313300152f002a3134001530002a3135001531002a3136001532002a3137001533002a3138001534002a3139001535002a3230001536002a3231001537002a3232001538002a3233001539002a323400153a002a323500153b002a323600153c002a323700153d006d6f64656c732f65312f775f74676c6f76652e646b6d00153e006d6f64656c732f65312f615f74617a65722e646b6d00153f006d6f64656c732f65312f77615f676c6f636b2e646b6d001540006d6f64656c732f65312f77655f696f6e6578706c2e737032001541006d6f64656c732f65312f775f696f6e626c61737465722e646b6d001542006d6f64656c732f65312f615f696f6e2e646b6d001543006d6f64656c732f65312f77615f696f6e2e646b6d001544006d6f64656c732f65312f77655f696f6e626c2e646b6d001545006d6f64656c732f65312f77655f696f6e6469732e737032001546006d6f64656c732f65312f77655f6d66696f6e2e737032001547006d6f64656c732f65312f77655f696f6e62662e737032001548006d6f64656c732f65312f775f63342e646b6d001549006d6f64656c732f65312f615f63342e646b6d00154a006d6f64656c732f65312f77615f63342e646b6d00154b006d6f64656c732f65312f77655f633470726a2e646b6d00154c006d6f64656c732f65312f775f73686f746379636c65722e646b6d00154d006d6f64656c732f65312f615f73686f742e646b6d00154e006d6f64656c732f65312f77615f73686f74362e646b6d00154f006d6f64656c732f65312f77655f73686f7463792e737032001550006d6f64656c732f65312f77655f73686f747368656c6c2e646b6d001551006d6f64656c732f65312f775f7369646577696e6465722e646b6d001552006d6f64656c732f65312f615f7377696e64722e646b6d001553006d6f64656c732f65312f77615f7377696e64722e646b6d001554006d6f64656c732f65312f77655f7377726f636b65742e646b6d001555006d6f64656c732f676c6f62616c2f77655f666c617265616d6265722e737032001556006d6f64656c732f65312f77655f6d667377696e6465722e737032001557006d6f64656c732f65312f775f73686f636b776176652e646b6d001558006d6f64656c732f65312f615f73686f6b77762e646b6d001559006d6f64656c732f65312f77615f73686f6b77762e646b6d00155a006d6f64656c732f65312f77655f336473686f636b2e646b6d00155b006d6f64656c732f65312f77655f73686f636b72696e672e73703200155c006d6f64656c732f65312f77655f73686f636b6578702e73703200155d006d6f64656c732f676c6f62616c2f77655f73686f7472696e672e73703200155e006d6f64656c732f65312f77655f6d6673776176652e73703200155f006d6f64656c732f65312f77655f73686f636b77616c6c2e737032001560006d6f64656c732f65312f775f67617368616e642e646b6d001561006d6f64656c732f65312f615f67617368616e642e646b6d001562006d6f64656c732f65312f77615f67617368616e642e646b6d001563006d6f64656c732f65312f77655f67617368616e642e646b6d001564006d6f64656c732f676c6f62616c2f775f6461696b6174616e612e646b6d001565006d6f64656c732f676c6f62616c2f615f6461696b6174616e612e646b6d001566006d6f64656c732f65342f77615f676c6f636b2e646b6d0013636d6420636f6e666967737472696e6773203138343638203130330a00";
        proxy.processIncomingDataPacket(hexStringToByteArray(hexString));
    }

    @Ignore
    @Test
    public void testProcessIncomingDataPacket_serverConfig2() {
        final String hexString = "03000080030000801567006d6f64656c732f676c6f62616c2f77655f646b6c6576656c2e646b6d001568006d6f64656c732f676c6f62616c2f77735f6461696b6174616e612e646b6d001569006d6f64656c732f676c6f62616c2f655f676962746f72736f2e646b6d00156a006d6f64656c732f676c6f62616c2f655f6769626c65672e646b6d00156b006d6f64656c732f676c6f62616c2f655f676962666f6f742e646b6d00156c006d6f64656c732f676c6f62616c2f655f67696268616e642e646b6d00156d006d6f64656c732f676c6f62616c2f655f676962686561642e646b6d00156e006d6f64656c732f676c6f62616c2f655f67696263686573742e646b6d00156f006d6f64656c732f676c6f62616c2f655f6769626579652e646b6d001570006d6f64656c732f676c6f62616c2f655f67696261726d2e646b6d001571006d6f64656c732f676c6f62616c2f655f6769626d6973632e646b6d001572006d6f64656c732f676c6f62616c2f655f776f6f64312e646b6d001573006d6f64656c732f676c6f62616c2f655f776f6f64322e646b6d001574006d6f64656c732f676c6f62616c2f655f676c617373312e646b6d001575006d6f64656c732f676c6f62616c2f655f676c617373322e646b6d001576006d6f64656c732f676c6f62616c2f655f6d6574616c312e646b6d001577006d6f64656c732f676c6f62616c2f655f6d6574616c322e646b6d001578006d6f64656c732f676c6f62616c2f655f676962726f626f74312e646b6d001579006d6f64656c732f676c6f62616c2f655f676962726f626f74322e646b6d00157a006d6f64656c732f676c6f62616c2f655f676962726f626f74332e646b6d00157b006d6f64656c732f676c6f62616c2f655f676962726f626f74342e646b6d00157c006d6f64656c732f676c6f62616c2f655f726f636b312e646b6d00157d006d6f64656c732f676c6f62616c2f655f726f636b322e646b6d00157e006d6f64656c732f676c6f62616c2f655f726f636b332e646b6d00157f006d6f64656c732f676c6f62616c2f615f707772622e646b6d001580006d6f64656c732f676c6f62616c2f615f707772632e646b6d001581006d6f64656c732f676c6f62616c2f615f61746b622e646b6d001582006d6f64656c732f676c6f62616c2f615f61746b632e646b6d001583006d6f64656c732f676c6f62616c2f615f737064622e646b6d001584006d6f64656c732f676c6f62616c2f615f737064632e646b6d001585006d6f64656c732f676c6f62616c2f615f616372622e646b6d001586006d6f64656c732f676c6f62616c2f615f616372632e646b6d001587006d6f64656c732f676c6f62616c2f615f76746c622e646b6d001588006d6f64656c732f676c6f62616c2f615f76746c632e646b6d001589006d6f64656c732f65332f64335f73746f6f6c2e646b6d00158a006d6f64656c732f65332f64335f616c7465722e646b6d00158b006d6f64656c732f65332f64335f6b6567732e646b6d00158c006d6f64656c732f65332f64335f666c6167312e646b6d00158d006d6f64656c732f65332f64335f7461626c652e646b6d00158e006d6f64656c732f65332f64335f647261676f6e7374617475652e646b6d00158f006d6f64656c732f65312f645f646b6c6f676f2e646b6d001590006d6f64656c732f65312f61315f686c74682e646b6d001591006d6f64656c732f65322f64325f736e616b65666972652e646b6d001592006d6f64656c732f65312f61315f6172322e646b6d001593006d6f64656c732f676c6f62616c2f615f67736f756c2e646b6d001594006d6f64656c732f65312f61315f6172312e646b6d001595006d6f64656c732f676c6f62616c2f65325f66697265612e737032001596006d6f64656c732f676c6f62616c2f6d5f6869726f2e646b6d0015210265312f77655f64676c6f766572656164792e7761760013636d6420636f6e666967737472696e6773203138343638203534360a00";
        proxy.processIncomingDataPacket(hexStringToByteArray(hexString));
    }

    @Ignore
    @Test
    public void testProcessIncomingDataPacket_serverConfig3() {
        final String hexString = "040000800400000015220265312f77655f64676c6f7665617761792e7761760015230265312f77655f64676c6f766573686f6f74612e7761760015240265312f77655f64676c6f7665616d62612e7761760015250265312f77655f64676c6f7665616d62622e7761760015260265312f77655f64676c6f7665686974612e7761760015270265312f77655f64676c6f7665686974632e7761760015280265312f77655f696f6e616d62612e7761760015290265312f77655f696f6e72656164792e77617600152a0265312f77655f696f6e617761792e77617600152b0265312f77655f696f6e73686f6f74622e77617600152c0265312f77655f696f6e6578706c6f6465612e77617600152d0265312f77655f696f6e6578706c6f6465622e77617600152e0265312f77655f696f6e6578706c6f6465632e77617600152f0265312f77655f696f6e666c7962792e7761760015300265312f77655f696f6e6869742e77617600153102676c6f62616c2f655f656c656374726f6e7370726b612e77617600153202676c6f62616c2f655f656c656374726f6e7370726b652e77617600153302676c6f62616c2f655f656c656374726f6e7370726b672e77617600153402676c6f62616c2f655f656c656374726f6e7370726b682e7761760015350265312f77655f633472656164792e7761760015360265312f77655f6334617761792e7761760015370265312f77655f633473686f6f74612e7761760015380265312f77655f6334616d62622e776176001539026e756c6c2e77617600153a0265312f77655f633462656570612e77617600153b0265312f77655f633462656570622e77617600153c0265312f77655f6334636f6e612e77617600153d0265312f77655f63346d6574616c612e77617600153e0265312f77655f6334776f6f64612e77617600153f0265312f77655f633473746f6e65612e7761760015400265312f77655f6334676c617373612e7761760015410265312f77655f6334696365612e7761760015420265312f77655f63346a616d2e7761760015430265312f77655f73686f746379636c657272656164792e7761760015440265312f77655f73686f746379636c6572617761792e7761760015450265312f77655f73686f746379636c657273686f6f74612e7761760015460265312f77655f73686f746379636c6572616d62612e7761760015470265312f77655f73686f746379636c657273686f6f74622e7761760015480265312f77655f73686f746379636c65727368656c6c612e7761760015490265312f77655f73686f746379636c65727368656c6c622e77617600154a0265312f77655f73686f746379636c65727368656c6c632e77617600154b0265312f77655f73686f746379636c65727368656c6c642e77617600154c0265312f77655f73686f746379636c65727368656c6c652e77617600154d0265312f77655f73686f746379636c65727368656c6c662e77617600154e0265312f77655f7369646577696e64657272656164792e77617600154f0265312f77655f7369646577696e646572617761792e7761760015500265312f77655f7369646577696e64657273686f6f74612e7761760015510265312f77655f7369646577696e646572616d62612e7761760015520265312f77655f7369646577696e6465726578702e7761760015530265312f77655f7369646577696e646572666c792e77617600155402676c6f62616c2f655f75776578706c6f6465612e77617600155502676c6f62616c2f655f75776578706c6f6465622e77617600155602676c6f62616c2f655f75776578706c6f6465632e77617600155702676c6f62616c2f655f75776578706c6f6465642e7761760015580265312f77655f73696465756e666972652e7761760015590265312f77655f73686f636b77617665616d62612e7761760013636d6420636f6e666967737472696e6773203138343638203630320a00";
        proxy.processIncomingDataPacket(hexStringToByteArray(hexString));
    }

    @Test
    public void testProcessIncomingDataPacket_serverSpawnBaseline() {
        final String hexString = "0b0000800b00008016838a84511133000002c03240cf4000c03240cf40000000803f0000803f0000803f0000803f16838a8451122e00000200e18012400000e1801240000000803f0000803f0000803f0000803f16838a8451132a0000028032c01240008032c01240000000803f0000803f0000803f0000803f16838a8451142300000200e100cf400000e100cf40000000803f0000803f0000803f0000803f16838a827915690080e6800f400180e6800f400102000000803f0000803f0000803f0707200707010000803f05200002000116838a8279166a00a0e500084001a0e50008400102000000803f0000803f0000803f151f20141e010000803f05200002000116838a8279176b00a0e5e0016002a0e5e001600202000000803f0000803f0000803f0f0f200b0f040000803f05200002000116838a8279186c00c0e400084006c0e40008400602000000803f0000803f0000803f11031f34032a0000803f25200041003b0116838a8279196d00a0e5200e4001a0e5200e400102000000803f0000803f0000803f1a28201a28020000803f05200002000116838280d5808080011a00ec0008800f00ec0008800f8401993e1c000000803f0000803f0000803f0000803f16809884d0091b020004000000040000803f0000803f0000803f0000803f00c02f44004058c400001041002080440000bec20080944316809884d0091c030004000000040000803f0000803f0000803f0000803f004060c4004070c4000010410080bfc30000803f0080944316809884d0091d040004000000040000803f0000803f0000803f0000803f0080c0c30020b8c4000010410020804400c057c40080944316809884d0091e050004000000040000803f0000803f0000803f0000803f004060c40080ff43000010410020c04400402c440010044516809884d0091f060004000000040000803f0000803f0000803f0000803f002086c40020cec40000104100c05fc400402c440010044516809884d00920070004000000040000803f0000803f0000803f0000803f0080c0c300005f430080a043002080440080b0430010044516809884d00921080004000000040000803f0000803f0000803f0000803f004050c40000f8410080a0430080cfc30080f0430010044516809884d00922090004000000040000803f0000803f0000803f0000803f004030c4004070c40080a04300c00fc40000803f0010044516878a8279236e0000f500ff400100809d4300f500ff400102000000803f0000803f0000803f3117181731aa0000803f05200002000116878a8279246f00c0f4c00a000300008743c0f4c00a000302000000803f0000803f0000803f08081408081a0000803f25200041001d011687da80d18080202661000120002200d4c00000001042002200d4c0000000803f0000803f0000803f3333333fc01687ca84d19080202762000180210002002200d4c00000001042002200d4c0000000803f0000803f0000803f0000803fff1687da80d1808020285f0001200022c00dc000000010420022c00dc0000000803f0000803f0000803f3333333fc01687ca84d190802029600001800900020022c00dc000000010420022c00dc0000000803f0000803f0000803f0000803fff16838a84512a2a000002002c00084000002c000840000000803f0000803f0000803f0000803f16838a84512b70000002002c00040001002c000400010000803f0000803f0000803f0000803f16838a84512c33000002002c00da4000002c00da40000000803f0000803f0000803f0000803f16838a84512d70000002002c00d60001002c00d600010000803f0000803f0000803f0000803f1687da80d18080202e6300012000f200d4c0000000104200f200d4c0000000803f0000803f0000803f3333333fc01687ca84d19080202f6400018011000200f200d4c0000000104200f200d4c0000000803f0000803f0000803f0000803fff13636d6420626173656c696e65732031383436382034380a00";
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
