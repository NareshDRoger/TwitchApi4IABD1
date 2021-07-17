package model.in

case class UserIn (
                    id: String,
                    login: String,
                    display_name: String,
//                    type :String,
                    broadcaster_type: String,
                    description: String,
                    profile_image_url: String,
                    offline_image_url: String,
                    view_count: Int,
//                    email:String,
                    created_at: String
                  )
