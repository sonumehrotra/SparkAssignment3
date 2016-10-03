package com.knoldus.receiver

import org.apache.spark.SparkConf
import org.apache.spark.streaming.{Seconds, StreamingContext}


object GitHubReceiverApp {

  def main(args: Array[String]) {

    val conf = new SparkConf().setMaster("local[*]").setAppName("GitHubStreaming")
    val ssc = new StreamingContext(conf, Seconds(5))
    val stream = ssc.receiverStream(new GitHubReceiver("<token>")) //Replace <token> with a valid token
    stream.print()
    ssc.start()
    ssc.awaitTermination()
  }
}
