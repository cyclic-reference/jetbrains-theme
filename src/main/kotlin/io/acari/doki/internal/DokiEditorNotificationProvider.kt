package io.acari.doki.internal

import com.intellij.openapi.fileEditor.FileEditor
import com.intellij.openapi.project.Project
import com.intellij.openapi.util.Key
import com.intellij.openapi.vfs.VirtualFile
import com.intellij.ui.EditorNotificationPanel
import com.intellij.ui.EditorNotifications
import io.acari.doki.actions.EditorNotificationManager

class DokiEditorNotificationProvider : EditorNotifications.Provider<EditorNotificationPanel>() {

  companion object {
    private const val KEY = "io.acari.doki.editor.notification"
    private val PROVIDER_KEY = Key.create<EditorNotificationPanel>(KEY)
  }

  override fun getKey(): Key<EditorNotificationPanel> = PROVIDER_KEY


  override fun createNotificationPanel(file: VirtualFile, fileEditor: FileEditor): EditorNotificationPanel? =
    buildNotification()

  private fun buildNotification(): EditorNotificationPanel? {
    if (!EditorNotificationManager.shouldShowNotification()) return null

    val panel = EditorNotificationPanel()
    panel.createActionLabel("Link One") {

    }
    panel.createActionLabel("Link Two") {

    }
    return panel
  }

  override fun createNotificationPanel(
    file: VirtualFile,
    fileEditor: FileEditor,
    project: Project
  ): EditorNotificationPanel? = buildNotification()
}