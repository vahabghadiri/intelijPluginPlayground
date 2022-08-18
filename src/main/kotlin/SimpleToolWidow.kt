import com.intellij.openapi.project.Project
import com.intellij.openapi.wm.ToolWindow
import com.intellij.openapi.wm.ToolWindowFactory
import com.intellij.ui.content.ContentFactory
import javax.swing.JPanel

//https://plugins.jetbrains.com/docs/intellij/tool-windows.html#declarative-setup
//https://jetbrains.design/intellij/components/tool_window/


class SimpleToolWidowFactory : ToolWindowFactory {

    override fun createToolWindowContent(project: Project, toolWindow: ToolWindow) {
        val simpleToolWidow = SimpleToolWidow(toolWindow)
        val contentFactory = ContentFactory.SERVICE.getInstance()
        val content = contentFactory.createContent(
            simpleToolWidow.getContent(), "Simple tool", false
        )
        toolWindow.contentManager.addContent(content)
    }
}

class SimpleToolWidow(toolWindow: ToolWindow) {

    fun getContent(): JPanel {
        return JPanel()
    }
}