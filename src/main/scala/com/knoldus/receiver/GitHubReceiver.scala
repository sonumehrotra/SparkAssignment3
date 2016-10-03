package com.knoldus.receiver

import net.liftweb.json.DefaultFormats
import org.apache.spark.storage.StorageLevel
import org.apache.spark.streaming.receiver.Receiver
import scalaj.http.Http

case class Name(name: String)

class GitHubReceiver (token: String) extends Receiver[String](StorageLevel.MEMORY_ONLY) with Runnable with JsonHelper {

  override def onStart(): Unit = {
   val thread = new Thread(this)
    thread.start()
  }

  override def onStop(): Unit = {
  }

  override def run(): Unit = {
    receive()
  }

  private def receive(): Unit = {

    implicit val formats = DefaultFormats
    val response = Http(s"https://api.github.com/user/repos?access_token=$token").asString.body
    val result = (parse(response)).extract[List[Name]]
    while (!isStopped()) {
      for(name <- result) {
        store(name.name)
      }
    }
  }

}
