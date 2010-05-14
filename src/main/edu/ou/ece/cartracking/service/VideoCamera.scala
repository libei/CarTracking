package edu.ou.ece.cartracking.service

import actors.Actor
import java.util.Date
import org.apache.log4j.Logger

class VideoCamera(mediator: Mediator) extends Actor {
  private val logger: Logger = Logger.getLogger(getClass)

  def act() {

    while (true) {

      if (false) { //any new cars detected

        mediator ! CarIdentifiedMsg(this, null, 1l)
        logger debug ("Send CarIdentifiedMsg")

      }

    }
  }
}