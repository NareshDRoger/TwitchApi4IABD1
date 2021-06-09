package utils.convertos

import java.sql.Timestamp

import model.in.CategorieIn
import model.out.CategorieOut

object CategorieConvertor extends Converter[CategorieIn, CategorieOut]{

  override def convert(input: CategorieIn): CategorieOut = {


    CategorieOut(
      box_art_url = input.box_art_url,
      name = input.name,
      id = input.id
    )


  }


}
