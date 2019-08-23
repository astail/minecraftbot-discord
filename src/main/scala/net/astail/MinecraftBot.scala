package net.astail

import com.typesafe.config.ConfigFactory
import ackcord._
import ackcord.commands._
import akka.NotUsed
import cats.Monad

object MinecraftBot {

  val GeneralCommands = "!"
  val token = ConfigFactory.load.getString("minecraft_bot_discord_token")
  val settings = ClientSettings(token)
  val futureClient = settings.createClient()

  def hoge: Unit = {
    val settings = ClientSettings(token, commandSettings = CommandSettings(prefixes = Set(GeneralCommands), needsMention = true))
    import settings.executionContext

    val futureClient = settings.createClient()

    futureClient.foreach { client =>
      client.login()
      registerParsedCommand(client)
    }
  }

  def registerParsedCommand[F[_]: Monad: Streamable](commands: CommandsHelper[F]): Unit = {
    commands.registerCmd[NotUsed, Id](
      refiner = CmdInfo[F](prefix = GeneralCommands, aliases = Seq("ping"), filters = Seq(CmdFilter.NonBot, CmdFilter.InGuild)),
      description = Some(CmdDescription("Ping", "Check if the bot is alive"))
    ) { cmd: ParsedCmd[F, NotUsed] =>
      println(s"Received ping command")
    }
  }
}
