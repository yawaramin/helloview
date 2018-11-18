import javafx.application.Application
import javafx.scene.control.Button

class HelloView extends Application {
  import javafx.stage.Stage

  override def start(stage: Stage): Unit = {
    import javafx.scene.layout.StackPane
    import javafx.scene.Scene

    val btn = new Button
    val root = new StackPane
    val scene = new Scene(root, 300, 250)

    btn setText controller.btnText
    btn setOnAction controller.handleClickBtn
    root.getChildren add btn
    stage setTitle "Hello, World!"
    stage setScene scene
    stage show ()
  }

  private val controller = new HelloController
}

object HelloView {
  def main(args: Array[String]): Unit = Application
    .launch(classOf[HelloView])
}

private class HelloController {
  import java.util.concurrent.atomic.AtomicInteger
  import javafx.event.ActionEvent

  def btnText: String = btnText(count.get)
  def handleClickBtn(event: ActionEvent): Unit = event
    .getSource
    .asInstanceOf[Button]
    .setText(btnText(count.incrementAndGet()))

  private def btnText(count: Int) = s"Clicked $count times!"
  private val count = new AtomicInteger
}

