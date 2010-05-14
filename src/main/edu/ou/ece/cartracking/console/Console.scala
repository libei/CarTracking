package edu.ou.ece.cartracking.console

import edu.ou.ece.cartracking.service.{BluetoothSensor, Mediator, VideoCamera}

object Console extends Application {
  val bluetoothSensor = new BluetoothSensor("url")
  val mediator = new Mediator(bluetoothSensor)
  val camera = new VideoCamera(mediator)


  mediator.start
  camera.start

  System.out.println("Press Any Key to Continue...")
  System.in.read

}