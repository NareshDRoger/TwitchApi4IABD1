package model.out

import java.sql.Timestamp

case class VideoOut(

            created_at:Timestamp = null,
            description:String = null,
            duration:String = null,
            id: String = null,
            language: String = null,
            //pagination: Object[String],
            published_at: Timestamp = null,
            title : String = null,
            type_ : String = null,
            //url : Object,
            user_id: String = null,
            user_login: String = null,
            user_name:String = null,
            view_count: Int = 0,
            viewable: String = null

            )


