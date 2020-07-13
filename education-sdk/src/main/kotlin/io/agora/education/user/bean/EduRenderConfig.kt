package io.agora.education.user.bean

import io.agora.education.user.enums.EduRenderMode

class EduRenderConfig constructor() {
    lateinit var renderMode: EduRenderMode

    constructor(renderMode: EduRenderMode): this() {
        this.renderMode = renderMode
    }
}