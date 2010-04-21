package ou.ece.cartracking.service

import edu.ou.ece.cartracking.domain.BluetoothRecord

class BluetoothSensor(uri: String) {

  //uri: http://127.0.0.1/bluetoothsensor/getrecords
  //
  // paras:  ?start=xx&end=xx

  def getRecords(): List[BluetoothRecord] = {
    null
  }

}