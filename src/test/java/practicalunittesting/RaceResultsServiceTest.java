package practicalunittesting;

import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;

/**
 * Created by sharath on 4/9/15.
 */
public class RaceResultsServiceTest {

    private RaceResultsService resultsService = new RaceResultsService();
    private Message message = mock(Message.class);
    private Subscriber subscriber1 = mock(Subscriber.class);
    private Subscriber subscriber2 = mock(Subscriber.class);

    @Test
    public void subscriberShouldReceiveMessage() {
        resultsService.register(subscriber1);
        resultsService.send(message);

        verify(subscriber1).receive(message);
    }

    // zero registered subscribers
    @Test
    public void notRegisteredSubscribersShouldNotReceiveMessage() {
        resultsService.send(message);

        verify(subscriber1, never()).receive(message);
        verify(subscriber2, never()).receive(message);
    }

    // few registered subscribers
    @Test
    public void onlyRegisteredSubscribesShouldGetMessage() {
        resultsService.register(subscriber1);
        resultsService.send(message);

        verify(subscriber1).receive(message);
        verify(subscriber2, never()).receive(message);
    }

    // all registered subscribers
    @Test
    public void allRegisteredSubscribersShouldReceiveMessage() {
        resultsService.register(subscriber1);
        resultsService.register(subscriber2);
        resultsService.send(message);

        verify(subscriber1).receive(message);
        verify(subscriber2).receive(message);
    }

    @Test
    public void shouldSendOnlyOneMessageToMultiRegisteredSubscriber() {
        resultsService.register(subscriber1);
        resultsService.register(subscriber1);
        resultsService.send(message);

        verify(subscriber1).receive(message);
    }

    @Test
    public void deregisteredSubscriberShouldNeverReceiveMessage() {
        resultsService.register(subscriber1);
        resultsService.deregister(subscriber1);
        resultsService.send(message);

        verify(subscriber1, never()).receive(message);
    }
}