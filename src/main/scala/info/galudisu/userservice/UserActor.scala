package info.galudisu.userservice

import akka.actor.{ActorLogging, Props}
import akka.persistence.PersistentActor

import scala.concurrent.duration._

case class Command(name: String)
case class Event(name: String)

class UserActor extends PersistentActor with ActorLogging {

  override def persistenceId: String = self.path.parent.name + "-" + self.path.name

  // passivate the entity when no activity
  context.setReceiveTimeout(2.minutes)

  var state = 0

  def updateState(event: Event): Unit =
    state = state + 1

  val receiveCommand: Receive = {
    case cmd: Command =>
      persistAll(List(Event(cmd.name))) {
        log.info(s"UserActor updating state for: ${cmd.name}")
        updateState
        // Send output Event here
      }
  }

  val receiveRecover: Receive = {
    case evt: Event => updateState(evt)
  }

}

object UserActor {

  def props(): Props = Props(new UserActor)

}
