package edu.ou.ece.cartracking.console

import edu.ou.ece.cartracking.service.{LicensePlateDetector, BluetoothSensor, Mediator, VideoCamera}
import edu.ou.ece.cartracking.utils.Configuration

object Console extends Application {
  val licensePlateDetector = new LicensePlateDetector(Configuration.licenseplateUrl)
  val bluetoothSensor = new BluetoothSensor(Configuration.bluetoothUrl)
  val mediator = new Mediator(bluetoothSensor)
  val camera = new VideoCamera(mediator)


  mediator.start
  camera.start

  System.out.println("Press Any Key to Continue...")
  System.in.read

}