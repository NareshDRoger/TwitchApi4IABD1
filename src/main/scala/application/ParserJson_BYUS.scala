package application
import model.in.CategorieIn
import org.json4s._
import org.json4s.jackson.JsonMethods._

object ParserJson_BYUS extends App{


  implicit val formats = DefaultFormats


  val js =
    """{"box_art_url": "https://static-cdn.jtvnw.net/ttv-boxart/Disc%20Golf-52x72.jpg", "id": "24960", "name": "Disc Golf"}"""


  val testClassCategorie = parse(js).extract[CategorieIn]

  print(testClassCategorie)

  val jsonString =
    """{"data": [{"box_art_url": "https://static-cdn.jtvnw.net/ttv-boxart/Disc%20Golf-52x72.jpg", "id": "24960", "name": "Disc Golf"}, {"box_art_url": "https://static-cdn.jtvnw.net/ttv-boxart/Disc%20Creatures-52x72.jpg", "id": "514694", "name": "Disc Creatures"}, {"box_art_url": "https://static-cdn.jtvnw.net/ttv-boxart/Disc%20Golf%20VR-52x72.jpg", "id": "54805687", "name": "Disc Golf VR"}, {"box_art_url": "https://static-cdn.jtvnw.net/ttv-boxart/disc%20party-52x72.jpg", "id": "985051251", "name": "disc party"}, {"box_art_url": "https://static-cdn.jtvnw.net/ttv-boxart/Disc-52x72.jpg", "id": "2610", "name": "Disc"}, {"box_art_url": "https://static-cdn.jtvnw.net/ttv-boxart/DISC%20ROOM-52x72.jpg", "id": "508084", "name": "DISC ROOM"}, {"box_art_url": "https://static-cdn.jtvnw.net/ttv-boxart/Disc%20Golf%20Valley-52x72.jpg", "id": "1742806421", "name": "Disc Golf Valley"}, {"box_art_url": "https://static-cdn.jtvnw.net/ttv-boxart/Disc%20Room-52x72.jpg", "id": "89734404", "name": "Disc Room"}, {"box_art_url": "https://static-cdn.jtvnw.net/ttv-boxart/Disc%20Drivin%27-52x72.jpg", "id": "31093", "name": "Disc Drivin'"}, {"box_art_url": "https://static-cdn.jtvnw.net/ttv-boxart/Disc%20Jam-52x72.jpg", "id": "491413", "name": "Disc Jam"}], "pagination": {"cursor": "MTA="}}"""

  // json is a JValue instance
  val json = parse(jsonString)
  val elements = (json \\ "").children
  for (acct <- elements) {
    val m = acct.extract[CategorieIn]
    println("Categorie: " + m)
  }

//  val categoriesIn : List[CategorieIn] = parse(jsonString).as[List[CategorieIn]]





}
