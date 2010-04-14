package edu.ou.ece.cartracking.utils

import org.hibernate.SessionFactory
import org.hibernate.cfg.Configuration
import org.apache.log4j.Logger


object HibernateUtils {
  private val sessionFactory = buildSessionFactory()
  private val logger: Logger = Logger.getLogger(getClass)

  private def buildSessionFactory(): SessionFactory = {

    try {
      // Create the SessionFactory from hibernate.cfg.xml
      return new Configuration().configure().buildSessionFactory();
    }
    catch {

      case ex: Throwable => {
        System.err.println("Initial SessionFactory creation failed." + ex);
        throw ex;

      }
    }
  }

  def getSessionFactory() = sessionFactory;

}