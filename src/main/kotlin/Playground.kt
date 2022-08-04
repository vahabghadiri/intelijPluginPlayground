import com.intellij.notification.NotificationDisplayType
import com.intellij.notification.NotificationGroup
import com.intellij.openapi.actionSystem.AnAction
import com.intellij.openapi.actionSystem.AnActionEvent
import com.intellij.openapi.actionSystem.CommonDataKeys
import com.intellij.openapi.project.Project
import com.intellij.openapi.ui.MessageType
import java.util.*

class Playground : AnAction() {
    override fun actionPerformed(e: AnActionEvent) {
        e.project?.run {
            showNotificationBaloon(this)
        }
        val editor = e.getData(CommonDataKeys.EDITOR)
        println(editor?.document?.charsSequence)
    }

    private fun showNotificationBaloon(project: Project) {
        NotificationGroup(
            "fsdfdsfsdf", NotificationDisplayType.TOOL_WINDOW
        ).createNotification(
            "Playground plugin says Hello! :D ${
                Calendar.getInstance().time
            }\n${
                project.name
            }", MessageType.INFO
        ).notify(project)
    }
}