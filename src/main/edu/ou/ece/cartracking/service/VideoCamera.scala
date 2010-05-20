package edu.ou.ece.cartracking.service

import actors.Actor
import org.apache.log4j.Logger
import java.util.{Calendar}

class VideoCamera(mediator: Mediator) extends Actor {
  private val logger: Logger = Logger.getLogger(getClass)
  private val calendar = Calendar.getInstance()

  def act() {

    while (true) {

      if (false) { //any new cars detected

        mediator ! CarIdentifiedMsg(this, calendar.getTime, 1l)
        logger debug ("Send CarIdentifiedMsg")

      }

    }
  }
}