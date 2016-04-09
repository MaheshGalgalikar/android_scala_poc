package cardio

object Consts {

  lazy val prefix = local.replace("/classes/test/debug", "/javaResources/debug")
  private lazy val local = getClass.getResource("").getPath()

  object SimpleDataLoader {
    val storageRoot = prefix

  }
}
