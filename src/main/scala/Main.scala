import akka.actor.ActorSystem
import akka.stream.ActorMaterializer
import akka.http.scaladsl.server.Directives._ // 下記 `get` などの Routing DSL ディレクティブが使用可能になる
import akka.http.scaladsl.marshallers.xml.ScalaXmlSupport._ // 下記 *1 の記法が使用可能になる
import akka.http.scaladsl.Http

object Main {
  def main(args: Array[String]): Unit = {

    // アクターシステムおよびその他「おまじない」を `implicit` で宣言
    implicit val system = ActorSystem("mySystem")
    implicit val materializer = ActorMaterializer()
    implicit val ec = system.dispatcher

    // ルーティング GET '/'
    val route = path("") {
      get {
        complete {
          <h1>Say hello to akka-http</h1>
        } // ↑*1
      }
    }

    // IP とポートを指定してリッスン開始
    val bindingFuture = Http().bindAndHandle(route, "127.0.0.1", 8080)

    // 簡単のためデーモン化せず、リターンを入力すれば停止するようにしています。
    println("Server online at http://127.0.0.1:8080/\nPress RETURN to stop...")
    scala.io.StdIn.readLine()
    bindingFuture.flatMap(_.unbind()).onComplete(_ => system.terminate())
  }
}