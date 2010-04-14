package edu.ou.ece.cartracking.repository

import edu.ou.ece.cartracking.utils.HibernateUtils
import org.apache.log4j.Logger
import edu.ou.ece.cartracking.domain.CarRecord

object CarRecordRepository {
  private val logger: Logger = Logger.getLogger(getClass)

  def save(carRecord: CarRecord): CarRecord = {
    try {
      HibernateUtils.getSessionFactory.openSession().saveOrUpdate(carRecord)
    }
    catch {
      case ex: Throwable => {
        logger.error(ex.getMessage, ex)
        return null
      }
    }
    carRecord
  }
}