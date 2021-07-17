package utils.convertos

import model.in.StreamIn
import model.out.StreamOut

import java.time.LocalDateTime
import java.time.format.DateTimeFormatter


object StreamConvertor extends Converter[StreamIn, StreamOut]{

  val dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss'Z'");

  override def convert(input: StreamIn): StreamOut = {

    StreamOut(
      user_login = input.user_id,
      user_name = input.user_name,
      game_name = input.game_name,
      title = input.title,
      view_count = input.viewer_count,
      started_at = LocalDateTime.parse(input.started_at, dtf),
      language = input.language
    )

  }
}
