package io.agora.education.scene

import io.agora.education.classroom.CreateRoomConfig

class CreateRoomConfigFactory {
    companion object {
        @JvmStatic
        fun create(scene: Scene): CreateRoomConfig {
            when (scene) {
                Scene.ONE_ON_ONE -> CreateRoomConfig(1, 1)
                Scene.SMALL_CLASS -> CreateRoomConfig(1, 16)
                Scene.LARGE_CLASS -> CreateRoomConfig(1, -1)
            }
            throw IllegalArgumentException()
        }
    }
}
