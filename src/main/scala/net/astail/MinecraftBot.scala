package net.astail

import ackcord._
import ackcord.data._
import com.typesafe.config.ConfigFactory


object MinecraftBot {

  val token = ConfigFactory.load.getString("minecraft_bot_discord_token")
  val clientSettings = ClientSettings(token)

  import clientSettings.executionContext
  val futureClient = clientSettings.createClient()

  def test {
    futureClient.foreach { client =>
      client.onEvent[Id] {
        case APIMessage.Ready(_) => println("Now ready")
        case _ =>
      }
      client.login()
    }
  }

}
