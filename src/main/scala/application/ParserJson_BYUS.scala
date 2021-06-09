package application
import model.in.CategorieIn
import org.json4s._
import org.json4s.jackson.JsonMethods._

object ParserJson_BYUS extends App{


  implicit val formats = DefaultFormats


  println("Test for unique element : ")

  val jsOneCategorieIn =
    """{"box_art_url": "https://static-cdn.jtvnw.net/ttv-boxart/Disc%20Golf-52x72.jpg", "id": "24960", "name": "Disc Golf"}"""

  val testClassCategorie = parse(jsOneCategorieIn).extract[CategorieIn]

  println(testClassCategorie)

  val jsMultipleCategorieIn =
    """{"data": [{"box_art_url": "https://static-cdn.jtvnw.net/ttv-boxart/Disc%20Golf-52x72.jpg", "id": "24960", "name": "Disc Golf"}, {"box_art_url": "https://static-cdn.jtvnw.net/ttv-boxart/Disc%20Creatures-52x72.jpg", "id": "514694", "name": "Disc Creatures"}, {"box_art_url": "https://static-cdn.jtvnw.net/ttv-boxart/Disc%20Golf%20VR-52x72.jpg", "id": "54805687", "name": "Disc Golf VR"}, {"box_art_url": "https://static-cdn.jtvnw.net/ttv-boxart/disc%20party-52x72.jpg", "id": "985051251", "name": "disc party"}, {"box_art_url": "https://static-cdn.jtvnw.net/ttv-boxart/Disc-52x72.jpg", "id": "2610", "name": "Disc"}, {"box_art_url": "https://static-cdn.jtvnw.net/ttv-boxart/DISC%20ROOM-52x72.jpg", "id": "508084", "name": "DISC ROOM"}, {"box_art_url": "https://static-cdn.jtvnw.net/ttv-boxart/Disc%20Golf%20Valley-52x72.jpg", "id": "1742806421", "name": "Disc Golf Valley"}, {"box_art_url": "https://static-cdn.jtvnw.net/ttv-boxart/Disc%20Room-52x72.jpg", "id": "89734404", "name": "Disc Room"}, {"box_art_url": "https://static-cdn.jtvnw.net/ttv-boxart/Disc%20Drivin%27-52x72.jpg", "id": "31093", "name": "Disc Drivin'"}, {"box_art_url": "https://static-cdn.jtvnw.net/ttv-boxart/Disc%20Jam-52x72.jpg", "id": "491413", "name": "Disc Jam"}], "pagination": {"cursor": "MTA="}}"""

  // json is a JValue instance
  val json = parse(jsMultipleCategorieIn)
  val elements = (json \\ "data").children
  println(elements.size + " CategorieIn :")
  for (acct <- elements) {
    val m = acct.extract[CategorieIn]
    println("Categorie: " + m)
  }

//  println("Test for unique element : ")
//
//  val jsOneVideoIn =
//    """{"box_art_url": "https://static-cdn.jtvnw.net/ttv-boxart/Disc%20Golf-52x72.jpg", "id": "24960", "name": "Disc Golf"}"""
//
//  val testClassVideoIn = parse(jsOneVideoIn).extract[CategorieIn]
//
//  println(testClassCategorie)
//
//  val jsMultipleVideoIn =
//    """{"data": [{"id": "1049993597", "stream_id": "42299574028", "user_id": "41719107", "user_login": "zerator", "user_name": "ZeratoR", "title": "D\u00e9brief #ZLAN2021 ! Quel week-end de fou ! D\u00e9but du mapping ZrT Trackmania Cup le 12 Juin avec des nouveaux blocs !", "description": "", "created_at": "2021-06-08T18:59:25Z", "published_at": "2021-06-08T18:59:25Z", "url": "https://www.twitch.tv/videos/1049993597", "thumbnail_url": "", "viewable": "public", "view_count": 551, "language": "fr", "type": "archive", "duration": "2h22m22s", "muted_segments": null}, {"id": "1047621005", "stream_id": "42241650589", "user_id": "41719107", "user_login": "zerator", "user_name": "ZeratoR", "title": "#ZLAN 2021 | GROSSE COUPURE INTERNET, ILS SONT DESSUS !", "description": "", "created_at": "2021-06-06T10:47:25Z", "published_at": "2021-06-06T10:47:25Z", "url": "https://www.twitch.tv/videos/1047621005", "thumbnail_url": "https://static-cdn.jtvnw.net/cf_vods/d2nvs31859zcd8/5a62bb66c4a6eace8020_zerator_42241650589_1622976436/thumb/custom-fe82b9ce-2d65-450f-a02d-fe9828f2c537-%{width}x%{height}.jpeg", "viewable": "public", "view_count": 4322075, "language": "fr", "type": "archive", "duration": "12h32m56s", "muted_segments": null}], "pagination": {"cursor": "eyJiIjpudWxsLCJhIjp7Ik9mZnNldCI6Mn19"}}"""
//
//  // json is a JValue instance
//  val json2 = parse(jsMultipleVideoIn)
//  val elements2 = (json \\ "data").children
//  println(elements.size + " VideoIn :")
//  for (acct <- elements) {
//    val m = acct.extract[VideoIn]
//    println("VideoIn: " + m)
//  }



}