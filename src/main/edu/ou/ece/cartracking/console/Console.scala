package edu.ou.ece.cartracking.console

import edu.ou.ece.cartracking.service.VideoCamera

object Console extends Application {
  val camera = new VideoCamera
  camera.start

}