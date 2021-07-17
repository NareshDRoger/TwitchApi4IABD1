package model.out

import java.time.LocalDateTime

case class StreamOut(
                      user_login: String = null,
                      user_name: String = null,
                      game_name: String = null,
//                      type: String = null,
                      title: String,
                      view_count: Int = 0,
                      started_at: LocalDateTime = null,
                      language: String = null
                    )
