package utils.convertos

import model.in.VideoIn
import model.out.VideoOut

import java.time.LocalDateTime
import java.time.format.DateTimeFormatter


object VideoConvertor extends Converter[VideoIn, VideoOut]{

  val dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss'Z'");

  override def convert(input: VideoIn): VideoOut = {

    VideoOut(
      title = input.title,
      url = input.url,
      user_login= input.user_login,
      user_name = input.user_name,
      created_at = LocalDateTime.parse(input.created_at, dtf),
      published_at = LocalDateTime.parse(input.published_at, dtf),
      description = input.description,
      duration = input.duration,
      language = input.language,
//      type_ = input.type_,
      view_count = input.view_count,
      viewable = input.viewable
    )

  }
}
