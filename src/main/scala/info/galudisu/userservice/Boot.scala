package info.galudisu.userservice

import akka.actor.{ActorRef, ActorSystem}

object Boot extends App with Config {

  val system = ActorSystem(clusterName)

  val userRegion: ActorRef = UserShardingRegion.start(system, 10)

  val consumer = system.actorOf(KafkaConsumerActor.props(userRegion))

}
