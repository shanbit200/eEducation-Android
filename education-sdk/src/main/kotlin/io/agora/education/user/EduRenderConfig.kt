package io.agora.education.user

import io.agora.education.statistics.EduRenderMode

class EduRenderConfig constructor() {
    lateinit var renderMode: EduRenderMode

    constructor(renderMode: EduRenderMode): this() {
        this.renderMode = renderMode
    }
}