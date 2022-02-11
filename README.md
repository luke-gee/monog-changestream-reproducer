reproduce

1. Build using
``
mvn clean verify -Pnative -DskipTests -Dquarkus.container-image.build=true
``

2. under docker-compose run:

``docker-compose up mongodb --build``

``docker-compose up mongoDbDataSetup``

3. run created image from first step from compose

4. insert doc to mongo test-collection collection (via compass or similar)

5. update that document  (via compass or similar)
