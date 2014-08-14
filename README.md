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

