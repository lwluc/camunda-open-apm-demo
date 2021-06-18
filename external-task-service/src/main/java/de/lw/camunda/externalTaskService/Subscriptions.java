package de.lw.camunda.externalTaskService;

import org.camunda.bpm.client.spring.SpringTopicSubscription;
import org.camunda.bpm.client.spring.event.SubscriptionInitializedEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class Subscriptions implements ApplicationListener<SubscriptionInitializedEvent> {

  protected static final Logger LOG = LoggerFactory.getLogger(Subscriptions.class);

  @Autowired
  public SpringTopicSubscription exampleTopic;

  @Override
  public void onApplicationEvent(SubscriptionInitializedEvent event) {
    SpringTopicSubscription springTopicSubscription = event.getSource();
    String topicName = springTopicSubscription.getTopicName();
    LOG.info("Subscription with topic name '{}' initialized", topicName);

    if (!springTopicSubscription.isOpen()) {
      LOG.info("Subscription with topic name '{}' not yet opened", topicName);

      springTopicSubscription.open();

      LOG.info("Subscription with topic name '{}' opened", topicName);

      springTopicSubscription.close();

      LOG.info("Subscription with topic name '{}' temporarily closed", topicName);

      springTopicSubscription.open();

      LOG.info("Subscription with topic name '{}' reopened again", topicName);
    }
  }
}
