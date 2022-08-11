import com.intellij.notification.NotificationDisplayType
import com.intellij.notification.NotificationGroup
import com.intellij.openapi.actionSystem.AnAction
import com.intellij.openapi.actionSystem.AnActionEvent
import com.intellij.openapi.actionSystem.CommonDataKeys
import com.intellij.openapi.project.Project
import com.intellij.openapi.ui.MessageType
import com.intellij.openapi.ui.Messages
import java.util.*

class Playground : AnAction() {
    override fun actionPerformed(e: AnActionEvent) {
        showInputDialog(e)
    }

    private fun showInputDialog(e: AnActionEvent) {
        val editor = e.getData(CommonDataKeys.EDITOR)
        val text = editor?.selectionModel?.selectedText ?: "-"
        val result = Messages.showInputDialog(text, "Title", null)
        showNotification(e.project!!, result ?: "--")
    }

    private fun showNotification(project: Project, value: String) {
        NotificationGroup(
            "fsdfdsfsdf", NotificationDisplayType.TOOL_WINDOW
        ).createNotification(
            "$value ${
                Calendar.getInstance().time
            }\n${
                project.name
            }", MessageType.INFO
        ).notify(project)
    }
}