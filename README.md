play-eventsourced
=================

This is planned to be a [cqrs](http://martinfowler.com/bliki/CQRS.html)/[event-sourced](http://martinfowler.com/eaaDev/EventSourcing.html) example, which is inspired by:

1. Primarily by [Erik Rozendaal's simple example with a blog in Play](http://blog.zilverline.com/2012/07/04/simple-event-sourcing-introduction-part-1/)
2. [his example with an invoice](https://github.com/erikrozendaal/scala-event-sourcing-example)
3. [Martin Krassner's example](https://github.com/eligosource/eventsourced-example) 
4. [Pawel Kaczor's example using Akka](http://pkaczor.blogspot.com/2014/04/reactive-ddd-with-akka.html)
5. a [real-world example](http://www.parleys.com/play/53a7d2cce4b0543940d9e55c)
6. the [cqrs journey taken by folks at MSDN](http://msdn.microsoft.com/en-us/library/jj554200.aspx)


Technologies Used
-----------------

Technologies used in this repo are:

1. Java JDK 1.7.0_51
2. [Scala](http://www.scala-lang.org/) 2.10.4
3. [SBT](http://www.scala-sbt.org/index.html) 0.12.2
4. [Akka](http://akka.io/) [2.3.4](http://doc.akka.io/docs/akka/2.3.4/scala.html) ... especially [Akka Persistence](http://doc.akka.io/docs/akka/2.3.4/scala/persistence.html) which replaces the [event sourced library](https://github.com/eligosource/eventsourced).
5. [Play](http://www.playframework.com/) 2.1.5
6. [Redis](http://redis.io/) 2.8.13 is what I know works on my machine


Roadmap Plans
-------------
1. First, code review of Erik's original app
2. Make the controller specs pass in either Specs 2 (or ScalaTest)
3. Examine feasibility of switching to Akka Persistence.
4. Consider another data store for the event store besides Redis. By default, Akka Persistence uses [Level DB](https://code.google.com/p/leveldb/) as its event store. See [here](http://kkovacs.eu/cassandra-vs-mongodb-vs-couchdb-vs-redis) a succinct comparasion of various NoSQL stores.
I think I'd like to use [Apache Cassandra](http://cassandra.apache.org/) using Martin's [cassandra plugin](https://github.com/krasserm/akka-persistence-cassandra/).
5. On the client side, the pages can be rendered using a single-page application using [AngularJS](https://angularjs.org/), along the lines of [this organization](http://cliffmeyers.com/blog/2013/4/21/code-organization-angularjs-javascript)
6. It should be possible to create similar functionality using [Spray](http://spray.io/) or [Vert.x](http://vertx.io)


Running the application
=======================

1. To run the application install play-2.1.5 (or later) and run "play".
2. Or install sbt 0.12.2 (or later) and run "sbt".
3. To start the server with the Redis (http://redis.io) event store implementation you will need to have a Redis instance running. Redis 2.6 or higher is required. You can change the connection settings in conf/application.conf.
4. Now you can execute "play run" (or "sbt run") to start the server. First time the internet is downloaded, but after a while you should be able to browse to http://localhost:9000/
