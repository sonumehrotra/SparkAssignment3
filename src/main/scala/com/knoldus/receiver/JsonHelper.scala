package com.knoldus.receiver

import net.liftweb.json.{ DefaultFormats, JNothing, JValue, parse => liftParser }

trait JsonHelper {

  protected def parse(value: String): JValue = {
    implicit val formats = DefaultFormats
    liftParser(value)
  }

  implicit protected def extractOrEmptyString(json: JValue): String = {
    implicit val formats = DefaultFormats
    json match {
      case JNothing => ""
      case data => data.extract[String]
    }
  }
}
