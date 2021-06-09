package model.out

import java.sql.Timestamp

case class UserOut (

                     broadcaster_type: String = null,
                     description: String = null,
                     display_name: String = null,
                     id: String = null,
                     login: String = null,
                     type_ :String = null,
                     view_count: Int = 0,
                     email:String = null,
                     created_at: Timestamp = null
  )
