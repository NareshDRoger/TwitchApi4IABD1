package utils.convertos

import java.sql.Timestamp

import model.in.VideoIn
import model.out.VideoOut


object VideoConvertor extends Converter[VideoIn, VideoOut]{

  override def convert(input: VideoIn): VideoOut = {

    VideoOut(
      //created_at = Timestamp.valueOf(input.created_at),
      created_at = new Timestamp(Integer.parseInt(input.created_at)),
      description = input.description,
      duration = input.duration,
      id = input.id,
      language = input.language,
      //pagination: Object[String],
      published_at = new Timestamp(Integer.parseInt(input.published_at)),
      title = input.title,
//      type_ = input.type_,
      //url : Object,
      user_id = input.user_id,
      user_login= input.user_login,
      user_name = input.user_name,
      view_count = input.view_count,
      viewable = input.viewable
    )

  }
}
