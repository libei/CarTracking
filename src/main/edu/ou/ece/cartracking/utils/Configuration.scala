package edu.ou.ece.cartracking.utils

import java.util.Properties
import java.io.FileInputStream
import java.lang.String

object Configuration {
  private val configFilePath: String = getClass.getClassLoader.getResource("config.properties").getPath
  private val props = new Properties()
  props.load(new FileInputStream(configFilePath))

  def bluetoothUrl: String = return props.getProperty("bluetoothsensor.url")

  def licenseplateUrl: String = return props.getProperty("licenseplate.url")

}