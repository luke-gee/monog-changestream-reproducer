package org.acme;

import io.quarkus.mongodb.reactive.ReactiveMongoClient;
import io.quarkus.runtime.StartupEvent;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;
import javax.enterprise.inject.Instance;
import javax.inject.Inject;

@ApplicationScoped
public class ChangeStream {

    @Inject
    Instance<ReactiveMongoClient> reactiveMongoClient;

    void onStartup(@Observes StartupEvent startupEvent)
    {
        reactiveMongoClient.get().getDatabase("test")
                .getCollection("test-collection")
                .watch()
                .subscribe()
                .with(System.out::println);
    }

}
