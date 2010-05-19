package edu.ou.ece.cartracking.service

import actors.Actor
import org.apache.log4j.Logger
import edu.ou.ece.cartracking.repository.CarRecordRepository
import edu.ou.ece.cartracking.domain.{LicensePlateRecord, CarRecord}

class Mediator(bluetoothSensor: BluetoothSensor, licensePlateDetector: LicensePlateDetector) extends Actor {
  private val logger: Logger = Logger.getLogger(getClass)

  def act() {

    while (true) {
      receive {

        case c: CarIdentifiedMsg => {
          logger debug ("CarIdentifiedMsg received.")

          //c.time

          val carRecord = new CarRecord

          val bluetoothRecords = bluetoothSensor.getRecords(null, null)
          carRecord.addBluetoothRecords(bluetoothRecords)

          val licensePlateRecords = licensePlateDetector.get(null, null)
          carRecord.addLicensePlateRecords(licensePlateRecords)

          CarRecordRepository.save(carRecord)
        }

      }

    }
  }
}