package edu.ou.ece.cartracking.repository

import edu.ou.ece.cartracking.utils.HibernateUtils
import org.apache.log4j.Logger
import edu.ou.ece.cartracking.domain.CarRecord
import org.hibernate.classic.Session
import org.hibernate.Transaction

object CarRecordRepository {
  private val logger: Logger = Logger.getLogger(getClass)

  def load(id: Long): CarRecord = {
    val session: Session = HibernateUtils.getSessionFactory.openSession()
    try {
      session.load(classOf[CarRecord], id).asInstanceOf[CarRecord]
    } finally {
      //      session.close
    }
  }

  def save(carRecord: CarRecord) {
    val session: Session = HibernateUtils.getSessionFactory.openSession()
    var transaction: Transaction = null

    try {
      transaction = session.beginTransaction
      session.saveOrUpdate(carRecord)
      transaction.commit
    }
    catch {
      case ex: Throwable => {
        logger.error(ex.getMessage, ex)
        transaction.rollback
        throw ex
      }
    }
    finally {
      session.close
    }
  }
}