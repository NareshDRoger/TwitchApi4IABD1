package utils.convertos

import java.sql.Timestamp

import model.in.UserIn
import model.out.UserOut

object UserConvertor extends Converter[UserIn, UserOut]{

  override def convert(input: UserIn): UserOut = {


    UserOut(
      broadcaster_type = input.broadcaster_type,
      description = input.description,
      display_name =  input.display_name,
      id = input.id,
      login = input.login,
      type_ = input.type_,
      view_count = input.view_count,
      email = input.email,
      created_at = new Timestamp(Integer.parseInt(input.created_at))
    )


  }


}
