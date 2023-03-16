package entelect.training.incubator.clientConfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

@Configuration
public class RewardsClientConfig {
    @Bean
    public Jaxb2Marshaller marshaller() {
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        marshaller.setContextPath("entelect.training.incubator.client.gen");
        return marshaller;
    }

    @Bean
    public RewardsClient rewardsClient(Jaxb2Marshaller marshaller) {
        RewardsClient client = new RewardsClient();
        client.setDefaultUri("http://localhost:8208/ws");
        client.setMarshaller(marshaller);
        client.setUnmarshaller(marshaller);
        return client;
    }
}
