package utils.convertos

import model.in.UserIn
import model.out.UserOut
import utils.convertos.StreamConvertor.dtf

import java.time.LocalDateTime

object UserConvertor extends Converter[UserIn, UserOut]{

  override def convert(input: UserIn): UserOut = {


    UserOut(
      broadcaster_type = input.broadcaster_type,
      description = input.description,
      display_name =  input.display_name,
      id = input.id,
      login = input.login,
//      type_ = input.type_,
      view_count = input.view_count,
//      email = input.email,
      created_at = LocalDateTime.parse(input.created_at, dtf)
    )


  }


}
