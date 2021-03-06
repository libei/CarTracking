package edu.ou.ece.cartracking.repository

import edu.ou.ece.cartracking.domain.CarRecord
import org.apache.log4j.Logger
import org.hibernate.classic.Session
import edu.ou.ece.cartracking.utils.HibernateUtils

object CarRecordRepository extends HibernateRepository[CarRecord] {
  private val logger: Logger = Logger.getLogger(getClass)

  def load(id: Long): CarRecord = {
    val session: Session = HibernateUtils.getSessionFactory.openSession()
    try {
      session.load(classOf[CarRecord], id).asInstanceOf[CarRecord]
    } finally {
      //      session.close
      //will throw exception if the session is close and the object is accessed.
    }
  }

}