package soc.qase.file.dm2;

import junit.framework.TestCase;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;
import soc.qase.state.World;

/**
 * Created by Vojtech.Smital on 16.2.2016.
 */
@RunWith(MockitoJUnitRunner.class)
public class DM2ParserTest extends TestCase {

    @Ignore
    @Test
    public void testGetNextWorld() {
        final DM2Parser parser = new DM2Parser("c:\\Users\\smital\\DAI_TOOLS\\test2.dem");
        World world = null;

        world = parser.getNextWorld();
    }
}
