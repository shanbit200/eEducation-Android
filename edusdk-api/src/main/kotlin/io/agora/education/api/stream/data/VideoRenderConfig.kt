package io.agora.education.api.stream.data

enum class RenderMode(value: Int) {
    HIDDEN(1),
    FIT(2),
    FILL(4)
}

data class VideoRenderConfig(
        var renderMode: RenderMode = RenderMode.HIDDEN
)
