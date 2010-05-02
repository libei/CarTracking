package edu.ou.ece.cartracking.repository

import org.apache.log4j.Logger
import org.hibernate.classic.Session
import edu.ou.ece.cartracking.utils.HibernateUtils
import edu.ou.ece.cartracking.domain.{BluetoothRecord}

object BluetoothRecordRepository extends HibernateRepository[BluetoothRecord] {
  private val logger: Logger = Logger.getLogger(getClass)

  def load(id: Long): BluetoothRecord = {
    val session: Session = HibernateUtils.getSessionFactory.openSession()
    try {
      session.load(classOf[BluetoothRecord], id).asInstanceOf[BluetoothRecord]
    } finally {
      //      session.close
      //will throw exception if the session is close and the object is accessed.
    }
  }

}