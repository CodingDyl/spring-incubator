import entelect.training.incubator.client.gen.RewardsBalanceResponse;
import entelect.training.incubator.clientConfig.RewardsClient;
import entelect.training.incubator.clientConfig.RewardsClientConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = RewardsClientConfig.class, loader = AnnotationConfigContextLoader.class)
public class ClientLiveTest {

    @Autowired
    RewardsClient client;

    @Test
    public void givenBookingService_whenBooked_thenRewardsAreGiven() {
        RewardsBalanceResponse response = client.getBalance("7463736382837");
        assertEquals(1560.89, response.getBalance());
    }
}
