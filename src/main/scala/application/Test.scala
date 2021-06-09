//package application
//
//import com.ning.http.client.AsyncHttpClientConfig
//import play.api.libs.ws.ning.NingWSClient
//import scala.concurrent.ExecutionContext.Implicits.global
//
//class Test {
//
//  val httpConfigBuilder = new AsyncHttpClientConfig.Builder()
//  val httpConfig = httpConfigBuilder.build()
//  val client = new NingWSClient(httpConfig)
//
//  client
//    .url(s"https://api.newrelic.com/v2/applications.json%22)
//      .withHeaders("X-Api Key" ->"9338232b0a1c0690aa4e")
//      .withQueryString("filter[name]" -> "my.app.hostname")
//      .get() map { res =>
//      client.close()
//      res.status
//    }
//
//}
