package utils.convertos

import model.in.CategorieIn
import model.out.CategorieOut

object CategorieConvertor extends Converter[CategorieIn, CategorieOut]{

  override def convert(input: CategorieIn): CategorieOut = {


    CategorieOut(
      name = input.name,
      id = input.id
    )
  }
}
