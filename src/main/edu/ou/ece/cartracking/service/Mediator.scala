package edu.ou.ece.cartracking.service

import actors.Actor
import org.apache.log4j.Logger
import edu.ou.ece.cartracking.repository.CarRecordRepository
import edu.ou.ece.cartracking.domain.{CarRecord}

class Mediator(bluetoothSensor: BluetoothSensor) extends Actor {
  private val logger: Logger = Logger.getLogger(getClass)

  def act() {

    while (true) {
      receive {

        case c: CarIdentifiedMsg => {
          logger debug ("CarIdentifiedMsg received.")

          val carRecord: CarRecord = new CarRecord
          val records = bluetoothSensor.getRecords(null, null)
          carRecord.addBluetoothRecords(records)
          CarRecordRepository.save(carRecord)

        }

      }

    }
  }
}