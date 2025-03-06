package com.ctw

import dev.langchain4j.data.image.Image
import jakarta.inject.Inject
import jakarta.ws.rs.Consumes
import jakarta.ws.rs.GET
import jakarta.ws.rs.Path
import jakarta.ws.rs.core.MediaType
import org.jboss.resteasy.reactive.RestForm
import java.io.File
import java.util.*

@Path("/hello")
class ExampleResource @Inject constructor(val llavaService: LlavaService) {

    @GET
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    fun hello(@RestForm image: File): Boolean {
        val base64Image: String = Base64.getEncoder().encodeToString(image.readBytes())

        val langchain4jImage: Image = Image.builder()
            .base64Data(base64Image)
            .mimeType("image/jpeg")
            .build()

        return llavaService.isBlurry(langchain4jImage)
    }
}
