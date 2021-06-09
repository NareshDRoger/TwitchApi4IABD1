package model.in

import java.sql.Timestamp

case class VideoIn(
                created_at: String,
                description: String,
                duration: String,
                id: String,
                language: String,
                //pagination: Object[String],
                published_at: String,
                title : String,
                type_ : String,
                //url : Object,
                user_id: String,
                user_login: String,
                user_name:String,
                view_count: Int,
                viewable: String
                )





