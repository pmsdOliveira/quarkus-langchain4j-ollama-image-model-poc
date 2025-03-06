package com.ctw

import dev.langchain4j.data.image.Image
import dev.langchain4j.service.SystemMessage
import dev.langchain4j.service.UserMessage
import io.quarkiverse.langchain4j.RegisterAiService

@RegisterAiService(
    modelName = "llava",
    chatMemoryProviderSupplier = RegisterAiService.NoChatMemoryProviderSupplier::class
)
interface LlavaService {

    @SystemMessage("You are responsible for detecting if an image is blurry or not.")
    @UserMessage("Is this image blurry?")
    fun isBlurry(image: Image): Boolean
}
