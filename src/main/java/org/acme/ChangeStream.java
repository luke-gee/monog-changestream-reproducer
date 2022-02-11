package org.acme;

import com.mongodb.client.model.changestream.ChangeStreamDocument;
import io.quarkus.mongodb.reactive.ReactiveMongoClient;
import io.quarkus.runtime.StartupEvent;
import org.bson.Document;

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
                .log()
                .subscribe()
                .with(this::sink);
    }


    void sink(ChangeStreamDocument<Document> doc)
    {
        System.out.println("hello");
        System.out.println(doc);
        System.out.println(doc.getUpdateDescription());
    }

}
