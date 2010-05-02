package edu.ou.ece.cartracking.utils

import org.apache.commons.httpclient.methods.GetMethod
import org.apache.commons.httpclient.params.HttpMethodParams
import org.apache.commons.httpclient.{HttpStatus, DefaultHttpMethodRetryHandler, HttpClient}
import org.apache.log4j.Logger

object HttpClientUtils {
  private val logger: Logger = Logger.getLogger(getClass)

  def get(url: String): String = {
    val httpClient = new HttpClient
    val getMethod = new GetMethod(url)
    getMethod.getParams().setParameter(HttpMethodParams.RETRY_HANDLER,
      new DefaultHttpMethodRetryHandler(3, false));

    try {
      val status = httpClient.executeMethod(getMethod)
      if (status != HttpStatus.SC_OK)
        return null

      val response = getMethod.getResponseBody()
      return new String(response)
    } catch {
      case e: Exception => {
        logger.error("Fail to get the response from " + url, e)
      }
    }

    return null

  }

}