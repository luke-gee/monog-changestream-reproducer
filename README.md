reproduce

1. Build using
``
mvn clean verify -Pnative -DskipTests -Dquarkus.container-image.build=true
``

2. under docker-compose run:

``docker-compose up monogbd --build``

``docker-compose up mongoDbDataSetup``

3. run created image from first step from compose