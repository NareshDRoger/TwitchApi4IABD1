package utils

trait IOReader[T] {

  def read(url: String): String

}


trait IOApiReader[T] extends IOReader[T]{


  override def read(url: String): String = ???
      //lire le fichier avec oslib
      //lire le JSON


}

//Trait IOParser


abstract  class AbstractApiReader[T] extends IOApiReader[T]

