package utils.convertos

trait Converter[In, Out] {

  def convert(input: In): Out

}
