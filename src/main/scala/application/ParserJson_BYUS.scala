package application
import model.in.{CategorieIn, UserIn, VideoIn}
import org.json4s._
import org.json4s.jackson.JsonMethods._
import utils.convertos.VideoConvertor

import java.time.format.DateTimeFormatter

object ParserJson_BYUS extends App{


  implicit val formats = DefaultFormats

  val dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy")

  val r = requests.post("https://id.twitch.tv/oauth2/token", data = Map("client_id" -> "29kho0bv7hn49vs4o0moum0f59om64","client_secret"->"5ga0hmwwjr20zgsqiiwqemaaa3dumc","grant_type"->"client_credentials"))
  println(r.statusCode)
  println(r.text)
  val bearer = (parse(r.text())\"access_token").extract[String]
  println(bearer)

  println("CLASSEMENT DES VIDEOS LES PLUS VUES D'UN JEU DONNE")

  print("Entrez le jeu que vous souhaitez explorer : ")
  val gameNameSelect = scala.io.StdIn.readLine()

  val gameGetRequest = requests.get(
    "https://api.twitch.tv/helix/search/categories?query=" + gameNameSelect,
    headers = Map("Client-ID" -> "29kho0bv7hn49vs4o0moum0f59om64","Authorization" -> ("Bearer " + bearer))
  )
//  println(gameGetRequest.text)
  val gameGetJson = gameGetRequest.text

  // json is a JValue instance
  val game = parse(gameGetJson)
  val gameElement = (game \\ "data").children
  println(gameElement.size + " categories disponibles.")
  println("Voici la liste des catégories de 0 à " + (gameElement.size - 1))
  for (acct <- gameElement) {
    val g = acct.extract[CategorieIn]
    println("\t" + g.name)
  }

  print("Entrez le numéro du jeu que vous souhaitez explorer : ")
  val gameSelect = scala.io.StdIn.readInt()
  val gameId = gameElement(gameSelect).extract[CategorieIn].id
  val gameName = gameElement(gameSelect).extract[CategorieIn].name
  assert(gameId != null)
  assert(gameName != null)
  println("Vous avez choisi le jeu : "+ gameName)
  println("gameId = " + gameId)

  print("Entrez le nombre de videos que vous souhaitez classer : ")
  val videosNumber = scala.io.StdIn.readInt()

  val videosFromGameGetRequest = requests.get(
    "https://api.twitch.tv/helix/videos?sort=views&game_id=" + gameId + "&first=" + videosNumber,
    headers = Map("Client-ID" -> "29kho0bv7hn49vs4o0moum0f59om64","Authorization" -> ("Bearer " + bearer))
  )

  println(videosFromGameGetRequest.text)
  val videosFromGameGetJson = videosFromGameGetRequest.text
  // json is a JValue instance
  val videos = parse(videosFromGameGetJson)
  val videosElements = (videos \\ "data").children
  println(videosElements.size + " videos.")
  println("Voici les " + (videosElements.size) + " vidéos les plues vues du jeu " + gameName)

  var cpt = 1
  for (acct <- videosElements) {
    val vIn = acct.extract[VideoIn]
    val vOut = VideoConvertor.convert(vIn)
    println("\tVideo " + cpt)
    println("\t\t" + "Titre = " + vOut.title)
    println("\t\tUrl = " + vOut.url)
    println("\t\tPublié le " + vOut.published_at.toLocalDate.format(dtf) + " à " + vOut.published_at.toLocalTime)
    println("\t\tPublié par = " + vOut.user_login)
    println("\t\tNombre de vus = " + vOut.view_count)
    println("\t\tDurée = " + vOut.duration)
    cpt += 1
  }


  println("CLASSEMENT DES VIDEOS LES PLUS VUES D'UN JEU DONNE")

    print("Entrez l'utilisateur que vous souhaitez explorer : ")
    val userNameSelect = scala.io.StdIn.readLine()

  val userGetRequest = requests.get(
    "https://api.twitch.tv/helix/users?login=" + userNameSelect,
    headers = Map("Client-ID" -> "29kho0bv7hn49vs4o0moum0f59om64","Authorization" -> ("Bearer " + bearer))
  )
//  println(userGetRequest.text)
  val userGetJson = userGetRequest.text

  // json is a JValue instance
  val user = parse(userGetJson)
  val userElement = (user \\ "data").children
  println(userElement.size + " utilisateur(s) disponible(s).")
  println("Voici la liste des utilisateurs de 0 à " + (userElement.size - 1))
  for (acct <- userElement) {
    val u = acct.extract[UserIn]
    println("\t" + u.login)
  }

  val userId = userElement(0).extract[UserIn].id
  val userDisplayName = userElement(0).extract[UserIn].display_name
  assert(userId != null)
  assert(userDisplayName != null)
  println("Vous avez choisi l'utilisateur : " + userDisplayName)
  println("userId = " + userId)

  print("Entrez le nombre de videos que vous souhaitez classer : ")
  val videosByUserNumber = scala.io.StdIn.readInt()

  val videosFromUserGetRequest = requests.get(
    "https://api.twitch.tv/helix/videos?sort=views&user_id=" + userId + "&first=" + videosByUserNumber,
    headers = Map("Client-ID" -> "29kho0bv7hn49vs4o0moum0f59om64","Authorization" -> ("Bearer " + bearer))
  )

  println(videosFromUserGetRequest.text)
  val videosFromUserGetJson = videosFromUserGetRequest.text
  // json is a JValue instance
  val videosByUser = parse(videosFromUserGetJson)
  val videosByUserElements = (videosByUser \\ "data").children
  println(videosByUserElements.size + " videos.")
  println("Voici les " + (videosByUserElements.size) + " vidéos les plues vues de l'utilisateur " + userDisplayName)

  var cpt2 = 1
  for (acct <- videosByUserElements) {
    val vIn = acct.extract[VideoIn]
    val vOut = VideoConvertor.convert(vIn)
    println("\tVideo " + cpt2)
    println("\t\t" + "Titre = " + vOut.title)
    println("\t\tUrl = " + vOut.url)
    println("\t\tPublié le " + vOut.published_at.toLocalDate.format(dtf) + " à " + vOut.published_at.toLocalTime)
    println("\t\tPublié par = " + vOut.user_login)
    println("\t\tNombre de vus = " + vOut.view_count)
    println("\t\tDurée = " + vOut.duration)
    cpt2 += 1
  }

}
