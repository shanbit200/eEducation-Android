package io.agora.education.scene

import io.agora.education.classroom.RoomConfig

class RoomConfigFactory {
    companion object {
        @JvmStatic
        fun create(scene: Scene): RoomConfig {
            when (scene) {
                Scene.ONE_ON_ONE -> RoomConfig(teacherLimit = 1, studentLimit = 1)
                Scene.SMALL_CLASS -> RoomConfig(teacherLimit = 1, studentLimit = 16)
                Scene.LARGE_CLASS -> RoomConfig(teacherLimit = 1, studentLimit = -1)
            }
            throw IllegalArgumentException()
        }
    }
}
