package net.astail

import org.slf4j.{Logger, LoggerFactory}

object Main {
  val logger: Logger = LoggerFactory.getLogger(this.getClass)

  def main(args: Array[String]): Unit = {
    s"""
       |　minecraft bot discord
       |
       """.stripMargin.split('\n').foreach(logger.info(_))
  }

  MinecraftBot.hoge

}
