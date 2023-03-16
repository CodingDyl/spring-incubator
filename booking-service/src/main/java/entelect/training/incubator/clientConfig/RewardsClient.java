package entelect.training.incubator.clientConfig;

import entelect.training.incubator.client.gen.CaptureRewardsResponse;
import entelect.training.incubator.client.gen.RewardsBalanceRequest;
import entelect.training.incubator.client.gen.RewardsBalanceResponse;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;

import java.math.BigDecimal;

public class RewardsClient extends WebServiceGatewaySupport {

    public RewardsBalanceResponse getBalance(String passportNumber) {
        RewardsBalanceRequest request = new RewardsBalanceRequest();
        request.setPassportNumber(passportNumber);

        RewardsBalanceResponse response = (RewardsBalanceResponse) getWebServiceTemplate()
                .marshalSendAndReceive(request);
        return response;
    }
}
