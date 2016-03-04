package soc.qase.file.dem;

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
public class DemParserTest extends TestCase {

    @Ignore
    @Test
    public void testGetNextWorld() {
        final DemParser parser = new DemParser("c:\\Users\\smital\\DAI_TOOLS\\test2.dem");
        World world = null;

        world = parser.getNextWorld();
    }
}
