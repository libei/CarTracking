package edu.ou.ece.cartracking.repository

import edu.ou.ece.cartracking.utils.HibernateUtils
import org.hibernate.classic.Session
import org.hibernate.Transaction
import org.apache.log4j.Logger
import java.lang.Class

class HibernateRepository[T <: AnyRef] {
  private val logger: Logger = Logger.getLogger(getClass)

  //  def load(id: Long): T = {
  //    val session: Session = HibernateUtils.getSessionFactory.openSession()
  //    try {
  //      val vt: T = new T
  //      session.load(classOf[T], id).asInstanceOf[T]
  //    } finally {
  //      session.close
  //    }
  //  }

  def save(entity: T) {
    val session: Session = HibernateUtils.getSessionFactory.openSession()
    var transaction: Transaction = null

    try {
      transaction = session.beginTransaction
      session.saveOrUpdate(entity)
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