package model.out

import java.time.LocalDateTime


case class VideoOut(
                     title: String = null,
                     url : String = null,
                     user_login: String = null,
                     user_name: String = null,
                     created_at:LocalDateTime = null,
                     published_at:LocalDateTime = null,
                     description:String = null,
                     duration:String = null,
                     language: String = null,
//                     type_ : String = null,
                     view_count: Int = 0,
                     viewable: String = null
            )



